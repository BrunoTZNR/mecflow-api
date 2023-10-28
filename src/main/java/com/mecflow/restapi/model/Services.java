package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_service")
public class Services implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "desc_serv", nullable = false, length = 120)
	private String desc;
	
	@Column(name = "amount_serv", nullable = false)
	private Double amount;
	
	@Column(name = "dtCad_serv", nullable = false)
	private LocalDate dtCad;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDtCad() {
		return dtCad;
	}

	public void setDtCad(LocalDate dtCad) {
		this.dtCad = dtCad;
	}

	public Long getId() {
		return id;
	}
}
