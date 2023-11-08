package com.mecflow.restapi.dto.mapper;

import org.springframework.stereotype.Component;

import com.mecflow.restapi.dto.PaymentDTO;
import com.mecflow.restapi.enums.TypePay;
import com.mecflow.restapi.model.Payment;

@Component
public class PaymentMapper {

	public PaymentDTO toDTO(Payment p) {
		if(p == null) {
			return null;
		}
		
		return new PaymentDTO(p.getId(), p.getAmount(), 
				p.getDt(), p.getTypePay().getValue(), p.getInstallments());
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
