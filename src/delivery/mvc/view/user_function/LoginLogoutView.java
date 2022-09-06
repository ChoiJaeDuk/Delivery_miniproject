package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.UsersController;
import delivery.mvc.session.Session;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.MenuView;
import delivery.mvc.view.actor.UsersView;


public class LoginLogoutView {

	private static Scanner sc = new Scanner(System.in);
	/**
	 * 1.로그인 
	 */
	
	public static void login() {
		 System.out.print("* * * 아이디를 입력해주세요. >> ");
		 String usersId = sc.nextLine();
		 
		 System.out.print("* * * 비밀번호를 입력해주세요. >> ");
		 String usersPwd = sc.nextLine();
		 
		 //컨트롤러 호출하기 
		 UsersController.userLogin(usersId, usersPwd);
		 UsersView.users(usersId);
		 
		 
	}
	
	

	
	/**
	 * 로그아웃
	 */
	public static void logOut(String userId) {
		Session session = new Session(userId);
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
		
		//컨트롤러 호출하기
		//세션을 종료하는 메소드를 호출
		//MenuView.menu();
		
	}
}
