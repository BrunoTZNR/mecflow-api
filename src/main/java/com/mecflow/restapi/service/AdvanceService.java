package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.AdvanceCreateDTO;
import com.mecflow.restapi.dto.AdvanceDTO;
import com.mecflow.restapi.dto.mapper.AdvanceMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Advance;
import com.mecflow.restapi.repository.AdvanceRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class AdvanceService {

	@Autowired
	private final AdvanceRepository advanceRepository;
	
	@Autowired
	private final AdvanceMapper advanceMapper;
	
	public AdvanceService(AdvanceRepository advanceRepository, AdvanceMapper advanceMapper, 
			EmployeeService employeeService) {
		this.advanceRepository = advanceRepository;
		this.advanceMapper = advanceMapper;
	}
	
	//all advances
	public List<AdvanceDTO> list() {
		return advanceRepository.findAll()
				.stream()
				.map(advanceMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//find advance of employee
	public List<AdvanceDTO> listOfEmployee(@Positive @NotNull Long id) {
		return advanceRepository
				.findAllByEmployeeId(id)
				.stream()
				.map(advanceMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one advance
	public AdvanceDTO findById(@Positive @NotNull Long id) {
		return advanceRepository.findById(id)
				.map(advanceMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create advance
	public AdvanceDTO create(@Valid @NotNull AdvanceCreateDTO advanceCreateDTO) {
		return advanceMapper.toDTO(advanceRepository
				.save(advanceMapper.toEntity(advanceMapper.toDTO(advanceCreateDTO))));
	}
	
	//update advance
	public AdvanceDTO update(@Positive @NotNull Long id, @Valid @NotNull AdvanceCreateDTO advanceCreateDTO) {
		return advanceRepository.findById(id)
				.map(recordFound -> {
					Advance ad0 = advanceMapper.toEntity(advanceMapper.toDTO(advanceCreateDTO));
					
					recordFound.setDt(ad0.getDt());
					recordFound.setAmount(ad0.getAmount());
					recordFound.setStatus(ad0.getStatus());
					recordFound.setEmployee(ad0.getEmployee());
					
					return advanceMapper.toDTO(advanceRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete
	public void delete(@Positive @NotNull Long id) {
		advanceRepository.delete(advanceRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
