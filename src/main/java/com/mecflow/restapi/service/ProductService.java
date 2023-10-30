package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.ProductDTO;
import com.mecflow.restapi.dto.mapper.ProductMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.repository.ProductRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ProductService {

	@Autowired
	private final ProductRepository productRepository;
	
	@Autowired
	private final ProductMapper productMapper;
	
	public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}
	
	//all products
	public List<ProductDTO> list() {
		return productRepository.findAll()
				.stream()
				.map(productMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one product
	public ProductDTO findById(@Positive @NotNull Long id) {
		return productRepository.findById(id)
				.map(productMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create product
	public ProductDTO create(@Valid @NotNull ProductDTO productDTO) {
		return productMapper.toDTO(productRepository.save(productMapper.toEntity(productDTO)));
	}
	
	//update product
	public ProductDTO update(@Positive @NotNull Long id, @Valid @NotNull ProductDTO productDTO) {
		return productRepository.findById(id)
				.map(recordFound -> {
					recordFound.setCod(productDTO.cod());
					recordFound.setStock(productDTO.stock());
					recordFound.setDesc(productDTO.desc());
					recordFound.setPrice(productDTO.price());
					recordFound.setNcm(productDTO.ncm());
					
					return productMapper.toDTO(productRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete product
	public void delete(@Positive @NotNull Long id) {
		productRepository.delete(productRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
		
	}
}
