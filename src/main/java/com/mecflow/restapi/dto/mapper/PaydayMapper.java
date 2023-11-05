package com.mecflow.restapi.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.PaydayDTO;
import com.mecflow.restapi.model.Payday;

@Component
public class PaydayMapper {
	
	@Autowired
	private final EmployeeMapper employeeMapper;

	public PaydayMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}
	
	public PaydayDTO toDTO(Payday p) {
		if(p == null) {
			return null;
		}
		
		return new PaydayDTO(
				p.getId(), p.getDt(), p.getAmount(), p.getAmountCom(), 
				p.getAmountAd(), p.getTotalAmount(), employeeMapper.toDTO(p.getEmployee()));
	}
	
	public Payday toEntity(PaydayDTO pDTO) {
		if(pDTO == null) {
			return null;
		}
		
		Payday p0 = new Payday();
		
		if(pDTO.id() != null) {
			p0.setId(pDTO.id());
		}
		
		p0.setDt(pDTO.dt());
		p0.setAmount(pDTO.amount());
		p0.setAmountCom(pDTO.amountCom());
		p0.setAmountAd(pDTO.amountAd());
		p0.setTotalAmount(pDTO.totalAmount());
		p0.setEmployee(employeeMapper.toEntity(pDTO.employee()));
		
		return p0;
	}
}
