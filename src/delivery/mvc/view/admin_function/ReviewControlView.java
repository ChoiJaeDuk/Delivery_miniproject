package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.view.actor.AdminView;

/**
 * �ı���� - ���Ը��
 */
public class ReviewControlView {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void storeList() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ ���� ��� ]                         \n");
		System.out.println("              �����ڵ�           ���� �̸�");
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("storeCode, storeName ȣ���ϱ�!!!\n\n\n\n\n\n");
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("* * * �����ڵ带 �Է����ּ���. >> ");
		int storeCode = Integer.parseInt(sc.nextLine());
		
		reviewList();
		
	}
	
	/**
	 * �ı���
	 */
	public static void reviewList() {
		
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("                          [ �ı� ��� ]                         \n");
			System.out.println("      �ı� �ڵ�         ���� �̸�           �ı�         ����   ");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("������ �ҷ�����!!!!\n\n\n\n\n\n");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("1.�ı� �����ϱ�       2.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int reviewList = Integer.parseInt(sc.nextLine());
			
			switch(reviewList) {
				case 1:
					System.out.println("* * * ������ �ı� �ڵ带 �Է����ּ���. >> ");
					int reviewCode = Integer.parseInt(sc.nextLine());
					reviewList();//������ ��� ��ȸ!!
					break;
				case 2:
					AdminView.admin();
					break;
				default :
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					reviewList();
					break;
			}
		
		
	}
	
	
	/**
	 * �ı����
	 */
	
	/*public static void reviewDelete() {
		reviewList();
		int reviewList = Integer.parseInt(sc.nextLine());
		switch(reviewList) {
			case 1:
				System.out.println("* * * ������ �ı� �ڵ带 �Է����ּ���. >> ");
				int reviewCode = Integer.parseInt(sc.nextLine());
				return;
			case 2:
				storeList();
				break;
			default :
				break;
		}
	}*/
	
}
