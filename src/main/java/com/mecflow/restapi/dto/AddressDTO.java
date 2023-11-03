package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

public record AddressDTO(

		@Length(max = 8, min = 8)
		String cep,
		
		@Length(max = 10)
		String number,
		
		@Length(max = 50)
		String street,
		
		@Length(max = 50)
		String neighborhood,
		
		@Length(max = 20)
		String state,
		
		@Length(max = 2)
		String uf
		) {}
