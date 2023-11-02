package com.mecflow.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mecflow.restapi.dto.CarDTO;
import com.mecflow.restapi.service.CarService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
	
	@Autowired
	private final CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping
	public List<CarDTO> list() {
		return carService.list();
	}
	
	@GetMapping("/{placa}")
	public CarDTO findByPlaca(@PathVariable @NotBlank String placa) {
		return carService.findByPlaca(placa);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CarDTO create(@RequestBody @Valid CarDTO carDTO) {
		return carService.create(carDTO);
	}
	
	@PutMapping("/{placa}")
	public CarDTO update(@PathVariable @NotBlank String placa, 
			@RequestBody @Valid CarDTO carDTO) {
		return carService.update(placa, carDTO);
	}
	
	@DeleteMapping("/{placa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotBlank String placa) {
		carService.delete(placa);
	}
}
