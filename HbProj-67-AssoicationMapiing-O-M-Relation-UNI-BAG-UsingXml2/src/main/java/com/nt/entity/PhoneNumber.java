package com.nt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
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

}
