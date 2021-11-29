package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "MOBILE_BRAND_OTM_BI")
@Setter
@Getter
@RequiredArgsConstructor
public class MobileBrand implements Serializable {
	@Id
	@GeneratedValue
	private Integer brandId;
	@Column(length = 20)
	@Type(type="string")
	@NonNull
	private String brandName;
	@NonNull
	private LocalDate lunchDate;
	@Column(length = 20)
	@Type(type="string")
	@NonNull
	private String location;
	@OneToMany(targetEntity = MobileModel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name = "BRAND_ID",referencedColumnName = "brandId")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<MobileModel> models;
	
   public MobileBrand() {
	   System.out.println("MobileBrand::0 param constructor");
   }
@Override
public String toString() {
	return "MobileBrand [brandId=" + brandId + ", brandName=" + brandName + ", lunchDate=" + lunchDate + ", location="
			+ location + "]";
}
   

}
