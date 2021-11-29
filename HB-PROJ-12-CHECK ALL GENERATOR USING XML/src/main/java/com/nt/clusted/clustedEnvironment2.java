package com.nt.clusted;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class clustedEnvironment2 {

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
     prod.setPid(3000);prod.setPidname("ab");prod.setPrice(90900.0f);prod.setQty(789);
       try {
    	   tx=ses.beginTransaction();
    	   int id=(int)ses.save(prod);
    	   System.out.println("Session id ="+id);
    	   flag=true;
    	  System.out.println("Object Succesfully Inserted");
    	  Thread.sleep(30000);
       }catch(HibernateException he) {
    	   he.printStackTrace();
    	   flag=false;
    	   System.out.println("Object SuccesFully Not Inserted");
       }catch(Exception e) {
    	   e.printStackTrace();
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
