package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Project;
import com.nt.utitlty.HibernateUtil;

public class AnnotaionBasedTest {
	public static void main(String[] args) {
		Project proj=null;
		//get Session Object
		Session ses=null;
		Transaction tx=null;
		Long id=0l;
		
		ses=HibernateUtil.getSession();
		boolean flag=false;
		proj=new Project();
		proj.setPid(101L);
		proj.setPname("openFx");
		proj.setCompName("Oracle");
		proj.setTeamMember(12);
		try {
			tx=ses.beginTransaction();
			id=(Long)ses.save(proj);
			flag=true;
			System.out.println(id);
		}catch(HibernateException he) { 
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionfactory();
			
		}
		
		
	}

}
