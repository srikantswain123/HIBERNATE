package com.nt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("CARD")
public class CardPayment extends Payment {
	private Long cardNumber;
	private String cardType;
	private String paymentGateway;
	@Override
	public String toString() {
		return super.toString() +"CardPayment [cardNumber=" + cardNumber + ", cardType=" + cardType + ", paymentGateway=" + paymentGateway
				+ "]";
	}
	
	

}
