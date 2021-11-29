package com.nt.entity;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Doctor {
	
	private Integer did;
	@NonNull
	private String dname;
	@NonNull
	private String hospital;
	@NonNull
	private String qlfy;
	private List<Patient> patient;
	public Doctor() {
		System.out.println("Doctor Object");
	}
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", hospital=" + hospital + ", qlfy=" + qlfy + "]";
	}
	

}
