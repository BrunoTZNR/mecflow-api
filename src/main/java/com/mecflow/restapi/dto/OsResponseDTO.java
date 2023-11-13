package com.mecflow.restapi.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record OsResponseDTO(
		
		Long id,
		
		@NotNull
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dtIn,
		
		@NotNull
		@JsonFormat(pattern = "yyyy-MM-dd")
		LocalDate dtOut,
		
		@Range(min = 0, max = 9999)
		Double totalAmount,
		
		@Range(min = 0, max = 9999)
		Double totalDiscount,
		
		@NotNull(message = "Este campo é obrigatório")
		@Pattern(regexp = "concluido|pendente|cancelado", message = "Tipo de pagamento inválido")
		String status,
		
		@NotNull
		@NotEmpty
		ClientDTO client,
		
		@NotNull
		@NotEmpty
		CarDTO car,
		
		List<OsProductsResponseDTO> osProducts,
		
		List<OsServicesResponseDTO> osServices,
		
		List<PaymentDTO> payment
		) {}
