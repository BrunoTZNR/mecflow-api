package com.mecflow.restapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.ProductDTO;
import com.mecflow.restapi.model.Product;

@Component
public class ProductMapper {

	public ProductDTO toDTO(Product product) {
		if(product == null) {
			return null;
		}
		
		return new ProductDTO(product.getId(), 
				product.getCod(), product.getStock(), 
				product.getDesc(), product.getPrice(), 
				product.getNcm());
	}
	
	public Product toEntity(ProductDTO productDTO) {
		if(productDTO == null) {
			return null;
		}
		
		Product product0 = new Product();
		
		if(productDTO.id() != null) {
			product0.setId(productDTO.id());
		}
		
		if(productDTO.ncm() != null) {
			product0.setNcm(productDTO.ncm());
		}
		
		product0.setCod(productDTO.cod());
		product0.setStock(productDTO.stock());
		product0.setDesc(productDTO.desc());
		product0.setPrice(productDTO.price());
		
		return product0;
	}
}
