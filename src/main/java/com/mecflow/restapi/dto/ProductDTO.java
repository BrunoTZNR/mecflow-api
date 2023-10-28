package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
		
		Long id,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(max = 15, message = "Tamanho máximo do campo é 15")
		String cod,
		
		@NotNull(message = "Este campo é obrigatório")
		@Range(min = 0, max = 999, message = "O valor deve estar entre 0 a 999")
		Integer stock,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(max = 60, message = "Tamanho máximo do campo é 60")
		String desc,
		
		@NotNull(message = "Este campo é obrigatório")
		@Min(value = 0, message = "O valor não pode ser menor que 0")
		Double price,
		
		@Length(max = 10, message = "Tamanho máximo do campo é 10")
		String ncm
		) {}
