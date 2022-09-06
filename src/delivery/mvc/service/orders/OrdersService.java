package delivery.mvc.service.orders;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;

public interface OrdersService {
	
	/**
	 * �ֹ��� insert
	 * */
	public void orderInsert(OrdersDTO orders) throws SQLException;
	
	
	/**
	 * 33p 
	 * */
	public List<OrdersDTO> selectOrderList(int store_code) throws SQLException;

	
	/**
	 * 34p
	 * */
	public void approveOrder(OrdersDTO orders, int delivery_time) throws SQLException;
	
	
	/**
	 * 35p
	 * */
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException;
	
	
	/**
	 * 65p ȸ���� ȯ�� ��û (�ֹ� ���)
	 * */
	
	public void orderStatusUpdate(int order_code,int order_status_code) throws SQLException;
	
	
	
}
