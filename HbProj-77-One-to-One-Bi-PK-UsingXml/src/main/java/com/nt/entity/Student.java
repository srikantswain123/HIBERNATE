package com.nt.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Student {
	private Integer sid;
	@NonNull
	private String sname;
	@NonNull
	private String sadd;
	
	private LibraryMgmt library;
	public Student() {
		System.out.println("Student.Zero param constructor");
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
	

}//class
