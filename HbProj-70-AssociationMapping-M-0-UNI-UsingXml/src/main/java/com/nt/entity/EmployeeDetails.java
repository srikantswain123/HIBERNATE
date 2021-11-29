package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeDetails implements Serializable {
	private Integer empRegno;
	@NonNull
	private String empName;
	@NonNull
	private Float empSal;
	@NonNull
	private Department dept;
	public EmployeeDetails() {
		System.out.println("Employee::class:Load"+this.getClass().getName());
	}
	

}
