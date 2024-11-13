package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TaskDto;
import com.exo1.exo1.dto.TasksPerProjetDto;
import com.exo1.exo1.entity.Task;
import com.exo1.exo1.entity.TasksPerProjet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TasksPerProjetMapper {
    TasksPerProjetMapper INSTANCE = Mappers.getMapper(TasksPerProjetMapper.class);

    TasksPerProjetDto toDto(TasksPerProjet tasksPerProjet);

    List<TasksPerProjetDto> toDtos(List<TasksPerProjet> tasksPerProjets);

    TasksPerProjet toEntity(TasksPerProjetDto tasksPerProjetDto);
}

