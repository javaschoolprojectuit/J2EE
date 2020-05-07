/**
 * 
 */
package javax.clothes.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author E6440
 *
 */
public class Category {
	private int id;
	private String name;
	private String image;
	private String description;
	private boolean active;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Category> getAllCategories() {
		List<Category> cats = new ArrayList<Category>();
		try (Connection conn = Database.getSQLServerConnection(); Statement stmt = conn.createStatement();) {
			String query = "SELECT * FROM CATEGORIES";
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				Category temp = new Category();
				temp.setId(result.getInt("CAT_ID"));
				temp.setName(result.getString("NAME"));
				temp.setImage(result.getString("IMAGE"));
				temp.setActive(result.getBoolean("ACTIVE"));
				temp.setDescription(result.getString("DESCRIPTION"));
				cats.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		return cats;
	}

}
