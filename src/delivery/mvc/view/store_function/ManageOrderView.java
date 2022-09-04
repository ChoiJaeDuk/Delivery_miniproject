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
				ManageOrderView.orderDetail();//주문상세보기
				
				break;
				
			case 2:
				ManageOrderView.manageDelivery();//배달관리
				break;
			
			case 3:	
				StoreView.printMenuForStores();//종료 
				break;
			}
		}
	}
	
	public static void printMenu() {
		orderList();
		System.out.println("         	1. 주문상세보기         2. 배달관리          3. 뒤로가기              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
	}
	
	/*
	 * 1. 주문상세보기
	 * */
	public static void orderDetail() {
		System.out.print("* * * 주문코드를 입력해주세요. >>");
		String orderCode = sc.nextLine();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("            ["+orderCode+"에 따른 ㅇㅇㅇ(db불러옴)회원 주문 상세 ]                            ");
		System.out.println("                 메뉴         수량         금액          총금액                   ");
		System.out.println("	                        db에서 불러울곳                                                      ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("       	1. 주문승인하기         2. 주문취소하기          3. 뒤로가기              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		//System.out.println("* * * 예상 배달시간을 입력해주세요. >> ");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				acceptOrder();//주문승인하기
				return;
				
			case 2:
				refuseOrder();//주문취소하기
				return;		
			case 3:
				printMenu();//뒤로가기
				break;
			} 
		}
	}
	
	/**
	 * 1-1 주문승인하기
	 * */
	public static void acceptOrder() {
		System.out.println("* * * 예상 배달시간을 입력해주세요. >> ");
		String expectedTime = sc.nextLine();
		System.out.println("db쿼리문 배달상태 업데이트 ");
	}
	
	/**
	 * 1-2 주문취소하기
	 * */
	public static void refuseOrder() {
		
		System.out.println("db쿼리문 주문취소");
	}
	
	
	
	/*
	 * 2. 배달관리
	 * */
	public static void manageDelivery() {
		System.out.print("* * * 주문코드를 입력해주세요. >>");
		String orderCode = sc.nextLine();
		orderList();
		System.out.println("       	1. 배달시작하기         2. 배달완료하기          3. 뒤로가기              ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");

		
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					startDelivery();//배달시작
					return;
				case 2:
					finishDelivery();//배달완료
					return;

				case 3:
					printMenu(); //뒤로가기
					return;
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 배달시작
	 * */
	public static void startDelivery() {
		System.out.println("db쿼리문 배달상태변경");
	}
	
	/**
	 * 2-2 배달완료
	 * */
	public static void finishDelivery() {
		System.out.println("db쿼리문 배달상태변경");
	}
	
	
	public static void orderList() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ 주 문 목 록 ]                                    ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        주문코드      회원 ID       전화번호        주소       배달상태           ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("          ㅇㅇ          323         010-        ㅁㅇ        대기/줍비/중/완료/취  ");
		System.out.println("----------------------------------------------------------------------------------");
	}
	
}
