package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.MenuView;
import delivery.mvc.view.orders.BascketView;
import delivery.mvc.view.orders.CategoriesView;
import delivery.mvc.view.orders.OrdersView;
import delivery.mvc.view.user_function.mypageView;

public class UsersView {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UsersView.users();
	}

	public static void users() {
		while (true) {
			usersPrintMenu();
			int users = Integer.parseInt(sc.nextLine());

			switch (users) {
			case 1:
				category();// ���
			case 2:
				BascketView.bascket();// ��ٱ��� ��ȸ
			case 3:
				mypageView.mypage();// ����������
			case 4:
				MenuView.menu();// �α׾ƿ�

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

	private static void category() {
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.���   2.�߽�   3.�ѽ�   4.���� �˻�   5.�޴� �˻�   6. �ڷΰ���  ");
			System.out.println("--------------------------------------------------------------------");
			
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int category = Integer.parseInt(sc.nextLine());
			
			switch(category) {
			
			}//switch��
		
		}//while��
		
	}
}
