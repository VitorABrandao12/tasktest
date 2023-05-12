package com.backendapi.codechallenge.aplication.service.dto;


import com.backendapi.codechallenge.domain.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * Input class for Transactions search endpoint.
 * @author Vitor Augusto Brandao
 * @version 1.0
*/
public class TaskUpdateStatusDTO {
	
	@JsonProperty(value = Constants.ID_FIELD, required = true)
	@NotNull
	private long id;
	
	@JsonProperty(value = Constants.STATUS_FIELD, required = true)
	@NotNull
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
