package com.mecflow.restapi.exception;

public class DuplicateCodValueException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DuplicateCodValueException(String cod) {
		super("O código digitado já está cadastrado, código: " + cod);
	}
}
