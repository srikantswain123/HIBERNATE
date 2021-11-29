package com.nt.customGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class NitGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	  Connection con=session.connection();
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  int id=0;
	  try {
	  ps=con.prepareStatement("select nit_seq.nextval from dual");
	 rs=ps.executeQuery();
	 if(rs.next()) {
		 id=rs.getInt(1);
	 }
	  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
		String name="NIT"+000+id;
		
		return name;
	}

}
