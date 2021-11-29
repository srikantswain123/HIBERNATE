package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="JOBSEEKER")
@Data
public class JobSeeker {
	@Id
	@Type(type="int")
	@GeneratedValue
	private Integer eid;
	@Type(type="string")
	@Column(length = 20)
	private String ename;
	@Type(type="string")
	@Column(length = 20)
	private String eaddr;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;

}
