package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.PaymentDTO;
import com.mecflow.restapi.dto.mapper.PaymentMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.repository.PaymentRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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
	
	//all payments
	public List<PaymentDTO> list(@NotNull @Positive Long os_id) {
		return paymentRepository.findAllByOsId(os_id)
				.stream()
				.map(paymentMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one payment
	public PaymentDTO findById(@NotNull @Positive Long id) {
		return paymentRepository.findById(id)
				.map(paymentMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create payment
	public PaymentDTO create(@Valid @NotNull PaymentDTO paymentDTO) {
		return paymentMapper.toDTO(paymentRepository.save(paymentMapper.toEntity(paymentDTO)));
	}
	
	//update payment
	public PaymentDTO update(@Positive @NotNull Long id, 
			@Valid @NotNull PaymentDTO paymentDTO) {
		return paymentRepository.findById(id)
				.map(recordFound -> {
					recordFound.setAmount(paymentDTO.amount());
					recordFound.setDt(paymentDTO.dt());
					recordFound.setTypePay(paymentMapper.convertTypePayValue(paymentDTO.typePay()));
					recordFound.setInstallments(paymentDTO.installments());
					
					return paymentMapper.toDTO(paymentRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete payment
	public void delete(@Positive @NotNull Long id) {
		paymentRepository.delete(paymentRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
		
	}
}
