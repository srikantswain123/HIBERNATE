package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private Integer userId;
	@NonNull
	private String  uname;
	@NonNull
	private String   uaddrs;
	private Set<PhoneNumber> phoneDetails;
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", uname=" + uname + ", uaddrs=" + uaddrs + "]";
	}
	
	

}
