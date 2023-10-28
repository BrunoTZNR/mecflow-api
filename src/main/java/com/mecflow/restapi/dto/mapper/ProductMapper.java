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
				product.getCodProduct(), product.getStockProduct(), 
				product.getDescProduct(), product.getPriceProduct(), 
				product.getNcmProduct());
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
			product0.setNcmProduct(productDTO.ncm());
		}
		
		product0.setCodProduct(productDTO.cod());
		product0.setStockProduct(productDTO.stock());
		product0.setDescProduct(productDTO.desc());
		product0.setPriceProduct(productDTO.price());
		
		return product0;
	}
}
