package com.exo1.exo1.controller;


import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.dto.TasksPerProjetDto;
import com.exo1.exo1.entity.TasksPerProjet;
import com.exo1.exo1.mapper.TasksPerProjetMapper;
import com.exo1.exo1.service.TasksPerProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasksPerProjet")
public class TasksPerProjetController {

    private final TasksPerProjetService tasksPerProjetService;
    private final TasksPerProjetMapper tasksPerProjetMapper = TasksPerProjetMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<TasksPerProjetDto>> findAll(@RequestParam int page, @RequestParam int size)
    {
        return ResponseEntity.ok(tasksPerProjetService.findAll(page, size));
    }

    @Autowired
    public TasksPerProjetController(TasksPerProjetService tasksPerProjetService) {
        this.tasksPerProjetService = tasksPerProjetService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TasksPerProjetDto> getTasksPerProjetById(@PathVariable Long id) {
        TasksPerProjet tasksPerProjet = tasksPerProjetService.findByProjetId(id);
        return ResponseEntity.ok(tasksPerProjetMapper.toDto(tasksPerProjet));
    }
}
