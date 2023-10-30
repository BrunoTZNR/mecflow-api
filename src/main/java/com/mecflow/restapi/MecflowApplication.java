package com.mecflow.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mecflow.restapi.model.Car;
import com.mecflow.restapi.model.Payment;
import com.mecflow.restapi.model.Product;
import com.mecflow.restapi.model.Services;
import com.mecflow.restapi.repository.CarRepository;
import com.mecflow.restapi.repository.PaymentRepository;
import com.mecflow.restapi.repository.ProductRepository;
import com.mecflow.restapi.repository.ServicesRepository;

@SpringBootApplication
public class MecflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(MecflowApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ProductRepository pr,
			ServicesRepository sr,
			CarRepository cr,
			PaymentRepository payr) {
		return args -> {
			pr.deleteAll();
			sr.deleteAll();
			cr.deleteAll();
			payr.deleteAll();
			
			//PRODUCT DEBUG
			List<Product> p = new ArrayList<>(2);
			
			Product p01 = new Product();
			p01.setCod("P001");
			p01.setStock(0);
			p01.setDesc("Produto teste!");
			p01.setPrice(0.0);
			p01.setNcm(null);
			
			Product p02 = new Product();
			p02.setCod("P002");
			p02.setStock(999);
			p02.setDesc("Produto teste!");
			p02.setPrice(25.99);
			p02.setNcm("1234567890");

			p.add(p01);
			p.add(p02);
			
			pr.saveAll(p);
			
			//SERVICES DEBUG
			List<Services> s = new ArrayList<>(2);
			
			Services s01 = new Services();
			s01.setDesc("Serviço teste!");
			s01.setAmount(500.50);
			
			Services s02 = new Services();
			s02.setDesc("Serviço teste!");
			s02.setAmount(0.0);
			
			s.add(s01);
			s.add(s02);
			
			sr.saveAll(s);
			
			//CAR DEBUG
			/*List<Car> c = new ArrayList<>(2);
			
			Car c01 = new Car();
			
			Car c02 = new Car();
			
			c.add(c01);
			c.add(c02);
			
			cr.saveAll(c);*/
			
			//PAYMENT DEBUG
			/*List<Payment> pay = new ArrayList<>(2);
			
			Payment pay01 = new Payment();
			
			Payment pay02 = new Payment();
			
			pay.add(pay01);
			pay.add(pay02);
			
			payr.saveAll(pay);*/
		};
	}
}
