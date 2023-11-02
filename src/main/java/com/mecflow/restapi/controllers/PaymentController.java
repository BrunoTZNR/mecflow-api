package com.mecflow.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mecflow.restapi.service.PaymentService;

@Validated
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
	
	@Autowired
	private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
}
