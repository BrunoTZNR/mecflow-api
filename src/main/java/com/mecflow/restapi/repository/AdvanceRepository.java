package com.mecflow.restapi.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Advance;

@Repository
public interface AdvanceRepository extends JpaRepository<Advance, Long>{
	List<Advance> findAllByEmployeeId(Long id);
	
	@Query(value = "SELECT COALESCE(SUM(ad.amount_ad), 0.00) as total_amount_ad FROM tb_advance AS ad JOIN tb_employee AS emp ON ad.employee_id = emp.id WHERE ad.status_ad = :status AND ad.employee_id = :employee_id", nativeQuery = true)
	Double getAllAdvancesOfEmployee(Long employee_id, String status);
}
