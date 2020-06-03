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
			while (result != null && result.next()) {
				CategoryDTO temp = new CategoryDTO();
				temp = resultSetMapping(result);
				cats.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cats;
	}
}
