package com.nt.test;

import com.nt.dao.IManyToManyDao;
import com.nt.dao.ManyToManyDaoImpl;
import com.nt.utility.HibernateUtility;

public class ManyToManyTest 
{
    public static void main( String[] args )
    {
        //create dao object
    	IManyToManyDao dao=new ManyToManyDaoImpl();
    	//invoke method
    	dao.saveObjectUsingParent();
    	//close session factory
    	HibernateUtility.closeSessionFactory();
    }
}
