package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_payday")
public class Payday implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "dtCad_pd", nullable = false)
	private LocalDateTime dtCad = LocalDateTime.now();
	
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dt_pd", nullable = false)
	private LocalDate dt;
	
	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "amount_pd", nullable = false)
	private Double amount;
	
	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "amountCom_pd", nullable = false)
	private Double amountCom;
	
	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "amountAd_pd", nullable = false)
	private Double amountAd;
	
	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "totalAmount_pd", nullable = false)
	private Double totalAmount;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
}
