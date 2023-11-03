package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record ContactDTO(
		
		Long id,
		
		@NotBlank
		@Length(max = 11, min = 11)
		String phone,
		
		@Length(max = 200, min = 4)
		String email,
		
		@Length(max = 11, min = 11)
		String whatsapp
		) {}
