package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.IinsurancePolicy;
import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class LoadingObjectTest {
	public static void main(String[] args) {
		IinsurancePolicy policy = null;
		Session ses = null;
		try {
			ses = HibernateUtility.getSession();

			policy = ses.load(IinsurancePolicy.class, 1010L);
			System.out.println(policy);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.closeSession(ses);
			HibernateUtility.closeFactory();
		}

	}

}
