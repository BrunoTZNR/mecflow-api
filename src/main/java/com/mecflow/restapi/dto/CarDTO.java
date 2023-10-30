package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CarDTO(
		
		Long id,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(max = 20, message = "Tamanho máximo do campo é 20")
		String model,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(max = 15, message = "Tamanho máximo do campo é 15")
		String automaker,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(min = 4, max = 4, message = "Tamanho obrigatório: 4")
		String fYear,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(min = 4, max = 4, message = "Tamanho obrigatório: 4")
		String mYear,
		
		@NotBlank(message = "Este campo é obrigatório")
		@Length(max = 20)
		String color,
		
		@NotNull(message = "Este campo é obrigatório")
		@Min(value = 1, message = "O valor não pode ser menor que 1")
		Double capacity,
		
		@NotNull(message = "Este campo é obrigatório")
		@Min(value = 8, message = "O valor não pode ser menor que 8")
		Integer engine,
		
		@NotNull(message = "Este campo é obrigatório")
		@Pattern(regexp = "gasolina|alcool|flex|diesel|eletrico", message = "Tipo de pagamento inválido")
		String fuel
		) {}
