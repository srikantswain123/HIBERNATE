package com.nt.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
public class Passport {
	private Long ppid;
	@NonNull
	private String country;
	@NonNull
	private LocalDate expiry;
	private Person details;
	
	public Passport() {
		System.out.println("Pasort using zero param constructor");
	}

	@Override
	public String toString() {
		return "Passport [ppid=" + ppid + ", country=" + country + ", expiry=" + expiry + "]";
	}
	

}
