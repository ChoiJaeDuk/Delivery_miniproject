package delivery.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class OrdersDTO {
	private int order_code;
	private String user_id;
	private String order_date;
	private int store_code;
	private int order_total_price;
	private String order_approval_time;
	private String order_delivery_time;
	private int delivery_code;
	
	
	private UsersDTO users;
	private Delivery_StatusDTO delivery_status;
	private List<OrderLineDTO> orderLineList = new ArrayList<OrderLineDTO>();
	
	private String month;
	private int menu_sales;
	
	private int total_sales;
	private int total_sales_for_stores;
	private int total_sales_for_master;
	

	  
	
	public OrdersDTO() { }
	
	public OrdersDTO(String month, int total_sales, int total_sales_for_master, int total_sales_for_stores) {
		this.month = month;
		this.total_sales = total_sales;
		this.total_sales_for_master =total_sales_for_master;
		this.total_sales_for_stores = total_sales_for_stores;
	}
	
	public OrdersDTO(int order_code, int delivery_code) {
		super();
		this.order_code = order_code;
		this.delivery_code = delivery_code;
	}



	public OrdersDTO(String month, int menu_sales) {
		this.month = month;
		this.menu_sales = menu_sales;
	}
	
	public OrdersDTO(String user_id) {
		super();
		this.user_id = user_id;
	}

/////////////////////////////////////////////////////
	//UsersDAOImpl.selectOrderList()를 위한 생성 (이종민)
	public OrdersDTO(int order_code, String order_date, int order_total_price, Delivery_StatusDTO delivery_status,
			String order_delivery_time) {
		this.order_code = order_code;
		this.order_date = order_date;
		this.order_total_price = order_total_price;
		this.order_delivery_time = order_delivery_time;
		this.delivery_status = delivery_status;
	}
/////////////////////////////////////////////////////

	public OrdersDTO(int order_code, String user_id, UsersDTO users, Delivery_StatusDTO delivery_status) {
		super();
		this.order_code = order_code;
		this.user_id = user_id;
		this.users = users;
		this.delivery_status = delivery_status;
	}



	public OrdersDTO(int order_code, String user_id, int store_code, String order_date ,int order_total_price,
			String order_approval_time, String order_delivery_time, int delivery_code) {
		super();
		this.order_code = order_code;
		this.user_id = user_id;
		this.order_date = order_date;
		this.store_code = store_code;
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
	
	public int getStore_code() {
		return store_code;
	}
	public void setStore_code(int store_code) {
		this.store_code = store_code;
	}
	
	
	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public int getMenu_sales() {
		return menu_sales;
	}


	public void setMenu_sales(int menu_sales) {
		this.menu_sales = menu_sales;
	}

	public int getTotal_sales() {
		return total_sales;
	}

	public void setTotal_sales(int total_sales) {
		this.total_sales = total_sales;
	}

	public int getTotal_sales_for_stores() {
		return total_sales_for_stores;
	}

	public void setTotal_sales_for_stores(int total_sales_for_stores) {
		this.total_sales_for_stores = total_sales_for_stores;
	}

	public int getTotal_sales_for_master() {
		return total_sales_for_master;
	}

	public void setTotal_sales_for_master(int total_sales_for_master) {
		this.total_sales_for_master = total_sales_for_master;
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
		builder.append(", store_code=");
		builder.append(store_code);
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
	public UsersDTO getUsers() {
		return users;
	}
	public void setUsers(UsersDTO users) {
		this.users = users;
	}
	public Delivery_StatusDTO getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(Delivery_StatusDTO delivery_status) {
		this.delivery_status = delivery_status;
	}



	public List<OrderLineDTO> getOrderLineList() {
		return orderLineList;
	}



	public void setOrderLineList(List<OrderLineDTO> orderLineList) {
		this.orderLineList = orderLineList;
	}
	
	
	
}
