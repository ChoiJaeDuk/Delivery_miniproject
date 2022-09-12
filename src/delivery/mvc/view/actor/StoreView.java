package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.controller.UsersController;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.MenuView;
import delivery.mvc.view.store_function.ManageOrderView;
import delivery.mvc.view.store_function.ManageStoreView;
import delivery.mvc.view.store_function.MypageForStoreView;


public class StoreView {
	private static Scanner sc = new Scanner(System.in);


	public static void menu(String userId) {
		while (true) {

			StoreView.printMenu(userId);

			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				UsersView.users(userId); //회원모드
				return;
			case 2:
				StoreView.printMenuForStores(userId);// 판매자모드 
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				menu(userId);
				break;				
			
			}
		}

	}
	

	public static void printMenu(String userId) {
		   
		System.out.println("--------------------------------------------------------------------");
		System.out.println("	       " + userId + "님 반갑습니다.        		 	                    ");
		System.out.println("													         		");
		System.out.println("	  1. 회원모드 	       2. 판매자 모드       		            ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		
	}
	
	
	
	public static void printMenuForStores(String users_id) { 
	
		while(true) {
			
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("	1. 가게 관리       2. 주문관리     3. 마이페이지     4. 로그아웃   ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					ManageStoreView.manageStore(users_id);//가게관리
					return; 
					
				case 2 :
					ManageOrderView.manageOrder(users_id); //주문관리
					return;
					
				case 3 :
					MypageForStoreView.mypageForStore(users_id);//마이페이지
					return;
					
				case 4 :
					UsersController.usersLogout(users_id);//로그아웃
					MenuView.menu();
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					printMenuForStores(users_id);
					break;	
				}
		}

	
	}
}
