package com.exo1.exo1.service;

import com.exo1.exo1.entity.TasksPerProjet;
import com.exo1.exo1.repository.TasksPerProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TasksPerProjetService {

    private final TasksPerProjetRepository tasksPerProjetRepository;

    @Autowired
    public TasksPerProjetService(TasksPerProjetRepository tasksPerProjetRepository) {
        this.tasksPerProjetRepository = tasksPerProjetRepository;
    }

    public List<TasksPerProjet> findAll() {
        return tasksPerProjetRepository.findAll();
    }

    public TasksPerProjet findByProjetId(Long projetId) {
        return tasksPerProjetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé pour l'ID : " + projetId));
    }
}
