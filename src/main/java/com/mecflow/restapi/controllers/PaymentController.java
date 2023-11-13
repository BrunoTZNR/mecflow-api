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

import com.mecflow.restapi.dto.PaymentDTO;
import com.mecflow.restapi.service.PaymentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
	
	@Autowired
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping("/{os_id}")
	public List<PaymentDTO> list(@PathVariable @NotNull @Positive Long os_id) {
		return paymentService.list(os_id);
	}
	
	/*@GetMapping("/{id}")
	public PaymentDTO findById(@PathVariable @NotNull @Positive Long id) {
		return paymentService.findById(id);
	}*/
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PaymentDTO create(@RequestBody @Valid PaymentDTO paymentDTO) {
		return paymentService.create(paymentDTO);
	}
	
	@PutMapping("/{id}")
	public PaymentDTO update(@PathVariable @NotNull @Positive Long id,
			@RequestBody @Valid PaymentDTO paymentDTO) {
		return paymentService.update(id, paymentDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotNull @Positive Long id) {
		paymentService.delete(id);
	}
}
