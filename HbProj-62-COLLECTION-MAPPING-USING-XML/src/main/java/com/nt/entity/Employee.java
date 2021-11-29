package com.nt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
@Data
public class Employee implements Serializable {
	private Integer eno;
	private String ename;
	private String eadd;
	private List<String> friends;
	private List<String> relatives;
	private Set<Long> mobileNo;
	private Map<String,Long> bankAccount;
}
