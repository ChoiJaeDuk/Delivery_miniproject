package delivery.mvc.view.orders;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class CategoriesView {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * ���
	 */
	public static void westernFood() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ ��� ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("4.����          5.�Ľ�Ÿ          6.������ũ          7.�ڷΰ���");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int westernFood = Integer.parseInt(sc.nextLine());
		
			switch (westernFood) {
				case 4:
					//����
				case 5:
					//�Ľ�Ÿ
				case 6:
					//������ũ
				case 7:										
					UsersView.category(); //�ڷΰ���
					return;
				
				//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}
	
	
	
	/**
	 * �߽�
	 */
	public static void chineseFood() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ �߽� ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("7.��             8.�丮             9.��             10.�ڷΰ���");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int chineseFood = Integer.parseInt(sc.nextLine());
		
			switch (chineseFood) {
				case 7:
					//��
				case 8:
					//�丮
				case 9:
					//��
				case 10:										
					UsersView.category(); //�ڷΰ���
					return;
				
				//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}
	
	
	
	
	/**
	 * �ѽ�
	 */
	public static void koreanFood() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ �ѽ� ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("10.�           11.����          12.��/��          13.�ڷΰ���");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int koreanFood = Integer.parseInt(sc.nextLine());
		
			switch (koreanFood) {
				case 10:
					//�
				case 11:
					//����
				case 12:
					//��/��
				case 13:										
					UsersView.category(); //�ڷΰ���
					return;
				
				//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}

}
