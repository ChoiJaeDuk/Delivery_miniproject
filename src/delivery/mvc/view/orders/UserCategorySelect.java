package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;

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
		selectLayout();
		//StoresController.storesInfoSelectAll();
		StoresController.storesSelectAll();
		
	}
	
	/**
	 * %�޴�% �˻� -���� ��� ��ȸ
	 */
	public static String menuSelect() {
		System.out.println("* * * �޴��̸��� �Է����ּ���. >> ");
		String menuName =sc.nextLine();
		
			selectLayout();

		StoresController.storesSelectByMenu("", menuName);
		
		return menuName;
	}

}
