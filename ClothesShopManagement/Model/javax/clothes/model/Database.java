package javax.clothes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author E6440
 *
 */

public class Database {
	/**
	 * connect to sql with config files.
	 **/
	public static Connection getSQLServerConnection() throws SQLException, ClassNotFoundException {
		String hostName = "E6440-PC";
		String sqlInstanceName = "SQLEXP";
		String database = "Store";
		String userName = "";
		String password = "";

		return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
	}

	/**
	 * connect to sql with custom input.
	 **/
	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database,
			String userName, String password) throws ClassNotFoundException, SQLException {

		String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";instance="
				+ sqlInstanceName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
