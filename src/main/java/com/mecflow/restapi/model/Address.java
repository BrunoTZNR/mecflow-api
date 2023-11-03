package com.mecflow.restapi.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_address")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Length(max = 8, min = 8)
	@Column(name = "cep_address", nullable = false, length = 8)
	private String cep;
	
	@Length(max = 10)
	@Column(name = "number_address", nullable = true, length = 10)
	private String number;
	
	@Length(max = 50)
	@Column(name = "street_address", nullable = true, length = 50)
	private String street;
	
	@Length(max = 50)
	@Column(name = "neightborhood_address", nullable = true, length = 50)
	private String neighborhood;
	
	@Length(max = 20)
	@Column(name = "state_address", nullable = true, length = 20)
	private String state;
	
	@Length(max = 2)
	@Column(name = "uf_address", nullable = true, length = 2)
	private String uf;
}
