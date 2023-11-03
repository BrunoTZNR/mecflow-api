package com.mecflow.restapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mecflow.restapi.model.Address;
import com.mecflow.restapi.model.Client;
import com.mecflow.restapi.model.Contact;
import com.mecflow.restapi.model.Employee;
import com.mecflow.restapi.model.People;
/*import com.mecflow.restapi.enums.Fuel;
import com.mecflow.restapi.model.Car;
import com.mecflow.restapi.model.Payment;
import com.mecflow.restapi.model.Product;
import com.mecflow.restapi.model.Services;*/
import com.mecflow.restapi.repository.CarRepository;
import com.mecflow.restapi.repository.ClientRepository;
import com.mecflow.restapi.repository.EmployeeRepository;
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
			PaymentRepository payr,
			ClientRepository clir,
			EmployeeRepository empr) {
		return args -> {
			Contact cont01 = new Contact();
			cont01.setPhone("61123456789");
			cont01.setEmail("admin@admin.com");
			cont01.setWhatsapp("61123456789");
			
			Contact cont02 = new Contact();
			cont02.setPhone("61987654321");
			cont02.setEmail("user@user.com");
			cont02.setWhatsapp("61987654321");
			
			Address address01 = new Address();
			address01.setCep("12345678");
			
			People peo01 = new People();
			peo01.setFName("Bruno");
			peo01.setLName("Silva");
			peo01.setDtNasc(LocalDate.of(2003, 1, 1));
			peo01.setContact(cont01);
			peo01.setAddress(address01);
			
			People peo02 = new People();
			peo02.setFName("Renan");
			peo02.setLName("Rodrigues");
			peo02.setDtNasc(LocalDate.of(2003, 1, 11));
			peo02.setContact(cont02);
			
			People peo03 = new People();
			peo03.setFName("Italo");
			peo03.setLName("Oliveira");
			peo03.setDtNasc(LocalDate.of(2003, 1, 6));
			
			Client cli01 = new Client();
			cli01.setCpf("01234567890");
			cli01.setPeople(peo02);
			
			Client cli02 = new Client();
			cli02.setPeople(peo03);
			
			Employee emp01 = new Employee();
			emp01.setComission(50.00);
			emp01.setPeople(peo01);
			
			clir.save(cli01);
			clir.save(cli02);
			empr.save(emp01);
			
			/*pr.deleteAll();
			sr.deleteAll();
			cr.deleteAll();
			payr.deleteAll();
			
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
			
			List<Car> c = new ArrayList<>(2);
			
			Car c01 = new Car();
			c01.setPlaca("AAA0000");
			c01.setModel("gol");
			c01.setAutomaker("volkswagem");
			c01.setFYear("2010");
			c01.setMYear("2011");
			c01.setEngine(8);
			c01.setCapacity(1.0);
			c01.setColor("prata");
			c01.setFuel(Fuel.GASOLINA);
			
			Car c02 = new Car();
			c02.setPlaca("BBB1111");
			c02.setModel("civic");
			c02.setAutomaker("honda");
			c02.setFYear("1995");
			c02.setMYear("1995");
			c02.setEngine(16);
			c02.setCapacity(1.8);
			c02.setColor("ciano");
			c02.setFuel(Fuel.GASOLINA);
			
			c.add(c01);
			c.add(c02);
			
			cr.saveAll(c);
			
			List<Payment> pay = new ArrayList<>(2);
			
			Payment pay01 = new Payment();
			
			Payment pay02 = new Payment();
			
			pay.add(pay01);
			pay.add(pay02);
			
			payr.saveAll(pay);*/
		};
	}
}
