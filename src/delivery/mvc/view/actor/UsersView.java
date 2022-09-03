package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.MenuView;
import delivery.mvc.view.orders.BascketView;
import delivery.mvc.view.orders.CategoriesView;
import delivery.mvc.view.user.mypageView;

public class UsersView {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UsersView.users();
	}

	public static void users() {
		while (true) {
			usersPrintMenu();
			int users = Integer.parseInt(sc.nextLine());

			switch (users) {
				case 1:
					category();//배달				
				case 2:
					BascketView.bascket();// 장바구니 조회
				case 3:
					mypageView.mypage();// 마이페이지					
				case 4:
					MenuView.menu();// 로그아웃					
				
				//그 외 번호 입력 시 오류 메세지

			}//switch끝		
		} // while끝	
	}

	public static void usersPrintMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		System.out.println("                    " + "usersId" + "님 반갑습니다.                  ");
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. 배달        2. 장바구니 조회       3. 마이페이지      4. 로그아웃");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
	}

	
	/**
	 * 
	 * 배달
	 */
	public static void category() {		

		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.양식   2.중식   3.한식   4.가게 검색   5.메뉴 검색   6. 뒤로가기  ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int category = Integer.parseInt(sc.nextLine());
		
			switch (category) {
				case 1:
					CategoriesView.westernFood();//양식
				case 2:
					CategoriesView.chineseFood();//중식
				case 3:
					//한식
				case 4:
					//가게 검색
				case 5:
					//메뉴 검색
				case 6:
					users(); //뒤로가기
					return;
				
				//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}

	
	
	
	
	
	

}
