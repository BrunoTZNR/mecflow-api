package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ClientDTO(
		
		Long id,
		
		@Length(max = 11, min = 11)
		String cpf,

		@NotNull
		@NotEmpty
		@Valid
		PeopleDTO people
		) {}
