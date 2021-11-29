package com.nt.customConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CustomConnection implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}
       
	Connection con=null;
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("CustomConnection.getConnection()");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Srikant1234");
		
		return con;
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
        con.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
