package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.clothes.dto.UserDTO;

public class UserMapper extends DBMapper {

	public UserMapper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO resultSetMapping(ResultSet rs) {
		UserDTO temp = new UserDTO();
		try {
			temp.setId(rs.getInt("USER_ID"));
			temp.setActive(rs.getBoolean("ACTIVE"));
			temp.setAddress(rs.getString("ADDRESS"));
			temp.setCity(rs.getString("CITY"));
			temp.setDeleted(rs.getBoolean("DELETED"));
			temp.setEmail(rs.getString("EMAIL"));
			temp.setFirstName(rs.getString("FIRSTNAME"));
			temp.setLastName(rs.getString("LASTNAME"));
			temp.setPassword(rs.getString("PASSWORD"));
			temp.setPhone(rs.getString("PHONE"));
			temp.setRoleID(rs.getInt("ROLE_ID"));
			temp.setUserName(rs.getString("USERNAME"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	public ArrayList<UserDTO> getUsersByFilters(UserDTO user) {
		ArrayList<UserDTO> users = new ArrayList<>();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM USERS WHERE " + "FIRSTNAME LIKE " + "'%" + user.getFirstName() + "%'"
					+ " AND " + "LASTNAME LIKE " + "'%" + user.getLastName() + "%'" + " AND " + "ADDRESS LIKE " + "'%"
					+ user.getAddress() + "%'" + " AND " + "CITY LIKE " + "'%" + user.getCity() + "%'" + " AND "
					+ "USERNAME LIKE " + "'%" + user.getUserName() + "%'" + " AND " + "PHONE LIKE " + "'%"
					+ user.getPhone() + "%'" + " AND " + "EMAIL LIKE " + "'%" + user.getEmail() + "%'";
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server

			while (rs != null && rs.next()) {
				UserDTO queryResult = new UserDTO();
				queryResult = resultSetMapping(rs);
				users.add(queryResult);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return users;
	}

	public UserDTO getUserById(int id) {
		UserDTO userdto = new UserDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM USERS WHERE USER_ID =" + Integer.toString(id);
			ResultSet rs = stmt.executeQuery(sqlStr); // Send the query to the server
			while (rs != null && rs.next()) {
				userdto = resultSetMapping(rs);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return userdto;
	}

	public boolean addUser(UserDTO user) {
		try {
			Statement stmt = getConnection().createStatement();
			String fields = "";
			fields = "('" + user.getFirstName() + "','" + user.getLastName()  +
					 "','" + user.getAddress() + "','" + user.getCity() +
					 "','" + user.getPhone() + "','" + user.getPhone() +
					 "','" + user.getUserName()  +
					 "'," + Integer.toString(user.getRoleID()) + 
					 "," + String.valueOf(user.isDeleted()) + ')';
			String sqlStr = "INSERT INTO USERS (FIRSTNAME,LASTNAME,ADDRESS,CITY,PHONE,USERNAME,PASSWORD,ROLE_ID,DELETED) VALUES " + fields ;
			stmt.executeUpdate(sqlStr); // Send the query to the server
			return true;

		} catch (Exception ex) {
			return false;
		}
	}

	public boolean updateUser(UserDTO user) {
		try {
			Statement stmt = getConnection().createStatement();
			String fields = "";
			fields = "firstname='" + user.getFirstName() + "', lastname='" + user.getLastName()  +
					 "', address='" + user.getAddress() + "', city='" + user.getCity() +
					 "', email='" + user.getPhone() + "', phone='" + user.getPhone() +
					 "', username='" + user.getUserName() + "', password='" + user.getPassword() +
					 "', role_id=" + user.getRoleID() + ", deleted=" + user.isDeleted();
			String sqlStr = "UPDATE USERS SET " + fields + "WHERE USER_ID = " + Integer.toString(user.getId());
			stmt.executeUpdate(sqlStr); // Send the query to the server
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean deleteUser(int userid) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "DELETE FROM users WHERE userid = " + userid;
			stmt.executeUpdate(sqlStr); // Send the query to the server
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
