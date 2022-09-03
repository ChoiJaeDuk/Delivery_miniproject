package delivery.mvc.view;

import java.util.Scanner;

import delivery.mvc.view.user.FindView;
import delivery.mvc.view.user.LoginLogoutView;
import delivery.mvc.view.user.RegisterView;


public class MenuView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			

			MenuView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				LoginLogoutView.login(); //�α���
				break;
			case 2:
				RegisterView.register();// ȸ������
				break;
				
			case 3:
				FindView.find();// ���̵�*��й�ȣ ã��
				break;

			case 4:
				System.exit(0); //����
			}
		}

	}
	
	public static void printMenu() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                              ��� ����                           ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. �α���      2. ȸ������     3. ���̵�*��й�ȣ ã��    4. ����");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
	}

}
