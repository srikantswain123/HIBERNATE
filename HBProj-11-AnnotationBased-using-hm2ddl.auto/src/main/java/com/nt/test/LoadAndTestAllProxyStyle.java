package com.nt.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Iproject;
import com.nt.utitlty.HibernateUtil;

public class LoadAndTestAllProxyStyle {
	public static void main(String[] args) {
		Iproject proj=null;
		//get Session Object
		Session ses=null;
		Transaction tx=null;
		
		ses=HibernateUtil.getSession();
		try {
			proj=ses.load(Iproject.class,101L);
			System.out.println(proj.getClass()+" "+Arrays.toString(proj.getClass().getInterfaces()));
			
		}catch(HibernateException he) {
			he.printStackTrace();
			
		}finally {
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionfactory();
			
		}
		
		
	}

}
