package com.nt.test;

import com.nt.dao.IPersonDao;
import com.nt.dao.PersonDaoImpl;

public class One_To_One_fk_Anno_Test {

	public static void main(String[] args) {
		//craete dao object
	IPersonDao dao=new PersonDaoImpl();
	//invoke method
	dao.saveObject();
	

	}

}
