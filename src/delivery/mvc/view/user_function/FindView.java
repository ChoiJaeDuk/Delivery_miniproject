package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.UsersController;
import delivery.mvc.view.MenuView;


public class FindView {
	private static Scanner sc = new Scanner(System.in);

	
	public static void find() {
				
		while (true) {
			
			FindView.idPw();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				FindView.findId(); //���̵� ã��
				FindView.idPw();
				return;
				
			case 2:
				FindView.findPw();// ��й�ȣã��
				FindView.idPw();
				return;
				
			case 3:
				MenuView.printMenu();// �ڷΰ���
				
			}
			break;
			
		}//while��
		
	}
	
	/**
	 *  ���̵�*��й�ȣ ã�� ����
	 */
	
	public static void idPw() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                              [ ���̵� * ��й�ȣ ã�� ]            ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.���̵� ã��    2.��й�ȣ ã��     3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
	}
	
	
	/**
	 * ���̵�
	 */
	
	public static void findId() {
		System.out.print("* * * �̸��� �Է����ּ���. >> ");
		String usersName = sc.nextLine();
		
		System.out.print("* * * �ֹε�Ϲ�ȣ�� �Է����ּ���. >> ");
		String usersJumin = sc.nextLine();
		
		//���̵�ã�� UsersController 
		UsersController.searchId(usersName, usersJumin);
	}
	
	
	
	/**
	 * ��й�ȣ /////// ���ι��� 
	 */
	
	public static void findPw() {
		System.out.print("* * * ���̵� �Է����ּ���. >> ");
		String usersId = sc.nextLine();
		
		System.out.print("* * * �̸��� �Է����ּ���. >> ");
		String usersName = sc.nextLine();
		
		System.out.print("* * * �ֹε�Ϲ�ȣ�� �Է����ּ���. >> ");
		String usersJumin = sc.nextLine();

//////////////////////////////////////////////////////////////////////// 
		System.out.print("* * * ���ο� ��й�ȣ�� �Է����ּ���. >> ");
		String newpwd = sc.nextLine();
		
////////////////////////////////////////////////////////////////////////
		//��й�ȣ ã��/�缳�� UsersController 
				UsersController.searchPwd(usersId, usersName, usersJumin, newpwd);
	}
}
