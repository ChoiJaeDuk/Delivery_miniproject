package delivery.mvc.dto;

public class OrderLineDTO {
	private int order_line_code;
	private int order_code;
	private int menu_code;
	private int order_quantity;
	
	public OrderLineDTO() { }

////////////////////////////////////////////////////////////////////////////////////
	/*
	 * usersDAOImpl.selectDelivery_time() join문을 위한 생성자
	 */
	private MenuDTO menu;
	private StoresDTO store;

	public OrderLineDTO(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	
	public OrderLineDTO(int order_line_code, int order_quntity, MenuDTO menu, StoresDTO store) {
		this.order_line_code = order_line_code;
		this.order_quantity = order_quntity;
		this.menu = menu;
		this.store = store;
	}

	public MenuDTO getMenu() {
		return menu;
	}

	public void setMenu(MenuDTO menu) {
		this.menu = menu;
	}

	public StoresDTO getStore() {
		return store;
	}

	public void setStore(StoresDTO store) {
		this.store = store;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////	


	public OrderLineDTO(int order_line_code, int order_code, int menu_code, int order_quantity) {
		super();
		this.order_line_code = order_line_code;
		this.order_code = order_code;
		this.menu_code = menu_code;
		this.order_quantity = order_quantity;
	}

	public int getOrder_line_code() {
		return order_line_code;
	}

	public void setOrder_line_code(int order_line_code) {
		this.order_line_code = order_line_code;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public int getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}

	public int getOrder_quntity() {
		return order_quantity;
	}

	public void setOrder_quntity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderLineDTO [order_line_code=");
		builder.append(order_line_code);
		builder.append(", order_code=");
		builder.append(order_code);
		builder.append(", menu_code=");
		builder.append(menu_code);
		builder.append(", order_quntity=");
		builder.append(order_quantity);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
