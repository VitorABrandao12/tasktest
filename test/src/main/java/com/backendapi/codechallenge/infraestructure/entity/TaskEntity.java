package com.backendapi.codechallenge.infraestructure.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.backendapi.codechallenge.domain.Constants;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Table(name = "TASK", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Constants.ID_FIELD, updatable = false, nullable = false)
	private long id;
	
	@NotNull
	@Basic(optional = false)
	@Column(name = Constants.NAME_FIELD, nullable = false)
	private String name;
	
	@Column(name = Constants.DESCRIPTION_FIELD)
	private String description;
	
	@Column(name = Constants.STATUS_FIELD)
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
