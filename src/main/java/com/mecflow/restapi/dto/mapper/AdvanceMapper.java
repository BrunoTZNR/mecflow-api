package com.mecflow.restapi.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.AdvanceCreateDTO;
import com.mecflow.restapi.dto.AdvanceDTO;
import com.mecflow.restapi.enums.Status;
import com.mecflow.restapi.model.Advance;
import com.mecflow.restapi.service.EmployeeService;

@Component
public class AdvanceMapper {
	
	@Autowired
	private final EmployeeMapper employeeMapper;
	
	@Autowired
	private final EmployeeService employeeService;
	
	public AdvanceMapper(EmployeeMapper employeeMapper, EmployeeService employeeService) {
		this.employeeMapper = employeeMapper;
		this.employeeService = employeeService;
	}
	
	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}
	
	public AdvanceDTO toDTO(AdvanceCreateDTO aCDTO) {
		if(aCDTO == null) {
			return null;
		}
		
		return new AdvanceDTO(aCDTO.id(), aCDTO.dt(), aCDTO.amount(), 
				aCDTO.status(), employeeService.findById(aCDTO.employee_id()));
	}
	
	public AdvanceDTO toDTO(Advance a) {
		if(a == null) {
			return null;
		}
		
		return new AdvanceDTO(a.getId(), a.getDt(), a.getAmount(), 
				a.getStatus().getValue(), employeeMapper.toDTO(a.getEmployee()));
	}
	
	public Advance toEntity(AdvanceDTO aDTO) {
		if(aDTO == null) {
			return null;
		}
		
		Advance a0 = new Advance();
		
		if(aDTO.id() != null) {
			a0.setId(aDTO.id());
		}
		
		a0.setDt(aDTO.dt());
		a0.setAmount(aDTO.amount());
		a0.setStatus(convertStatusValue(aDTO.status()));
		a0.setEmployee(employeeMapper.toEntity(aDTO.employee()));
		
		return a0;
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
