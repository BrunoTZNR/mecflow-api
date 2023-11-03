package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public record EmployeeDTO(
		
		Long id,
		
		@NotNull
		@Range(min = 0, max = 100)
		Double comission,
		
		PeopleDTO people
		) {}
