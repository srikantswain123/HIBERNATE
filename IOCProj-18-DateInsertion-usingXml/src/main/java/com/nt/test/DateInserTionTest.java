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
		pers.setDob(LocalDateTime.of(96,02,06,4,50,25));
		pers.setDoj(LocalDateTime.now());
		pers.setDom(LocalDate.of(125,05,06));
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
