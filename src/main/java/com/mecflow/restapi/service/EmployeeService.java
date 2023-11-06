package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.EmployeeDTO;
import com.mecflow.restapi.dto.mapper.EmployeeMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Employee;
import com.mecflow.restapi.repository.EmployeeRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EmployeeService {
	
	@Autowired
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	private final EmployeeMapper employeeMapper;
	
	public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
	}
	
	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}
	
	//all employees
	public List<EmployeeDTO> list() {
		return employeeRepository.findAll()
				.stream()
				.map(employeeMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//all paydays of employee
	/*public List<PaydayDTO> listOfEmployee(@Positive @NotNull Long id) {
		return paydayRepository.findAllByEmployeeId(id)
				.stream()
				.map(paydayMapper::toDTO)
				.collect(Collectors.toList());
	}*/
	
	//one employee
	public EmployeeDTO findById(@Positive @NotNull Long id) {
		return employeeRepository.findById(id)
				.map(employeeMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create employee
	public EmployeeDTO create(@Valid @NotNull EmployeeDTO employeeDTO) {
		return employeeMapper.toDTO(employeeRepository.save(employeeMapper.toEntity(employeeDTO)));
	}
	
	//update employee
	public EmployeeDTO update(@Positive @NotNull Long id, @Valid @NotNull EmployeeDTO employeeDTO) {
		return employeeRepository.findById(id)
				.map(recordFound -> {
					Employee employee = employeeMapper.toEntity(employeeDTO);
					
					recordFound.setComission(employee.getComission());
					recordFound.setPeople(employee.getPeople());
					
					return employeeMapper.toDTO(employeeRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//delete employee
	public void delete(@Positive @NotNull Long id) {
		employeeRepository.delete(employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
