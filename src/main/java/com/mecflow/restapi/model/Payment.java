package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.mecflow.restapi.enums.TypePay;
import com.mecflow.restapi.enums.converters.TypePayConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "amount_pay", nullable = false)
	private Double amount;
	
	@NotNull
	@Column(name = "dt_pay", nullable = false)
	private LocalDate dt;
	
	@NotNull
	@Column(name = "dtCad_pay", nullable = false)
	private LocalDateTime dtCad = LocalDateTime.now();
	
	@NotNull
	@Convert(converter = TypePayConverter.class)
	@Column(name = "type_pay", nullable = false, length = 8)
	private TypePay typePay;
	
	@Min(value = 1)
	@Column(name = "installments", nullable = true)
	private Integer installments = 1;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "os_id", nullable = true)
    private Os os;
}
