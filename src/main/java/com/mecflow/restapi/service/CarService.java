package com.mecflow.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.CarDTO;
import com.mecflow.restapi.dto.mapper.CarMapper;
import com.mecflow.restapi.exception.CarNotFoundException;
import com.mecflow.restapi.repository.CarRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class CarService {

	@Autowired
	private final CarRepository carRepository;
	
	@Autowired
	private final CarMapper carMapper;
	
	public CarService(CarRepository carRepository, CarMapper carMapper) {
		this.carRepository = carRepository;
		this.carMapper = carMapper;
	}
	
	//all cars
	public List<CarDTO> list() {
		return carRepository.findAll()
				.stream()
				.map(carMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	//one car
	public CarDTO findByPlaca(@NotBlank String placa) {
		return carRepository.findByPlaca(placa)
				.map(carMapper::toDTO)
				.orElseThrow(() -> new CarNotFoundException(placa));
	}
	
	//create car
	public CarDTO create(@Valid @NotNull CarDTO carDTO) {
		return carMapper.toDTO(carRepository.save(carMapper.toEntity(carDTO)));
	}
	
	//update car
	public CarDTO update(@NotBlank String placa, @Valid @NotNull CarDTO carDTO) {
		return carRepository.findByPlaca(placa)
				.map(recordFound -> {
					recordFound.setModel(carDTO.model());
					recordFound.setAutomaker(carDTO.automaker());
					recordFound.setFYear(carDTO.fYear());
					recordFound.setMYear(carDTO.mYear());
					recordFound.setCapacity(carDTO.capacity());
					recordFound.setEngine(carDTO.engine());
					recordFound.setColor(carDTO.color());
					recordFound.setFuel(carMapper.convertFuelValue(carDTO.fuel()));
					
					return carMapper.toDTO(carRepository.save(recordFound));
				})
				.orElseThrow(() -> new CarNotFoundException(placa));
	}
	
	//delete car
	public void delete(@NotNull String placa) {
		carRepository.delete(carRepository.findByPlaca(placa)
				.orElseThrow(() -> new CarNotFoundException(placa)));
	}
}
