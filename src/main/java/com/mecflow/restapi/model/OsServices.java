package com.mecflow.restapi.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Range;

import com.mecflow.restapi.model.id.OsServicesId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_os_services")
@IdClass(OsServicesId.class)
public class OsServices implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "os_id", nullable = false)
    private Os os;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "service_id", nullable = false)
    private Services service;

	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "amount", nullable = false)
	private Double amount;
	
	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@NotNull
	@Range(min = 0, max = 9999)
	@Column(name = "discount", nullable = false)
	private Double discount;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
}
