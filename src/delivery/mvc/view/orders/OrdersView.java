package delivery.mvc.view.orders;

import delivery.mvc.view.actor.UsersView;
import java.util.Scanner;

public class OrdersView {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * ���԰˻�
	 */
	public static void storeSelect() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                          [ ���� ��� ]                         ");
			System.out.println();
			System.out.println("�����ڵ�     �����̸�          �����         �ı�/����   �ֹ���");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
			System.out.println("\n\n\n\n");// ��ü���Ը��
			System.out.println("----------------------------------------------------------------");
			System.out.println("1.���� ����                  2.����                   3.�ڷΰ���");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int storeSelect = Integer.parseInt(sc.nextLine());
		
			switch (storeSelect) {
				case 1:
					//���Լ���
				case 2:
					//����
				case 3:															
				//	UsersView.category(); //�ڷΰ���
					return;				
				default:
					   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}
	

	
	/**
	 * �޴��˻�
	 */
	public static void menuSelect() {
		
			System.out.println("* * * �޴� �̸��� �Է����ּ���.(����:��ġ) >> ");		
			int storeSelect = Integer.parseInt(sc.nextLine());
			
			//�Է¹��� �޴��� �Ĵ� ���� ��� ��������.
			//���԰˻� �޼ҵ� �̿��ϱ� storeSelect();
			
		
	}
	
	
}
