package com.backendapi.codechallenge.aplication.service;
import org.springframework.http.ResponseEntity;

import com.backendapi.codechallenge.aplication.service.dto.TaskUpdateStatusDTO;
import com.backendapi.codechallenge.domain.model.Task;

/**
 * Service class that handles http requests from the controller
 * @author Vitor Augusto Brandao
 * @version 1.0
*/
public interface TaskService {
	public ResponseEntity<Object> save(Task transactionDto);

	public Task findById(long id);

	public Iterable<Task> findAll();

	public Task updateStatus(TaskUpdateStatusDTO taskDto);

}
