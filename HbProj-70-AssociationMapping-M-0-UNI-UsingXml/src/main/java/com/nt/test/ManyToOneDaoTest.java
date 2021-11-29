package com.nt.test;

import com.nt.dao.IManyToOneDao;
import com.nt.dao.ManyToOneDaoImpl;

public class ManyToOneDaoTest {

	public static void main(String[] args) {
		//create Dao Object
		IManyToOneDao dao=new ManyToOneDaoImpl();
		//invoke method
		//dao.saveManyToOne();
		//dao.selectDataUsingChild();
		dao.deleteOneChildFromCollectionOfChildOfAparent();

	}//main

}//class
