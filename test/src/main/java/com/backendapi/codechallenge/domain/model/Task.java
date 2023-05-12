package com.backendapi.codechallenge.domain.model;

import com.backendapi.codechallenge.domain.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
	
	@JsonProperty(value = Constants.ID_FIELD, required = false)
	private long id;
	
	@JsonProperty(value = Constants.DESCRIPTION_FIELD, required = true)
	private String description;
	
	@JsonProperty(Constants.NAME_FIELD)
	private String name;
	
	@JsonProperty(value = Constants.STATUS_FIELD, required = true)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
