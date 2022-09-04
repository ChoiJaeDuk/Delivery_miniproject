package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.view.actor.StoreView;


////////////////////////////�ޙ�,...�޼ҵ�..��ؿ뤱...

public class ManageStoreView {
	private static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		ManageStoreView.manageStore();
	}
	
	public static void manageStore() {
		while (true) {
			ManageStoreView.printMenu();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				ManageStoreView.storeStatus();//���� Ŭ����
				break;
				
			case 2:
				ManageStoreView.manageMenu();//�޴�����
				break;
			case 3:
				ManageStoreView.salesStatistics();//�Ǹ����
				break;
			case 4:
				ManageStoreView.manageReview();// �ı����
				break;
			case 5:	
				StoreView.printMenuForStores();//���� 
				break;
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [�� �� �� ��]                                      ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("1. open/close ���� ����      2. �޴� ����     3. �Ǹ����    4. �ı����    5. ����");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
	}
	
	/*
	 * 1. open/close ���� �����ϱ�
	 * */
	public static void storeStatus() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [open/close ���� ]                                 ");
		
		System.out.println("-------------������"+ "(db������Ʈ���ҷ�����)+"+" �����Դϴ� -------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("	      	1. open              2. close               3.�ڷΰ���                ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				openStore();
				storeStatus();
				return; 
				
			case 2:
				closeStore();
				storeStatus();
				break;		
			case 3:
				printMenu();//�ڷΰ���
				break;
			}
		}
	}
	
	/**
	 * 1-1 open����
	 * */
	public static void openStore() {
		System.out.println("db������ ���� ������Ʈ ");
	}
	
	/**
	 * 1-2 close����
	 * */
	public static void closeStore() {
		System.out.println("db������ Ŭ���� ������Ʈ ");
	}


	
	
	/*
	 * 2. �޴�����
	 * */
	public static void manageMenu() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ �� �� �� ��  ]                                   ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println(" 	1. �޴� ���     2. �޴� ����    3. �޴� ����     4. �޴���ȸ    5.�ڷΰ���   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertMenu();//�޴����					
					return;
				case 2:
					updateMenu();//�޴�����
					return;
				case 3:
					deleteMenu();//�޴�����
					return;
				case 4:
					showMenu();//�޴���ȸ
					return;
				case 5:
					printMenu(); //�ڷΰ���
					return;
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 �޴����
	 * */
	public static void insertMenu() {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                               [ ��� ī�װ� ��� ]                             ");
			System.out.println("\n");
			System.out.println("                 4. ����          5.�Ľ�Ÿ            6.������ũ            ");
			System.out.println("----------------------------------------------------------------------------------");
			
			System.out.println("* * * ��� ī�װ� ��ȣ�� �Է����ּ��� >> ");
			String categoryNo = sc.nextLine();
			System.out.println("* * * �޴� �̸��� �Է����ּ��� >> ");
			String menuName = sc.nextLine();
			System.out.println("* * * �޴� ������ �Է����ּ��� >> ");
			String menuPrice = sc.nextLine();
			
			//MenuDTO menu =  new MenuDTO();
	    	//��Ʈ�ѷ�.insert(menu);
		}
		
	
	
	/**
	 * 2-1 �޴�����
	 * */
	public static void updateMenu() {
		menuList();
		System.out.println("* * * ������ �޴� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		System.out.println("* * * ������ �޴� �̸��� �Է����ּ��� >> ");
		String newName = sc.nextLine();
		System.out.println("* * * ������ �޴� ������ �Է����ּ��� >> ");
		String newPrice = sc.nextLine();
		
		//MenuDTO menu =  new MenuDTO(bo,newname,newprice);
    	//��Ʈ�ѷ�.update(menu);
	}
	
	/**
	 * 2-1 �޴�����
	 * */
	public static void deleteMenu() {
		menuList();
		System.out.println("* * * ������ �޴� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		
		//��Ʈ�ѷ�.delete(no);
	}
	
	/**
	 * 2-1 �޴���ȸ
	 * */
	public static void showMenu() {
		menuList();
	}
	
	/*
	 * 3. �Ǹ����
	 * */
	
	public static void salesStatistics() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ �� �� �� Ȳ �� ȸ  ]                             ");
		System.out.println("               �޴��ڵ�            �޴��̸�             �� ����                   ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("              111111                  ����               5000000                  ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("               	1. ���� ���� ��ȸ              2. �ڷΰ���                        ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					//���� ���� ��ȸ 
					return;
					
				case 2:
					printMenu(); //�ڷΰ���
					return;
				
			}
			
		}
	}
	/**
	 * 3-1 ���θ�����ȸ
	 * */
	public static void salesDetail() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              [   ������ ���� ���� ��Ȳ ��ȸ  ]                                 ");
		System.out.println("               �޴��ڵ�            �޴��̸�             �� ����                   ");		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("     ex)            1111                ����              5,000,000        ");
		System.out.println("----------------------------------------------------------------------------------");
	
		
	}
	/*
	 * 4. �ı���� 
	 * */
	
	public static void manageReview	() {
		reviewList();
		System.out.println("        1. ����ۼ�      2. ��ۼ���       3. ��ۻ���       4. �ڷΰ���          ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					//����ۼ�
					return;
					
				case 2:
					//��ۼ���
					return;
					
				case 3:
					//��ۻ���
					return;
					
				case 4:
					printMenu(); //�ڷΰ���
					return;
				
			}
			
		}
	}//�޼ҵ峡
	
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~������~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 
	 * 
	  4-1 ����ۼ�
	 
	public static void insertMenu() {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                               [ ��� ī�װ� ��� ]                             ");
			System.out.println("\n");
			System.out.println("                 4. ����          5.�Ľ�Ÿ            6.������ũ            ");
			System.out.println("----------------------------------------------------------------------------------");
			
			System.out.println("* * * ��� ī�װ� ��ȣ�� �Է����ּ��� >> ");
			String categoryNo = sc.nextLine();
			System.out.println("* * * �޴� �̸��� �Է����ּ��� >> ");
			String menuName = sc.nextLine();
			System.out.println("* * * �޴� ������ �Է����ּ��� >> ");
			String menuPrice = sc.nextLine();
			
			//MenuDTO menu =  new MenuDTO();
	    	//��Ʈ�ѷ�.insert(menu);
		}
		
	
	
	
	 4-2 ��ۼ���
	 
	public static void updateMenu() {
		menuList();
		System.out.println("* * * ������ �޴� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		System.out.println("* * * ������ �޴� �̸��� �Է����ּ��� >> ");
		String newName = sc.nextLine();
		System.out.println("* * * ������ �޴� ������ �Է����ּ��� >> ");
		String newPrice = sc.nextLine();
		
		//MenuDTO menu =  new MenuDTO(bo,newname,newprice);
    	//��Ʈ�ѷ�.update(menu);
	}
	
	 4-3 ��ۻ���
	
	public static void deleteMenu() {
		menuList();
		System.out.println("* * * ������ ���� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		
		//��Ʈ�ѷ�.delete(no);
	}
	*/
	
	
	
	/**
	 * �޴�����Ʈ
	 * */
	public static void  menuList() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                     [ �� ��  �� ��  db���� ������]                               ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        �޴��ڵ�      ī�װ�       �޴��̸�        ����       ǰ������           ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("          ����          323         010-        ����        ���/�ݺ�/��/�Ϸ�/��  ");
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public static void  reviewList() {
	System.out.println("----------------------------------------------------------------------------------");
	System.out.println("                                [   ��   ��   ]                                   ");
	System.out.println("         �г���      �ֹ��ڵ�       ����        �ı�          �����              ");
	System.out.println("----------------------------------------------------------------------------------");
	System.out.println("          ȫ���      ????           4          ���־���~       2022-09-01        ");
	System.out.println("----------------------------------------------------------------------------------");
		
	}
	
}
