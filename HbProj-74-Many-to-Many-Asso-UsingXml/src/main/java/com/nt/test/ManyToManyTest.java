package com.nt.test;

import com.nt.dao.IManyToMayDao;
import com.nt.dao.ManyToManyDaoImpl;

public class ManyToManyTest {

	public static void main(String[] args) {
		//invoke method
		IManyToMayDao dao=new ManyToManyDaoImpl();
		//dao.saveObjectUsingParent();
		//dao.saveObjectUsingChild();
         // dao.selectDataUsingParent();
		//dao.selectDataUsingChild();
		//dao.deleteAllcchildsOfAParent();
		dao.deleteAchildOfAParent();
	}//main

}//class
