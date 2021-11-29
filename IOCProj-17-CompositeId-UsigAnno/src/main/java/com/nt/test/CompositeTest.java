package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProgramerId;
import com.nt.entity.Project_Composite;
import com.nt.utility.HibernateUtil;

public class CompositeTest {
	public static void main(String[] args) {
		Session ses = null;
		ProgramerId id = null;
		Project_Composite pc = null;
		boolean flag = false;
		Transaction tx = null;
		ses = HibernateUtil.getSession();
		try {
			tx = ses.beginTransaction();
			id = new ProgramerId();
			id.setPid(1012);
			id.setProjectId(50121);
			pc = new Project_Composite();
			pc.setCompany("TCS");
			pc.setProjectName("OpenFx");
			pc.setId(id);
			id = (ProgramerId) ses.save(pc);
			System.out.println("Session id::" + id);
			flag = true;
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // finally{
		if (flag) {
			tx.commit();
		} else {
			tx.rollback();
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.CloseSessionFactory();

	}

}
