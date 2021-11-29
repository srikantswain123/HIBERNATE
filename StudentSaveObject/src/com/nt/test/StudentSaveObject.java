package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student;

public class StudentSaveObject {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		Student st=null;
		boolean flag=false;
		//create hibernate configuration object
		cfg=new Configuration();
		cfg.configure("com/nt/cfg/hibernate.cfg.xml");
		//build session factory
		factory=cfg.buildSessionFactory();
		//open session factory for connection
		ses=factory.openSession();
		//set Student Object Value
		st=new Student();
		st.setSid(9000);st.setSaddr("Mumbai");st.setMark(550);st.setSname("jagdip");
		try {
			tx=ses.beginTransaction();//internally uses Autio Commit false
			ses.save(st);
			flag=true;
			System.out.println("Successfully Inserted ");
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
			System.out.println("Not inserted Properly");
		}finally {
			if(flag==true) {
				tx.commit();
			}else {
				tx.rollback();
			}
		}
		
		

	}

}
