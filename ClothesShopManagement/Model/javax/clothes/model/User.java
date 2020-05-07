package javax.clothes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String email;
	private String phone;
	private String userName;
	private String password;
	private boolean active;
	private boolean deleted;
	private int roleID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void mappingUser(int id, String firstName, String lastName, String address, String email, String city,
			String phone, String userName, String password, int roleID, boolean isDelete, boolean isActive) {
		this.setId(id);
		this.setActive(isActive);
		this.setAddress(address);
		this.setCity(city);
		this.setDeleted(isDelete);
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
		this.setPhone(phone);
		this.setRoleID(roleID);
		this.setUserName(userName);
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = Database.getSQLServerConnection(); Statement stmt = conn.createStatement();) {
			String query = "SELECT * FROM USERS";
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				User temp = new User();
				temp.setId(result.getInt("USER_ID"));
				temp.setActive(result.getBoolean("ACTIVE"));
				temp.setAddress(result.getString("ADDRESS"));
				temp.setCity(result.getString("CITY"));
				temp.setDeleted(result.getBoolean("DELETED"));
				temp.setEmail(result.getString("EMAIL"));
				temp.setFirstName(result.getString("FIRSTNAME"));
				temp.setLastName(result.getString("LASTNAME"));
				temp.setPassword(result.getString("PASSWORD"));
				temp.setPhone(result.getString("PHONE"));
				temp.setRoleID(result.getInt("ROLE_ID"));
				temp.setUserName(result.getString("USERNAME"));
				users.add(temp);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return users;
	}

	public User getUser(String Email,int id) {
		User user = new User();
		try (Connection conn = Database.getSQLServerConnection(); Statement stmt = conn.createStatement();) {
			String query = "SELECT * FROM USERS WHERE EMAIL=" + Email + "OR USER_ID=" + id;
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				user.mappingUser(result.getInt("USER_ID"), result.getString("FIRSTNAME"), result.getString("LASTNAME"),
						result.getString("ADDRESS"), result.getString("EMAIL"), result.getString("CITY"),
						result.getString("PHONE"), result.getString("USERNAME"), result.getString("PASSWORD"),
						result.getInt("ROLE_ID"), result.getBoolean("DELETED"), result.getBoolean("ACTIVE"));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return user;
	}


	public void updateUser(User user) {
		User inputUser = this.getUser(user.email,user.id);
		if (inputUser != null) {
			String fields = "";
			fields = "firstname=" + user.getFirstName() + "lastname=" + user.getLastName()  +
					 "address=" + user.getAddress() + "city=" + user.getCity() +
					 "email=" + user.getPhone() + "phone=" + user.getPhone() +
					 "username=" + user.getUserName() + "password=" + user.getPassword() +
					 "role_id=" + user.getRoleID() + "deleted=" + user.isDeleted();
			
			try (Connection conn = Database.getSQLServerConnection(); Statement stmt = conn.createStatement();) {
				String query = "UPDATE USERS SET " + fields + "WHERE EMAIL=" + email ;
				stmt.executeQuery(query);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
}
