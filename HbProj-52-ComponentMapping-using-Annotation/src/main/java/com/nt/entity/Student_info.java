package com.nt.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student_info {
	@Id
	@GeneratedValue
	private int sno;
	private String sname;
	private float savg;
	@Embedded
	private Address saddr;
	

}
