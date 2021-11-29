package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.InsurancePolicy;

public class HibernateUtility {
	private static SessionFactory factory;
	static {
		//standard service registry 
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		//service registry
		ServiceRegistry registry=null;
		//boot strap hibernate 
		Configuration cfg=new Configuration();
		//configure anotated class
		cfg.addAnnotatedClass(InsurancePolicy.class);
		//read propertied file
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		registry=builder.applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(registry);
	}
	
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.getCurrentSession();
		return ses;
	}
	
	public static void closeSessionFactory() {
		factory.close();
	}
	
	//get factory object
	public static SessionFactory getFactory() {
		return factory;
	}

}//class
