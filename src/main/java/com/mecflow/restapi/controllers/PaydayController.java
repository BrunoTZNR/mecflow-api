package com.mecflow.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mecflow.restapi.dto.PaydayDTO;
import com.mecflow.restapi.dto.PaydayEmployeeDTO;
import com.mecflow.restapi.service.PaydayService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/paydays")
public class PaydayController {

	/*@Autowired
	private final PaydayService paydayService;

	public PaydayController(PaydayService paydayService) {
		this.paydayService = paydayService;
	}
	
	@GetMapping
	public List<PaydayEmployeeDTO> list() {
		return paydayService.list();
	}
	
	@GetMapping("/{id}")
	public PaydayEmployeeDTO findById(@PathVariable @Positive @NotNull Long id) {
		return paydayService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PaydayEmployeeDTO create(@RequestBody @NotNull @Valid PaydayDTO paydayDTO) {
		return paydayService.create(paydayDTO);
	}
	
	/*@PutMapping("/{id}")
	public PaydayDTO update(@PathVariable @Positive @NotNull Long id, 
			@RequestBody @NotNull @Valid PaydayCreateDTO advanceCreateDTO) {
		return paydayService.update(id, advanceCreateDTO);
	}*/
	
	/*@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @Positive @NotNull Long id) {
		paydayService.delete(id);
	}*/
}
