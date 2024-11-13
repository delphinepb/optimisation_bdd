package com.exo1.exo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksPerProjetDto {
    private Long projetId;
    private String projetName;
    private Long taskCount;
}
