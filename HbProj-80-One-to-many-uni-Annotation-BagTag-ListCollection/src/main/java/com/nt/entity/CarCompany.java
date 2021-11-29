package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@Table(name = "CAR_COMPANY_BAG")
public class CarCompany implements Serializable {
	@Id
	@GeneratedValue
	private Integer cid;
	@Type(type="string")
	@Column(length = 20)
	@NonNull
	private String compName;
	@Type(type="string")
	@Column(length = 20)
	@NonNull
	private String location;
	
	
	@OneToMany(targetEntity = CarModel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true )
	@JoinColumn(name = "company_id",referencedColumnName = "cid")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	private List<CarModel> model;
  
	
	public CarCompany() {
   System.out.println("CarCompany::zero param constructor");
	}


	@Override
	public String toString() {
		return "CarCompany [cid=" + cid + ", compName=" + compName + ", location=" + location + "]";
	}
	
}
