package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.MenuView;
import delivery.mvc.view.store_function.ManageOrderView;
import delivery.mvc.view.store_function.ManageStoreView;
import delivery.mvc.view.store_function.MypageForStoreView;
//import delivery.mvc.view.user.LoginLogoutView;
//import delivery.mvc.view.user.RegisterView;



public class StoreView {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		 StoreView.menu();
		 System.out.println("-----------");
	}
	

	

	public static void menu() {
		while (true) {
			StoreView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				//�������� ȸ�� �޼ҵ� ȣ��//ȸ�����
				
				
			case 2:
				StoreView.printMenuForStores();// �Ǹ��ڸ�� 
				//MenuView.printMenu();
							
			
			}
		}

	}
	
	public static void printMenu() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("	       userId�� �ݰ����ϴ�.        		 	                    ");
		System.out.println("													         		");
		System.out.println("	  1. ȸ����� 	       2. �Ǹ��� ���       		            ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
	}
	
	
	public static void printMenuForStores() { //�μ��� ��Ʈ�� �޴°� �´��� Ȯ��(case4��)
	
		while(true) {
			//SessionSet ss = SessionSet.getInstance();
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("	1. ���� ����       2. �ֹ�����     3. ����������     4. �α׾ƿ�   ");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					ManageStoreView.manageStore();//���԰���
					return; //�Լ��� ����������.
					//break;
					
				case 2 :
					ManageOrderView.manageOrder();//�ֹ�����
					return;
				case 3 :
					MypageForStoreView.mypageForStore();//����������
					return;
				case 4 :
					MenuView.menu();//�α׾ƿ�
					
				}
		}

	
	}
}
