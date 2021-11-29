package com.nt.entity;

import lombok.Data;

@Data
public class JobSeeker {
	private Integer eid;
	private String ename;
	private String eaddr;
	private byte[] photo;
	private char[] resume;

}
