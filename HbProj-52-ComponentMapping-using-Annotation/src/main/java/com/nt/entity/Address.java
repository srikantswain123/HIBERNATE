package com.nt.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	private String doorNo;
	private String streetName;
	private String cityName;
	private String countryName;
	private Long pin;

}
