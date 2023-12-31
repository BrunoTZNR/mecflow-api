package com.mecflow.restapi.model;

import java.io.Serializable;

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
@Table(name = "tb_contact")
public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Length(max = 11, min = 11)
	@Column(name = "phone_contact", nullable = false, length = 11)
	private String phone;
	
	@Length(max = 200, min = 4)
	@Column(name = "email_contact", nullable = true, length = 11)
	private String email;
	
	@Length(max = 11, min = 11)
	@Column(name = "whatsapp_contact", nullable = true, length = 11)
	private String whatsapp;
}
