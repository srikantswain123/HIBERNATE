package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		try {
		Configuration cfg=null;
		//Boot Strap Hibernate
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Session getSession() {
		Session ses=null;
		if(ses==null)
		  return	ses=factory.openSession();
		else 
			return ses;
		
		
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void CloseSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
