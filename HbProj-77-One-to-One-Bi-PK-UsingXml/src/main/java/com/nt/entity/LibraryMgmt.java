package com.nt.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class LibraryMgmt {
	private Integer lid;
	@NonNull
	private String type;
	@NonNull
	private LocalDate startDate;
	@NonNull
	private LocalDate endDate;
	private Student studentDetails;
	
	public LibraryMgmt() {
		System.out.println("LibraryMgmt::zero param constructor");
	}

	@Override
	public String toString() {
		return "LibraryMgmt [lid=" + lid + ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	

}//class
