package com.exo1.exo1.repository;

import com.exo1.exo1.entity.TasksPerProjet;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TasksPerProjetRepository extends JpaRepository<TasksPerProjet, Long> {
    Page<TasksPerProjet> findAll(Pageable pageable);
    @Modifying
    @Transactional
    @Query(value = "REFRESH MATERIALIZED VIEW tasks_per_projet", nativeQuery = true)
    void refreshTasksPerProjetView();
}


