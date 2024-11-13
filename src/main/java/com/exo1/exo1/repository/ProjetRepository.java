package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjetRepository extends JpaRepository<Projet, Long> {

    @Override
    @Query("SELECT p FROM Projet p JOIN FETCH p.users JOIN FETCH p.tasks")
    Page<Projet> findAll(Pageable pageable);

    @EntityGraph(value = "projet-task-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Projet> findById(Long id);


}
