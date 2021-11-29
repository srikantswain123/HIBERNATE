package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Product implements Serializable {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	private String pidname;
	private Float price;
	private Integer qty;

}
