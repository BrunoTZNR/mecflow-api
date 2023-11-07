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

import com.mecflow.restapi.dto.OsRequestDTO;
import com.mecflow.restapi.dto.OsResponseDTO;
import com.mecflow.restapi.service.OsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/os")
public class OsController {

	@Autowired
	private final OsService osService;
	
	public OsController(OsService osService) {
		this.osService = osService;
	}
	
	@GetMapping
	public List<OsResponseDTO> list() {
		return osService.list();
	}
	
	@GetMapping("/{id}")
	public OsResponseDTO findById(@PathVariable @Positive @NotNull Long id) {
		return osService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OsResponseDTO create(@RequestBody @Valid @NotNull OsRequestDTO o) {
		return osService.create(o);
	}
	
	@PutMapping("/{id}")
	public OsResponseDTO update(@PathVariable @Positive @NotNull Long id, 
			@RequestBody @Valid @NotNull OsRequestDTO o) {
		return osService.update(id, o);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @Positive @NotNull Long id) {
		osService.delete(id);
	}
}
