package com.nt.entity;

import java.io.Serializable;

public class BankAccount implements Serializable {
	private int acno;
	private String achname;
	private float balance;
	public int getAcno() {
		return acno;
	}
	public String getAchname() {
		return achname;
	}
	public float getBalance() {
		return balance;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	public void setAchname(String achname) {
		this.achname = achname;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", achname=" + achname + ", balance=" + balance + "]";
	}
	

}
