package com.mecflow.restapi.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PaydayDTO(

		Long id,
		
		@NotNull
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dt,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double salary,

		@NotNull
		@Positive
		Long employee_id,

		List<Long> advances
		) {}
