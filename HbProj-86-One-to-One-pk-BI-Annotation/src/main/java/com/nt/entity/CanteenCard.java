package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="CANTEEN_OTO_PK_BI_ANNO")
@Data
@RequiredArgsConstructor
public class CanteenCard implements Serializable {
	@Id
	@GenericGenerator(name = "gen1",strategy = "foreign",parameters = @Parameter(name="property",value = "emp"))
	@GeneratedValue(generator = "gen1")

	private Integer cid;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String cname;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String location;
	@Column(length=20)
	@Type(type="string")
	@NonNull
	private String cardType;
	@OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "canteenDetails")
	private Employee emp;
	public CanteenCard() {
		System.out.println("CanteenCard::zero param constructor");
	}

}
