package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@Entity
@Table(name="EMPLOYE_OTO_PK_BI_ANNO")
@RequiredArgsConstructor
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer eno;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String ename;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String eadd;
	@NonNull
	private Float sal;
	
	@OneToOne(targetEntity =CanteenCard.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@PrimaryKeyJoinColumn(name = "CID",referencedColumnName = "ENO")
	private CanteenCard canteenDetails;
	
	public Employee() {
		System.out.println("Employee::zero param constructor");
	}

}
