package com.nt.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Person_Info;
import com.nt.utility.HibernateUtil;

public class DateInserTionTest {

	public static void main(String[] args) {
		Person_Info pers=null;
		Session ses=null;
		Transaction tx=null;
		ses=HibernateUtil.getSession();
		boolean flag=false;
		//create Person Object and set Valueto parameter
		pers=new Person_Info();
		pers.setDob(LocalDateTime.of(1996,02,06,4,50,25));
		pers.setDoj(LocalDate.of(2012, 06,2));
		pers.setDom(LocalDateTime.of(201,02,06,4,50,25));
		pers.setPname("Srikant");
		try {
			tx=ses.beginTransaction();
			int pid=(int)ses.save(pers);
			flag=true;		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}//catch
		finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSession(ses);
			HibernateUtil.CloseSessionFactory();
			
		}//finally

	}

}
