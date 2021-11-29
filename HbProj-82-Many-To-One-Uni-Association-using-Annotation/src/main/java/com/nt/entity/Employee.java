package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name="EMPLOYESS_COMPANY")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Employee implements Serializable {
	@Id
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gen1",sequenceName = "EMPLOYE_COMP_GEN",allocationSize = 1,initialValue = 1000000)
	private Integer empid;
	@Column(length = 20)
	@Type(type ="string")
	@NonNull
	private String empname;
	@Column(length = 20)
	@Type(type ="string")
	@NonNull
	private String addrs;
	@Column(length = 20)
	@Type(type ="string")
	@NonNull
	private String technology;
	@ManyToOne(targetEntity = Company.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID",referencedColumnName = "compId")
	@LazyToOne(LazyToOneOption.PROXY)
	private Company company;

	public Employee() {
		System.out.println("Employess::zero param constructor");
	}

	@Override
	public String toString() {
		return "Employess [empid=" + empid + ", empname=" + empname + ", addrs=" + addrs + ", technology=" + technology
				+ "]";
	}
	
}
