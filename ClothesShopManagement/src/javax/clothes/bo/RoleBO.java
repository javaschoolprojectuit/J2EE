package javax.clothes.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.clothes.dto.RoleDTO;
import javax.clothes.mapper.RoleMapper;

public class RoleBO {
	public ArrayList<RoleDTO> getRolesrByFilters(String type) {
		ArrayList<RoleDTO> roles = null;
		RoleMapper mapper = null;
		try {
			mapper = new RoleMapper();
			roles = mapper.getRolesByFilter(type);
		} catch (Exception ex) {
			Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return roles;
	}

	public RoleDTO getRoleById(int id) {
		RoleDTO user = null;
		RoleMapper mapper = null;
		try {
			mapper = new RoleMapper();
			user = mapper.getRole(id);
		} catch (Exception ex) {
			Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return user;
	}
	
	public void addRole(RoleDTO userdto) {
		RoleMapper mapper = null;
		try {
			mapper = new RoleMapper();
			mapper.addRole(userdto);
		} catch (Exception ex) {
			Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public void updateRole(RoleDTO userdto) {
		RoleMapper mapper = null;
		try {
			mapper = new RoleMapper();
			mapper.updateRole(userdto);
		} catch (Exception ex) {
			Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(RoleBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
