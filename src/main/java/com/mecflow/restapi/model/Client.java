package com.mecflow.restapi.model;

import java.io.Serializable;

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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_client")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(max = 11, min = 11)
	@Column(name = "cpf", nullable = true, unique = true, length = 11)
	private String cpf;
	
	@NotNull
	@NotEmpty
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "people_id")
	private People people;
}
