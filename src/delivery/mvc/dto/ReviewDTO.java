package delivery.mvc.dto;

public class ReviewDTO {
	private int review_code;
	private int order_code;
	private String user_id;//
	private int store_code;	
	private String review_detail;//
	private String post_date;
	private int star_grade;//
	private String reply;
	
	private StoresDTO storesDTO;
	
	

	public ReviewDTO() { }

	public ReviewDTO(int review_code, int order_code, String user_id, int store_code, String review_detail,
			String post_date, int star_grade, String reply) {
		super();
		this.review_code = review_code;
		this.order_code = order_code;
		this.user_id = user_id;
		this.store_code = store_code;
		this.review_detail = review_detail;
		this.post_date = post_date;
		this.star_grade = star_grade;
		this.reply = reply;
	}
	
	public ReviewDTO(int review_code, int order_code, String user_id, int store_code, String review_detail,
			String post_date, int star_grade, String reply, StoresDTO storesDTO) {
		super();
		this.review_code = review_code;
		this.order_code = order_code;
		this.user_id = user_id;
		this.store_code = store_code;
		this.review_detail = review_detail;
		this.post_date = post_date;
		this.star_grade = star_grade;
		this.reply = reply;
		this.storesDTO = storesDTO;
	}
	
	

	public ReviewDTO(int review_code, int order_code, String user_id, int store_code, String review_detail,
			String post_date, int star_grade) {
		super();
		this.review_code = review_code;
		this.order_code = order_code;
		this.user_id = user_id;
		this.store_code = store_code;
		this.review_detail = review_detail;
		this.post_date = post_date;
		this.star_grade = star_grade;
	}
	
	

	public ReviewDTO(String user_id, int order_code,  int star_grade, String review_detail, 
			String post_date) {
		super();
		this.order_code = order_code;
		this.user_id = user_id;
		this.review_detail = review_detail;
		this.post_date = post_date;
		this.star_grade = star_grade;
	}
	

	public ReviewDTO(String user_id, int order_code, int store_code, String review_detail, int star_grade) {
		super();
		this.order_code = order_code;
		this.user_id = user_id;
		this.store_code = store_code;
		this.review_detail = review_detail;
		this.star_grade = star_grade;
	}
	
	

	public ReviewDTO(int star_grade, String review_detail, int review_code) {
		super();
		this.review_code = review_code;
		this.review_detail = review_detail;
		this.star_grade = star_grade;
	}
	
	

	public ReviewDTO(int review_code) {
		super();
		this.review_code = review_code;
	}

	public int getReview_code() {
		return review_code;
	}

	public void setReview_code(int review_code) {
		this.review_code = review_code;
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

	public int getStore_code() {
		return store_code;
	}

	public void setStore_code(int store_code) {
		this.store_code = store_code;
	}

	public String getReview_detail() {
		return review_detail;
	}

	public void setReview_detail(String review_detail) {
		this.review_detail = review_detail;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public int getStar_grade() {
		return star_grade;
	}

	public void setStar_grade(int star_grade) {
		this.star_grade = star_grade;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	

	
	public StoresDTO getStoresDTO() {
		return storesDTO;
	}

	public void setStoresDTO(StoresDTO storesDTO) {
		this.storesDTO = storesDTO;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewDTO [review_code=");
		builder.append(review_code);
		builder.append(", order_code=");
		builder.append(order_code);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", store_code=");
		builder.append(store_code);
		builder.append(", review_detail=");
		builder.append(review_detail);
		builder.append(", post_date=");
		builder.append(post_date);
		builder.append(", star_grade=");
		builder.append(star_grade);
		builder.append(", reply=");
		builder.append(reply);
		builder.append("]");
		return builder.toString();
	}

	
	}
	
	
	

