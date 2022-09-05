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
	 * 주문하기 주문내역과 주문 상세내역을 삽입하고 성공시 장바구니를 초기화한다.
	 * */
	public static void insertOrders(OrdersDTO orders) {
		try {
			orderService.orderInsert(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	/**
	 * 주문 내역 조회 
	 * */
	public static void selectOrderList(int store_code) {
		try {
			List<OrdersDTO> list = orderService.selectOrderList(store_code);
			//view로 출력
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	/**
	 * 배달 승인,거부 업데이트!!!! delivery_time = 예상배송시간 , 배송시간
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
	 * user_id를 받아 주문상세를 조회한다.
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
