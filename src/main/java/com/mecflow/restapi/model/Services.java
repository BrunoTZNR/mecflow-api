package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_service")
public class Services implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Length(max = 120)
	@Column(name = "desc_serv", nullable = false, length = 120)
	private String desc;
	
	@NotNull
	@Min(value = 0)
	@Column(name = "amount_serv", nullable = false)
	private Double amount;
	
	@NotNull
	@Column(name = "dtCad_serv", nullable = false)
	private LocalDateTime dtCad = LocalDateTime.now();
}
