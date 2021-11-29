package com.nt.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtility;
@WebListener
public class HibernateFactoryClose implements ServletContextListener {
	 @Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context destroy");
		HibernateUtility.closeFactory();
	}

}
