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
	public void addDataToParentAndItsChild() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			//set object data
			PhoneNumber phone1 = new PhoneNumber(7777777l, "prepaierd", "Airtel");
			PhoneNumber phone2 = new PhoneNumber(6666666l, "postpaid", "Vodafone");
			Set<PhoneNumber> phoneSet = Set.of(phone1, phone2);

			UserInfo info = new UserInfo("Aron", "africa");
			info.setPhoneDetails(phoneSet);
			//save data
			ses.save(info);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Object are saved");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		}

	}

	@Override
	public void selectParentDataAndTheirChild() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

			Query query = ses.createQuery("from UserInfo");
			List<UserInfo> list = query.getResultList();
			list.forEach(user -> {
				System.out.println("parent ::" + user.getUname() + " " + user.getUaddrs() + " " + user.getUserId());
				Set<PhoneNumber> set = user.getPhoneDetails();
				System.out.println(set.isEmpty());
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			//close session factory
			HibernateUtility.closeSessionFactory();
		} //finally
	}

	@Override
	public void addDataOnExstingParentAndItsChild() {

		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			UserInfo user = ses.get(UserInfo.class, 1);
			PhoneNumber num = new PhoneNumber();
			num.setPhoneNumber(55555555l);
			num.setType("postpaid");
			num.setProvider("jio");
			Set<PhoneNumber> set = user.getPhoneDetails();
			set.add(num);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Object are saved on exting component");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved on existing component");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		} //finally

	}

	@Override
	public void deleteAparentAndItsChild() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			UserInfo user = ses.get(UserInfo.class, 1);
			ses.delete(user);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println(" parent and its childs Are deleted");
			} else {
				tx.rollback();
				System.out.println("Problem towards deleted the object ");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		} //finally

	}

	@Override
	public void deleteDataOfParentAndTheirChild() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			Query<UserInfo> query = ses.createQuery(" FROM com.nt.entity.UserInfo");
			List<UserInfo> list = query.getResultList();
			list.forEach(user -> {
				ses.delete(user);
			});
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println(" parent and Their childs Are deleted");
			} else {
				tx.rollback();
				System.out.println("Problem towards deleted the object ");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		} //finally

	}

	@Override
	public void deleteAllChildsOfAParent() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			UserInfo user = ses.get(UserInfo.class, 2);
			Set<PhoneNumber> set = user.getPhoneDetails();
			set.removeAll(set);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println(" All childs of parents are deleted");
			} else {
				tx.rollback();
				System.out.println("Problem towards deleted the object ");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		} //finally

	}

	@Override
	public void deleteOneChildFromCollectionOfChildOfA_Parent() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			UserInfo user = ses.get(UserInfo.class, 1);
			Set<PhoneNumber> set = user.getPhoneDetails();
			PhoneNumber ph1 = ses.get(PhoneNumber.class, 95);
			set.remove(ph1);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println("one childs of A parents are deleted");
			} else {
				tx.rollback();
				System.out.println("Problem towards deleted the object ");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		} //finally

	}

	@Override
	public void transferOneChildOfAparentToAnotherParent() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			PhoneNumber ph1 = ses.get(PhoneNumber.class, 89);
			UserInfo user = ses.get(UserInfo.class, 2);
			Set<PhoneNumber> set = user.getPhoneDetails();
			set.add(ph1);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println("one childs of A parents is transfer to another child");
			} else {
				tx.rollback();
				System.out.println("Problem towards Transfer the object ");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		} //finally

	}

}
