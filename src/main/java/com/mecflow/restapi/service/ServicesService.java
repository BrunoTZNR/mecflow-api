package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.ServicesDTO;
import com.mecflow.restapi.dto.mapper.ServicesMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.repository.ServicesRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ServicesService {

	@Autowired
	private final ServicesRepository servicesRepository;
	
	@Autowired
	private final ServicesMapper servicesMapper;
	
	public ServicesService(ServicesRepository servicesRepository, ServicesMapper servicesMapper) {
		this.servicesRepository = servicesRepository;
		this.servicesMapper = servicesMapper;
	}
	
	//all services
	public List<ServicesDTO> list() {
		return servicesRepository.findAll()
				.stream()
				.map(servicesMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one services
	public ServicesDTO findById(@Positive @NotNull Long id) {
		return servicesRepository.findById(id)
				.map(servicesMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create services
	public ServicesDTO create(@NotNull @Valid ServicesDTO servicesDTO) {
		return servicesMapper.toDTO(servicesRepository.save(servicesMapper.toEntity(servicesDTO)));
	}
	
	//update services
	public ServicesDTO update(@Positive @NotNull Long id, @Valid @NotNull ServicesDTO servicesDTO) {
		return servicesRepository.findById(id)
				.map(recordFound -> {
					recordFound.setDesc(servicesDTO.desc());
					recordFound.setAmount(servicesDTO.amount());
					
					return servicesMapper.toDTO(servicesRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete services
	public void delete(@Positive @NotNull Long id) {
		servicesRepository.delete(servicesRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
