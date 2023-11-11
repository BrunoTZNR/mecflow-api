package com.mecflow.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.OsProducts;
import com.mecflow.restapi.model.id.OsProductsId;

@Repository
public interface OsProductsRepository extends JpaRepository<OsProducts, OsProductsId>{
	List<OsProducts> findAllByOsId(Long os_id);
	void deleteById(OsProductsId id);
}
