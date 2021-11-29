package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name = "COMPANY_EMPLOYES")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Company implements Serializable {
	@Id
	@GeneratedValue
	private Integer compId;
	@Column(length = 20)
	@Type(type ="string")
	@NonNull
	private String compName;
	@Column(length = 20)
	@Type(type ="string")
	@NonNull
	private String location;
	@Column(length = 20)
	@Type(type ="string")
	@NonNull
	private String technology;
	
	public Company() {
		System.out.println("Company::zero param constructor");
	}

	@Override
	public String toString() {
		return "Company [compId=" + compId + ", compName=" + compName + ", location=" + location + ", technology="
				+ technology + "]";
	}
	
}
