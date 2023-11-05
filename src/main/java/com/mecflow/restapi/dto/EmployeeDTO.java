package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EmployeeDTO(
		
		Long id,
		
		@NotNull
		@Range(min = 0, max = 100)
		Double comission,
		
		@NotNull
		@NotEmpty
		@Valid
		PeopleDTO people
		) {}