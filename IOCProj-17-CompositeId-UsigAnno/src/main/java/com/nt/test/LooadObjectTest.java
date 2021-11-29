package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProgramerId;
import com.nt.entity.Project_Composite;
import com.nt.utility.HibernateUtil;

public class LooadObjectTest {
	public static void main(String[] args) {
		Session ses = null;
		ProgramerId id = null;
		Project_Composite proj=null;
		
		ses = HibernateUtil.getSession();
		try {
			
			id = new ProgramerId();
			id.setPid(101);
			id.setProjectId(5011);
			
			proj=(Project_Composite) ses.get(Project_Composite.class, id);
			System.out.println(proj);
			
		} // try
		catch (HibernateException he) {
			he.printStackTrace();
		} // finally{
		
		HibernateUtil.closeSession(ses);
		HibernateUtil.CloseSessionFactory();

	}

}
