package delivery.mvc.dto;
/**
 * 장바구니 객체화
 */
public class BasketDTO {
	//필드
	private int basket_code;
	private String user_id;
	private int menu_code;
	private int basket_quantity;
	private String basket_date;

	private int store_code;
	private String store_name;
	private String menu_name;
	private int sum_price;
	
	public BasketDTO() {}
	
	public BasketDTO(int basket_quantity) {
		this.basket_quantity = basket_quantity;
	}
	
	
	
	public BasketDTO(int store_code, String user_id ) {
		
		this.user_id = user_id;
		this.store_code = store_code;
	}

	public BasketDTO(String user_id, int menu_code) {
		this.user_id = user_id;
		this.menu_code = menu_code;
	}
	public BasketDTO(String user_id, int menu_code, int basket_quantity) {
		this(user_id, menu_code);
		this.basket_quantity = basket_quantity;
	}
	public BasketDTO(int basket_code, String user_id, int menu_code, int basket_quantity, String basket_date) {
		this(user_id, menu_code, basket_quantity);
		this.basket_code = basket_code;
		this.basket_date = basket_date;
	}
	
	public BasketDTO(String user_id, int menu_code, int basket_quantity, String store_name, String menu_name, int sum_price, int store_code) {
		this.user_id = user_id;
		this.menu_code = menu_code;
		this.basket_quantity = basket_quantity;
		this.store_name = store_name;
		this.menu_name = menu_name;
		this.sum_price = sum_price;
		this.store_code=store_code;
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
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	
	public int getSum_price() {
		return sum_price;
	}
	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}
	public int getStore_code() {
		return store_code;
	}
	public void setStore_code(int store_code) {
		this.store_code = store_code;
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
		builder.append(", store_name=");
		builder.append(store_name);
		builder.append(", menu_name=");
		builder.append(menu_name);
		builder.append(", sum_price=");
		builder.append(sum_price);
		builder.append("]");
		return builder.toString();
	}
}
