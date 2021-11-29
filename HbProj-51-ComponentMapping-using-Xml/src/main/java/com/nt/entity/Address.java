package com.nt.entity;

import lombok.Data;

@Data
public class Address {
	private String doorNo;
	private String streetName;
	private String cityName;
	private String countryName;
	private Long pin;

}
