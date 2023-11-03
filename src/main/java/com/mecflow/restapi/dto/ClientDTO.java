package com.mecflow.restapi.dto;

import org.hibernate.validator.constraints.Length;

public record ClientDTO(
		
		Long id,
		
		@Length(max = 11, min = 11)
		String cpf,

		PeopleDTO people
		) {}
