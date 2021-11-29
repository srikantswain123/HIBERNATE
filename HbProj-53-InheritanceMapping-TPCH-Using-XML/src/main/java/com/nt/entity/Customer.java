package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Customer extends Person implements Serializable {
  private String desg;
  private float sal;
  private Integer deptno;
@Override
public String toString() {
	return super.toString() + "Customer [desg=" + desg + ", sal=" + sal + ", deptno=" + deptno + ", toString()=" +  "]";
}
  
}
