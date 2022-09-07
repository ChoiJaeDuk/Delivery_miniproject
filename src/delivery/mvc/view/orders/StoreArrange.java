package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.session.SessionSet;


public class StoreArrange {

	//UserOrdersView uov = new UserOrdersView();
	static int category = UserOrdersView.category;
	static int subFoodList;
	
	static Scanner sc = new Scanner(System.in);
	//UserOrdersView uo = new UserOrdersView();
	
	
	
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
				//UserCategorySelect.totalStoreList(); 
			
				StoresController.storesSelectAll("ORDER BY ORDER_COUNT DESC");
				break;
			case 2:
				//UserCategorySelect.totalStoreList(); 
				
				StoresController.storesSelectAll("ORDER BY STAR_AVG DESC");
				break;
			case 3:
				StoresController.storesSelectAll("ORDER BY STORE_DELIVERY_FEE");
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
	public static void menuarrange(String menuName) {
		//System.out.println("\n\n-------------------------------------------------------------------");
		//System.out.println("1.�ֹ� ���� ��    2.���� ���� ��    3.����� ���� ��     4.�ڷΰ���");
		//System.out.println("-------------------------------------------------------------------");
		
		arrangeLayout();
		
		
		int menuarrange = Integer.parseInt(sc.nextLine());

		switch(menuarrange) {
			case 1:
			
				StoresController.storesSelectByMenu("ORDER BY ORDER_COUNT DESC", menuName);
				break;
			case 2:
			
				StoresController.storesSelectByMenu("ORDER BY STAR_AVG DESC", menuName);
				break;
			case 3:
			
				StoresController.storesSelectByMenu("ORDER BY STORE_DELIVERY_FEE", menuName);
				break;
			case 4:
				UserOrdersView.storeSelect(1);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				menuarrange(menuName);
				break;
		}//switch��
	}
	
	/**
	 * ���� ī�װ� ����(����, �, ...)
	 */
	
	public static void categoryArrange(int categoryCode) {
		SessionSet ss = SessionSet.getInstance();
		   String userId = ss.getSet().iterator().next().getSessionId();
		arrangeLayout();
		

		int categoryArrange = Integer.parseInt(sc.nextLine());
		switch(categoryArrange) {
			case 1:
				 
				StoresController.storesSelectByCategory("ORDER BY ORDER_COUNT DESC", categoryCode);
				
				//System.out.println("�ֹ� ���� ������ ����ī�װ� ���Ե� ���� ��� �ҷ�����\n\n\n\n");
				break;
			case 2:
	
				StoresController.storesSelectByCategory("ORDER BY STAR_AVG DESC", categoryCode);
				break;
			case 3:
				
				StoresController.storesSelectByCategory("ORDER BY STORE_DELIVERY_FEE", categoryCode);
				break;
			case 4:
				UserOrdersView.category(category, userId);
				//UserOrdersView.subFood(subFoodList);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				categoryArrange(categoryCode);
				break;
		}//switch��) 
	}	
}
