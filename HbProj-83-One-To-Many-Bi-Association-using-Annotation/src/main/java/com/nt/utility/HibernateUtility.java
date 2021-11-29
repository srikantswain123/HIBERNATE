package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.MobileBrand;
import com.nt.entity.MobileModel;

public class HibernateUtility {
	private static SessionFactory factory;
	static {
		try {
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		ServiceRegistry registry=null;
		//boot hibernate
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//add anotated class
		   cfg.addAnnotatedClass(MobileModel.class);
		   cfg.addAnnotatedClass(MobileBrand.class);
		 
		//registry object
		registry=builder.applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(registry);
		}catch(HibernateException he) {
			he.printStackTrace();
		}
				
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.getCurrentSession();
		return ses;
	}
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
