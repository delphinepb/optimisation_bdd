package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.dto.TasksPerProjetDto;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.entity.TasksPerProjet;
import com.exo1.exo1.mapper.TasksPerProjetMapper;
import com.exo1.exo1.repository.TasksPerProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TasksPerProjetService {

    private TasksPerProjetRepository tasksPerProjetRepository;
    private TasksPerProjetMapper tasksPerProjetMapper;

    @Autowired
    public TasksPerProjetService(TasksPerProjetRepository tasksPerProjetRepository) {
        this.tasksPerProjetRepository = tasksPerProjetRepository;
        tasksPerProjetRepository.refreshTasksPerProjetView();
    }

    public List<TasksPerProjetDto> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<TasksPerProjet> tasksPerProjetPage = tasksPerProjetRepository.findAll(pageRequest);
        tasksPerProjetRepository.refreshTasksPerProjetView();
        return tasksPerProjetMapper.toDtos(tasksPerProjetPage.getContent());
    }

    public TasksPerProjet findByProjetId(Long projetId) {
        tasksPerProjetRepository.refreshTasksPerProjetView();
        return tasksPerProjetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé pour l'ID : " + projetId));

    }
}