package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.admin_function.AdminControlView;
import delivery.mvc.view.admin_function.ReviewControlView;
import delivery.mvc.view.user_function.LoginLogoutView;

public class AdminView {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void admin(String userId) {
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                      [ ��� ��� �Դϴ�. ]                       \n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.�����                   2.�ı����                   3.�α׾ƿ�");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int admin = Integer.parseInt(sc.nextLine());
		switch(admin) {
			case 1:
				AdminControlView.adminControl(userId);
				break;
			case 2:
				ReviewControlView.storeList(userId);
				break;
			case 3:
				LoginLogoutView.logOut(userId);
				return;
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				admin(userId);
				break;
		}//switch��
	}
}
