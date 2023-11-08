package com.mecflow.restapi.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.OsProductsRequestDTO;
import com.mecflow.restapi.dto.OsProductsResponseDTO;
import com.mecflow.restapi.model.OsProducts;
import com.mecflow.restapi.service.EmployeeService;
import com.mecflow.restapi.service.OsService;
import com.mecflow.restapi.service.ProductService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Component
@AllArgsConstructor
@Getter
public class OsProductsMapper {
	
	@Autowired
	private final ProductService prodService;
	
	@Autowired
	private final EmployeeService empService;
	
	@Autowired
	private final OsService osService;
	
	public OsProducts toEntity(OsProductsRequestDTO op) {
		if(op == null) {
			return null;
		}
		
		OsProducts op0 = new OsProducts();
		
		op0.setOs(osService.getOsMapper().toEntity(osService.findById(op.id_os())));
		op0.setProduct(prodService.getProductMapper().toEntity(prodService.findById(op.id_product())));
		op0.setAmount(op.amount());
		op0.setQuantity(op.quantity());
		op0.setDiscount(op.discount());
		op0.setEmployee(empService.getEmployeeMapper().toEntity(empService.findById(op.employee_id())));
		
		return op0;
	}
	
	public OsProductsResponseDTO toDTO(OsProducts op) {
		if(op == null) {
			return null;
		}
		
		return new OsProductsResponseDTO(
				op.getOs().getId(),
				prodService.findById(op.getProduct().getId()),
				op.getAmount(),
				op.getQuantity(),
				op.getDiscount(),
				op.getEmployee().getId());
	}
}
