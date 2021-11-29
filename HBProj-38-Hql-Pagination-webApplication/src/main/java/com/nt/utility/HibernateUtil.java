package com.nt.utility;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.InsurancePolicy;

public class HibernateUtil {
	private static SessionFactory factory=null;
	static {
		StandardServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		Configuration cfg=null;
		try {
		//bootstarp hibernate With ServiceRegistry for additional functionality upon existing session oBject\
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/Hibernate.cfg.xml");
		cfg.addAnnotatedClass(InsurancePolicy.class);
		builder=new StandardServiceRegistryBuilder();
		registry=builder.applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(registry);
		}catch(HibernateException he) {
			he.printStackTrace();
		}
	}//static
  public static Session getSession() {
	  Session ses=null;
	  if(factory!=null)
		  ses=factory.getCurrentSession();
	  
	  return ses;
  }//close session
  
  public static void closeFactory() {
	  if(factory!=null)
	     factory.close();
  }//close factorys
	
	
	
}
