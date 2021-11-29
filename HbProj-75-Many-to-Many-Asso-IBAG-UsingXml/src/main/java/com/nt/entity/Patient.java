package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
public class Patient {
	
	private  Integer pid;
	@NonNull
	private String pname;
	@NonNull
	private String diease;
    private Set<Doctor> doctor;
    public Patient() {
		System.out.println("Patient Object");
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", diease=" + diease + "]";
	}
 
}
