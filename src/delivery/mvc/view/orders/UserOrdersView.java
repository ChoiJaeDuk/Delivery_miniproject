package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.controller.BasketController;
import delivery.mvc.controller.MenuController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.actor.UsersView;

public class UserOrdersView {
	
	static Scanner sc = new Scanner(System.in);
	static int category = 0;
	static String menuName = null;
	
	
	/**
	 *  ���,�߽�,�ѽ� �˻�
	 *  ����, �޴� �˻�
	 */
	public static void deliveryMenu(String user_id) {
		
		
		while(true) {
			
		
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.���   2.�߽�   3.�ѽ�   4.���� �˻�   5.�޴� �˻�   6. �ڷΰ���  ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			category = Integer.parseInt(sc.nextLine());
			
			switch(category) {
				case 1:
					category(category, user_id);
					break;
				case 2:
					category(category, user_id);
					break;
				case 3:
					category(category, user_id);
					break;
				case 4:
					UserCategorySelect.totalStoreList(); 				
					storeSelect(9, 0); //�ι�° �μ� index�� 0�̸� ��ü ���� ��� select, 1�̸� %�޴�% ������ ���Ը�� select
					break;
				case 5:
					menuName = UserCategorySelect.menuSelect();
					storeSelect(9, 1);//�ι�° �μ� index�� 0�̸� ��ü ���� ��� select , 1�̸� %�޴�% ������ ���Ը�� select

					break;
				case 6:
					UsersView.users(user_id);
					return;
					
				default:
					   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				
			}
			
						
			
		}//while��
	}

	
	
	/**
	 * ���� ī�װ� 
	 */
	public static void category(int category, String user_id) {
		
	
		
		switch(category) {
			case 1:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ ��� ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("4.����          5.�Ľ�Ÿ          6.������ũ         13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category, user_id);
				return;
			
			case 2:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ �߽� ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("7.��             8.�丮             9.��             13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category, user_id);
				return;
			
			case 3:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ �ѽ� ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("10.�           11.����          12.��/��          13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category, user_id);
				return;
			
			case 13:
				deliveryMenu(user_id);
				return;
		
			default:
			   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
		}//switch��
		
		
	}

	
	/**
	 * ���� ī�װ� - ���Ը��
	 */
	public static void subFood(int subFood, String user_id) {
		
	

			
			switch(subFood) {
				case 4:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ ���� ���� ��� ]                       \n");
					subFoodList(subFood);
				
					return;
				
				case 5:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                     [ �Ľ�Ÿ ���� ��� ]                       \n");
										
					subFoodList(5);
				
					return;
				
				case 6:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                    [ ������ũ ���� ��� ]                      \n");
										
					subFoodList(6);
				
					return;
				
				case 7:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ �� ���� ��� ]                         \n");
										
					subFoodList(7);
					
					return;
				
				case 8:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ �丮 ���� ��� ]                        \n");
										
					subFoodList(8);
				
					return;
				
				case 9:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ �� ���� ��� ]                         \n");
										
					subFoodList(9);
				
					return;
				
				case 10:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ � ���� ��� ]                        \n");
										
					subFoodList(10);
					
					return;
				
				case 11:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ ���� ���� ��� ]                        \n");
										
					subFoodList(11);
					
					return;
				
				case 12:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ ��/�� ���� ��� ]                       \n");
										
					subFoodList(12);
				
					return;
				
				case 13:
					deliveryMenu(user_id);
					return;
				default:
					   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					   category(category, user_id);
		
			}//switch��
		
	}//subFood�޼ҵ峡
	
	
	

	public static int subFoodList(int subFoodList) {

		System.out.println("�����ڵ�    �����̸�      �����          �ı�/����       �ֹ���");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		
		switch(subFoodList) {//subFoodList�� ���Ը���� ��Ƽ� �������ش�.
			case 4:
				StoresController.storesSelectByCategory("",subFoodList);
				
				
				storeSelect(subFoodList, 2); //int index
				break;
			case 5:
				
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			case 6:
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			case 7:
				System.out.println("�� ���Ը��");
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			case 8:
				System.out.println("�丮 ���Ը��");
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			case 9:
				System.out.println("�� ���Ը��");
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			case 10:
				System.out.println("� ���Ը��");
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			case 11:
				System.out.println("���� ���Ը��");
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			case 12:
				System.out.println("��/�� ���Ը��");
				StoresController.storesSelectByCategory("",subFoodList);
				storeSelect(subFoodList, 2);
				break;
			
		}//switch��
		
		return subFoodList;
	}
	
	
	public static void storeSelect(int subFoodList, int ...index ) {//index=0�̸�arragne(), =1 menuarrage() 9,2
		
		SessionSet ss = SessionSet.getInstance();
		String userId = ss.getSet().iterator().next().getSessionId();
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("1.���Լ���                   2.����                   3.�ڷΰ���");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int storeSelect =Integer.parseInt(sc.nextLine());
		
		switch(storeSelect) {
			case 1:
				System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
				int storeCode =Integer.parseInt(sc.nextLine());
				stores(storeCode, userId);
				break;
			case 2:
				if (index[0] == 0)
					StoreArrange.arrange(); // ��ü������ȸ --> ��ü ���Ը���� �����ؼ� ����ؾ���.
				else if (index[0] == 1)
					StoreArrange.menuarrange(menuName); // %�޴�%�� �Ĵ� ���� ��� �����ϱ�...
				else if(index[0] == 2) // ����ī�װ�(��:����)�� �Ĵ� ���Ը���� ��������. ???? ����� �Է°��� ���� ���Ը�� ȣ���ؾ��ϴµ�.....��ƴ�...
					StoreArrange.categoryArrange(subFoodList);
				break;
			
			case 3:
				deliveryMenu(userId);
				
				return;
			case 4 :
				category(category, userId);
				
				break;
		
			default:
				   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				   subFood(storeSelect, userId);
				   return;
		}//switch��
	}

	
	/**
	 *  ȸ�� �ֹ��ϴ� ��� : ���� ����� ���� �޴��� �����ϰų�, �� ������ �ı⸦ ��ȸ�Ѵ�.
	 */

	public static void stores(int storeCode, String user_id) {
		SessionSet ss = SessionSet.getInstance();
		String userId = ss.getSet().iterator().next().getSessionId();
	
				
		System.out.println("----------------------------------------------------------------");
		
		StoresController.storeSelcetByCode(storeCode);  // ȸ���� ���Ը� �����ϸ� �ش� ���� ������ �Ұ� 
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("1.�޴� ����             2.�ı�             3.�ڷΰ���           ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int no = Integer.parseInt(sc.nextLine());
		switch(no) {
			case 1:
				menu(storeCode, user_id);
				break;
			case 2:
				StoreReviewView.review(0,userId);
				break;
			case 3:
				//deliveryMenu();
				//subFoodList(subFoodList[0]); //[0]�ǹ̴� ����.....? �ʱ�ȭ?????? //������ ���ϰھ�� !!!!!
				return;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				stores(storeCode, user_id);
				return;
		}//switch��
	}
	
	
	
	
	/**
	 * �޴�  //���Ǿ��̵� ��� ������ �����ϳ��� ?(�ּ� ����)
	 */
	public static void menu(int store_code, String user_id) {
		System.out.println("\n\n----------------------------------------------------------------");
		System.out.println("                            [ �޴� ]                            \n");
		System.out.println("�޴��ڵ�                      �޴��̸�                      ����");
		System.out.println("----------------------------------------------------------------");
		MenuController.menuSelectByAllByUser(store_code);
		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("1.�ֹ��ϱ�          2.��ٱ���(����)          3.�ڷΰ���");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
			case 1:			
				System.out.println("* * * �޴��ڵ带 �Է����ּ���. >> ");
	            int menu_code = Integer.parseInt(sc.nextLine());
	            
	            System.out.println("* * * ������ �Է����ּ���. >> ");
	            int num = Integer.parseInt(sc.nextLine());
	            
	            BasketController.basketInsert(new BasketDTO(user_id, menu_code, num));
	            
				menu(store_code,user_id);
				break;
				
			case 2:

				UserBascketView.bascket(user_id);

				break;
				
			case 3:
				stores(store_code, user_id);
				
				break;
				
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				menu(store_code, user_id);
				return;
			
		}
	}
	
	
}