package com.nt.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Transient;

import lombok.Data;

@Data


public class Student_info {

	private int sno;
	private String sname;
	private float savg;
	private Address saddr;
	

}
