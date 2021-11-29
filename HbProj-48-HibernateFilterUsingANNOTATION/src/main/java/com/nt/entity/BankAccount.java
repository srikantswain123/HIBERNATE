package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="BANK_ACCOUNT")
@FilterDef(name = "BANK_ACCOUNT_STATUS",parameters = {@ParamDef(name="param1",type = "string"),
		                                              @ParamDef(name="param2",type="string")
                                                      }
          )
@Filter(name = "BANK_ACCOUNT_STATUS",condition = "STATUS NOT IN(:param1,:param2)")
public class BankAccount {
	@Id
	private Long acno;
	private String holderName;
	private Float balance;
	private String status;
	public Long getAcno() {
		return acno;
	}
	public void setAcno(Long acno) {
		this.acno = acno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + ", status="
				+ status + "]";
	}
	

}
