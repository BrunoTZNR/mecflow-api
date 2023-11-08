package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OsProductsRequestDTO(
		
		@NotNull
		@Positive
		Long id_os,
		
		@NotNull
		@Positive
		Long id_product,
		
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
