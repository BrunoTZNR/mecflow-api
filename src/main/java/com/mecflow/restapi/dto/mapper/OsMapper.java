package com.mecflow.restapi.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.OsRequestDTO;
import com.mecflow.restapi.dto.OsResponseDTO;
import com.mecflow.restapi.enums.Status;
import com.mecflow.restapi.model.Os;
import com.mecflow.restapi.service.CarService;
import com.mecflow.restapi.service.ClientService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Component
@AllArgsConstructor
@Getter
public class OsMapper {

	@Autowired
	private final CarService carService;
	
	@Autowired
	private final ClientService clientService;
	
	/* REQUEST TO ENTITY */
	public Os toEntity(OsRequestDTO o) {
		if(o == null) {
			return null;
		}
		
		Os os0 = new Os();
		
		if(o.id() != null) {
			os0.setId(o.id());
		}
		
		os0.setDtIn(o.dtIn());
		os0.setDtOut(o.dtOut());
		os0.setTotalAmount(o.totalAmount());
		os0.setTotalDiscount(o.totalDiscount());
		os0.setStatus(convertStatusValue(o.status()));
		os0.setCar(carService.getCarMapper()
				.toEntity(carService.findByPlaca(o.car_id())));
		os0.setClient(clientService.getClientMapper()
				.toEntity(clientService.findById(o.client_id())));
	
		return os0;
	}
	
	/* RESPONSE TO ENTITY */
	public Os toEntity(OsResponseDTO o) {
		if(o == null) {
			return null;
		}
		
		Os os0 = new Os();
		
		if(o.id() != null) {
			os0.setId(o.id());
		}
		
		os0.setDtIn(o.dtIn());
		os0.setDtOut(o.dtOut());
		os0.setTotalAmount(o.totalAmount());
		os0.setTotalDiscount(o.totalDiscount());
		os0.setStatus(convertStatusValue(o.status()));
		os0.setCar(carService.getCarMapper()
				.toEntity(carService.findByPlaca(o.car().placa())));
		os0.setClient(clientService.getClientMapper()
				.toEntity(clientService.findById(o.client().id())));
	
		return os0;
	}
	
	/* ENTITY TO RESPONSE */
	public OsResponseDTO toDTO(Os o) {
		if(o == null) {
			return null;
		}
		
		return new OsResponseDTO(o.getId(), o.getDtIn(), o.getDtOut(), 
				o.getTotalAmount(), o.getTotalDiscount(), o.getStatus().getValue(), 
				clientService.getClientMapper().toDTO(o.getClient()), 
				carService.getCarMapper().toDTO(o.getCar()));
	}
	
	public Status convertStatusValue(String value) {
		if(value == null) {
			return null;
		}
		
		return switch(value) {
			case "concluido" -> Status.CONCLUIDO;
			case "pendente" -> Status.PENDENTE;
			case "cancelado" -> Status.CANCELADO;
			default -> throw new IllegalArgumentException("Tipo de combustivel inválido: " + value);
		};
	}
}
