package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.service.orders.OrdersService;
import delivery.mvc.service.orders.OrdersServiceImpl;
import delivery.mvc.view.SuccessView;

public class OrdersController {
	private static OrdersService orderService = new OrdersServiceImpl();
	/**
	 * 주문하기 주문내역과 주문 상세내역을 삽입하고 성공시 장바구니를 초기화한다.
	 * */
	public static void insertOrders(String user_id) {
		try {
			
			orderService.orderInsert(user_id);
			SuccessView.getmessagePrint("주문되었습니다.");
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
			for (OrdersDTO orders: list) {
				System.out.print("\t  "+ orders.getOrder_code()+"\t  ");
				System.out.print(orders.getUser_id()+"\t  ");
				System.out.print(orders.getUsers().getUsers_phone()+"      ");
				System.out.print(orders.getUsers().getUsers_addr()+"\t");
				System.out.print(orders.getDelivery_status().getDelivery_status()+"\t");
				System.out.println();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 배달 승인,거부 업데이트!!!! delivery_time = 예상배송시간 , 배송시간
	 * */
	public static void approveOrder(OrdersDTO orders, int delivery_time) {
		try {
			orderService.approveOrder(orders, delivery_time);
			SuccessView.getmessagePrint("업데이트 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * user_id를 받아 주문상세를 조회한다.
	 * */
	public static void selectOrderLine(int order_code) {
		try {
			List<MenuDTO> list = orderService.selectOrderLine(order_code);
			SuccessView.selectOrderLine(list);
			//for (MenuDTO menu :list) {
			//	System.out.println(menu.getMenu_name()+"  "+ menu.getOrderLine().getOrder_quntity() +"  "+ menu.getMenu_price()+"  "+menu.getTotal_price() );
			//}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void orderStatusUpdate(int order_code, int order_status_code) {
		try {
			orderService.orderStatusUpdate(order_code, order_status_code);
			SuccessView.getmessagePrint(" 주문 상태가 변경 되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
