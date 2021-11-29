package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
     Session ses=null;
     Product prod=null;
     Transaction tx=null;
     boolean flag=false;
     //open session factory
     ses=HibernateUtil.getSession();
    
     //create Entity class Object
     prod=new Product();
     prod.setPid(100);prod.setPidname("table");prod.setPrice(5000);prod.setQty(5);
       try {
    	   tx=ses.beginTransaction();
    	   ses.save(prod);
    	   flag=true;
    	  System.out.println("Object Succesfully Inserted");
       }catch(HibernateException he) {
    	   he.printStackTrace();
    	   flag=false;
    	   System.out.println("Object SuccesFully Not Inserted");
       }
       finally {
    	   if(flag==true) {
    		   tx.commit();//Internally connection uses Autocommit
    	   }else {
    		   tx.rollback();//internally connection use Roolback
    	   }
    	   //close Session Object
    	   HibernateUtil.closeSession(ses);
    	   HibernateUtil.closeFactory();
    	   
       }
      
     
     
	}

}
