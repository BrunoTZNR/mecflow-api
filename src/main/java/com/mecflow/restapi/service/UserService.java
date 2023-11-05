package com.mecflow.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.UserDTO;
import com.mecflow.restapi.dto.mapper.UserMapper;
import com.mecflow.restapi.exception.UserNotFoundException;
import com.mecflow.restapi.repository.UserRepository;

import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
	
	@Autowired
	private final UserMapper userMapper;
	
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	//one user of login
	public UserDTO findByLogin(@NotNull String login) {
		return userRepository.findByLogin(login)
				.map(userMapper::toDTO)
				.orElseThrow(() -> new UserNotFoundException(login));
	}
}
