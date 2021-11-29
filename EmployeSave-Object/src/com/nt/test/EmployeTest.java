package com.nt.test;

import javax.transaction.TransactionalException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employe;

public class EmployeTest {
    public static void main(String[] args) {
		Configuration cfg=null;
		boolean flag=false;
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		SessionFactory factory=null;
		factory=cfg.buildSessionFactory();
		Session ses=null;
		ses=factory.openSession();
		Employe emp=new Employe();
		emp.setAge(26);
		emp.setEmpname("Durvi");
        emp.setSallary(150);	
        Transaction tx=null;
        
        try {
        	tx=ses.beginTransaction();
        	ses.persist(emp);
        	flag=true;
           
        }catch(TransactionException te) {
        	te.printStackTrace();
        	flag=false;
        }finally {
        	if(flag==true) {
        		tx.commit();
        	}else {
        		tx.rollback();
        	}
        	
        	ses.close();
        	factory.close();

        }
	}
}
