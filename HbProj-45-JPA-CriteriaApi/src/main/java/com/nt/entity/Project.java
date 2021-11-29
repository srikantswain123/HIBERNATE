package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	private Long pid;
	private String compName;
	private String pname;
	private Long teammemeber;
	private String location;

}
