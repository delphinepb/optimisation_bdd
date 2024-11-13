package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TasksPerProjetDto;
import com.exo1.exo1.entity.TasksPerProjet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TasksPerProjetMapper {
    TasksPerProjetMapper INSTANCE = Mappers.getMapper(TasksPerProjetMapper.class);

    TasksPerProjetDto toDto(TasksPerProjet tasksPerProjet);

    TasksPerProjet toEntity(TasksPerProjetDto tasksPerProjetDto);
}

