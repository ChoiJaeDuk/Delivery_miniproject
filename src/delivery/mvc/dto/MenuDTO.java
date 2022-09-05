package delivery.mvc.dto;

import delivery.mvc.dto.BasketDTO;

public class MenuDTO {
	//�ʵ�
	private int menu_code;
	private String menu_name;
	private int menu_price;
	private int soldout_status;
	private String menu_regist_date;
	private int category_code;
	private int store_code;

	private int total_price;
	private OrderLineDTO orderLine;
	private BasketDTO basket;
	private StoresDTO store;

	//������
	public MenuDTO() {}

	public MenuDTO(int store_code) {
		this.store_code = store_code;
	}

	public MenuDTO(int menu_code, StoresDTO store, String name, BasketDTO basket , int menu_price, int total_price) {
		this.menu_code = menu_code;
		this.store = store;
		this.menu_name = name;
		this.basket = basket;
		this.menu_price = menu_price;
		this.total_price = total_price;
	}

	//usersDAOImpl.selectDelivery_time() join���� ���� ������(������)
	public MenuDTO(String menu_name, int menu_price) {
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}

	//�ۼ��� : �����
	public MenuDTO(String name, OrderLineDTO orderLine , int menu_price, int total_price) {
		this.menu_name = name;
		this.orderLine = orderLine;
		this.menu_price = menu_price;
		this.total_price = total_price;

	}

	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �޴��� �����ϱ� ���� ������
	 */
	public MenuDTO(int menu_code, String menu_name, int menu_price, int soldout_status) {
		this(menu_name, menu_price);
		this.menu_code = menu_code;
		this.soldout_status = soldout_status;
	}

	public MenuDTO(String name, BasketDTO basket , int menu_price, int total_price) {
		this.menu_name = name;
		this.orderLine = orderLine;
		this.menu_price = menu_price;
		this.total_price = total_price;
	}
	public MenuDTO(int category_code, int store_code, String menu_name, int menu_price, int soldout_status) {
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.soldout_status = soldout_status;
		this.category_code = category_code;
		this.store_code = store_code;
	}
	public MenuDTO(int menu_code, String menu_name, int menu_price, int soldout_status, String menu_regist_date,
			int category_code, int store_code) {
		this(category_code, store_code, menu_name, menu_price, soldout_status);
		this.menu_code = menu_code;
		this.menu_regist_date = menu_regist_date;
	}



	public int getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(int menu_code) {
		this.menu_code = menu_code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}

	public int getSoldout_status() {
		return soldout_status;
	}

	public void setSoldout_status(int soldout_status) {
		this.soldout_status = soldout_status;
	}

	public String getMenu_regist_date() {
		return menu_regist_date;
	}

	public void setMenu_regist_date(String menu_regist_date) {
		this.menu_regist_date = menu_regist_date;
	}

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
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
		builder.append("MenuDTO [menu_code=");
		builder.append(menu_code);
		builder.append(", menu_name=");
		builder.append(menu_name);
		builder.append(", menu_price=");
		builder.append(menu_price);
		builder.append(", soldout_status=");
		builder.append(soldout_status);
		builder.append(", category_code=");
		builder.append(category_code);
		builder.append("]");
		return builder.toString();
	}

	public OrderLineDTO getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLineDTO orderLine) {
		this.orderLine = orderLine;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public StoresDTO getStore() {
		return store;
	}

	public void setStore(StoresDTO store) {
		this.store = store;
	}



	public BasketDTO getBasket() {
		return basket;
	}



	public void setBasket(BasketDTO basket) {
		this.basket = basket;
	}







}
