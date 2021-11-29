package com.nt.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtility;
@WebListener
public class SessionObjectListnerForDestorySessionObject implements ServletRequestListener {
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request Destroy");
		HibernateUtility.closeSession();
	}

}
