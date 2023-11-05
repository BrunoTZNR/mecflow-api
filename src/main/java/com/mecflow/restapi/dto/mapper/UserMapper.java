package com.mecflow.restapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.UserDTO;
import com.mecflow.restapi.model.User;

@Component
public class UserMapper {

	public UserDTO toDTO(User u) {
		if(u == null) {
			return null;
		}
		
		return new UserDTO(u.getId(), u.getLogin(), u.getPass());
	}
	
	public User toEntity(UserDTO uDTO) {
		if(uDTO == null) {
			return null;
		}
		
		User u0 = new User();
		
		if(uDTO.id() != null) {
			u0.setId(uDTO.id());
		}
		
		u0.setLogin(uDTO.login());
		u0.setPass(uDTO.pass());
		
		return u0;
	}
}
