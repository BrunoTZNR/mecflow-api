package com.mecflow.restapi.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.PaymentDTO;
import com.mecflow.restapi.enums.TypePay;
import com.mecflow.restapi.exception.RecordNotFoundException;
import com.mecflow.restapi.model.Payment;
import com.mecflow.restapi.repository.OsRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PaymentMapper {

	@Autowired
	private final OsRepository osRepository;
	
	public PaymentDTO toDTO(Payment p) {
		if(p == null) {
			return null;
		}
		
		return new PaymentDTO(p.getId(), p.getAmount(), 
				p.getDt(), p.getTypePay().getValue(), p.getInstallments(), 
				p.getOs().getId());
	}
	
	public Payment toEntity(PaymentDTO pDTO) {
		if(pDTO == null) {
			return null;
		}
		
		Payment p0 = new Payment();
		
		if(pDTO.id() != null) {
			p0.setId(pDTO.id());
		}
		
		if(pDTO.installments() != 1) {
			p0.setInstallments(pDTO.installments());
		}
		
		p0.setDt(pDTO.dt());
		p0.setAmount(pDTO.amount());
		p0.setTypePay(convertTypePayValue(pDTO.typePay()));
		p0.setOs(osRepository.findById(pDTO.os_id()).orElseThrow(() -> new RecordNotFoundException(pDTO.os_id())));
		
		return p0;
	}
	
	public TypePay convertTypePayValue(String value) {
		if(value == null) {
			return null;
		}
		
		return switch(value) {
			case "credito" -> TypePay.CREDITO;
			case "debito" -> TypePay.DEBITO;
			case "dinheiro" -> TypePay.DINHEIRO;
			case "pix" -> TypePay.PIX;
			default -> throw new IllegalArgumentException("Tipo do pagamento inválido: " + value);
		};
	}
}
