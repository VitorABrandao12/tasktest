package com.backendapi.codechallenge.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.StreamSupport;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.backendapi.codechallenge.aplication.service.dto.TaskUpdateStatusDTO;
import com.backendapi.codechallenge.domain.Constants;
import com.backendapi.codechallenge.domain.model.Task;
import com.backendapi.codechallenge.domain.port.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TaskControllerTest {
	
	@Autowired
    private TaskRepository repository;

    @Autowired
    private MockMvc mockMvc;
    
    public Task generateTestTask(String name, String description) {
    	Task t = new Task();
    	t.setStatus("");
    	t.setName(name);
    	t.setDescription(description);
    	return t;
    }
    
    @Test
    void should_create_a_task() throws Exception {
    	Task t = generateTestTask("createtask", "createtask test");
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = objectMapper.writeValueAsString(t);
        
        this.mockMvc.perform(post(Constants.TASK_URL + Constants.CREATE_URL)
            .contentType(APPLICATION_JSON)
            .content(json)
        )
        .andExpect(status().isCreated());
    }
    
    @Test
    void should_update_status() throws Exception {
    	Task t = generateTestTask("createtask", "createtask test");
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = objectMapper.writeValueAsString(t);
        
        this.mockMvc.perform(post(Constants.TASK_URL + Constants.CREATE_URL)
            .contentType(APPLICATION_JSON)
            .content(json)
        )
        .andExpect(status().isCreated());
        
        Iterable<Task> tasks = repository.findAll();
        long id = tasks.iterator().next().getId();
        
    	TaskUpdateStatusDTO temp = new TaskUpdateStatusDTO();
    	temp.setId(id);
    	temp.setStatus("test");
    	
    	json = objectMapper.writeValueAsString(temp);
        
        this.mockMvc.perform(patch(Constants.TASK_URL + Constants.STATUS_URL)
            .contentType(APPLICATION_JSON)
            .content(json)
        )
        .andExpect(status().isOk());
        
        Iterable<Task> tasksResult = repository.findAll();
        Task result = tasksResult.iterator().next();
        String status = result.getStatus();
        
        assertThat(status).isEqualTo("test");
    }
    
    @Test
    void should_get_all() throws Exception {
    	Task t = generateTestTask("createtask", "createtask test");
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = objectMapper.writeValueAsString(t);
        
        this.mockMvc.perform(post(Constants.TASK_URL + Constants.CREATE_URL)
            .contentType(APPLICATION_JSON)
            .content(json)
        )
        .andExpect(status().isCreated());
        
        this.mockMvc.perform(post(Constants.TASK_URL + Constants.CREATE_URL)
            .contentType(APPLICATION_JSON)
            .content(json)
        )
        .andExpect(status().isCreated());
        
        Iterable<Task> tasks = repository.findAll();
        long i = StreamSupport.stream(tasks.spliterator(), false).count();

        assertThat((i+"").equals("2")).isTrue();
    }
    
}
