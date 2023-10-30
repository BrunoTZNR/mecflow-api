package com.mecflow.restapi.enums.converters;

import java.util.stream.Stream;

import com.mecflow.restapi.enums.TypePay;

import jakarta.persistence.AttributeConverter;

public class TypePayConverter implements AttributeConverter<TypePay, String>{

	@Override
	public String convertToDatabaseColumn(TypePay typePay) {
		if(typePay == null) {
			return null;
		}
		
		return typePay.getValue();
	}

	@Override
	public TypePay convertToEntityAttribute(String value) {
		if(value == null) {
			return null;
		}
		
		return Stream.of(TypePay.values())
				.filter(t -> t.getValue().equals(value))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
