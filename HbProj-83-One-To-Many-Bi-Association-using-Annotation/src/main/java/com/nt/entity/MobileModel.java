package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "MOBILE_MODELS_OTM_BI")
@Setter
@Getter
@RequiredArgsConstructor
public class MobileModel implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "MODELS_SEQ",allocationSize = 1,initialValue =1000)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer modelId;
	@Column(length = 20)
	@Type(type = "string")
	@NonNull
	private String modelName;
	@NonNull
	private LocalDate lunchDate;
	@ManyToOne(targetEntity = MobileBrand.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_ID",referencedColumnName = "brandId")
	private MobileBrand brand;
	
	
	public MobileModel() {
		System.out.println("MobileModel::0 param constructor");
	}  
	@Override
	public String toString() {
		return "MobileModel [modelId=" + modelId + ", modelName=" + modelName + ", lunchDate=" + lunchDate + "]";
	}
	

}
