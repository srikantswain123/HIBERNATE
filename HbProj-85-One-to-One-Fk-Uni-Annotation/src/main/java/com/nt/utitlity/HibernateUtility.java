package com.nt.utitlity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.Passport;
import com.nt.entity.Person;

public class HibernateUtility {
	private static SessionFactory factory;
	static {
		//create ServiceRegistry builder Object
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		ServiceRegistry registry=null;
		//bootstrap hibernate
		Configuration cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//add anotated class
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Passport.class);
		
		registry=builder.applySettings(cfg.getProperties()).build();
		// build  session factory  with serviceRegistry
		factory=cfg.buildSessionFactory(registry);
	}
	
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.getCurrentSession();
		return ses;
	}
	
	public void closeSessionFcatory() {
		factory.close();
	}

}
