package delivery.mvc.view;

import java.util.Scanner;

import delivery.mvc.view.user_function.FindView;
import delivery.mvc.view.user_function.LoginLogoutView;
import delivery.mvc.view.user_function.RegisterView;
import delivery.mvc.session.SessionSet;


public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			MenuView.printMenu();
			
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
				case 1:
					LoginLogoutView.login(); //로그인
					break;
					
				case 2:
					RegisterView.register();//회원가입
					break;
					
				case 3:
					FindView.find();//아이디비밀번호 찾기
					break;
					
				case 4:
					System.exit(0); //종료
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                              배달 서비스                           ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. 로그인      2. 회원가입     3. 아이디*비밀번호 찾기    4. 종료");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
	}

}
