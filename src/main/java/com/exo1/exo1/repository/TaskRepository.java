package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @EntityGraph(value = "task-user-projet-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Task> findAll();

    @EntityGraph(value = "task-user-projet-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Task> findById(Long id);
}
