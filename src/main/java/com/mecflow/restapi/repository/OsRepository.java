package com.mecflow.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Os;

@Repository
public interface OsRepository extends JpaRepository<Os, Long>{

}
