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
}
