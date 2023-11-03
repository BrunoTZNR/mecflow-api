package com.mecflow.restapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.AddressDTO;
import com.mecflow.restapi.dto.ClientDTO;
import com.mecflow.restapi.dto.ContactDTO;
import com.mecflow.restapi.dto.PeopleDTO;
import com.mecflow.restapi.model.Address;
import com.mecflow.restapi.model.Client;
import com.mecflow.restapi.model.Contact;
import com.mecflow.restapi.model.People;

@Component
public class ClientMapper {

	public ClientDTO toDTO(Client c) {
		if(c == null) {
			return null;
		}
		
		PeopleDTO p = null;
		
		if(c.getPeople() != null) {
			AddressDTO a = null;
			
			if(c.getPeople().getAddress() != null) {
				a = new AddressDTO(
					c.getPeople().getAddress().getCep(),
					c.getPeople().getAddress().getNumber(),
					c.getPeople().getAddress().getStreet(),
					c.getPeople().getAddress().getNeighborhood(),
					c.getPeople().getAddress().getState(),
					c.getPeople().getAddress().getUf());
			}
			
			ContactDTO cont = null;
			
			if(c.getPeople().getContact() != null) {
				cont = new ContactDTO(
					c.getPeople().getContact().getPhone(),
					c.getPeople().getContact().getEmail(),
					c.getPeople().getContact().getWhatsapp());
			}
			
			p = new PeopleDTO(
				c.getPeople().getFName(),
				c.getPeople().getLName(),
				c.getPeople().getDtNasc(),
				cont, a);
		}
		
		return new ClientDTO(c.getId(),	c.getCpf(),	p);
	}
	
	public Client toEntity(ClientDTO cDTO) {
		if(cDTO == null) {
			return null;
		}
		
		Client c = new Client();
		
		if(cDTO.id() != null) {
			c.setId(cDTO.id());
		}
		
		People p = new People();
		p.setFName(cDTO.people().fName());
		p.setLName(cDTO.people().lName());
		p.setDtNasc(cDTO.people().dtNasc());
		
		if(cDTO.people().contact() != null) {
			Contact cont = new Contact();
			
			cont.setPhone(cDTO.people().contact().phone());
			cont.setEmail(cDTO.people().contact().email());
			cont.setWhatsapp(cDTO.people().contact().whatsapp());
			
			p.setContact(cont);
		}
		
		if(cDTO.people().address() != null) {
			Address a = new Address();
			
			a.setCep(cDTO.people().address().cep());
			a.setNumber(cDTO.people().address().number());
			a.setStreet(cDTO.people().address().street());
			a.setNeighborhood(cDTO.people().address().neighborhood());
			a.setState(cDTO.people().address().state());
			a.setUf(cDTO.people().address().uf());
			
			p.setAddress(a);
		}
		
		c.setCpf(cDTO.cpf());
		c.setPeople(p);
		
		return c;
	}
}
