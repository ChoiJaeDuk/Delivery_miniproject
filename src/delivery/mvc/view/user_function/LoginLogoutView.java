package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.view.MenuView;

public class LoginLogoutView {
	private static Scanner sc = new Scanner(System.in);
	/**
	 * �α��� 
	 */
	
	public static void login() {
		 System.out.print("* * * ���̵� �Է����ּ���. >> ");
		 String usersId = sc.nextLine();
		 
		 System.out.print("* * * ��й�ȣ�� �Է����ּ���. >> ");
		 String usersPwd = sc.nextLine();
		 
		 //��Ʈ�ѷ� ȣ���ϱ� 
		 
		 
	}
	
	/**
	 * �α׾ƿ�
	 */
	public static void logOut() {
		
		//��Ʈ�ѷ� ȣ���ϱ�
		MenuView.menu();
		
	}
	
	/***
	 * �α׾ƿ�
	 */
	public static void logout() {
		 //������ �����ϴ� �޼ҵ带 ȣ��
	
	}
}