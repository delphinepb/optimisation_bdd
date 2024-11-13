package com.exo1.exo1.repository;

import com.exo1.exo1.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(value = "user-projet-task-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<User> findById(Long id);

    @Query("SELECT u FROM User u JOIN FETCH u.task")
    Page<User> findAll(Pageable pageable);

    @Cacheable(value = "users")
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.task WHERE u.id = :id")
    Optional<User> findByIdWithTask(@Param("id") Long id);

}
