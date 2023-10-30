package com.mecflow.restapi.enums;

public enum TypePay {
	CREDITO("credito"),
	DEBITO("debito"),
	DINHEIRO("dinheiro"),
	PIX("pix");
	
	private String value;
	
	private TypePay(String value) {
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
