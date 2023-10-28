package com.mecflow.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mecflow.restapi.dto.ProductDTO;
import com.mecflow.restapi.service.ProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductDTO> list() {
		return productService.list();
	}
	
	@GetMapping("/{id}")
	public ProductDTO findById(@PathVariable @NotNull @Positive Long id) {
		return productService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductDTO create(@RequestBody @Valid ProductDTO productDTO) {
		return productService.create(productDTO);
	}
	
	@PutMapping("/{id}")
	public ProductDTO update(@PathVariable @NotNull @Positive Long id,
			@RequestBody @Valid ProductDTO productDTO) {
		return productService.update(id, productDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotNull @Positive Long id) {
		productService.delete(id);
	}
}
