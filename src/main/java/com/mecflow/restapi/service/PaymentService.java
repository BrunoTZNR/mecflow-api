package com.mecflow.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.mapper.PaymentMapper;
import com.mecflow.restapi.repository.PaymentRepository;

@Validated
@Service
public class PaymentService {

	@Autowired
	private final PaymentRepository paymentRepository;
	
	@Autowired
	private final PaymentMapper paymentMapper;
	
	public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
		this.paymentRepository = paymentRepository;
		this.paymentMapper = paymentMapper;
	}
}
