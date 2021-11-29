package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "PERSON_OTO_FK_ANNO")
@Data
@RequiredArgsConstructor
public class Person implements Serializable {
	@Id
	@GeneratedValue
	private Integer pid;
	
	@Column(length = 20)
	@Type(type="string")
	@NonNull
	private String pname;
	@NonNull
	@Column(length = 20)
	@Type(type="string")
	private String addrs;
	
	public Person() {
		System.out.println("Person::zero param constructor");
	}

}
