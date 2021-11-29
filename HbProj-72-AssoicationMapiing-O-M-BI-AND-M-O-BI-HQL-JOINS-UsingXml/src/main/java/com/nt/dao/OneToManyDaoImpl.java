package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtility;

public class OneToManyDaoImpl implements OneToManyDao {
	
@Override
public void selectDataParentToChild() {
	//get Session object
	Session ses=HibernateUtility.getSession();
	Transaction tx=null;
	try {
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		Query query=ses.createQuery("select u.userId,u.uname,u.uaddrs,ph.regNo,ph.phoneNumber,ph.type,ph.provider from UserInfo u inner join u.phoneDetails ph");
		//Query query=ses.createQuery("select u.userId,u.uname,u.uaddrs,ph.regNo,ph.phoneNumber,ph.type,ph.provider from UserInfo u left join u.phoneDetails ph");
		//Query query=ses.createQuery("select u.userId,u.uname,u.uaddrs,ph.regNo,ph.phoneNumber,ph.type,ph.provider from UserInfo u right join u.phoneDetails ph");
		//Query query=ses.createQuery("select u.userId,u.uname,u.uaddrs,ph.regNo,ph.phoneNumber,ph.type,ph.provider from UserInfo u full join u.phoneDetails ph");
       List<Object[]> list=query.getResultList();
       list.forEach(per->{
    	   for(Object var:per) {
    		   System.out.print(var+" ");
    	   }
    	   System.out.println();
       });
	
	}catch(HibernateException he) {
		he.printStackTrace();
	}finally {
   HibernateUtility.closeSessionFactory();
	}
}//method


@Override
	public void selectDatachildToParent() {
	//get Session object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//Query query=ses.createQuery("select ph.regNo,ph.phoneNumber,ph.type,ph.provider,u.userId,u.uname,u.uaddrs from PhoneNumber ph inner join ph.user u");
			//Query query=ses.createQuery("select ph.regNo,ph.phoneNumber,ph.type,ph.provider,u.userId,u.uname,u.uaddrs from PhoneNumber ph left join ph.user u");
			//Query query=ses.createQuery("select ph.regNo,ph.phoneNumber,ph.type,ph.provider,u.userId,u.uname,u.uaddrs from PhoneNumber ph right join ph.user u");
			Query query=ses.createQuery("select ph.regNo,ph.phoneNumber,ph.type,ph.provider,u.userId,u.uname,u.uaddrs from PhoneNumber ph full join ph.user u");
	       List<Object[]> list=query.getResultList();
	       list.forEach(per->{
	    	   for(Object var:per) {
	    		   System.out.print(var+" ");
	    	   }
	    	   System.out.println();
	       });
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
	   HibernateUtility.closeSessionFactory();
		}
		
	}




}//class
