package com.backendapi.codechallenge.infraestructure.adaptor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backendapi.codechallenge.domain.model.Task;
import com.backendapi.codechallenge.domain.port.TaskRepository;
import com.backendapi.codechallenge.infraestructure.entity.TaskEntity;

/**
 * Repository for Tasks in the JPA H2 Db.
 * @author Vitor Augusto Brandao
 * @version 1.0
*/
@Repository
public class TaskRepositoryH2 implements TaskRepository {
	
	Logger logger = LoggerFactory.getLogger(TaskRepositoryH2.class);
	private final TaskCrudRepository taskCrudRepository;
	
	@Autowired
	TaskMapper taskMapper;
	
	public TaskRepositoryH2(TaskCrudRepository taskCrudRepository) {
		this.taskCrudRepository = taskCrudRepository;
	}

	@Override
	public boolean existsById(long id) {
		return taskCrudRepository.existsById(""+id);
	}

	@Override
	public Task create(Task taskDto) {
		TaskEntity task = taskMapper.taskDtoToTask(taskDto);
		taskCrudRepository.save(task);
		logger.info("Task Repository {} created successfully.", taskDto);
		return taskMapper.taskToTaskDto(task);
	}

	@Override
	public Task findById(long id) {
		Task dto = null;
		Optional<TaskEntity> entity = taskCrudRepository.findById(""+id);
		if(entity.isPresent()) {
			dto = taskMapper.taskToTaskDto(entity.get());
		}
		return dto;
	}

	@Override
	public Iterable<Task> findAll() {
		Iterable<TaskEntity> iterable = taskCrudRepository.findAll();
		List<TaskEntity> entity = StreamSupport.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
		return taskMapper.taskListToTaskDtoList(entity);
	}


	@Override
	public Task save(Task taskDto) {
		TaskEntity entity = taskMapper.taskDtoToTask(taskDto);
		entity = taskCrudRepository.save(entity);
		return taskMapper.taskToTaskDto(entity);
	}
	
}
