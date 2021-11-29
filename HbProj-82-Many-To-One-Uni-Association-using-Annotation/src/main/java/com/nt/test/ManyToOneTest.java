package com.nt.test;

import com.nt.dao.IManyToOneDao;
import com.nt.dao.ManyToOneDaoImpl;

public class ManyToOneTest {

	public static void main(String[] args) {
		//craeate Dao Object
		IManyToOneDao dao=new ManyToOneDaoImpl();
		//invoke method
		dao.saveObject();

	}

}
