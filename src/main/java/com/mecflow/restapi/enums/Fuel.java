package com.mecflow.restapi.enums;

public enum Fuel {
	GASOLINA("gasolina"),
	ALCOOL("alcool"),
	FLEX("flex"),
	DIESEL("diesel"),
	ELETRICO("eletrico");
	
	private String value;
	
	private Fuel(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
