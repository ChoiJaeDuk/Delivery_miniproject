package delivery.mvc.view.orders;

import java.util.Scanner;

public class UserCategorySelect {
	static Scanner sc = new Scanner(System.in);

	/**
	 * ������ȸ ���̾ƿ�
	 */
	
	public static void selectLayout() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ ���� ��� ]                         \n");
		System.out.println("�����ڵ�    �����̸�      �����          �ı�/����       �ֹ���");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
	}
	
	/**
	 * ��ü ���� ��� ��ȸ
	 */
	public static void totalStoreList() {
		//System.out.println("----------------------------------------------------------------\n");
		//System.out.println("                          [ ���� ��� ]                         \n");
		//System.out.println("�����ڵ�    �����̸�      �����          �ı�/����       �ֹ���");		
		//System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		selectLayout();
		System.out.println("��ü���� select!!\n\n\n\n\n\n");// controler ->service - dao
		
	}
	
	/**
	 * %�޴�% �˻� -���� ��� ��ȸ
	 */
	public static void menuSelect() {
		System.out.println("* * * �޴��̸��� �Է����ּ���. >> ");
		String menuName =sc.nextLine();
		
		//System.out.println("----------------------------------------------------------------\n");
		//System.out.println("                          [ ���� ��� ]                         \n");
		//System.out.println("�����ڵ�    �����̸�      �����          �ı�/����       �ֹ���");		
		//System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		selectLayout();
		System.out.println("%�޴��̸�%" + "select ��� ��������\n\n\n\n\n");
	}
}
