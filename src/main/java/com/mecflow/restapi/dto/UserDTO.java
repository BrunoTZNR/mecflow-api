package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
		
		Long id,

		@NotBlank
		@Length(max = 45)
		String login,
		
		@NotBlank
		@Length(max = 45)
		String pass
		) {}
