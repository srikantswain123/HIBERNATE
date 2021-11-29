package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.util.HibernateUtil;

public class RefreshTest3 {
	public static void main(String[] args) {
		BankAccount account = null;
		Session ses = null;
		boolean flag = false;


		ses = HibernateUtil.getSession();

		Transaction tx = null;

		account = ses.get(BankAccount.class, 101);
		System.out.println(account);

		try {

			tx = ses.beginTransaction(); // account.setAcno(101);
			if (account != null) {
				account.setBalance(595959);
				System.out.println("Objecct updated");
				flag = true;
			} else {
				flag = false;
				System.out.println("Object not updated");
			}
			try {
				Thread.sleep(40000);
				ses.refresh(account);
				System.out.println(account);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}

		} catch (HibernateException he) {

			he.printStackTrace();
			flag = false;
		} finally {
			if (flag == true) {
				tx.commit();
				System.out.println("Objecct found and updated");

			} else if (flag == false) {
				tx.rollback();
				System.out.println("Object not found and not updated");

			}

			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}

	}

}
