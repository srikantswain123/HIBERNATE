package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
@Data
@Entity
@DiscriminatorValue("cheque")
public class ChequePayment extends Payment {
	private Long chequeNo;
	private String chequeType;
	private LocalDate expiryDate;
	@Override
	public String toString() {
		return super.toString() + "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expiryDate=" + expiryDate
				 + "]";
	}
	

}
