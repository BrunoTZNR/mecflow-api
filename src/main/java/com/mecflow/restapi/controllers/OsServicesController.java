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

import com.mecflow.restapi.dto.OsServicesRequestDTO;
import com.mecflow.restapi.dto.OsServicesResponseDTO;
import com.mecflow.restapi.service.OsServicesService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/osservices")
public class OsServicesController {

	@Autowired
	private final OsServicesService osService;
	
	public OsServicesController(OsServicesService osService) {
		this.osService = osService;
	}
	
	@GetMapping("/{os_id}")
	public List<OsServicesResponseDTO> listByOs(@PathVariable @NotNull @Positive Long os_id) {
		return osService.listByOs(os_id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OsServicesResponseDTO create(@RequestBody @Valid OsServicesRequestDTO osDTO) {
		return osService.create(osDTO);
	}
}
