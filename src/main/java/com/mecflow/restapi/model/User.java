package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Length(max = 45)
	@Column(name = "login_user", nullable = false, length = 45)
	private String login;
	
	@NotBlank
	@Length(max = 45)
	@Column(name = "pass_user", nullable = false, length = 45)
	private String pass;
	
	@Column(name = "dtCad_user", nullable = false)
	private LocalDate dtCad = LocalDate.now();
}
