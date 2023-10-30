package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicesDTO(
		
		Long id,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(max = 60)
		String desc,
		
		@NotNull(message = "Este campo é obrigatório")
		@Min(value = 0, message = "O valor não pode ser menor que 0")
		Double amount
		) {}
