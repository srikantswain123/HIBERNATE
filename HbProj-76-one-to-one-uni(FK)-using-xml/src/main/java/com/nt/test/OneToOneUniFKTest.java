package com.nt.test;

import com.nt.dao.IOneToOneDAO;
import com.nt.dao.OneToOneDaoImpl;

public class OneToOneUniFKTest {

	public static void main(String[] args) {
		//create dao Object
		IOneToOneDAO dao=new OneToOneDaoImpl();
		//invoke method
		dao.saveObject();

	}

}
