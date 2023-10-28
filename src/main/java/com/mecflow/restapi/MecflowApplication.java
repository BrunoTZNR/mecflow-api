package com.mecflow.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mecflow.restapi.model.Product;
import com.mecflow.restapi.repository.ProductRepository;
import com.mecflow.restapi.repository.ServicesRepository;

@SpringBootApplication
public class MecflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(MecflowApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ProductRepository pr,
			ServicesRepository sr) {
		return args -> {
			pr.deleteAll();
			sr.deleteAll();
			
			List<Product> p = new ArrayList<>(2);
			
			Product p01 = new Product();
			p01.setCodProduct("P001");
			p01.setStockProduct(0);
			p01.setDescProduct("Produto teste!");
			p01.setPriceProduct(0.0);
			p01.setNcmProduct(null);
			
			Product p02 = new Product();
			p02.setCodProduct("P002");
			p02.setStockProduct(999);
			p02.setDescProduct("Produto teste!");
			p02.setPriceProduct(25.99);
			p02.setNcmProduct("1234567890");

			p.add(p01);
			p.add(p02);
			
			pr.saveAll(p);
		};
	}
}
