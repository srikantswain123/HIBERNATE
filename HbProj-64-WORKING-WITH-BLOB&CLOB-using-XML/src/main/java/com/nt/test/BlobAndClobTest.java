package com.nt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobSeeker;
import com.nt.utility.HibernateUtility;

public class BlobAndClobTest {

	public static void main(String[] args) throws Exception{
		//get session object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		JobSeeker job=new JobSeeker();
		//covert photo to byte[]
		FileInputStream fis=new FileInputStream("baby.jpg");
		byte[] photo=new byte[fis.available()];
		fis.read(photo);
		//convert resume to char[]
		File f=new File("resume.txt");
	     FileReader fr=new FileReader(f);
	     char[] resume=new char[(int)f.length()];
	     fr.read(resume);
	     //set value to job seeker
	     job.setEname("sreya");
	     job.setEaddr("Gandhidham");
	     job.setPhoto(photo);
	     job.setResume(resume);
		try {
			//check and gate transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//save object
			ses.save(job);
			flag=true;
			
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}//catch
		finally {
			//perform transaction
			if(flag) {
				tx.commit();
				System.out.println("Object saved");
			}else {
				tx.rollback();
				System.out.println("Object Not saved");
			}
			HibernateUtility.closeSessionFactory();
		}//finally

	}//main

}//class
