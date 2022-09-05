package delivery.mvc.dto;

public class StoresDTO {
	
	private int store_code;
	private String user_id;
	private String store_name;
	private String store_addr;
	private String store_phone;
	private String store_business_no;
	private int category_code;
	private String store_detail;
	private int store_delivery_fee;
	private int store_status;
	private String store_regis_date;
	private String store_regis_status;
	private String store_approval_date;
	
	private String menu_name;
	
	public StoresDTO() { }
	
	//usersDAOImpl.selectDelivery_time() join문을 위한 생성자(이종민)
		public StoresDTO(String store_name) {
			this.store_name = store_name;
		}
	

	public StoresDTO(int store_code, String user_id, String store_name, String store_addr, String store_phone,
			String store_business_no, int category_code, String store_detail, int store_delivery_fee, int store_status,
			String store_regis_date, String store_regis_status, String store_approval_date) {
		
		this(user_id, store_name,store_addr,store_phone, store_business_no, category_code, store_detail, store_delivery_fee);
		
		this.store_code = store_code;
		this.store_status = store_status;
		this.store_regis_date = store_regis_date;
		this.store_regis_status = store_regis_status;
		this.store_approval_date = store_approval_date;
	}
	

	public StoresDTO(String user_id, String store_name, String store_addr, String store_phone, String store_business_no,
			int category_code, String store_detail, int store_delivery_fee) {
		super();
		this.user_id = user_id;
		this.store_name = store_name;
		this.store_addr = store_addr;
		this.store_phone = store_phone;
		this.store_business_no = store_business_no;
		this.category_code = category_code;
		this.store_detail = store_detail;
		this.store_delivery_fee = store_delivery_fee;
	}
	

	public int getStore_code() {
		return store_code;
	}

	public void setStore_code(int store_code) {
		this.store_code = store_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_addr() {
		return store_addr;
	}

	public void setStore_addr(String store_addr) {
		this.store_addr = store_addr;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}

	public String getStore_business_no() {
		return store_business_no;
	}

	public void setStore_business_no(String store_business_no) {
		this.store_business_no = store_business_no;
	}

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public String getStore_detail() {
		return store_detail;
	}

	public void setStore_detail(String store_detail) {
		this.store_detail = store_detail;
	}

	public int getStore_delivery_fee() {
		return store_delivery_fee;
	}

	public void setStore_delivery_fee(int store_delivery_fee) {
		this.store_delivery_fee = store_delivery_fee;
	}

	public int getStore_status() {
		return store_status;
	}

	public void setStore_status(int store_status) {
		this.store_status = store_status;
	}

	public String getStore_regis_date() {
		return store_regis_date;
	}

	public void setStore_regis_date(String store_regis_date) {
		this.store_regis_date = store_regis_date;
	}

	public String getStore_regis_status() {
		return store_regis_status;
	}

	public void setStore_regis_status(String store_regis_status) {
		this.store_regis_status = store_regis_status;
	}

	public String getStore_approval_date() {
		return store_approval_date;
	}

	public void setStore_approval_date(String store_approval_date) {
		this.store_approval_date = store_approval_date;
	}
	

	public String getMenu_name() {
		return menu_name;
	}


	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StoresDTO [store_code=");
		builder.append(store_code);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", store_name=");
		builder.append(store_name);
		builder.append(", store_addr=");
		builder.append(store_addr);
		builder.append(", store_phone=");
		builder.append(store_phone);
		builder.append(", store_business_no=");
		builder.append(store_business_no);
		builder.append(", category_code=");
		builder.append(category_code);
		builder.append(", store_detail=");
		builder.append(store_detail);
		builder.append(", store_delivery_fee=");
		builder.append(store_delivery_fee);
		builder.append(", store_status=");
		builder.append(store_status);
		builder.append(", store_regis_date=");
		builder.append(store_regis_date);
		builder.append(", store_regis_status=");
		builder.append(store_regis_status);
		builder.append(", store_approval_date=");
		builder.append(store_approval_date);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
