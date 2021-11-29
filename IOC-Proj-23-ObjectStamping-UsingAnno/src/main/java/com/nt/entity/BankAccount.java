package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="BankAccount_Anno")
public class BankAccount implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long acno;
	@Column(length = 20)
	@Type(type="string")
	private  String holderName;
	@CreationTimestamp
	private LocalDateTime openingDate;
	@UpdateTimestamp
	private  LocalDateTime lastUpdated;
	@Type(type="double")
	private  Double  balance;
	@Column(length = 20)
	@Type(type="string")
	private String  type;
	@Version
	private Integer version;
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
	public LocalDateTime getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", holderName=" + holderName + ", openingDate=" + openingDate
				+ ", lastUpdated=" + lastUpdated + ", balance=" + balance + ", type=" + type + ", version=" + version
				+ "]";
	}
	
	
	
	
	
}
