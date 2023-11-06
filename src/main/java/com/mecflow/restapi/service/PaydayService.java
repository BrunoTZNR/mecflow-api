package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.mecflow.restapi.dto.PaydayDTO;
import com.mecflow.restapi.dto.PaydayEmployeeDTO;
import com.mecflow.restapi.dto.mapper.PaydayMapper;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Payday;
import com.mecflow.restapi.repository.PaydayRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class PaydayService {
	
	@Autowired
	private final PaydayRepository paydayRepository;

	@Autowired
	private final PaydayMapper payMapper;

	public PaydayService(PaydayRepository paydayRepository, PaydayMapper paydayMapper) {
		this.paydayRepository = paydayRepository;
		this.payMapper = paydayMapper;
	}

	//all paydays
	/*public List<PaydayEmployeeDTO> list() {
		return paydayRepository.findAll()
				.stream()
				.map(payMapper::toEmployeeDTO)
				.collect(Collectors.toList());
	}
	
	//one payday
	public PaydayEmployeeDTO findById(@Positive @NotNull Long id) {
		return paydayRepository.findById(id)
				.map(payMapper::toEmployeeDTO)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	//create payday
	public PaydayEmployeeDTO create(@RequestBody @Valid @NotNull PaydayDTO paydayDTO) {
		Payday p0 = new Payday();
		
		p0.setDt(paydayDTO.dt());
		p0.setSalary(paydayDTO.salary());
		
		
		p0.setAmountCom(0.00);
		
		p0.setAmountAd(advanceService.totalPayAdvances(paydayDTO.employee_id(), paydayDTO.advances()));
		
		p0.setTotalAmount();
		p0.setEmployee(employeeService.getEmployeeMapper().toEntity(employeeService
				.findById(paydayDTO.employee_id())));
		p0.setAdvances(paydayDTO.advances()
				.stream()
				.map(advanceService::findById)
				.map(paydayMapper.getAdvanceMapper()::toEntity)
				.collect(Collectors.toList()));
		
		return paydayMapper.toEmployeeDTO(paydayRepository.save(p0));
	}*/
	
	//update payday
	/*public PaydayDTO update(@Positive @NotNull Long id, 
			@RequestBody @Valid @NotNull PaydayCreateDTO paydayCreateDTO) {
		return paydayRepository.findById(id)
				.map(recordFound -> {
					Payday p0 = paydayMapper.toEntity(paydayMapper.toDTO(paydayCreateDTO));
					
					recordFound.setDt(p0.getDt());
					//valor do salario
					recordFound.setSalary(p0.getSalary());
					//pegar o valor de todos os serviços das os->concluido * emp.comission
					recordFound.setAmountCom(0.00);
					//pegar o valor de todos os adiantamentos->pendente
					//recordFound.setAmountAd(allAdvances(p0.getEmployee().getId()));
					
					//seta o valor total do pagamento = salario + comissões - adiantamentos
					recordFound.setTotalAmount(
							recordFound.getSalary() 
							+ recordFound.getAmountCom() 
							- recordFound.getAmountAd());
					
					recordFound.setEmployee(p0.getEmployee());
					
					return paydayMapper.toDTO(paydayRepository.save(recordFound));
				})
				.orElseThrow(() -> new RecordNotFoundException(id));
	}*/
	
	//delete
	public void delete(@Positive @NotNull Long id) {
		paydayRepository.delete(paydayRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));
	}
}
