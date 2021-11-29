package com.nt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CARD_PAYMENT_TPSC")
@DiscriminatorValue("CARD")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID",referencedColumnName = "PID")
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
