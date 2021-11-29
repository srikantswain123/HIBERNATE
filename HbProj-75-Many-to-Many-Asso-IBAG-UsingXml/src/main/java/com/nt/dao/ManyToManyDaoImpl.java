package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtility;

public class ManyToManyDaoImpl implements IManyToMayDao {

	@Override
	public void saveObjectUsingParent() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = true;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		try {
			// create doctor object
			Doctor d1 = new Doctor("raja", "Appolo", "MD");
			Doctor d2 = new Doctor("rajesh", "KIMS", "MD");
			// create Patient Object
			Patient p1 = new Patient("AA", "HEART");
			Patient p2 = new Patient("BB", "KIDNEY");
			Patient p3 = new Patient("CC", "LIVER");
			Patient p4 = new Patient("DD", "CANCER");
			// set Patient Set<> Data
			d1.setPatient(List.of(p1, p2));
			d2.setPatient(List.of(p1, p2, p3, p4));
			// set DOCTOR Set<> data
			p1.setDoctor(Set.of(d1, d2));
			p2.setDoctor(Set.of(d1, d2));
			p3.setDoctor(Set.of(d2));
			p4.setDoctor(Set.of(d2));

			// save data using parent Object
			ses.save(d1);
			ses.save(d2);
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} finally {
			// perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Object saved");
			} else {
				tx.rollback();
				System.out.println("Object Not saved");
			}

		} // finally

	}// method

	@Override
	public void saveObjectUsingChild() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = true;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		try {
			// create doctor object
			Doctor d1 = new Doctor("mukesh", "AIMS", "MD");
			Doctor d2 = new Doctor("Hritik", "General", "MD");
			// create Patient Object
			Patient p1 = new Patient("EE", "HEART");
			Patient p2 = new Patient("FF", "KIDNEY");
			Patient p3 = new Patient("GG", "LIVER");
			Patient p4 = new Patient("HH", "CANCER");
			// set Patient Set<> Data
			d1.setPatient(List.of(p1, p2));
			d2.setPatient(List.of(p1, p2, p3, p4));
			// set DOCTOR Set<> data
			p1.setDoctor(Set.of(d1, d2));
			p2.setDoctor(Set.of(d1, d2));
			p3.setDoctor(Set.of(d2));
			p4.setDoctor(Set.of(d2));

			// save data using parent Object
			ses.save(p1);
			ses.save(p2);
			ses.save(p3);
			ses.save(p4);
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} finally {
			// perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Object saved");
			} else {
				tx.rollback();
				System.out.println("Object Not saved");
			}

		} // finally

	}// method


}// class
