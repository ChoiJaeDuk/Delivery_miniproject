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
				ManageOrderView.orderDetail(userid);//주문상세보기
				break;
				
			case 2:
				ManageOrderView.manageDelivery(userid);//배달관리
				break;
			
			case 3:	
				StoreView.printMenuForStores(userid);//종료 
				break;
			}
		}
	}
	
	public static void printMenu(String userid) {
		orderList(userid);
		System.out.println("         	1. 주문상세보기         2. 배달관리          3. 뒤로가기              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
	}
	
	/*
	 * 1. 주문상세보기
	 * */
	public static void orderDetail(String userid) {
		System.out.print("* * * 주문코드를 입력해주세요. >>");
		String orderCode = sc.nextLine();

		OrdersController.selectOrderLine(Integer.parseInt(orderCode));                                             
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("       	1. 주문승인하기         2. 주문취소하기          3. 뒤로가기              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				acceptOrder(orderCode);//주문승인하기
				return;
				
			case 2:
				refuseOrder(orderCode);//주문취소하기
				return;		
				
			case 3:
				manageOrder(userid);//뒤로가기
				break;
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				orderDetail(userid);
				break;	
			} 
		}
	}
	
	/**
	 * 1-1 주문승인하기
	 * */
	public static void acceptOrder(String orderCode) {
		System.out.print("예상 배달시간을 입력해주세요 : ");
		String expectedTime = sc.nextLine();
		OrdersController.approveOrder(new OrdersDTO(Integer.parseInt(orderCode),2),Integer.parseInt(expectedTime));
		
	}
	
	/**
	 * 1-2 주문취소하기
	 * */
	public static void refuseOrder(String orderCode) {
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode),4);
		
	}
	
	
	
	/*
	 * 2. 배달관리
	 * */
	public static void manageDelivery(String userid) {
		System.out.print("* * * 주문코드를 입력해주세요. >>");
		String orderCode = sc.nextLine();
		orderList(userid);
		System.out.println("       	1. 배달시작하기         2. 배달완료하기          3. 뒤로가기              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		

		
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					startDelivery(orderCode);//배달시작
					return;
				case 2:
					finishDelivery(orderCode);//배달완료
					return;
					
				case 3:
					printMenu(userid); //뒤로가기
					return;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					manageDelivery(userid);
					break;	
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 배달시작 : DB수정해야함 배달 상태 4개로 분류
	 * */
	public static void startDelivery(String orderCode) {
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode), 3);
	}
	
	/**
	 * 2-2 배달완료
	 * */
	public static void finishDelivery(String orderCode) {
		OrdersController.orderStatusUpdate(Integer.parseInt(orderCode), 1);
	}
	
	
	public static void orderList(String userid) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ 주 문 목 록 ]                                    ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        주문코드      회원 ID       전화번호        주소       배달상태           ");
		System.out.println("----------------------------------------------------------------------------------");
		OrdersController.selectOrderList(userid);
		System.out.println("----------------------------------------------------------------------------------");
	}
	
}
