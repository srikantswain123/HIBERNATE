package com.nt.connProvider;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

public class CustomConnectionProvider extends UserSuppliedConnectionProviderImpl {
	private BasicDataSource ds;

	public CustomConnectionProvider() {
		ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("system");
		ds.setPassword("Srikant1234");
		
	}
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	@Override
	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
		
	}
	


}
