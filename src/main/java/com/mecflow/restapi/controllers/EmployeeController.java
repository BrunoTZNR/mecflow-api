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

import com.mecflow.restapi.dto.EmployeeDTO;
import com.mecflow.restapi.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<EmployeeDTO> list() {
		return employeeService.list();
	}
	
	@GetMapping("/{id}")
	public EmployeeDTO findById(@PathVariable @Positive @NotNull Long id) {
		return employeeService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDTO create(@RequestBody @Valid EmployeeDTO employeeDTO) {
		return employeeService.create(employeeDTO);
	}
	
	@PutMapping("/{id}")
	public EmployeeDTO create(@PathVariable @Positive @NotNull Long id, 
			@RequestBody @Valid EmployeeDTO employeeDTO) {
		return employeeService.update(id, employeeDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @Positive @NotNull Long id) {
		employeeService.delete(id);
	}
}
