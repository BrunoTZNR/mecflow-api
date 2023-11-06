package com.mecflow.restapi;

import java.time.LocalDate;
/*import java.util.ArrayList;
import java.util.List;*/

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import com.mecflow.restapi.enums.Status;
//import com.mecflow.restapi.model.Advance;
//import com.mecflow.restapi.model.Address;
//import com.mecflow.restapi.model.Client;
import com.mecflow.restapi.model.Contact;
import com.mecflow.restapi.model.Employee;
import com.mecflow.restapi.model.People;
import com.mecflow.restapi.model.User;
import com.mecflow.restapi.repository.AdvanceRepository;
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
import com.mecflow.restapi.repository.UserRepository;

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
			EmployeeRepository empr,
			UserRepository userr,
			AdvanceRepository adr) {
		return args -> {
			userr.deleteAll();
			
			User u0 = new User();
			u0.setLogin("admin@admin.com");
			u0.setPass("123456");
			
			userr.save(u0);
			
			Contact cont01 = new Contact();
			cont01.setPhone("61999999999");
			cont01.setEmail("admin@admin.com");
			cont01.setWhatsapp("61999999999");
			
			People peo01 = new People();
			peo01.setFName("Bruno");
			peo01.setLName("Silva");
			peo01.setDtNasc(LocalDate.of(2003, 1, 1));
			peo01.setContact(cont01);
			
			People peo02 = new People();
			peo02.setFName("Sergio");
			peo02.setLName("Henrique");
			peo02.setDtNasc(LocalDate.of(1986, 3, 20));

			Employee emp01 = new Employee();
			emp01.setSalary(600.00);
			emp01.setComission(50.00);
			emp01.setPeople(peo01);
			
			Employee emp02 = new Employee();
			emp02.setComission(50.00);
			emp02.setPeople(peo02);
			
			empr.save(emp01);
			empr.save(emp02);
			
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
