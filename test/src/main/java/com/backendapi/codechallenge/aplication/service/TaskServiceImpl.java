package com.backendapi.codechallenge.aplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.backendapi.codechallenge.aplication.service.dto.TaskUpdateStatusDTO;
import com.backendapi.codechallenge.domain.model.Task;
import com.backendapi.codechallenge.domain.port.TaskRepository;

/**
 * Service class that handles http requests from the controller
 * @author Vitor Augusto Brandao
 * @version 1.0
*/
@Component
public class TaskServiceImpl implements TaskService {
	
	Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task create(Task transactionDto) {
		taskRepository.create(transactionDto);
		logger.info("Task Repository {} created successfully.", transactionDto);
		return transactionDto;
	}
	

	@Override
	public Task findById(long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

	@Override
	public Iterable<Task> findAll() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}


	public ResponseEntity<Object> save(Task transactionDto) {
		taskRepository.save(transactionDto);
		logger.info("Task Repository {} created successfully.", transactionDto);
		return new ResponseEntity<>(transactionDto, HttpStatus.ACCEPTED);
	}

	@Override
	public Task updateStatus(TaskUpdateStatusDTO taskDto) {
		Task task = taskRepository.findById(taskDto.getId());
		if(task != null) {
			task.setStatus(taskDto.getStatus());
			taskRepository.save(task);
		}
		return task;
	}

}
