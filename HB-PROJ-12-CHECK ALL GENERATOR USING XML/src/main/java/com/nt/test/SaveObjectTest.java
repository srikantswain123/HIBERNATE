package com.nt.test;



import org.hibernate.Session;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args)throws Exception {
     Session ses=null,ses1=null,ses2=null;
     Product prod=null,prod1=null,prod2=null;
     MyRequest mreq=null,mreq1=null,mreq2=null;
     boolean flag=false;
     //open session factory
     ses=HibernateUtil.getSession();
     ses1=HibernateUtil.getSession();
     ses2=HibernateUtil.getSession();
    
     //create Entity class Object
     prod=new Product();
     prod.setPid(100);prod.setPidname("table");prod.setPrice(5000);prod.setQty(5);
     
     
     prod1=new Product();
     prod1.setPid(1001); prod1.setPidname("table"); prod1.setPrice(5000); prod1.setQty(5);
     
     
     
     prod2=new Product();
     prod2.setPid(1002);prod2.setPidname("table");prod2.setPrice(5000);prod2.setQty(5);
     
     mreq=new MyRequest(prod, ses);
     mreq1=new MyRequest(prod1, ses1);
     mreq2=new MyRequest(prod2, ses2);
     Thread t1=new Thread(mreq);
     Thread t2=new Thread(mreq1);
     Thread t3=new Thread(mreq2);
     t1.start(); t2.start(); t3.start();
     
     
     
      Thread.sleep(300000);
    	   //close Session Object
    	   HibernateUtil.closeSession(ses);
    	   HibernateUtil.closeFactory();
    	   
       }
      
     
     
	}


