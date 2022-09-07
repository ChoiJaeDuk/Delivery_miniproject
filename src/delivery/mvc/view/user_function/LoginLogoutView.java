package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.UsersController;
import delivery.mvc.session.Session;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.MenuView;
import delivery.mvc.view.actor.StoreView;
import delivery.mvc.view.actor.UsersView;


public class LoginLogoutView {
	private static String userId = null;
	private static SessionSet ss = SessionSet.getInstance();

	private static Scanner sc = new Scanner(System.in);
	/**
	 * 1.�α��� 
	 */

	public static void login() {

		SessionSet ss = SessionSet.getInstance();
		System.out.println(ss.getSet()); // []

		System.out.print("* * * ���̵� �Է����ּ���. >> ");
		userId = sc.nextLine();

		System.out.print("* * * ��й�ȣ�� �Է����ּ���. >> ");
		String usersPwd = sc.nextLine();

	
		UsersController.userLogin(userId, usersPwd);	//��Ʈ�ѷ� ȣ���ϱ� 
	}

	/**
	 * �α׾ƿ�
	 */
	public static void logOut(String userId) {
		Session session = new Session(userId);

		SessionSet ss = SessionSet.getInstance();
		ss.remove(session);	

		LoginLogoutView.userId=null;


	}
}
