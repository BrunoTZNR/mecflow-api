package com.mecflow.restapi.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.AdvanceRequestDTO;
import com.mecflow.restapi.dto.AdvanceResponseDTO;
import com.mecflow.restapi.enums.Status;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Advance;
import com.mecflow.restapi.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AdvanceMapper {

	@Autowired
	private final EmployeeMapper empMapper;
	
	@Autowired
	private final EmployeeRepository empRepository;
	
	public AdvanceResponseDTO toDTO(Advance a) {
		if(a == null) {
			return null;
		}
		
		return new AdvanceResponseDTO(a.getId(), a.getDt(), 
				a.getAmount(), a.getStatus().getValue(), 
				empMapper.toDTO(a.getEmployee()));
	}
	
	public Advance toEntity(AdvanceRequestDTO a) {
		if(a == null) {
			return null;
		}
		
		Advance ad0 = new Advance();
		
		if(a.id() != null) {
			ad0.setId(a.id());
		}
		
		ad0.setDt(a.dt());
		ad0.setAmount(a.amount());
		ad0.setStatus(convertStatusValue(a.status()));
		ad0.setEmployee(empRepository.findById(a.employee_id()).orElseThrow(() -> new RecordNotFoundException(a.employee_id())));
		ad0.setPayday(null);
		
		return ad0;
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
