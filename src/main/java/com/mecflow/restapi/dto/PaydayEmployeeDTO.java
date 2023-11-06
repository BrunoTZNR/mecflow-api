package com.mecflow.restapi.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PaydayEmployeeDTO(

		Long id,
		
		@NotNull
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dt,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double salary,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double amountCom,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double amountAd,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double totalAmount,
		
		@NotNull
		@NotEmpty
		@Valid
		EmployeeDTO employee,
		
		@Valid
		List<AdvanceResponseDTO> advances
		) {}
