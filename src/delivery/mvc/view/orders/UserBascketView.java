package delivery.mvc.view.orders;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class UserBascketView {
	private static final String usersId = null;
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		bascket();
	}
	
	/**
	 * ��ٱ��� ��ȸ
	 */
	public static void bascket() {
		
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("                              [ ��ٱ��� ]                          ");
			System.out.println();
			System.out.println("�޴� �ڵ�     �����̸�              �޴��̸�           ����     ����");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
			System.out.println("\n\n\n\n");// ��ٱ��Ͽ� ��� ����
			System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("�� �ݾ� : " + "???��");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.���� �����ϱ�      2.�޴� �����ϱ�      3.�ֹ��ϱ�      4.�ڷΰ���");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int bascket = Integer.parseInt(sc.nextLine());
		
			switch (bascket) {
				case 1:
					bascketUpdate();
					break;
				case 2:
					bascketDelet();
					break;
				case 3:
					bascketOrder();
					break;
				case 4:
					UsersView.users(usersId); //�ڷΰ���
					return;				
				default:
					   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}
	
	
	/**
	 * ��ٱ��� ���� ����
	 */
	public static void bascketUpdate() {
		System.out.println("* * * ������ �޴��ڵ带 �Է����ּ���. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		System.out.println("* * * ������ ������ �Է����ּ���. >> ");
		int bascketQuantity = Integer.parseInt(sc.nextLine());
		
		bascket(); //���� ���� ������Ʈ�� ��, ��ٱ��� ��ȸ
	}
	
	
	/**
	 * ��ٱ��� �޴� ����
	 */
	public static void bascketDelet() {
		System.out.println("* * * ������ �޴��ڵ带 �Է����ּ���. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		bascket(); //������Ʈ�� ��, ��ٱ��� ��ȸ
	}
	
	/**
	 * ��ٱ��� �ֹ��ϱ�
	 */
	public static void bascketOrder() {
		System.out.println("* * * �ֹ��� �Ϸ�Ǿ����ϴ�. >> ");
		System.out.println("* * * �ֹ� ������ ��� ���Դϴ�. >> \n\n");
		
		UsersView.users(usersId);
	}
	
	

}
