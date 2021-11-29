package com.nt.test;

import com.nt.dao.IOne_To_Many_Dao_UNI;
import com.nt.dao.One_To_Many_DAO_IMPL;
import com.nt.utility.HibernateUtility;

public class One_to_Many_uni_test 
{
    public static void main( String[] args )
    {
    	//craete dao Object
    	IOne_To_Many_Dao_UNI dao=new One_To_Many_DAO_IMPL();
    	//invoke method
    	//dao.saveObjectUsingParent();
    	//dao.loadDataUsingParent();
    	//dao.loadDataUsingParentQBC();
    	dao.deleteOneChildOfCollectionOfChildsBelngingAParent();
    	
    	//close session factory
    	HibernateUtility.closeSessionFactory();
    }
}
