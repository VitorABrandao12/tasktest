package com.backendapi.codechallenge.domain.port;

import com.backendapi.codechallenge.domain.model.Task;

public interface TaskRepository {

	boolean existsById(long id);

	Task save(Task transactionDto);
	
	Task create(Task transactionDto);

	Task findById(long id);
	
	Iterable<Task> findAll();
}
