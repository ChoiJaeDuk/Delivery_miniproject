package delivery.mvc.view.orders;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class BascketView {
	static Scanner sc = new Scanner(System.in);
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
					//���� �����ϱ�
				case 2:
					//�޴� �����ϱ�
				case 3:
					//�ֹ��ϱ�
				case 4:
					UsersView.users(); //�ڷΰ���
					return;
				
				//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}

}
