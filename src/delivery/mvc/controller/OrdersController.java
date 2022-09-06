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
	 * �ֹ��ϱ� �ֹ������� �ֹ� �󼼳����� �����ϰ� ������ ��ٱ��ϸ� �ʱ�ȭ�Ѵ�.
	 * */
	public static void insertOrders(String user_id) {
		try {
			
			orderService.orderInsert(user_id);
			SuccessView.getmessagePrint("�ֹ��Ǿ����ϴ�.");
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
	 * ��� ����,�ź� ������Ʈ!!!! delivery_time = �����۽ð� , ��۽ð�
	 * */
	public static void approveOrder(OrdersDTO orders, int delivery_time) {
		try {
			orderService.approveOrder(orders, delivery_time);
			SuccessView.getmessagePrint("������Ʈ �Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * user_id�� �޾� �ֹ��󼼸� ��ȸ�Ѵ�.
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
			SuccessView.getmessagePrint(" �ֹ� ���°� ���� �Ǿ����ϴ�.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
