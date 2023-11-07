package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Range;

import com.mecflow.restapi.enums.Status;
import com.mecflow.restapi.enums.converters.StatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_os")
public class Os implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "dtCad_os", nullable = false)
	private LocalDateTime dtCad = LocalDateTime.now();
	
	@NotNull
	@Column(name = "dtIn_os", nullable = false)
	private LocalDate dtIn;
	
	@NotNull
	@Column(name = "dtOut_os", nullable = false)
	private LocalDate dtOut;
	
	@Range(min = 0, max = 99999)
	@Column(name = "totalAmount_os", nullable = true)
	private Double totalAmount;
	
	@Range(min = 0, max = 99999)
	@Column(name = "totalDiscount_os", nullable = true)
	private Double totalDiscount;
	
	@NotNull
	@Column(name = "status_os", nullable = false, length = 10)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.PENDENTE;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "car_id")
	private Car car;
}