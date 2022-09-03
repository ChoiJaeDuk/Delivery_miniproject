package delivery.mvc.dto;

public class BascketDTO {
	private int basket_code;
	private String user_id;
	private int menu_code;
	private int basket_quantity;
	private String basket_date;
	
	public BascketDTO() { }
	
	public BascketDTO(int basket_code, String user_id, int menu_code, int basket_quantity, String basket_date) {
		super();
		this.basket_code = basket_code;
		this.user_id = user_id;
		this.menu_code = menu_code;
		this.basket_quantity = basket_quantity;
		this.basket_date = basket_date;
	}

	public int getBasket_code() {
		return basket_code;
	}

	public void setBasket_code(int basket_code) {
		this.basket_code = basket_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}

	public int getBasket_quantity() {
		return basket_quantity;
	}

	public void setBasket_quantity(int basket_quantity) {
		this.basket_quantity = basket_quantity;
	}

	public String getBasket_date() {
		return basket_date;
	}

	public void setBasket_date(String basket_date) {
		this.basket_date = basket_date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BascketDTO [basket_code=");
		builder.append(basket_code);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", menu_code=");
		builder.append(menu_code);
		builder.append(", basket_quantity=");
		builder.append(basket_quantity);
		builder.append(", basket_date=");
		builder.append(basket_date);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
