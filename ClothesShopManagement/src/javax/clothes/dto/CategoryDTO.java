package javax.clothes.dto;

public class CategoryDTO {

	private int id;
	private String name;
	private String image;
	private String description;
	private boolean active;
	
	public CategoryDTO() {
		this.name = "";
		this.image = "";
		this.description = "";
		this.active = false;
	}

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
}
