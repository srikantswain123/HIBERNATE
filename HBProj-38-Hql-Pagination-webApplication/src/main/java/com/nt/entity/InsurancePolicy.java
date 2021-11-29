package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;
@NamedQuery(query = "FROM com.nt.entity.InsurancePolicy", name = "Insurance_data")
@NamedQuery(query = "SELECT count(*) FROM com.nt.entity.InsurancePolicy", name = "Insurance_count")
@Data
@Entity

public class InsurancePolicy implements Serializable {
	@Id
	private Long PolicyId;
	private String PolicyName;
	private String company;
	private String policyType;
	private Integer tenure;

}
