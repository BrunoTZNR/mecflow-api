package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.OsServicesRequestDTO;
import com.mecflow.restapi.dto.OsServicesResponseDTO;
import com.mecflow.restapi.dto.mapper.OsServicesMapper;
import com.mecflow.restapi.model.id.OsServicesId;
import com.mecflow.restapi.repository.OsServicesRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Validated
@Service
@AllArgsConstructor
@Getter
public class OsServicesService {

	@Autowired
	private final OsServicesRepository osRepository;
	
	@Autowired
	private final OsServicesMapper osMapper;
	
	//all products by os
	public List<OsServicesResponseDTO> listByOs(@NotNull @Positive Long os_id) {
		return osRepository.findAllByOsId(os_id)
				.stream()
				.map(osMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//create osProducts
	public OsServicesResponseDTO create(@Valid @NotNull OsServicesRequestDTO osDTO) {
		osMapper.getOsService().updateAmounts(osDTO.id_os());
		
		return osMapper.toDTO(osRepository.save(osMapper.toEntity(osDTO)));
	}
	
	//delete osProducts
		public void delete(@NotNull @Positive Long os_id, @NotNull @Positive Long services_id) {
			OsServicesId osId = new OsServicesId(os_id, services_id);
			
			osRepository.deleteById(osId);
		}
}
