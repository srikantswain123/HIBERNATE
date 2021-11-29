package com.nt.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {

	public static void main(String[] args) {
     Configuration cfg=null;
     SessionFactory factory=null;
     Session ses=null;
     Product prod=null;
     Transaction tx=null;
     boolean flag=false;
     //create hibernate Object
     cfg=new Configuration();
     //suppliying cofiguration object
     cfg.configure("com/nt/cfg/hibernate.cfg.xml");
     //build Session Factory Object
     factory=cfg.buildSessionFactory();
     ses=factory.openSession();
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
    	   ses.close();//close Session Object
    	   factory.close();//close Factory Object
       }
     
     
	}

}
