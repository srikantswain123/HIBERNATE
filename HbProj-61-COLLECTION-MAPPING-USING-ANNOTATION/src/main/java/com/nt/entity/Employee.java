package com.nt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.Type;

import lombok.Data;
@Data
@Entity
@Table(name="Employee_collection")
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private Integer eno;
	
	@Type(type="string")
	@Column(length = 20)
	private String ename;
	
	@Type(type="string")
	@Column(length = 20)
	private String eadd;
	
	@ElementCollection
	@Column(name="FRIEND")
	@CollectionTable(name="FRIENDS_LIST",
	joinColumns =@JoinColumn(name="EMP_ID",referencedColumnName = "eno"))
	@OrderColumn(name = "FRIENDS_NO")
	@ListIndexBase(value=1)
	private List<String> friends;
	
	
	@ElementCollection
	@Column(name="MOBILE_NO")
	@CollectionTable(name="EMP_NUMBERS",
	joinColumns =@JoinColumn(name="EMP_ID",referencedColumnName = "eno"))
	private Set<Long> mobileNo;
	
	
	@ElementCollection
	@Column(name="BANK_ACCOUNT")
	@CollectionTable(name="EMP_ACCOUNTS",
	joinColumns =@JoinColumn(name="EMP_ID",referencedColumnName = "eno"))
	@MapKeyColumn(name="BANK_NAME")
	private Map<String,Long> bankAccount;
}
