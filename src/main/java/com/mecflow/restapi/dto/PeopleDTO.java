package com.mecflow.restapi.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;

public record PeopleDTO(

		@NotBlank
		@Length(max = 15, min = 3)
		String fName,
	
		@Length(max = 15)
		String lName,
		
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dtNasc,

		ContactDTO contact,

		AddressDTO address
		) {}
