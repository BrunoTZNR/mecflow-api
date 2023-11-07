package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mecflow.restapi.enums.Fuel;
import com.mecflow.restapi.enums.converters.FuelConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_car")
public class Car implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotBlank
	@Length(max = 7, min = 7)
	@Column(nullable = false, length = 7)
	private String placa;
	
	@NotNull
	@Column(name = "dtCad_car", nullable = false)
	private LocalDateTime dtCad = LocalDateTime.now();
	
	@NotBlank
	@Length(max = 20)
	@Column(name = "model_car", nullable = false, length = 20)
	private String model;

	@NotBlank
	@Length(max = 15)
	@Column(name = "automaker_car", nullable = false, length = 15)
	private String automaker;

	@NotBlank
	@Length(min = 4, max = 4)
	@Column(name = "fYear_car", nullable = false, length = 4)
	private String fYear;
	
	@NotBlank
	@Length(min = 4, max = 4)
	@Column(name = "mYear_car", nullable = false, length = 4)
	private String mYear;
	
	@NotBlank
	@Length(max = 20)
	@Column(name = "color_car", nullable = false, length = 20)
	private String color;
	
	@NotNull
	@Min(value = 1)
	@Column(name = "capacity_car", nullable = false)
	private Double capacity;
	
	@NotNull
	@Min(value = 8)
	@Column(name = "engine_car", nullable = false)
	private Integer engine;
	
	@NotNull
	@Column(name = "fuel_car", nullable = false, length = 8)
	@Convert(converter = FuelConverter.class)
	private Fuel fuel;
	
	@Valid
	@OneToMany(orphanRemoval = true, mappedBy = "car")
	@JsonIgnore
	private List<Os> os;
}
