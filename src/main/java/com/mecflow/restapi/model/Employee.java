package com.mecflow.restapi.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Range;

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
@Table(name = "tb_employee")
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "salary_employee", nullable = true)
	private Double salary = 0.0;
	
	@NotNull
	@Range(min = 0, max = 100)
	@Column(name = "comission_employee", nullable = true)
	private Double comission;
	
	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "people_id")
	private People people;
	
	@Valid
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
	private List<Advance> advances;
	
	@Valid
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "employee")
	private List<Payday> paydays;
}
