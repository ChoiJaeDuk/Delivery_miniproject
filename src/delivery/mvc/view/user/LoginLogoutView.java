package delivery.mvc.view.user;

import java.util.Scanner;

public class LoginLogoutView {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * 로그인 기능
	 */
	
	public static void login() {
		 System.out.print("* * * 아이디를 입력해주세요. >> ");
		 String usersId = sc.nextLine();
		 
		 System.out.print("* * * 비밀번호를 입력해주세요. >> ");
		 String usersPwd = sc.nextLine();
		 
		 //컨트롤러 호출하기 
	}
}
