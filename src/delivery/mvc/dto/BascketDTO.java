package delivery.mvc.dto;

public class BascketDTO {

	private int bascket_code;
	private String user_id;
	private int menu_code;
	private int bascket_quantity;
	private String bascket_date;
	
	public BascketDTO() {}
	
	public BascketDTO(int bascket_code, String user_id, int menu_code, int bascket_quantity, String bascket_date) {
		super();
		this.bascket_code = bascket_code;
		this.user_id = user_id;
		this.menu_code = menu_code;
		this.bascket_quantity = bascket_quantity;
		this.bascket_date = bascket_date;
	}
	
	public int getBascket_code() {
		return bascket_code;
	}
	public void setBascket_code(int bascket_code) {
		this.bascket_code = bascket_code;
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
	public int getBascket_quantity() {
		return bascket_quantity;
	}
	public void setBascket_quantity(int bascket_quantity) {
		this.bascket_quantity = bascket_quantity;
	}
	public String getBascket_date() {
		return bascket_date;
	}
	public void setBascket_date(String bascket_date) {
		this.bascket_date = bascket_date;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BascketDTO [bascket_code=");
		builder.append(bascket_code);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", menu_code=");
		builder.append(menu_code);
		builder.append(", bascket_quantity=");
		builder.append(bascket_quantity);
		builder.append(", bascket_date=");
		builder.append(bascket_date);
		builder.append("]");
		return builder.toString();
	}
	
}
