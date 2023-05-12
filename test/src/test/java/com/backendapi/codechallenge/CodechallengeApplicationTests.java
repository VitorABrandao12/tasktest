package com.backendapi.codechallenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backendapi.codechallenge.infraestructure.rest.controller.TaskController;

@SpringBootTest
class CodechallengeApplicationTests {
	
	@Autowired
	private TaskController taskController;
	
	@Test
	void contextLoads() {
		assertThat(taskController).isNotNull();
	}

}
