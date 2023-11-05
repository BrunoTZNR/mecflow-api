package com.mecflow.restapi.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AdvanceDTO(
		
		Long id,
		
		@NotNull
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dt,
		
		@NotNull
		@Range(min = 0, max = 9999)
		Double amount,
		
		@NotNull(message = "Este campo é obrigatório")
		@Pattern(regexp = "concluido|pendente|cancelado", message = "Tipo de pagamento inválido")
		String status,
		
		@NotNull
		@NotEmpty
		@Valid
		EmployeeDTO employee
		) {}
