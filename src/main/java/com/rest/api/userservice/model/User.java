package com.rest.api.userservice.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {
	
	@Id
	private String id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@NotNull
	private String role;

}
