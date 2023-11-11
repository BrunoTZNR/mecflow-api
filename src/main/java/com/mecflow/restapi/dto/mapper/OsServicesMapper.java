package com.mecflow.restapi.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.OsServicesRequestDTO;
import com.mecflow.restapi.dto.OsServicesResponseDTO;
import com.mecflow.restapi.model.OsServices;
import com.mecflow.restapi.service.EmployeeService;
import com.mecflow.restapi.service.OsService;
import com.mecflow.restapi.service.ServicesService;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Component
@AllArgsConstructor
@Getter
public class OsServicesMapper {
	
	@Autowired
	private final ServicesService servService;
	
	@Autowired
	private final EmployeeService empService;
	
	@Autowired
	private final OsService osService;
	
	public OsServices toEntity(OsServicesRequestDTO os) {
		if(os == null) {
			return null;
		}
		
		OsServices os0 = new OsServices();
		
		os0.setOs(osService.getOsMapper().toEntity(osService.findById(os.id_os())));
		os0.setService(servService.getServicesMapper().toEntity(servService.findById(os.id_services())));
		os0.setAmount(os.amount());
		os0.setQuantity(os.quantity());
		os0.setDiscount(os.discount());
		os0.setEmployee(empService.getEmployeeMapper().toEntity(empService.findById(os.employee_id())));
		
		return os0;
	}
	
	public OsServicesResponseDTO toDTO(OsServices os) {
		if(os == null) {
			return null;
		}
		
		return new OsServicesResponseDTO(
				os.getOs().getId(),
				servService.findById(os.getService().getId()),
				os.getAmount(),
				os.getQuantity(),
				os.getDiscount(),
				os.getEmployee().getId());
	}
}
