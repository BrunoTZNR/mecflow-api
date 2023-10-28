package com.mecflow.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long>{

}
