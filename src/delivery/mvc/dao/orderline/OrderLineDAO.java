package delivery.mvc.dao.orderline;

public interface OrderLineDAO {
	/**
	 * ��ٱ��Ͽ��� �ֹ��ڵ�, �޴��ڵ�, ������ �Է¹޾� ������ ����(���Ͼ���!)
	 * */
	public void insertOrderLine(int order_code, int menu_code, int order_quantity);	
	
}


