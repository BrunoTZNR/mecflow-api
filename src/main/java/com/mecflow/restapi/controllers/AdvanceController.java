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

import com.mecflow.restapi.dto.AdvanceRequestDTO;
import com.mecflow.restapi.dto.AdvanceResponseDTO;
import com.mecflow.restapi.service.AdvanceService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/advances")
public class AdvanceController {

	@Autowired
	private AdvanceService advanceService;
	
	public AdvanceController(AdvanceService advanceService) {
		this.advanceService = advanceService;
	}
	
	@GetMapping
	public List<AdvanceResponseDTO> list() {
		return advanceService.list();
	}
	
	@GetMapping("/employee/{id}")
	public List<AdvanceResponseDTO> listOfEmployee(@PathVariable @Positive @NotNull Long id) {
		return advanceService.listOfEmployee(id);
	}
	
	@GetMapping("/{id}")
	public AdvanceResponseDTO findById(@PathVariable @Positive @NotNull Long id) {
		return advanceService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AdvanceResponseDTO create(@RequestBody @NotNull @Valid AdvanceRequestDTO advanceEmployeeDTO) {
		return advanceService.create(advanceEmployeeDTO);
	}
	
	@PutMapping("/{id}")
	public AdvanceResponseDTO update(@PathVariable @Positive @NotNull Long id, 
			@RequestBody @NotNull @Valid AdvanceRequestDTO advanceEmployeeDTO) {
		return advanceService.update(id, advanceEmployeeDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @Positive @NotNull Long id) {
		advanceService.delete(id);
	}
}
