package com.mecflow.restapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.ServicesDTO;
import com.mecflow.restapi.model.Services;

@Component
public class ServicesMapper {
	
	public ServicesDTO toDTO(Services s) {
		if(s == null) {
			return null;
		}
		
		return new ServicesDTO(s.getId(), s.getDesc(), s.getAmount());
	}
	
	public Services toEntity(ServicesDTO sDTO) {
		if(sDTO == null) {
			return null;
		}
		
		Services s0 = new Services();
		
		if(sDTO.id() != null) {
			s0.setId(sDTO.id());
		}
		
		s0.setDesc(sDTO.desc());
		s0.setAmount(sDTO.amount());
		
		return s0;
	}
}
