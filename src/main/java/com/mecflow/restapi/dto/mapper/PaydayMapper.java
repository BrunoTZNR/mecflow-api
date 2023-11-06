package com.mecflow.restapi.dto.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.PaydayEmployeeDTO;
import com.mecflow.restapi.model.Payday;

@Component
public class PaydayMapper {

	/*public PaydayEmployeeDTO toEmployeeDTO(Payday p) {
		if(p == null) {
			return null;
		}
		
		return new PaydayEmployeeDTO(
				p.getId(), p.getDt(), p.getSalary(), p.getAmountCom(), 
				p.getAmountAd(), p.getTotalAmount(), 
				employeeMapper.toDTO(p.getEmployee()), 
				p.getAdvances()
					.stream()
					.map(advanceMapper::toDTO)
					.collect(Collectors.toList()));
	}
	
	public Payday toEntity(PaydayEmployeeDTO pEDTO) {
		if(pEDTO == null) {
			return null;
		}
		
		Payday p0 = new Payday();
		
		if(pEDTO.id() != null) {
			p0.setId(pEDTO.id());
		}
		
		p0.setDt(pEDTO.dt());
		p0.setSalary(pEDTO.salary());
		p0.setAmountCom(pEDTO.amountCom());
		p0.setAmountAd(pEDTO.amountAd());
		p0.setTotalAmount(pEDTO.totalAmount());
		p0.setEmployee(employeeMapper.toEntity(pEDTO.employee()));
		p0.setAdvances(pEDTO.advances()
				.stream()
				.map(advanceMapper::toEntity)
				.collect(Collectors.toList()));
		
		return p0;
	}*/
}
