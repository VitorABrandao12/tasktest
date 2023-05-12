package com.backendapi.codechallenge.infraestructure.adaptor;

import org.springframework.data.repository.CrudRepository;

import com.backendapi.codechallenge.infraestructure.entity.TaskEntity;

public interface TaskCrudRepository extends CrudRepository<TaskEntity, String> {
}
