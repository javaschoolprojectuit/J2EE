package javax.clothes.mapper;

import java.sql.Connection;

public class DBMapper {
	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates and open the template
	 * in the editor.
	 */
	private Connection connection;

	public DBMapper() throws Exception {
		try {
			connection = DBConnectionService.getSQLServerConnection();
		} catch (Exception e) {
			System.out.println("Failed in constructor method in MapperDB:" + e);
			e.printStackTrace();
			throw e;
		}
	}

	public DBMapper(Connection con) {
		connection = con;
	}

	public void closeConnection() throws Exception {
		try {
			getConnection().close();
		} catch (Exception e) {
			System.out.println("Failed in closeConnection method in MapperDB:" + e);
			throw e;
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
