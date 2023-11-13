package com.mecflow.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	List<Payment> findAllByOsId(Long os_id);
}
