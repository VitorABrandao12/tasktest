package com.backendapi.codechallenge.infraestructure.rest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendapi.codechallenge.aplication.service.TaskService;
import com.backendapi.codechallenge.aplication.service.dto.TaskUpdateStatusDTO;
import com.backendapi.codechallenge.domain.Constants;
import com.backendapi.codechallenge.domain.model.Task;

/**
 * Controller class that handles http requests
 * @author Vitor Augusto Brandao
 * @version 1.0
*/
@RestController
@RequestMapping(Constants.TASK_URL)
public class TaskController {
	
	Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
    private TaskService taskService;
	
	@PostMapping(Constants.CREATE_URL)
    public ResponseEntity<Object> create(@RequestBody Task taskDto) {
		logger.info("create Input {}", taskDto);
		return new ResponseEntity<>(taskService.save(taskDto), HttpStatus.CREATED);
    }
	
	@GetMapping(Constants.FINDALL_URL)
    public ResponseEntity<Object> getAll() {
		logger.info("getall init.");
		return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }
	
	@PatchMapping(Constants.STATUS_URL)
    public ResponseEntity<Object> updateStatus(@Valid @RequestBody TaskUpdateStatusDTO taskDto) {
		logger.info("updateStatus Input {}", taskDto);
		return new ResponseEntity<>(taskService.updateStatus(taskDto), HttpStatus.OK);
    }
}
