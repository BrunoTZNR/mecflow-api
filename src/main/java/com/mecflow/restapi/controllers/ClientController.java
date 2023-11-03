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

import com.mecflow.restapi.dto.ClientDTO;
import com.mecflow.restapi.service.ClientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

	@Autowired
	private final ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping
	public List<ClientDTO> list() {
		return clientService.list();
	}
	
	@GetMapping("/{id}")
	public ClientDTO findById(@PathVariable @Positive @NotNull Long id) {
		return clientService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClientDTO create(@RequestBody @Valid ClientDTO clientDTO) {
		return clientService.create(clientDTO);
	}
	
	@PutMapping("/{id}")
	public ClientDTO create(@PathVariable @Positive @NotNull Long id, 
			@RequestBody @Valid ClientDTO clientDTO) {
		return clientService.update(id, clientDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @Positive @NotNull Long id) {
		clientService.delete(id);
	}
}
