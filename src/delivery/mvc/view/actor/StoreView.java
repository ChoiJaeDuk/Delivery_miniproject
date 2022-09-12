package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.controller.UsersController;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.MenuView;
import delivery.mvc.view.store_function.ManageOrderView;
import delivery.mvc.view.store_function.ManageStoreView;
import delivery.mvc.view.store_function.MypageForStoreView;


public class StoreView {
	private static Scanner sc = new Scanner(System.in);


	public static void menu(String userId) {
		while (true) {

			StoreView.printMenu(userId);

			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				UsersView.users(userId); //ȸ�����
				return;
			case 2:
				StoreView.printMenuForStores(userId);// �Ǹ��ڸ�� 
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				menu(userId);
				break;				
			
			}
		}

	}
	

	public static void printMenu(String userId) {
		   
		System.out.println("--------------------------------------------------------------------");
		System.out.println("	       " + userId + "�� �ݰ����ϴ�.        		 	                    ");
		System.out.println("													         		");
		System.out.println("	  1. ȸ����� 	       2. �Ǹ��� ���       		            ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		
	}
	
	
	
	public static void printMenuForStores(String users_id) { 
	
		while(true) {
			
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("	1. ���� ����       2. �ֹ�����     3. ����������     4. �α׾ƿ�   ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					ManageStoreView.manageStore(users_id);//���԰���
					return; 
					
				case 2 :
					ManageOrderView.manageOrder(users_id); //�ֹ�����
					return;
					
				case 3 :
					MypageForStoreView.mypageForStore(users_id);//����������
					return;
					
				case 4 :
					UsersController.usersLogout(users_id);//�α׾ƿ�
					MenuView.menu();
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					printMenuForStores(users_id);
					break;	
				}
		}

	
	}
}
