package delivery.mvc.dto;

public class OrderLineDTO {
	private int order_line_code;
	private int order_code;
	private int menu_code;
	private int order_quntity;
	
	public OrderLineDTO() { }

	public OrderLineDTO(int order_line_code, int order_code, int menu_code, int order_quntity) {
		super();
		this.order_line_code = order_line_code;
		this.order_code = order_code;
		this.menu_code = menu_code;
		this.order_quntity = order_quntity;
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
		return order_quntity;
	}

	public void setOrder_quntity(int order_quntity) {
		this.order_quntity = order_quntity;
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
		builder.append(order_quntity);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
