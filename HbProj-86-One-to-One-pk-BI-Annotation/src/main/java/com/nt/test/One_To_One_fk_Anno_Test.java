package com.nt.test;

import com.nt.dao.IOne_To_One_pk_Dao;
import com.nt.dao.One_To_One_Dao_Impl;

public class One_To_One_fk_Anno_Test {

	public static void main(String[] args) {
		//craete dao object
	IOne_To_One_pk_Dao dao=new One_To_One_Dao_Impl();
	//invoke method
	dao.saveObject();
	

	}

}
