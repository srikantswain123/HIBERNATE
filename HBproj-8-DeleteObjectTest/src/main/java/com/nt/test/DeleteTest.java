package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Project;
import com.nt.util.HibernateUtil;

public class DeleteTest {

	public static void main(String[] args) {
		Project proj=null;
		
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		
		try {
			tx=ses.beginTransaction();
			proj=ses.get(Project.class, 81);
			if(proj!=null) {
			
			ses.delete(proj);
			flag=true;
			System.out.println("object deleted");
			}else {
				flag=false;
				System.out.println("object not deleted");
			}
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				tx.commit();
				System.out.println("Object found ");
			}else {
				tx.rollback();
				System.out.println("Object not found");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}

}
