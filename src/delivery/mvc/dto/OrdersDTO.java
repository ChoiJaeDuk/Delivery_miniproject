package delivery.mvc.dto;

public class OrdersDTO {
	private int order_code;
	private String user_id;
	private String order_date;
	private int order_total_price;
	private String order_approval_time;
	private String order_delivery_time;
	private int delivery_code;
	
	public OrdersDTO() { }
	public OrdersDTO(int order_code, String user_id, String order_date, int order_total_price,
			String order_approval_time, String order_delivery_time, int delivery_code) {
		super();
		this.order_code = order_code;
		this.user_id = user_id;
		this.order_date = order_date;
		this.order_total_price = order_total_price;
		this.order_approval_time = order_approval_time;
		this.order_delivery_time = order_delivery_time;
		this.delivery_code = delivery_code;
	}
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getOrder_total_price() {
		return order_total_price;
	}
	public void setOrder_total_price(int order_total_price) {
		this.order_total_price = order_total_price;
	}
	public String getOrder_approval_time() {
		return order_approval_time;
	}
	public void setOrder_approval_time(String order_approval_time) {
		this.order_approval_time = order_approval_time;
	}
	public String getOrder_delivery_time() {
		return order_delivery_time;
	}
	public void setOrder_delivery_time(String order_delivery_time) {
		this.order_delivery_time = order_delivery_time;
	}
	public int getDelivery_code() {
		return delivery_code;
	}
	public void setDelivery_code(int delivery_code) {
		this.delivery_code = delivery_code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdersDTO [order_code=");
		builder.append(order_code);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", order_date=");
		builder.append(order_date);
		builder.append(", order_total_price=");
		builder.append(order_total_price);
		builder.append(", order_approval_time=");
		builder.append(order_approval_time);
		builder.append(", order_delivery_time=");
		builder.append(order_delivery_time);
		builder.append(", delivery_code=");
		builder.append(delivery_code);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
