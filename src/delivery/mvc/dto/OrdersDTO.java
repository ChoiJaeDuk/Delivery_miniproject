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
	
	
}
