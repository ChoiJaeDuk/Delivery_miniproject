package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.view.actor.AdminView;

/**
 * �����
 */
public class AdminControlView {
	
	static Scanner sc = new Scanner(System.in);

	public static void adminControl() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.���� ����                2.���� ��Ȳ ��ȸ               3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int adminControl = Integer.parseInt(sc.nextLine());
		switch(adminControl) {
			case 1:
				System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				storeControl();				
				break;
				
			case 2:
				break;
			case 3:
				AdminView.admin();
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				adminControl();
				break;
		}//switch��
	}
	
	
	
	/**
	 * ���԰���
	 */
	public static void storeControl() {
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                [ " + "storeName" + " ���� ���� ]                   \n");
		System.out.println("�������� �ҷ�����!!   \n\n\n\n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.�Ǹ��� ��û �����ϱ�     2.�Ǹ��� ��û �ź��ϱ�     3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	
	/**
	 * ������Ȳ��ȸ
	 */
	

}
