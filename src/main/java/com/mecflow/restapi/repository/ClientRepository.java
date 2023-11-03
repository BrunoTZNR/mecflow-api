package com.mecflow.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mecflow.restapi.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	Optional<Client> findByCpf(String cpf);
}
