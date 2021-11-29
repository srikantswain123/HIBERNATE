package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Entity
@Data
@Table(name="INSURANCEPOLICY")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public  class InsurancePolicy implements Serializable {
	@Id
	@GeneratedValue
	private Long policyId;
    private String policyName;
    private String policyType;
    private String company;
    private String tenure;
}
