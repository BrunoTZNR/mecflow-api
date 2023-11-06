package com.mecflow.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Payday;

@Repository
public interface PaydayRepository extends JpaRepository<Payday, Long>{
	List<Payday> findAllByEmployeeId(Long id);
	
	
}
