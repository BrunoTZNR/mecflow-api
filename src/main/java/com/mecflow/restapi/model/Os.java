package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mecflow.restapi.enums.Status;
import com.mecflow.restapi.enums.converters.StatusConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
	private Double totalAmount = 0.00;
	
	@Range(min = 0, max = 99999)
	@Column(name = "totalDiscount_os", nullable = true)
	private Double totalDiscount = 0.00;
	
	@NotNull
	@Column(name = "status_os", nullable = false, length = 10)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.PENDENTE;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;
	
	@Valid
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "os")
	@JsonIgnore
	private List<OsProducts> osProducts;
	
	@Valid
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "os")
	@JsonIgnore
	private List<OsServices> osServices;
}
