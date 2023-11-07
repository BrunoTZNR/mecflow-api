package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.ClientDTO;
import com.mecflow.restapi.dto.mapper.ClientMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Client;
import com.mecflow.restapi.repository.ClientRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Validated
@Service
@Getter
public class ClientService {

	@Autowired
	private final ClientRepository clientRepository;
	
	@Autowired
	private final ClientMapper clientMapper;
	
	public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
	}
	
	//all clients
	public List<ClientDTO> list() {
		return clientRepository.findAll()
				.stream()
				.map(clientMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one client
	public ClientDTO findById(@Positive @NotNull Long id) {
		return clientRepository.findById(id)
				.map(clientMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create client
	public ClientDTO create(@Valid @NotNull ClientDTO clientDTO) {
		return clientMapper.toDTO(clientRepository.save(clientMapper.toEntity(clientDTO)));
	}
	
	//update client
	public ClientDTO update(@Positive @NotNull Long id, @Valid @NotNull ClientDTO clientDTO) {
		return clientRepository.findById(id)
				.map(recordFound -> {
					Client client = clientMapper.toEntity(clientDTO);
					
					recordFound.setCpf(client.getCpf());
					recordFound.setPeople(client.getPeople());
					
					return clientMapper.toDTO(clientRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete client
	public void delete(@Positive @NotNull Long id) {
		clientRepository.delete(clientRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
