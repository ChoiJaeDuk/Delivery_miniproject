package delivery.mvc.dto;

public class Delivery_Status {
	private int delivery_code;
	/**
	 * 1 : ���
	 * 2 : �Ϸ�
	 * 3 : ���
	 */
	private int delivery_status;
	
	public Delivery_Status() { }
	public Delivery_Status(int delivery_code, int delivery_status) {
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
	public int getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(int delivery_status) {
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
