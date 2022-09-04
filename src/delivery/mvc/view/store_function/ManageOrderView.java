package delivery.mvc.view.store_function;

import java.util.Scanner;

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
		System.out.println("	                        db���� �ҷ����                                                      ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("       	1. �ֹ������ϱ�         2. �ֹ�����ϱ�          3. �ڷΰ���              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		//System.out.println("* * * ���� ��޽ð��� �Է����ּ���. >> ");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				acceptOrder();//�ֹ������ϱ�
				return;
				
			case 2:
				refuseOrder();//�ֹ�����ϱ�
				return;		
			case 3:
				printMenu();//�ڷΰ���
				break;
			} 
		}
	}
	
	/**
	 * 1-1 �ֹ������ϱ�
	 * */
	public static void acceptOrder() {
		System.out.println("* * * ���� ��޽ð��� �Է����ּ���. >> ");
		String expectedTime = sc.nextLine();
		System.out.println("db������ ��޻��� ������Ʈ ");
	}
	
	/**
	 * 1-2 �ֹ�����ϱ�
	 * */
	public static void refuseOrder() {
		
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
					startDelivery();//��޽���
					return;
				case 2:
					finishDelivery();//��޿Ϸ�
					return;

				case 3:
					printMenu(); //�ڷΰ���
					return;
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 ��޽���
	 * */
	public static void startDelivery() {
		System.out.println("db������ ��޻��º���");
	}
	
	/**
	 * 2-2 ��޿Ϸ�
	 * */
	public static void finishDelivery() {
		System.out.println("db������ ��޻��º���");
	}
	
	
	public static void orderList() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ �� �� �� �� ]                                    ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        �ֹ��ڵ�      ȸ�� ID       ��ȭ��ȣ        �ּ�       ��޻���           ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("          ����          323         010-        ����        ���/�ݺ�/��/�Ϸ�/��  ");
		System.out.println("----------------------------------------------------------------------------------");
	}
	
}
