package com.mecflow.restapi.exception;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String login) {
		super("Usuário não encontrado com o login: " + login);
	}
}
