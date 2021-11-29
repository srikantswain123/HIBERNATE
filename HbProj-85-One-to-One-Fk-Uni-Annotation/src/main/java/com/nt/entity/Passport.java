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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data	
@Table(name="PASSPORT_OTO_FK_ANNO")
@RequiredArgsConstructor
public class Passport implements Serializable {
	@Id
	@SequenceGenerator(name ="gen1",sequenceName="PASPORT_NO_ANNO",initialValue = 56489,allocationSize = 10)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
	private Integer ppno;
	@NonNull
	@Column(length = 20)
	@Type(type="string")
	private String Country;
	@NonNull
	private LocalDate expiryDate;
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name = "person_id",referencedColumnName = "PID")
	private Person person;

}
