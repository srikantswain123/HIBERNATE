package com.nt.test;

import com.nt.dao.AuthenticationDaoImpl;
import com.nt.dao.IAuthenticationDAO;

public class AuthenticationTest {
	

	public static void main(String[] args) {
		IAuthenticationDAO dao=null;
		dao=new AuthenticationDaoImpl();
		System.out.println(dao.verfiCredential("raja", "rani"));
		

	}

}
