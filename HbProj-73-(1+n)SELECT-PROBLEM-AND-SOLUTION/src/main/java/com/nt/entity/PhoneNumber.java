package com.nt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor 
public class PhoneNumber {
	private Integer regNo;
	@NonNull
	private Long    phoneNumber;
	@NonNull
	private String type;
	@NonNull
	private String provider;
	private UserInfo user;
	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phoneNumber=" + phoneNumber + ", type=" + type + ", provider="
				+ provider + "]";
	}
	

}
