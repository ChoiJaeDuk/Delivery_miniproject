package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.view.actor.UsersView;

public class UserOrdersView {
	
	public static void main(String[] args) {
		deliveryMenu();
		//subFoodList();
		//storeSelect();
		//stores();
	}
	
	static Scanner sc = new Scanner(System.in);
	static int category = 0;
	
	
	/**
	 *  ���,�߽�,�ѽ� �˻�
	 *  ����, �޴� �˻�
	 */
	public static void deliveryMenu() {
		while(true) {
			
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.���   2.�߽�   3.�ѽ�   4.���� �˻�   5.�޴� �˻�   6. �ڷΰ���  ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			category = Integer.parseInt(sc.nextLine());
			
			switch(category) {
			case 1:
				category(category);
				break;
			case 2:
				category(category);
				break;
			case 3:
				category(category);
				break;
			case 4:
				UserCategorySelect.totalStoreList(); 
				System.out.println("��ü ���� ��� �ҷ�����\n\n\n\n");
				storeSelect();
				break;
			case 5:
				UserCategorySelect.menuSelect();
				storeSelect();
				break;
			case 6:
				UsersView.users();
				return;
				
			default:
				   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				
			}
			
						
			
		}//while��
	}

	
	
	/**
	 * ���� ī�װ�
	 */
	public static void category(int category) {
		
		switch(category) {
			case 1:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ ��� ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("4.����          5.�Ľ�Ÿ          6.������ũ         13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category);
				return;
			
			case 2:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ �߽� ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("7.��             8.�丮             9.��             13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category);
				return;
			
			case 3:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ �ѽ� ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("10.�           11.����          12.��/��          13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category);
				return;
			
			case 13:
				deliveryMenu();
				return;
		
			default:
			   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
		}//switch��
		
		
	}

	
	/**
	 * ���� ī�װ� - ���Ը��
	 */
	public static void subFood(int subFood) {
		
		//while(true) {
			//System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			//int subFood =Integer.parseInt(sc.nextLine());
			
			switch(subFood) {
				case 4:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ ���� ���� ��� ]                       \n");
										
					subFoodList(4);
					//storeSelect();
					return;
				
				case 5:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                     [ �Ľ�Ÿ ���� ��� ]                       \n");
										
					subFoodList(5);
					//storeSelect();
					return;
				
				case 6:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                    [ ������ũ ���� ��� ]                      \n");
										
					subFoodList(6);
					//storeSelect();
					return;
				
				case 7:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ �� ���� ��� ]                         \n");
										
					subFoodList(7);
					//storeSelect();
					return;
				
				case 8:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ �丮 ���� ��� ]                        \n");
										
					subFoodList(8);
					//storeSelect();
					return;
				
				case 9:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ �� ���� ��� ]                         \n");
										
					subFoodList(9);
					//storeSelect();
					return;
				
				case 10:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ � ���� ��� ]                        \n");
										
					subFoodList(10);
					//storeSelect();
					return;
				
				case 11:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ ���� ���� ��� ]                        \n");
										
					subFoodList(11);
					//storeSelect();
					return;
				
				case 12:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ ��/�� ���� ��� ]                       \n");
										
					subFoodList(12);
					//storeSelect();
					return;
				
				case 13:
					deliveryMenu();
					return;
				default:
					   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					   category(category);
		
			}//switch��
		//}//while��
	}//subFood�޼ҵ峡
	
	
	

	public static int subFoodList(int subFoodList) {
		

		System.out.println("�����ڵ�    �����̸�      �����          �ı�/����       �ֹ���");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		
		switch(subFoodList ) {//subFoodList�� ���Ը���� ��Ƽ� �������ش�.
			case 4:
				System.out.println("���� ���Ը��\n\n\n\n");
				storeSelect();
				break;
			case 5:
				System.out.println("�Ľ�Ÿ ���Ը��\n\n\n\n");
				storeSelect();
				break;
			case 6:
				System.out.println("������ũ ���Ը��\n\n\n\n");
				storeSelect();
				break;
			case 7:
				System.out.println("�� ���Ը��");
				storeSelect();
				break;
			case 8:
				System.out.println("�丮 ���Ը��");
				storeSelect();
				break;
			case 9:
				System.out.println("�� ���Ը��");
				storeSelect();
				break;
			case 10:
				System.out.println("� ���Ը��");
				storeSelect();
				break;
			case 11:
				System.out.println("���� ���Ը��");
				storeSelect();
				break;
			case 12:
				System.out.println("��/�� ���Ը��");
				storeSelect();
				break;
			
		}//switch��
		
		return subFoodList;
	}
	
	
	public static void storeSelect() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("1.���Լ���                   2.����                   3.�ڷΰ���");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int storeSelect =Integer.parseInt(sc.nextLine());
		
		switch(storeSelect) {
			case 1:
				System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
				int storeCode =Integer.parseInt(sc.nextLine());
				stores();
				break;
			case 2:
				StoreArrange.arrange();
				break;
			
			case 3:
				category(category);
				break;
		
			default:
				   System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				   subFood(storeSelect);
				   return;
		}//switch��
	}

	
	
	
	/**
	 * ����
	 */
	public static void stores() {
				
		System.out.println("----------------------------------------------------------------");
		System.out.println("                      [ " + "�����̸�" + " ]                    \n");
		System.out.println("���Ը� �Ұ��ϴ� �κ��Դϴ�. ���Ը� �Ұ����ּ���. �ȳ��ϼ���.    \n\n\n");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("1.�޴� ����             2.�ı�             3.�ڷΰ���           ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int stores = Integer.parseInt(sc.nextLine());
		switch(stores) {
			case 1:
				menu();
				break;
			case 2:
				StoreReviewView.review();
				break;
			case 3:
				deliveryMenu();
				return;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				stores();
				return;
		}//switch��
	}
	
	
	
	
	/**
	 * �޴�
	 */
	public static void menu() {
		System.out.println("\n\n----------------------------------------------------------------");
		System.out.println("                            [ �޴� ]                            \n");
		System.out.println("1.�޴��ڵ�                  2.�޴��̸�                   3.����");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("�޴����\n\n\n\n");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("1.�ֹ��ϱ�          2.��ٱ���(����)          3.�ڷΰ���");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
			case 1:			
				System.out.println("* * * �޴��ڵ带 �Է����ּ���. >> ");
				menu = Integer.parseInt(sc.nextLine());
				
				System.out.println("* * * ������ �Է����ּ���. >> ");
				menu = Integer.parseInt(sc.nextLine());
				
				menu();
				break;
				
			case 2:
				UserBascketView.bascket();
				break;
				
			case 3:
				stores();
				break;
				
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				menu();
				return;
			
		}
	}
	
	
}
