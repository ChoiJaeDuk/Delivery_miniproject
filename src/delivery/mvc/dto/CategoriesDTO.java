package delivery.mvc.dto;

public class CategoriesDTO {
	private int category_code;
	private String category;
	private int category_mgr;
	
	public CategoriesDTO( ) { }

	public CategoriesDTO(int category_code, String category, int category_mgr) {
		super();
		this.category_code = category_code;
		this.category = category;
		this.category_mgr = category_mgr;
	}

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCategory_mgr() {
		return category_mgr;
	}

	public void setCategory_mgr(int category_mgr) {
		this.category_mgr = category_mgr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoriesDTO [category_code=");
		builder.append(category_code);
		builder.append(", category=");
		builder.append(category);
		builder.append(", category_mgr=");
		builder.append(category_mgr);
		builder.append("]");
		return builder.toString();
	}
	
	
}
