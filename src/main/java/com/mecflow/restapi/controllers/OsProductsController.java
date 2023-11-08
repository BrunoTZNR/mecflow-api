package com.mecflow.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mecflow.restapi.dto.OsProductsRequestDTO;
import com.mecflow.restapi.dto.OsProductsResponseDTO;
import com.mecflow.restapi.service.OsProductsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/osproducts")
public class OsProductsController {

	@Autowired
	private final OsProductsService opService;
	
	public OsProductsController(OsProductsService opService) {
		this.opService = opService;
	}
	
	@GetMapping("/{os_id}")
	public List<OsProductsResponseDTO> listByOs(@PathVariable @NotNull @Positive Long os_id) {
		return opService.listByOs(os_id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OsProductsResponseDTO create(@RequestBody @Valid OsProductsRequestDTO opDTO) {
		return opService.create(opDTO);
	}
}
