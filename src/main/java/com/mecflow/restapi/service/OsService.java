package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.OsRequestDTO;
import com.mecflow.restapi.dto.OsResponseDTO;
import com.mecflow.restapi.dto.mapper.OsMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Os;
import com.mecflow.restapi.repository.OsRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Validated
@Service
@AllArgsConstructor
@Getter
public class OsService {

	@Autowired
	private final OsRepository osRepository;
	
	@Autowired
	private final OsMapper osMapper;
	
	//all os's
	public List<OsResponseDTO> list() {
		return osRepository.findAll()
				.stream()
				.map(osMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one os
	public OsResponseDTO findById(@Positive @NotNull Long id) {
		return osRepository.findById(id)
				.map(osMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create os
	public OsResponseDTO create(@Valid @NotNull OsRequestDTO o) {
		return osMapper.toDTO(osRepository.save(osMapper.toEntity(o)));
	}
	
	//update os
	public OsResponseDTO update(@Positive @NotNull Long id, @Valid @NotNull OsRequestDTO o) {
		return osRepository.findById(id)
				.map(recordFound -> {
					Os os0 = osMapper.toEntity(o);
					
					recordFound.setDtIn(os0.getDtIn());
					recordFound.setDtOut(os0.getDtOut());
					recordFound.setTotalAmount(os0.getTotalAmount());
					recordFound.setTotalDiscount(os0.getTotalDiscount());
					recordFound.setStatus(os0.getStatus());
					recordFound.setCar(os0.getCar());
					recordFound.setClient(os0.getClient());
					
					return osMapper.toDTO(osRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete os
	public void delete(@Positive @NotNull Long id) {
		osRepository.delete(osRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
