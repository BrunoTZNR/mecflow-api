package com.mecflow.restapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.AddressDTO;
import com.mecflow.restapi.dto.ContactDTO;
import com.mecflow.restapi.dto.EmployeeDTO;
import com.mecflow.restapi.dto.PeopleDTO;
import com.mecflow.restapi.model.Address;
import com.mecflow.restapi.model.Contact;
import com.mecflow.restapi.model.Employee;
import com.mecflow.restapi.model.People;

@Component
public class EmployeeMapper {

	public EmployeeDTO toDTO(Employee e) {
		if(e == null) {
			return null;
		}
		
		PeopleDTO p = null;
		
		if(e.getPeople() != null) {
			AddressDTO a = null;
			
			if(e.getPeople().getAddress() != null) {
				a = new AddressDTO(
					e.getPeople().getAddress().getCep(),
					e.getPeople().getAddress().getNumber(),
					e.getPeople().getAddress().getStreet(),
					e.getPeople().getAddress().getNeighborhood(),
					e.getPeople().getAddress().getState(),
					e.getPeople().getAddress().getUf());
			}
			
			ContactDTO cont = null;
			
			if(e.getPeople().getContact() != null) {
				cont = new ContactDTO(
					e.getPeople().getContact().getPhone(),
					e.getPeople().getContact().getEmail(),
					e.getPeople().getContact().getWhatsapp());
			}
			
			p = new PeopleDTO(
				e.getPeople().getFName(),
				e.getPeople().getLName(),
				e.getPeople().getDtNasc(),
				cont, a);
		}
		
		return new EmployeeDTO(e.getId(), e.getComission(), p);
	}
	
	public Employee toEntity(EmployeeDTO eDTO) {
		if(eDTO == null) {
			return null;
		}
		
		Employee e = new Employee();
		
		if(eDTO.id() != null) {
			e.setId(eDTO.id());
		}
		
		People p = new People();
		p.setFName(eDTO.people().fName());
		p.setLName(eDTO.people().lName());
		p.setDtNasc(eDTO.people().dtNasc());
		
		if(eDTO.people().contact() != null) {
			Contact cont = new Contact();
			
			cont.setPhone(eDTO.people().contact().phone());
			cont.setEmail(eDTO.people().contact().email());
			cont.setWhatsapp(eDTO.people().contact().whatsapp());
			
			p.setContact(cont);
		}
		
		if(eDTO.people().address() != null) {
			Address a = new Address();
			
			a.setCep(eDTO.people().address().cep());
			a.setNumber(eDTO.people().address().number());
			a.setStreet(eDTO.people().address().street());
			a.setNeighborhood(eDTO.people().address().neighborhood());
			a.setState(eDTO.people().address().state());
			a.setUf(eDTO.people().address().uf());
			
			p.setAddress(a);
		}
		
		e.setComission(eDTO.comission());
		e.setPeople(p);
		
		return e;
	}
}
