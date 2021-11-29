package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="CHEQUE_PAYMENT_TPSC")
@DiscriminatorValue("cheque")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID",referencedColumnName = "PID")
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
