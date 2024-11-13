package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tasks_per_projet")
public class TasksPerProjet {
    @Id
    @Column(name = "projet_id")
    private Long projetId;

    @Column(name = "projet_name")
    private String projetName;

    @Column(name = "task_count")
    private Long taskCount;
}
