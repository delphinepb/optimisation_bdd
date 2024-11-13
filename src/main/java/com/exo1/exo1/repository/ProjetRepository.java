package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Projet;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

    @EntityGraph(value = "projet-task-graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Projet> findAll();

    @EntityGraph(value = "projet-task-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Projet> findById(Long id);
}
