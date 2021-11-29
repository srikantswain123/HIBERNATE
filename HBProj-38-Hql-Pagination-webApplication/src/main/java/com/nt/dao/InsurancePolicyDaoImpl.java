package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class InsurancePolicyDaoImpl implements IInsurancePolicyDao {

	@Override
	public List<InsurancePolicy> getResult(int pageResult, int maxResult) {
		Session ses=null;
		List<InsurancePolicy> list=null;
		Query query=null;
		try {
			//get Session Object
			ses=HibernateUtil.getSession();
			//get named Query
			query=ses.getNamedQuery("Insurance_data");
			//get Result along with pagination
			query.setFirstResult(pageResult);
			//set value for pagination
			query.setMaxResults(maxResult);
			list=query.getResultList();
		}catch(HibernateException he) {
			he.printStackTrace();
			throw he;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		
		return list;
	}//method

	@Override
	public Integer getResultCount() {
		
		Session ses=null;

       List<Integer> list=null;
		Query query=null;
		Transaction tx=null;
		Integer count=0;
		try {
			tx=ses.beginTransaction();
			//get Session Object
			ses=HibernateUtil.getSession();
			//get named Query
			query=ses.getNamedQuery("Insurance_count");
			//get Result along with pagination
			list=query.getResultList();
			count=list.get(0);
		}catch(HibernateException he) {
			he.printStackTrace();
			throw he;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	return  count;
	}

}//class
