package javax.clothes.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.clothes.dto.CategoryDTO;

public class CategoryMapper extends DBMapper {
	
	public CategoryMapper () throws Exception {
		super();
	}
	
	public CategoryDTO resultSetMapping(ResultSet result) {
		CategoryDTO temp = new CategoryDTO();
		try {
			temp.setId(result.getInt("CAT_ID"));
			temp.setName(result.getString("NAME"));
			temp.setImage(result.getString("IMAGE"));
			temp.setActive(result.getBoolean("ACTIVE"));
			temp.setDescription(result.getString("DESCRIPTION"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}
	
	public ArrayList<CategoryDTO> getAllCategories() {
		ArrayList<CategoryDTO> cats = new ArrayList<CategoryDTO>();
		try {
			Statement stmt = getConnection().createStatement();
			String query = "SELECT * FROM CATEGORIES";
			ResultSet result = stmt.executeQuery(query);
			CategoryDTO temp = new CategoryDTO();
			while (result != null && result.next()) {			
				temp = resultSetMapping(result);
				cats.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cats;
	}
	
	public CategoryDTO getCategoryByID (int id) {
		CategoryDTO cat = new CategoryDTO();
		try {
			Statement stmt = getConnection().createStatement();
			String query = "SELECT * FROM CATEGORIES WHERE CAT_ID=" + id;
			ResultSet result = stmt.executeQuery(query);
			
			while (result != null && result.next()) {			
				cat = resultSetMapping(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cat;
	}
	
	public boolean addCategory (CategoryDTO category) {
		int convertBit = 0;
		if (category.isActive()) convertBit = 1;
		try {
			Statement stmt = getConnection().createStatement();
			String values = "('"+category.getName() + "','" + 
							category.getImage() + "'," + 
							convertBit + ",'" + 
							category.getDescription() +"')";
			String query = "INSERT INTO CATEGORIES (NAME,IMAGE,ACTIVE,DESCRIPTION) VALUES" + values;
			stmt.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean updateCategory (CategoryDTO category) {
		int convertBit = 0;
		if (category.isActive()) convertBit = 1;
		try {
			Statement stmt = getConnection().createStatement();
			String values = "NAME='" + category.getName() + 
							"',IMAGE='" + category.getImage() + 
							"',ACTIVE=" + convertBit + 
							",DESCRIPTION='" + category.getDescription() + "'," +") ";
			String query = "UPDATE INTO SET" + values + "WHERE CAT_ID=" + category.getId();
			stmt.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean deleteCatgory (int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String query = "DELETE FROM CATEGORIES WHERE CAT_ID=" + id;
			stmt.executeUpdate(query);
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
