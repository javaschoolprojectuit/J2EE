package javax.clothes.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.clothes.dto.UserDTO;
import javax.clothes.mapper.UserMapper;

public class UserBO {

	public ArrayList<UserDTO> getUserByFilters(UserDTO user) {
		ArrayList<UserDTO> users = null;
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			users = mapper.getUsersByFilters(user);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return users;
	}

	public UserDTO getUserById(int id) {
		UserDTO user = null;
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			user = mapper.getUserById(id);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return user;
	}
	
	public void addUser(UserDTO userdto) {
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			mapper.addUser(userdto);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public void updateUser(UserDTO userdto) {
		UserMapper mapper = null;
		try {
			mapper = new UserMapper();
			mapper.updateUser(userdto);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}