package com.mecflow.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

	Optional<Car> findByPlaca(String placa);
}
