package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TasksPerProjetDto;
import com.exo1.exo1.entity.TasksPerProjet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-13T14:39:40+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class TasksPerProjetMapperImpl implements TasksPerProjetMapper {

    @Override
    public TasksPerProjetDto toDto(TasksPerProjet tasksPerProjet) {
        if ( tasksPerProjet == null ) {
            return null;
        }

        TasksPerProjetDto tasksPerProjetDto = new TasksPerProjetDto();

        tasksPerProjetDto.setProjetId( tasksPerProjet.getProjetId() );
        tasksPerProjetDto.setProjetName( tasksPerProjet.getProjetName() );
        tasksPerProjetDto.setTaskCount( tasksPerProjet.getTaskCount() );

        return tasksPerProjetDto;
    }

    @Override
    public TasksPerProjet toEntity(TasksPerProjetDto tasksPerProjetDto) {
        if ( tasksPerProjetDto == null ) {
            return null;
        }

        TasksPerProjet tasksPerProjet = new TasksPerProjet();

        tasksPerProjet.setProjetId( tasksPerProjetDto.getProjetId() );
        tasksPerProjet.setProjetName( tasksPerProjetDto.getProjetName() );
        tasksPerProjet.setTaskCount( tasksPerProjetDto.getTaskCount() );

        return tasksPerProjet;
    }
}
