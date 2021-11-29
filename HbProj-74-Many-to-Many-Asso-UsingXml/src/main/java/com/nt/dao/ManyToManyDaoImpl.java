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
			d1.setPatient(Set.of(p1, p2));
			d2.setPatient(Set.of(p1, p2, p3, p4));
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
			d1.setPatient(Set.of(p1, p2));
			d2.setPatient(Set.of(p1, p2, p3, p4));
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

	@Override
	public void selectDataUsingParent() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		try {
			Query<Doctor> query = ses.createQuery("FROM Doctor");
			List<Doctor> list = query.getResultList();
			list.forEach(doctor -> {
				System.out.println("parent " + doctor);
				Set<Patient> set = doctor.getPatient();
				set.forEach(patient -> {
					System.out.println("child " + patient);
				});
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			// close session factory
			HibernateUtility.closeSessionFactory();

		} // finally

	}// method

	@Override
	public void selectDataUsingChild() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		try {
			Query<Patient> query = ses.createQuery("FROM Patient");
			List<Patient> list = query.getResultList();
			list.forEach(patient -> {
				System.out.println("child " + patient);
				Set<Doctor> set = patient.getDoctor();
				set.forEach(doctor -> {
					System.out.println("Parent " + doctor);
				});
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			// close session factory
			HibernateUtility.closeSessionFactory();

		} // finally

	}// method

	@Override
	public void deleteAllcchildsOfAParent() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			
			  Doctor d1 = ses.get(Doctor.class, 131);
			  Set<Patient> patient =d1.getPatient();
			  patient.removeAll(patient);
			  
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		}catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			// perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Object deleted");
			} else {
				tx.rollback();
				System.out.println("Object Not deleted");
			}
			// close session factory
			HibernateUtility.closeSessionFactory();

		} // finally
	}//method
 @Override
public void deleteAchildOfAParent() {
	 Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			
			  Doctor d1 = ses.get(Doctor.class, 134);
			  Set<Patient> patient =d1.getPatient();
			  Patient p1=ses.get(Patient.class,1545);
			  patient.remove(p1);
			  
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		}catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			// perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Object deleted");
			} else {
				tx.rollback();
				System.out.println("Object Not deleted");
			}
			// close session factory
			HibernateUtility.closeSessionFactory();

		} // finally
	
}

}// class
