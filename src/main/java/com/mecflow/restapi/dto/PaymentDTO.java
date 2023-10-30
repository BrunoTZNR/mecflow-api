package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PaymentDTO(
		
		Long id,
		
		@NotNull(message = "Este campo é obrigatório")
		Double amount,
		
		@NotNull
		@Length(max = 10, message = "Tamanho máximo do campo é 10")
		@Pattern(regexp = "credito|debito|dinheiro|pix", message = "Tipo de pagamento inválido")
		String typePay,
		
		@Min(value = 1, message = "O valor não pode ser menor que 1")
		Integer installments
		) {}
