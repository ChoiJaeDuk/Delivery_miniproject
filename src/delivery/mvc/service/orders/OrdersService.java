package delivery.mvc.service.orders;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;

public interface OrdersService {
	
	/**
	 * 주문시 insert
	 * */
	public void orderInsert(String user_id) throws SQLException;
	
	
	/**
	 * 33p 
	 * */
	public List<OrdersDTO> selectOrderList(String userid) throws SQLException;

	
	/**
	 * 34p
	 * */
	public void approveOrder(OrdersDTO orders, int delivery_time) throws SQLException;
	
	
	/**
	 * 35p
	 * */
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException;
	
	
	/**
	 * 65p 회원이 환불 신청 (주문 취소)
	 * */
	
	public void orderStatusUpdate(int order_code,int order_status_code) throws SQLException;
	
	
	
}
