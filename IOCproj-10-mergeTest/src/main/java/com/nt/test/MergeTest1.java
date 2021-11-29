package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Membership;
import com.nt.utility.HibernateUtil;

public class MergeTest1 {

	public static void main(String[] args) {
		Session ses = null;
		Membership member = null, member1 = null, member2 = null;
		Transaction tx = null;
		boolean flag = false;
		// get Session
		ses = HibernateUtil.getSession();
		// prepare object
		member = ses.get(Membership.class, 66666L);
		System.out.println(member);
		try {
			// begin Tx
			tx = ses.beginTransaction();

			member1 = new Membership();
			member1.setMid(66666L);
			member1.setName("umesh");
			member1.setAddrs("mumbai");
			member1.setRewardPoints(84L);
			//ses.save(member1);
			//ses.saveOrUpdate(member1);
			//ses.delete(member1);
			//ses.update(member1);
			member2=(Membership) ses.merge(member1);
			System.out.println(member2);
			System.out.println(member.hashCode()+" "+member1.hashCode()+"  "+member2.hashCode());

			flag = true;
		} // try
		catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} finally {
			// perform tx mgmt
			if (flag) {
				tx.commit();
				System.out.println("Object is saved or updated");
			} else {
				tx.rollback();
				System.out.println("Object is not saved or updated");
			}
			// close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}

}
