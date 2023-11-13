package com.mecflow.restapi.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PaymentDTO(
		
		Long id,
		
		@NotNull(message = "Este campo é obrigatório")
		Double amount,
		
		@NotNull(message = "Este campo é obrigatório")
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dt,
		
		@NotNull
		@Pattern(regexp = "credito|debito|dinheiro|pix", message = "Tipo de pagamento inválido")
		String typePay,
		
		@Min(value = 1, message = "O valor não pode ser menor que 1")
		Integer installments,
		
		Long os_id
		) {}
