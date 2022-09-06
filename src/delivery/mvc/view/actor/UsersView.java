package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.session.SessionSet;
import delivery.mvc.view.orders.*;
import delivery.mvc.view.user_function.*;

public class UsersView {
	private static Scanner sc = new Scanner(System.in);
	

	public static void usersPrintMenu(String users_id) {
		
		SessionSet ss = SessionSet.getInstance();
		System.out.println("==>"+ss.getSet()); // []
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println();
		System.out.println("                    " + users_id + "�� �ݰ����ϴ�.                  ");
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. ���        2. ��ٱ��� ��ȸ       3. ����������      4. �α׾ƿ�");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
	}

	public static void users(String usersId) {
		usersPrintMenu(usersId);
	
		while (true) {
			int users = Integer.parseInt(sc.nextLine());

			switch (users) {
			case 1:
				UserOrdersView.deliveryMenu(usersId);// ���
				break;
				
			case 2:
				UserBascketView.bascket(usersId);// ��ٱ��� ��ȸ
				break;
				
			case 3:
				MypageView.mypage(usersId);// ����������
				break;
				
			case 4:
				LoginLogoutView.logOut(usersId);// �α׾ƿ�
				return;

			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");// �� �� ��ȣ �Է� �� �����޼���
				break;
			}// switch��
		} // while��
	}

}
