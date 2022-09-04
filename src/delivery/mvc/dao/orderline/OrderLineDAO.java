package delivery.mvc.dao.orderline;

public interface OrderLineDAO {
	/**
	 * 장바구니에서 주문코드, 메뉴코드, 수량을 입력받아 데이터 삽입(리턴없음!)
	 * */
	public void insertOrderLine(int order_code, int menu_code, int order_quantity);	
	
}


