
package javax.clothes.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnectionService {

	public static Connection getSQLServerConnection() throws SQLException, ClassNotFoundException {
		Properties prop = new Properties();	
		try {
				prop.load(readConfigFile("config.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			String dbURL = "jdbc:sqlserver://" + 
							prop.getProperty("serverName") + 
							";databaseName=" + 
							prop.getProperty("databaseName");
			String userName = prop.getProperty("userName");
			String pass = prop.getProperty("password");
			Connection conn = DriverManager.getConnection(dbURL, userName, pass);
			return conn;
	}
	
	public static InputStream readConfigFile(String path) {
		InputStream ip= DBConnectionService.class.getClassLoader().getResourceAsStream(path);;
		return ip;
	}
    
}
