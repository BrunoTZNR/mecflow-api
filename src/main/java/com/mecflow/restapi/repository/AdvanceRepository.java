package com.mecflow.restapi.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Advance;

@Repository
public interface AdvanceRepository extends JpaRepository<Advance, Long>{
	List<Advance> findAllByEmployeeId(Long id);
}
