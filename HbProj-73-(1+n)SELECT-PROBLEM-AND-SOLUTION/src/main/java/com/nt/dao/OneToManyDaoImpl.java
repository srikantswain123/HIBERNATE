package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtility;

public class OneToManyDaoImpl implements OneToManyDao {
	
@Override
public void selectDataParentToChildONE_NProblem() {
	//get Session object
	Session ses=HibernateUtility.getSession();
	Transaction tx=null;
	try {
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		Query query=ses.createQuery("FROM UserInfo");
       List<UserInfo> list=query.getResultList();
       list.forEach(per->{
    	  System.out.println("parent "+per);
    	  Set<PhoneNumber> set=	per.getPhoneDetails();
    	  set.forEach(chi->{
    		  System.out.println("Child "+chi);
    	  });
       });
	
	}catch(HibernateException he) {
		he.printStackTrace();
	}finally {
   HibernateUtility.closeSessionFactory();
	}
}//method

@Override
	public void HBQBC_one_plus_n_solution() {
	//get Session object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
				Criteria criteria=ses.createCriteria(UserInfo.class);
				//criteria.setFetchMode("phoneDetails", FetchMode.JOIN);
				List<UserInfo> list=criteria.list();
				list.forEach(par->{
					System.out.println("parent "+par);
					Set<PhoneNumber> set=par.getPhoneDetails();
					set.forEach(child->{
						System.out.println("Child "+child);
					});
				});
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
	   HibernateUtility.closeSessionFactory();
		}
		
	}

@Override
	public void JPAQBC_one_plus_n_solution() {
	//get Session object
			Session ses=HibernateUtility.getSession();
			Transaction tx=null;
			try {
				if(!ses.getTransaction().isActive())
					tx=ses.beginTransaction();
					CriteriaBuilder cBuilder=ses.getCriteriaBuilder();
					CriteriaQuery cTquery=cBuilder.createQuery(UserInfo.class);
					Root<UserInfo> root=cTquery.from(UserInfo.class);
					root.fetch("phoneDetails");
					cTquery.select(root);
					
					//create Query Object
					Query query=ses.createQuery(cTquery);
					List<UserInfo> list=query.getResultList();
					list.forEach(parent->{
						System.out.println("parent "+parent);
						Set<PhoneNumber> set=parent.getPhoneDetails();
						set.forEach(child->{
							System.out.println("child "+child);
						});
					});
			
			}catch(HibernateException he) {
				he.printStackTrace();
			}finally {
		   HibernateUtility.closeSessionFactory();
			}
	}
@Override
	public void FETCH_HQL_JOIN_solution() {
	//get Session object
	Session ses=HibernateUtility.getSession();
	Transaction tx=null;
	try {
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
			Query query=ses.createQuery("SELECT u from UserInfo u inner join fetch u.phoneDetails ph");
			List<UserInfo> list=query.getResultList();
			list.forEach(parent->{
				System.out.println("parent "+parent);
				Set<PhoneNumber> set=parent.getPhoneDetails();
				set.forEach(child->{
					System.out.println("child "+child);
				});
			});
	
	}catch(HibernateException he) {
		he.printStackTrace();
	}finally {
   HibernateUtility.closeSessionFactory();
	}
		
	}
@Override
	public void HQL_SCALLAR_solution() {
	//get Session object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
				Query query=ses.createQuery("select u.userId,u.uname,u.uaddrs,ph.regNo,ph.phoneNumber,ph.type,ph.provider from UserInfo u inner join u.phoneDetails ph");
				
				List<Object[]> list=query.getResultList();
				list.forEach(row->{
					for(Object fetch:row)
						System.out.print(fetch+" ");
					System.out.println();
				});
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
	   HibernateUtility.closeSessionFactory();
		}
			
		
	}

}//class
