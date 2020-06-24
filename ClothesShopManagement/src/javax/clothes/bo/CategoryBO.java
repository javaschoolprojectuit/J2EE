package javax.clothes.bo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.clothes.dto.CategoryDTO;
import javax.clothes.mapper.CategoryMapper;

public class CategoryBO {
	public ArrayList<CategoryDTO> getAllCategories() {
		ArrayList<CategoryDTO> cats = null;
		CategoryMapper mapper = null;
		try {
			mapper = new CategoryMapper();
			cats = mapper.getAllCategories();
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return cats;
	}
	
	public CategoryDTO getCategoryByID(int id) {
		CategoryDTO cat = new CategoryDTO();
		CategoryMapper mapper = null;
		try {
			mapper = new CategoryMapper();
			cat = mapper.getCategoryByID(id);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return cat;
	}
	
	public boolean addCategory(CategoryDTO input) {
		CategoryMapper mapper = null;
		try {
			mapper = new CategoryMapper();
			mapper.addCategory(input);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return true;
	}
	
	public boolean updateCategory(CategoryDTO input) {
		CategoryMapper mapper = null;
		try {
			mapper = new CategoryMapper();
			mapper.updateCategory(input);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return true;
	}
	
	public boolean deleteCategory(int id) {
		CategoryMapper mapper = null;
		try {
			mapper = new CategoryMapper();
			mapper.deleteCatgory(id);
		} catch (Exception ex) {
			Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		} finally {
			try {
				mapper.closeConnection();
			} catch (Exception ex) {
				Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return false;
	}
}
