package com.nt.entity;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private Integer userId;
	@NonNull
	private String  uname;
	@NonNull
	private String   uaddrs;
	private PhoneNumber[] phoneDetails;

}
