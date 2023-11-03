package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_people")
public class People implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Length(max = 15, min = 3)
	@Column(name = "fName_people", nullable = false, length = 15)
	private String fName;
	
	@Length(max = 15)
	@Column(name = "lName_people", nullable = true, length = 15)
	private String lName;
	
	@Column(name = "dtNasc_people", nullable = true)
	private LocalDate dtNasc;
	
	@NotNull
	@Column(name = "dtCad_people", nullable = false, length = 11)
	private LocalDateTime dtCad = LocalDateTime.now();
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "contact_id")
	private Contact contact;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "address_id")
	private Address address;
}
