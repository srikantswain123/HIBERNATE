package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Department implements Serializable {
	private Integer deptId;
	@NonNull
	private String deptName;
	@NonNull
	private String location;
	@NonNull
	private Integer capacity;

	
	public Department() {
		System.out.println("Department::class "+this.getClass().getName());
	}
}
