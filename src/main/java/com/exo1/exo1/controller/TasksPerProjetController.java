package com.exo1.exo1.controller;


import com.exo1.exo1.dto.TasksPerProjetDto;
import com.exo1.exo1.entity.TasksPerProjet;
import com.exo1.exo1.mapper.TasksPerProjetMapper;
import com.exo1.exo1.service.TasksPerProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasksPerProjet")
public class TasksPerProjetController {

    private final TasksPerProjetService tasksPerProjetService;
    private final TasksPerProjetMapper tasksPerProjetMapper = TasksPerProjetMapper.INSTANCE;

    @Autowired
    public TasksPerProjetController(TasksPerProjetService tasksPerProjetService) {
        this.tasksPerProjetService = tasksPerProjetService;
    }

    @GetMapping
    public ResponseEntity<List<TasksPerProjetDto>> getAllTasksPerProjet() {
        List<TasksPerProjetDto> dtos = tasksPerProjetService.findAll().stream()
                .map(tasksPerProjetMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TasksPerProjetDto> getTasksPerProjetById(@PathVariable Long id) {
        TasksPerProjet tasksPerProjet = tasksPerProjetService.findByProjetId(id);
        return ResponseEntity.ok(tasksPerProjetMapper.toDto(tasksPerProjet));
    }
}
