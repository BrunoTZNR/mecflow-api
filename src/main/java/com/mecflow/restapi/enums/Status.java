package com.mecflow.restapi.enums;

public enum Status {
	CONCLUIDO("concluido"),
	PENDENTE("pendente"),
	CANCELADO("cancelado");
	
	private String value;
	
	private Status(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
