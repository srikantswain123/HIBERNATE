package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;

public class MyRequest implements Runnable {
	private Product p;
	private Session ses;
	boolean flag=true;
	Transaction tx=null; 

	public MyRequest(Product p, Session ses) {
		this.p = p;
		this.ses = ses;
	}


	@Override
	public void run() {
		 
		 tx=ses.beginTransaction();
	
		 try {
	    	
			
	    	int count=(int)ses.save(p);
	    	System.out.println("generator id  "+count);
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

	}
	}
}


