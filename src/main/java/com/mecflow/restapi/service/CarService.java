package com.mecflow.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mecflow.restapi.dto.mapper.CarMapper;
import com.mecflow.restapi.repository.CarRepository;

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
}
