package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.admin_function.AdminControlView;
import delivery.mvc.view.admin_function.ReviewControlView;
import delivery.mvc.view.user_function.LoginLogoutView;

public class AdminView {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		admin();
	}

	public static void admin() {
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                      [ 운영자 모드 입니다. ]                       \n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.운영관리                   2.후기관리                   3.로그아웃");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int admin = Integer.parseInt(sc.nextLine());
		switch(admin) {
			case 1:
				AdminControlView.adminControl();
				break;
			case 2:
				ReviewControlView.storeList();
				break;
			case 3:
				LoginLogoutView.logOut();
				break;
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				admin();
				break;
		}//switch끝
	}
}
