package delivery.mvc.view.orders;

import java.util.Scanner;

public class UserCategorySelect {
	static Scanner sc = new Scanner(System.in);

	/**
	 * ���԰˻� - ��ü ���� ��� ��ȸ
	 */
	public static void totalStoreList() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ ���� ��� ]                         \n");
		System.out.println("�����ڵ�    �����̸�      �����          �ı�/����       �ֹ���");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		
	}
	
	/**
	 * �޴��˻�
	 */
	public static void menuSelect() {
		System.out.println("* * * �޴��̸��� �Է����ּ���. >> ");
		String menuName =sc.nextLine();
		
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ ���� ��� ]                         \n");
		System.out.println("�����ڵ�    �����̸�      �����          �ı�/����       �ֹ���");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("%�޴��̸�%" + "select ��� ��������\n\n\n\n\n");
	}
}
