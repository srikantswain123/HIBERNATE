package com.nt.test;

import com.nt.dao.IOne_To_OneDAO;
import com.nt.dao.One_To_One_DAOIMPL;

public class One_To_One_PK_BI_TEST 
{
    public static void main( String[] args )
    {
    	//create dao Object
    	IOne_To_OneDAO dao=new One_To_One_DAOIMPL();
    	//dao.saveObjectUsingParent();
    	//dao.saveObjectUsingChild();
    	dao.loadObjectUsingParent();
    }//method
}//class
