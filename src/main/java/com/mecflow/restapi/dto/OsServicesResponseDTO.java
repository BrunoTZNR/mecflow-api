package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OsServicesResponseDTO(
		
		Long id_os,
		
		@NotNull
		@NotEmpty
		@Valid
		ServicesDTO service,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double amount,
		
		@NotNull
		@Positive
		@Range(min = 0, max = 9999)
		Integer quantity,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double discount,
		
		@NotNull
		@Positive
		Long employee_id
		) {}
