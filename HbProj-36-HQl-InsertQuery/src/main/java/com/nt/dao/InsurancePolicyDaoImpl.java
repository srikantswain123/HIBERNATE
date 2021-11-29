package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtility;

public class InsurancePolicyDaoImpl implements IinsurancePolicyDAO {
	//private static final String HQL_TRANSFER_QUERY="INSERT INTO com.nt.entity.PremiumInsurancePolicy(pId,policyName,policyType,company,tenure)SELECT i.policyId,i.policyName,i.policyType,i.company,i.tenure from com.nt.entity.InsurancePolicy as i where i.tenure>=:min";
	

	@Override
	public String transferData(int tenure) {
		Session ses=null;
		int count=0;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		String msg=null;
		try {
			//get Session object from utility class
			ses=HibernateUtility.getSession();
			tx=ses.beginTransaction();
			//prepare query
			//query=ses.createQuery(HQL_TRANSFER_QUERY);
			//get mapping query from Mapping file 
			query=ses.getNamedQuery("HQL_TRANSFER_QUERY");
			
			//set parameter
			query.setParameter("min", tenure);
			//execute query
			count=query.executeUpdate();
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				msg=count+" Data transferd";
			}else {
				msg="no data transfered";
			}
		}//finally
		
		
		
		return msg;
	}

}
