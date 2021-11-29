package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class InsurancePolicyDto implements Serializable {
	private Long PolicyId;
	private String PolicyName;
	private String company;
	private String policyType;
	private Integer tenure;

}
