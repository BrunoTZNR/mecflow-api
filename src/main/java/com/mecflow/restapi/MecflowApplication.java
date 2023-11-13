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

	/*@Bean
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
		};
	}*/
}
