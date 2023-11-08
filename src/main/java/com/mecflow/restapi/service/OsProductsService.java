package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.OsProductsRequestDTO;
import com.mecflow.restapi.dto.OsProductsResponseDTO;
import com.mecflow.restapi.dto.mapper.OsProductsMapper;
import com.mecflow.restapi.repository.OsProductsRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Validated
@Service
@AllArgsConstructor
@Getter
public class OsProductsService {

	@Autowired
	private final OsProductsRepository opRepository;
	
	@Autowired
	private final OsProductsMapper opMapper;
	
	//all products by os
	public List<OsProductsResponseDTO> listByOs(@NotNull @Positive Long os_id) {
		return opRepository.findAllByOsId(os_id)
				.stream()
				.map(opMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//create osProducts
	public OsProductsResponseDTO create(@Valid @NotNull OsProductsRequestDTO opDTO) {
		return opMapper.toDTO(opRepository.save(opMapper.toEntity(opDTO)));
	}
}
