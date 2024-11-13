package com.exo1.exo1.service;

import com.exo1.exo1.dto.UserDto;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.UserMapper;
import com.exo1.exo1.repository.ProjetRepository;
import com.exo1.exo1.repository.TaskRepository;
import com.exo1.exo1.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    private ProjetRepository projetRepository;
    private UserMapper userMapper;
    @Autowired
    private CacheManager cacheManager;

    public void checkCacheForUser(Long userId) {
        Object cachedUser = cacheManager.getCache("users").get(userId);
        if (cachedUser != null) {
            System.out.println("Utilisateur trouvé dans le cache : " + cachedUser);
        } else {
            System.out.println("Utilisateur non trouvé dans le cache");
        }
    }

    public List<UserDto> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> userPage = userRepository.findAll(pageRequest);

        return userMapper.toDtos(userPage.getContent());
    }

    public UserDto findById(long id) {
        User user = userRepository.findByIdWithTask(id).orElse(null);
        checkCacheForUser(id);
        return userMapper.toDto(user);
    }

    @CachePut(value = "users", key = "#result.id")
    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.getProjets().stream().forEach(projet -> {
                    projet.getTasks().stream().forEach(task -> {task.setProjet(projet);});
                });
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDto update(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id " + id));
        userDto.setId(existingUser.getId());
        User userUpdated = userMapper.toEntity(userDto);
        userUpdated.getProjets().stream().forEach(projet -> {
            if(projetRepository.findById(projet.getId()).isPresent()) {
                projet.setUsers(new HashSet<>(Collections.singleton(userUpdated)));
                projet.getTasks().stream().forEach(
                        task -> {
                            if(taskRepository.findById(task.getId()).isPresent()) {
                                task.setProjet(projet);
                            }
                        });
            }
        });
        return userMapper.toDto(userRepository.save(userUpdated));
    }

    @CacheEvict(value = "users", key = "#id")
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
