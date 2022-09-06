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
	 * 1.�α��� 
	 */
	
	public static void login() {
		 System.out.print("* * * ���̵� �Է����ּ���. >> ");
		 String usersId = sc.nextLine();
		 
		 System.out.print("* * * ��й�ȣ�� �Է����ּ���. >> ");
		 String usersPwd = sc.nextLine();
		 
		 //��Ʈ�ѷ� ȣ���ϱ� 
		 UsersController.userLogin(usersId, usersPwd);
		 UsersView.users(usersId);
		 
		 
	}
	
	

	
	/**
	 * �α׾ƿ�
	 */
	public static void logOut(String userId) {
		Session session = new Session(userId);
		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	
		
		//��Ʈ�ѷ� ȣ���ϱ�
		//������ �����ϴ� �޼ҵ带 ȣ��
		//MenuView.menu();
		
	}
}
