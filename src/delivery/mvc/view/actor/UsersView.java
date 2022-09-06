package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.orders.*;
import delivery.mvc.view.user_function.*;

public class UsersView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void usersPrintMenu(String usersId) {
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		System.out.println("                    " + usersId + "님 반갑습니다.                  ");
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. 배달        2. 장바구니 조회       3. 마이페이지      4. 로그아웃");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
	}

	public static void users(String usersId) {
		usersPrintMenu(null);
	
		while (true) {
			int users = Integer.parseInt(sc.nextLine());

			switch (users) {
			case 1:
				UserOrdersView.deliveryMenu();// 배달
				break;
				
			case 2:
				UserBascketView.bascket(usersId);// 장바구니 조회
				break;
				
			case 3:
				MypageView.mypage();// 마이페이지
				break;
				
			case 4:
				LoginLogoutView.logOut(usersId);// 로그아웃
				return;

			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");// 그 외 번호 입력 시 오류메세지
				break;
			}// switch끝
		} // while끝
	}

}
