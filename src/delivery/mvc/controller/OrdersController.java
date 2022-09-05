package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.service.orders.OrdersService;
import delivery.mvc.service.orders.OrdersServiceImpl;

public class OrdersController {
	private static OrdersService orderService = new OrdersServiceImpl();
	/**
	 * �ֹ��ϱ� �ֹ������� �ֹ� �󼼳����� �����ϰ� ������ ��ٱ��ϸ� �ʱ�ȭ�Ѵ�.
	 * */
	public static void insertOrders(OrdersDTO orders) {
		try {
			orderService.orderInsert(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	/**
	 * �ֹ� ���� ��ȸ 
	 * */
	public static void selectOrderList(int store_code) {
		try {
			List<OrdersDTO> list = orderService.selectOrderList(store_code);
			//view�� ���
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	/**
	 * ��� ����,�ź� ������Ʈ!!!! delivery_time = �����۽ð� , ��۽ð�
	 * */
	public static void approveOrder(OrdersDTO orders, int delivery_time) {
		try {
			orderService.approveOrder(orders, delivery_time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * user_id�� �޾� �ֹ��󼼸� ��ȸ�Ѵ�.
	 * */
	public static void selectOrderLine(int order_code) {
		try {
			List<MenuDTO> list = orderService.selectOrderLine(order_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cancelOrder(int order_code) {
		try {
			orderService.cancelOrder(order_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
