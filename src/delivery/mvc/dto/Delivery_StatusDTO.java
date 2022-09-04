package delivery.mvc.dto;

public class Delivery_StatusDTO {
	private int delivery_code;
	/**
	 * 1 : 대기
	 * 2 : 완료
	 * 3 : 취소
	 */
	private String delivery_status;
	
	public Delivery_StatusDTO() { }
	
	
	public Delivery_StatusDTO(String delivery_status) {
		this.delivery_status = delivery_status;
	}


	public Delivery_StatusDTO(int delivery_code, String delivery_status) {
		super();
		this.delivery_code = delivery_code;
		this.delivery_status = delivery_status;
	}
	public int getDelivery_code() {
		return delivery_code;
	}
	public void setDelivery_code(int delivery_code) {
		this.delivery_code = delivery_code;
	}
	public String getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Delivery_Status [delivery_code=");
		builder.append(delivery_code);
		builder.append(", delivery_status=");
		builder.append(delivery_status);
		builder.append("]");
		return builder.toString();
	}
}
