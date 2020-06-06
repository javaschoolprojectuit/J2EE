package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.clothes.dto.RoleDTO;

public class RoleMapper extends DBMapper {

	public RoleMapper() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleDTO getRole(int id) {
		RoleDTO role = new RoleDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "SELECT * FROM ROLES WHERE ROLE_ID = " + Integer.toString(id);
			ResultSet rs = stmt.executeQuery(sqlStr);
			
			while(rs!= null && rs.next()) {
				role.setId(rs.getInt("ROLE_ID"));
				role.setType(rs.getString("TYPE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return role;
	}
	
	public boolean addRole(RoleDTO role) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "INSERT INTO ROLES (TYPE) VALUES ('" + role.getType() +"')";
			stmt.executeUpdate(sqlStr);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateRole(RoleDTO role) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "UPDATE ROLES SET TYPE = '" + role.getType() + "'" + 
							" WHERE ROLE_ID=" + Integer.toString(role.getId());
			stmt.executeUpdate(sqlStr);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteRole(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlStr = "DELETE FROM ROLES WHERE ROLE_ID = " + Integer.toString(id);
			stmt.executeUpdate(sqlStr);
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
