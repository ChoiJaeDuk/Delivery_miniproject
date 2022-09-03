package delivery.mvc.dto;

public class ReviewDTO {
	private int review_code;
	private String review_detail;
	private String user_id;
	private String post_date;
	private int star_grade;
	private int order_code;
	
	public ReviewDTO() { }

	public ReviewDTO(int review_code, String review_detail, String user_id, String post_date, int star_grade,
			int order_code) {
		super();
		this.review_code = review_code;
		this.review_detail = review_detail;
		this.user_id = user_id;
		this.post_date = post_date;
		this.star_grade = star_grade;
		this.order_code = order_code;
	}

	public int getReview_code() {
		return review_code;
	}

	public void setReview_code(int review_code) {
		this.review_code = review_code;
	}

	public String getReview_detail() {
		return review_detail;
	}

	public void setReview_detail(String review_detail) {
		this.review_detail = review_detail;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewDTO [review_code=");
		builder.append(review_code);
		builder.append(", review_detail=");
		builder.append(review_detail);
		builder.append(", user_id=");
		builder.append(user_id);
		builder.append(", post_date=");
		builder.append(post_date);
		builder.append(", star_grade=");
		builder.append(star_grade);
		builder.append(", order_code=");
		builder.append(order_code);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
