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

import com.mecflow.restapi.dto.ServicesDTO;
import com.mecflow.restapi.service.ServicesService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {
	
	@Autowired
	private final ServicesService servicesService;
	
	public ServicesController(ServicesService servicesService) {
		this.servicesService = servicesService;
	}
	
	@GetMapping
	public List<ServicesDTO> list() {
		return servicesService.list();
	}
	
	@GetMapping("/{id}")
	public ServicesDTO findById(@PathVariable @NotNull @Positive Long id) {
		return servicesService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ServicesDTO create(@RequestBody @Valid ServicesDTO servicesDTO) {
		return servicesService.create(servicesDTO);
	}
	
	@PutMapping("/{id}")
	public ServicesDTO update(@PathVariable @Positive @NotNull Long id,
			@RequestBody @Valid ServicesDTO servicesDTO) {
		return servicesService.update(id, servicesDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @Positive Long id) {
		servicesService.delete(id);
	}
}
