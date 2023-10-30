package com.mecflow.restapi.enums.converters;

import java.util.stream.Stream;

import com.mecflow.restapi.enums.Fuel;

import jakarta.persistence.AttributeConverter;

public class FuelConverter implements AttributeConverter<Fuel, String>{

	@Override
	public String convertToDatabaseColumn(Fuel fuel) {
		if(fuel == null) {
			return null;
		}
		
		return fuel.getValue();
	}

	@Override
	public Fuel convertToEntityAttribute(String value) {
		if(value == null) {
			return null;
		}
		
		return Stream.of(Fuel.values())
				.filter(f -> f.getValue().equals(value))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
