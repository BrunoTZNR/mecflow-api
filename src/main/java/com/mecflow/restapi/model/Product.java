package com.mecflow.restapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	@Length(max = 15)
	@Column(name = "cod_product", nullable = false, length = 15, unique = true)
	private String codProduct;
	
	@NotNull
	@Range(min = 0, max = 999)
	@Column(name = "stock_product", nullable = false)
	private Integer stockProduct = 0;
	
	@NotBlank
	@NotNull
	@Length(max = 60)
	@Column(name = "desc_product", nullable = false, length = 60)
	private String descProduct;
	
	@NotNull
	@Column(name = "dtCad_product", nullable = false)
	private LocalDateTime dtCadProduct = LocalDateTime.now();
	
	@NotNull
	@Min(value = 0)
	@Column(name = "price_product", nullable = false)
	private Double priceProduct;
	
	@Length(max = 10)
	@Column(name = "ncm_product", nullable = true, length = 10)
	private String ncmProduct = null;
}
