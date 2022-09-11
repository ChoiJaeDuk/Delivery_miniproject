package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.controller.UsersController;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.MenuView;
import delivery.mvc.view.actor.StoreView;
import delivery.mvc.view.user_function.MypageView;

public class MypageForStoreView {
	private static Scanner sc = new Scanner(System.in);

	public static void mypageForStore(String users_id){

		while(true) {
			MypageForStoreView.printMenu(users_id);
			int menu=Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1 :
				updateStoreInfo(users_id);//�Ǹ��� ��������
				storeDetail(users_id);
				return;
				
			case 2 : 

				StoreView.printMenuForStores(users_id);//�ڷΰ���

				return;
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");

				mypageForStore(users_id);

				break;	
			}

		}
	}
	
	//��� �������� �ƴҶ� ���� �޼ҵ� ¥�ߵǴ���
	
	public static void updateStoreInfo(String users_id) {
		System.out.println("* * * ��й�ȣ��  �Է����ּ���. >>  ");
		String pwd = sc.nextLine();
		int result = UsersController.pwdCheck(users_id, pwd);
		if(result==9999) updateStoreInfo(users_id);
		
		System.out.println("* * * ������ ���� �̸��� �Է����ּ��� >> ");
		String newName = sc.nextLine();
		System.out.println("* * * ������ ���� �ּҸ� �Է����ּ��� >> ");
		String newAddr = sc.nextLine();
		System.out.println("* * * ������ ���� ��ȭ��ȣ��  �Է����ּ��� >> ");
		String newPhone = sc.nextLine();
		System.out.println("* * * ������ ���� �Ұ��� �Է����ּ���(�ִ� 30 ��) >> ");
		String info = sc.nextLine();
		StoresDTO stores = new StoresDTO(users_id, newName, newAddr, newPhone ,info);
		System.out.println("---------------------------------------------------------------------");
		System.out.println("              1. �����ϱ�              2. ���                  ");
		System.out.println("---------------------------------------------------------------------");
		
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					 update(stores);
			
					printMenu(users_id);
					break;
				case 2:
					StoreView.printMenuForStores(users_id); //�ڷΰ���
					break;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					updateStoreInfo(users_id);
					break;	
					
					//��Ʈ�ѷ��� pwd������ �´��� Ȯ��
			}
		}
	}
	
	/**
	 * 1-1 �����ϱ�
	 * */
	public static void update(StoresDTO stores) {
		StoresController.storeUpdate(stores);
	}
	
	
	
	
	public static void printMenu(String users_id) {
		storeDetail(users_id);
		System.out.println("                1. �Ǹ��� ���� ����                  2. �ڷΰ���                  ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >>  ");;
			
		}
	
	
	public static void storeDetail(String users_id) {
		
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              "+users_id+"�����Դϴ�.                                    ");	
		System.out.println("----------------------------------------------------------------------------------");
		StoresController.storeSelectById(users_id);                  
		System.out.println("----------------------------------------------------------------------------------");
	}
}
	
	
