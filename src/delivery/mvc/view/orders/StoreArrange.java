package delivery.mvc.view.orders;

import java.util.Scanner;



public class StoreArrange {
	static Scanner sc = new Scanner(System.in);
	private static int[] subFoodList;
	//UserOrdersView uo = new UserOrdersView();
	static int c= UserOrdersView.category;
	
	
	/**
	 * ���ķ��̾ƿ�
	 */
	
	public static void arrangeLayout() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("1.�ֹ� ���� ��    2.���� ���� ��    3.����� ���� ��     4.�ڷΰ���");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
	}
	
	/**
	 * �������� ����
	 */
	public static void arrange() {
		//System.out.println("\n\n-------------------------------------------------------------------");
		//System.out.println("1.�ֹ� ���� ��    2.���� ���� ��    3.����� ���� ��     4.�ڷΰ���");
		//System.out.println("-------------------------------------------------------------------");
		//System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		arrangeLayout();
		
		int arrange = Integer.parseInt(sc.nextLine());
		
		switch(arrange) {
			case 1:
				UserCategorySelect.totalStoreList(); 
				System.out.println("�ֹ� ���� ������ ��ü ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("���� ���� ������ ��ü ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 3:
				System.out.println("����� ���� ������ ��ü ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 4:
				UserOrdersView.storeSelect(0);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				arrange();
				break;
		}//switch��
	}
	
	
	/**
	 * %�޴�% ���� ����
	 */
	public static void menuarrange() {
		//System.out.println("\n\n-------------------------------------------------------------------");
		//System.out.println("1.�ֹ� ���� ��    2.���� ���� ��    3.����� ���� ��     4.�ڷΰ���");
		//System.out.println("-------------------------------------------------------------------");
		
		arrangeLayout();
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int menuarrange = Integer.parseInt(sc.nextLine());
		
		switch(menuarrange) {
			case 1:
				UserCategorySelect.menuSelect(); 
				System.out.println("�ֹ� ���� ������ %�޴�%�� ���Ե� ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("���� ���� ������ %�޴�%�� ���Ե� ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 3:
				System.out.println("����� ���� ������ %�޴�%�� ���Ե� ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 4:
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				menuarrange();
				break;
		}//switch��
	}
	
	/**
	 * ���� ī�װ� ����(����, �, ...)
	 */
	
	public static void categoryArrange() {
		arrangeLayout();
		
		
		
		int categoryArrange = Integer.parseInt(sc.nextLine());
		switch(categoryArrange) {
			case 1:
				UserCategorySelect.menuSelect(); 
				System.out.println("�ֹ� ���� ������ ����ī�װ� ���Ե� ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("���� ���� ������ ����ī�װ��� ���Ե� ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 3:
				System.out.println("����� ���� ������ ����ī�װ��� ���Ե� ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 4:
				UserOrdersView.category(c);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				menuarrange();
				break;
		}//switch��) 
	}	
}