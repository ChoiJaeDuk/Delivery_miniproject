package delivery.mvc.dao.orders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;

public interface OrdersDAO {
	List<OrdersDTO> list = new ArrayList<OrdersDTO>();
	
	
	/**
	 * Orders 값 삽입한다 (데이터값 삽입하는 것이기 때문에 리턴값 없음!)
	 * 총 가격(order_total_price)는 장바구니에서 가져올 예정!!!!
	 * */
	public int orderInsert(String user_id, int store_code, int order_total_price, int delivery_code) throws SQLException;
	
	
	/**
	 * Store_Code를 입력받아 해당되는 데이터 리스트를 반환한다
	 * ppt 33p 주문목록 불러오기
	 * */
	public List<OrdersDTO> selectOrderList(int store_code) throws SQLException;
	
	
	/**
	 * 판매자가 배달 승인,거부 값 입력  Orders테이블의 delivery_code와 승인시간(SYSDATE), 예상배송대기시간 업데이트 한다.
	 * ppt 34p ~ 35p 주문 승인 취소하기
	 * */
	public OrdersDTO approveOrder(int delivery_code, int order_delivery_time, int ordercode) throws SQLException;		
	

	/**
	 *  order_code를 받아 해당되는 주문 상세를 조회한다.
	 * ppt 35p 주문상세보기
	 * */
	public List<OrderLineDTO> selectOrderLine(int order_code) throws SQLException;

	/**
	 * 회원이 주문을 환불신청한다.
	 * ppt 65p
	 * */
	public int cancelOrder(int order_code) throws SQLException;
	
	
	/**
	 * 주문내역에 입력할 총가격 값 가져오기
	 * Select sum(m.menu_price * b.basket_quantity) as total_price from menu m , bascket b where m.menu_code = b.menu_code;
	 * */
	public int totalPriceSelect(String user_id) throws SQLException;
	
}