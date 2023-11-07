package com.mecflow.restapi.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "people_id")
	private People people;
	
	@Valid
	@OneToMany(orphanRemoval = false, mappedBy = "client")
	@JsonIgnore
	private List<Os> os;
}
