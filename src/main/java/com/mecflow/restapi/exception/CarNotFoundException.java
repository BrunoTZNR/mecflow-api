package com.mecflow.restapi.exception;

public class CarNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public CarNotFoundException(String placa) {
		super("Carro não encontrado com a placa: " + placa);
	}

}
