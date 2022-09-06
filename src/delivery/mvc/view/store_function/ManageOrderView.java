package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.OrdersController;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.view.actor.StoreView;

public class ManageOrderView {
private static Scanner sc= new Scanner(System.in);
	
//	public static void main(String[] args) {
//		ManageOrderView.manageOrder();
//	}
	
	public static void manageOrder() {
		while (true) {

			ManageOrderView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				ManageOrderView.orderDetail();//�ֹ��󼼺���
				break;
				
			case 2:
				ManageOrderView.manageDelivery();//��ް���
				break;
			
			case 3:	
				StoreView.printMenuForStores();//���� 
				break;
			}
		}
	}
	
	public static void printMenu() {
		orderList();
		System.out.println("         	1. �ֹ��󼼺���         2. ��ް���          3. �ڷΰ���              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
	}
	
	/*
	 * 1. �ֹ��󼼺���
	 * */
	public static void orderDetail() {
		System.out.print("* * * �ֹ��ڵ带 �Է����ּ���. >>");
		String orderCode = sc.nextLine();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("            ["+orderCode+"�� ���� ������(db�ҷ���)ȸ�� �ֹ� �� ]                            ");
		System.out.println("                 �޴�         ����         �ݾ�          �ѱݾ�                   ");
		OrdersController.selectOrderLine(Integer.parseInt(orderCode));                                             
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("       	1. �ֹ������ϱ�         2. �ֹ�����ϱ�          3. �ڷΰ���              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		
		//System.out.println("* * * ���� ��޽ð��� �Է����ּ���. >> ");
		
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
				printMenu();//�ڷΰ���
				break;
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				orderDetail();
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
		System.out.println("db������ ��޻��� ������Ʈ ");
	}
	
	/**
	 * 1-2 �ֹ�����ϱ�
	 * */
	public static void refuseOrder(String orderCode) {
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode),3);
		System.out.println("db������ �ֹ����");
	}
	
	
	
	/*
	 * 2. ��ް���
	 * */
	public static void manageDelivery() {
		System.out.print("* * * �ֹ��ڵ带 �Է����ּ���. >>");
		String orderCode = sc.nextLine();
		orderList();
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
					printMenu(); //�ڷΰ���
					return;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					manageDelivery();
					break;	
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 ��޽��� : DB�����ؾ��� ��� ���� 4���� �з�
	 * */
	public static void startDelivery(String orderCode) {
		System.out.println("db������ ��޻��º���");
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode), 2);
	}
	
	/**
	 * 2-2 ��޿Ϸ�
	 * */
	public static void finishDelivery(String orderCode) {
		System.out.println("db������ ��޻��º���");
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode), 1);
	}
	
	
	public static void orderList() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ �� �� �� �� ]                                    ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        �ֹ��ڵ�      ȸ�� ID       ��ȭ��ȣ        �ּ�       ��޻���           ");
		System.out.println("----------------------------------------------------------------------------------");
		OrdersController.selectOrderList(2);
		System.out.println("----------------------------------------------------------------------------------");
	}
	
}
