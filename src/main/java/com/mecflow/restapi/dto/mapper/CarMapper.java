package com.mecflow.restapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.CarDTO;
import com.mecflow.restapi.enums.Fuel;
import com.mecflow.restapi.model.Car;

@Component
public class CarMapper {

	public CarDTO toDTO(Car c) {
		if(c == null) {
			return null;
		}
		
		return new CarDTO(c.getPlaca(), c.getModel(), c.getAutomaker(), c.getFYear(),
				c.getMYear(), c.getColor(), c.getCapacity(), c.getEngine(), 
				c.getFuel().getValue());
	}
	
	public Car toEntity(CarDTO cDTO) {
		if(cDTO == null) {
			return null;
		}
		
		Car c0 = new Car();
		
		if(cDTO.placa() != null) {
			c0.setPlaca(cDTO.placa());
		}
		
		c0.setModel(cDTO.model());
		c0.setAutomaker(cDTO.automaker());
		c0.setFYear(cDTO.fYear());
		c0.setMYear(cDTO.mYear());
		c0.setColor(cDTO.color());
		c0.setCapacity(cDTO.capacity());
		c0.setEngine(cDTO.engine());
		c0.setFuel(convertFuelValue(cDTO.fuel()));
		
		return c0;
	}
	
	public Fuel convertFuelValue(String value) {
		if(value == null) {
			return null;
		}
		
		return switch(value) {
			case "gasolina" -> Fuel.GASOLINA;
			case "alcool" -> Fuel.ALCOOL;
			case "flex" -> Fuel.FLEX;
			case "diesel" -> Fuel.DIESEL;
			case "eletrico" -> Fuel.ELETRICO;
			default -> throw new IllegalArgumentException("Tipo de combustivel inválido: " + value);
		};
	}
}
