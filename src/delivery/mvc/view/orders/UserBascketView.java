package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.controller.BasketController;
import delivery.mvc.controller.OrdersController;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.view.actor.UsersView;

public class UserBascketView {

	static Scanner sc = new Scanner(System.in);

	/**
	 * ��ٱ��� ��ȸ
	 */
	public static void bascket(String user_id) {
		
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("                              [ ��ٱ��� ]                          ");
			System.out.println();
			System.out.println("�޴� �ڵ�     �����̸�              �޴��̸�           ����     ����");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
			BasketController.basketMenuSelect(user_id);
		
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.���� �����ϱ�      2.�޴� �����ϱ�      3.�ֹ��ϱ�      4.�ڷΰ���");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int bascket = Integer.parseInt(sc.nextLine());
		
			switch (bascket) {
				case 1:
					bascketUpdate(user_id);
					break;
				case 2:
					bascketDelet(user_id);
					break;
				case 3:
					bascketOrder(user_id);
					break;
				case 4:
					UsersView.users(user_id); //�ڷΰ���
					return;				
				default:
					   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}
	
	
	/**
	 * ��ٱ��� ���� ����
	 */
	public static void bascketUpdate(String user_id) {
		System.out.println("* * * ������ �޴��ڵ带 �Է����ּ���. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		System.out.println("* * * ������ ������ �Է����ּ���. >> ");
		int bascketQuantity = Integer.parseInt(sc.nextLine());
		
		BasketController.basketUpdate(new BasketDTO(user_id, menuCode), bascketQuantity);
	}
	
	
	/**
	 * ��ٱ��� �޴� ����
	 */
	public static void bascketDelet(String user_id) {
		System.out.println("* * * ������ �޴��ڵ带 �Է����ּ���. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		BasketController.basketDelete(menuCode, user_id);
	}
	
	/**
	 * ��ٱ��� �ֹ��ϱ�
	 */
	public static void bascketOrder(String user_id) {
		System.out.println("* * * �ֹ��� �Ϸ�Ǿ����ϴ�. >> ");
		System.out.println("* * * �ֹ� ������ ��� ���Դϴ�. >> \n\n");
		OrdersController.insertOrders(user_id);
	}
}
