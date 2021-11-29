package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	static {
		try {
			Configuration cfg=null;
			cfg=new Configuration();
			cfg.configure("com/nt/cfg/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
			return ses=factory.openSession();
		}else {
			return ses;
		}
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeFactory() {
		if(factory!=null)
			factory.close();
	}


}
