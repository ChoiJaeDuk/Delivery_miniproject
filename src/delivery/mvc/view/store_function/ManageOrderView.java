package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.OrdersController;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.view.actor.StoreView;

public class ManageOrderView {
private static Scanner sc= new Scanner(System.in);
	

	public static void manageOrder(String userid) {
		while (true) {

			ManageOrderView.printMenu(userid);
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				ManageOrderView.orderDetail(userid);//�ֹ��󼼺���
				break;
				
			case 2:
				ManageOrderView.manageDelivery(userid);//��ް���
				break;
			
			case 3:	
				StoreView.printMenuForStores(userid);//���� 
				break;
			}
		}
	}
	
	public static void printMenu(String userid) {
		orderList(userid);
		System.out.println("         	1. �ֹ��󼼺���         2. ��ް���          3. �ڷΰ���              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
	}
	
	/*
	 * 1. �ֹ��󼼺���
	 * */
	public static void orderDetail(String userid) {
		System.out.print("* * * �ֹ��ڵ带 �Է����ּ���. >>");
		String orderCode = sc.nextLine();

		OrdersController.selectOrderLine(Integer.parseInt(orderCode));                                             
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("       	1. �ֹ������ϱ�         2. �ֹ�����ϱ�          3. �ڷΰ���              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				acceptOrder(orderCode);//�ֹ������ϱ�
				return;
				
			case 2:
				refuseOrder(orderCode);//�ֹ�����ϱ�
				return;		
				
			case 3:
				manageOrder(userid);//�ڷΰ���
				break;
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				orderDetail(userid);
				break;	
			} 
		}
	}
	
	/**
	 * 1-1 �ֹ������ϱ�
	 * */
	public static void acceptOrder(String orderCode) {
		System.out.print("���� ��޽ð��� �Է����ּ��� : ");
		String expectedTime = sc.nextLine();
		OrdersController.approveOrder(new OrdersDTO(Integer.parseInt(orderCode),2),Integer.parseInt(expectedTime));
		
	}
	
	/**
	 * 1-2 �ֹ�����ϱ�
	 * */
	public static void refuseOrder(String orderCode) {
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode),4);
		
	}
	
	
	
	/*
	 * 2. ��ް���
	 * */
	public static void manageDelivery(String userid) {
		System.out.print("* * * �ֹ��ڵ带 �Է����ּ���. >>");
		String orderCode = sc.nextLine();
		orderList(userid);
		System.out.println("       	1. ��޽����ϱ�         2. ��޿Ϸ��ϱ�          3. �ڷΰ���              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		

		
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					startDelivery(orderCode);//��޽���
					return;
				case 2:
					finishDelivery(orderCode);//��޿Ϸ�
					return;
					
				case 3:
					printMenu(userid); //�ڷΰ���
					return;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					manageDelivery(userid);
					break;	
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 ��޽��� : DB�����ؾ��� ��� ���� 4���� �з�
	 * */
	public static void startDelivery(String orderCode) {
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode), 3);
	}
	
	/**
	 * 2-2 ��޿Ϸ�
	 * */
	public static void finishDelivery(String orderCode) {
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode), 1);
	}
	
	
	public static void orderList(String userid) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ �� �� �� �� ]                                    ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        �ֹ��ڵ�      ȸ�� ID       ��ȭ��ȣ        �ּ�       ��޻���           ");
		System.out.println("----------------------------------------------------------------------------------");
		OrdersController.selectOrderList(userid);
		System.out.println("----------------------------------------------------------------------------------");
	}
	
}
