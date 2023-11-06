package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.AdvanceRequestDTO;
import com.mecflow.restapi.dto.AdvanceResponseDTO;
import com.mecflow.restapi.dto.mapper.AdvanceMapper;
import com.mecflow.restapi.enums.Status;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Advance;
import com.mecflow.restapi.repository.AdvanceRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@Service
@AllArgsConstructor
public class AdvanceService {

	@Autowired
	private final AdvanceRepository advanceRepository;
	
	@Autowired
	private final AdvanceMapper advanceMapper;
	
	//all advances
	public List<AdvanceResponseDTO> list() {
		return advanceRepository.findAll()
				.stream()
				.map(advanceMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//all advance of employee
	public List<AdvanceResponseDTO> listOfEmployee(@Positive @NotNull Long id) {
		return advanceRepository
				.findAllByEmployeeId(id)
				.stream()
				.map(advanceMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one advance
	public AdvanceResponseDTO findById(@Positive @NotNull Long id) {
		return advanceRepository.findById(id)
				.map(advanceMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create advance
	public AdvanceResponseDTO create(@Valid @NotNull AdvanceRequestDTO advanceRequestDTO) {
		return advanceMapper.toDTO(advanceRepository.save(advanceMapper.toEntity(advanceRequestDTO)));
	}
	
	//update advance
	public AdvanceResponseDTO update(@Positive @NotNull Long id, @Valid @NotNull AdvanceRequestDTO advanceEmployeeDTO) {
		return advanceRepository.findById(id)
				.map(recordFound -> {
					Advance ad0 = advanceMapper.toEntity(advanceEmployeeDTO);
					
					recordFound.setDt(ad0.getDt());
					recordFound.setAmount(ad0.getAmount());
					recordFound.setStatus(ad0.getStatus());
					recordFound.setEmployee(ad0.getEmployee());
					recordFound.setPayday(ad0.getPayday());
					
					return advanceMapper.toDTO(advanceRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete
	public void delete(@Positive @NotNull Long id) {
		advanceRepository.delete(advanceRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
	
	/* PEGA O VALOR TOTAL E ALTERA O STATUS DOS ADIANTAMENTOS SELECIONADOS PARA CONCLUIDO */
	public Double totalPayAdvances(@Positive @NotNull Long employee_id, List<Long> advances_id) {
		Double totalAdvances = 0.00;
		
		for(Long ad_id : advances_id) {
			Advance ad0 = advanceRepository.findById(ad_id)
					.orElseThrow(() -> new RecordNotFoundException(ad_id));
			ad0.setStatus(Status.CONCLUIDO);
			advanceRepository.save(ad0);
			
			totalAdvances += ad0.getAmount();
		}
		
		return totalAdvances;
	}
}
