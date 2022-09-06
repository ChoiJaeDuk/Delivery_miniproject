package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.controller.OrdersController;
import delivery.mvc.view.MenuView;
import delivery.mvc.view.store_function.ManageOrderView;
import delivery.mvc.view.store_function.ManageStoreView;
import delivery.mvc.view.store_function.MypageForStoreView;
//import delivery.mvc.view.user.LoginLogoutView;
//import delivery.mvc.view.user.RegisterView;



public class StoreView {
	private static final String usersId = null;
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		 StoreView.menu();
		 
	}
	
	

	public static void menu() {
		while (true) {
			StoreView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				UsersView.users(usersId);//삼진님의 회원 메소드 호출//회원모드
				
				
			case 2:
				StoreView.printMenuForStores();// 판매자모드 
				//MenuView.printMenu();
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				menu();
				break;				
			
			}
		}

	}
	
	public static void printMenu() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("	          "+"usersId"+"\t님 반갑습니다.        		 	       \n\n ");
		System.out.println("	  1. 회원모드 	       2. 판매자 모드       		            ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
	}
	
	
	public static void printMenuForStores() {
	
		while(true) {
			//SessionSet ss = SessionSet.getInstance();
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("	1. 가게 관리       2. 주문관리     3. 마이페이지     4. 로그아웃   ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					ManageStoreView.manageStore();//가게관리
					return; //함수를 빠저나간다.
					//break;
					
				case 2 :
					ManageOrderView.manageOrder();//주문관리
					
					return;
				case 3 :
					MypageForStoreView.mypageForStore();//마이페이지
					return;
				case 4 :
					MenuView.menu();//로그아웃
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					printMenuForStores();
					break;	
				}
		}

	
	}
}
