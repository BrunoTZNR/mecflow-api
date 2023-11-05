package com.mecflow.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mecflow.restapi.dto.UserDTO;
import com.mecflow.restapi.service.UserService;

import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{login}")
	public UserDTO findById(@PathVariable @NotNull String login) {
		return userService.findByLogin(login);
	}
}
