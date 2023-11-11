package com.mecflow.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.OsServices;
import com.mecflow.restapi.model.id.OsServicesId;

@Repository
public interface OsServicesRepository extends JpaRepository<OsServices, OsServicesId>{
	List<OsServices> findAllByOsId(Long os_id);
}
