package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.orders.*;
import delivery.mvc.view.user_function.*;

public class UsersView {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		users();

	}
	
	public static void users() {
		
		while (true) {
			usersPrintMenu();
			int users = Integer.parseInt(sc.nextLine());

			switch (users) {
			case 1:
				OrdersView.deliveryMenu();// ���
			case 2:
				BasketView.bascket();// ��ٱ��� ��ȸ
			case 3:
				mypageView.mypage();// ����������
			case 4:
				LoginLogoutView.logOut();// �α׾ƿ�

			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");// �� �� ��ȣ �Է� �� �����޼���

			}// switch��
		} // while��
	}
	
	public static void usersPrintMenu() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		System.out.println("                    " + "usersId" + "�� �ݰ����ϴ�.                  ");
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. ���        2. ��ٱ��� ��ȸ       3. ����������      4. �α׾ƿ�");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
	}

}
