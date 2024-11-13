package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Task;
import jakarta.persistence.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t JOIN FETCH t.user JOIN FETCH t.projet")
    Page<Task> findAll(Pageable pageable);

    @EntityGraph(value = "task-user-projet-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Task> findById(Long id);
}
