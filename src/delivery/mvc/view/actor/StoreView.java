package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.user.LoginLogoutView;
import delivery.mvc.view.user.RegisterView;
import kosta.mvc.controller.GoodsController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.MenuView;



public class StoreView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			StoreView.printMenuForStores();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				LoginLogoutView.login(); //로그인
				MenuView.printMenu();
				return;
				
			case 2:
				RegisterView.register();// 회원가입
				MenuView.printMenu();
				return;
				
			case 3:
				System.exit(0); //종료
			}
		}

	}
	
	public static void printMenuForStores(String userId) {
	
		while(true) {
			//SessionSet ss = SessionSet.getInstance();
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("				1. 로그인      2. 회원가입     3. 종료"              );
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					login(userId);// 
					return; //함수를 빠저나간다.
					//break;
					
				case 2 :
					GoodsController.goodsSelect();//전체 상품조회
					break;
				case 3 :
					printInputOrder(userId);
					break;
				case 4 :
					OrderController.selectOrdersByUserId(userId);
					break;
				case 5 :
					MenuView.putCart(userId);// 
					break;	
		
				case 6 : 
					viewCart(userId);
					break;
				}
		}

	
}
