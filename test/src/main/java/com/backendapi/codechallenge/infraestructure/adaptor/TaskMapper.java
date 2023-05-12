package com.backendapi.codechallenge.infraestructure.adaptor;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.backendapi.codechallenge.domain.Constants;
import com.backendapi.codechallenge.domain.model.Task;
import com.backendapi.codechallenge.infraestructure.entity.TaskEntity;

@Mapper(
    componentModel = "spring"
)
public interface TaskMapper {
	
	Task taskToTaskDto(TaskEntity task);
	
	TaskEntity taskDtoToTask(Task taskDto);
	
	List<Task> taskListToTaskDtoList(List<TaskEntity> task);
	
	
}