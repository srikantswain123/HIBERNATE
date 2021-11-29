package com.nt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.JobSeeker;
import com.nt.utility.HibernateUtility;

public class BlobAndClobRetriveTest {

	public static void main(String[] args) throws Exception{
		//get session object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			//check and gate transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			JobSeeker js=ses.get(JobSeeker.class, 52);
			//convert byte and char convert to as file
			FileOutputStream fos=new FileOutputStream("store/baby.jpeg");
			fos.write(js.getPhoto());
			FileWriter fr=new FileWriter("store/resume.txt");
			fr.write(js.getResume());
			fos.flush();
			fr.flush();
			System.out.println(js.getEid()+" "+js.getEname()+" "+js.getEaddr());
		}catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		finally {
			//perform transaction
			HibernateUtility.closeSessionFactory();
		}//finally

	}//main

}//class
