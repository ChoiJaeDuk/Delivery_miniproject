package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.actor.StoreView;

public class ManageStoreView {
	private static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		ManageStoreView.manageStore();
	}
	
	public static void manageStore() {
		while (true) {
			ManageStoreView.printMenu();
			int menuno = Integer.parseInt(sc.nextLine());
			
			switch (menuno) {
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
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				manageStore();
				break;	
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [�� �� �� ��]                                      ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("1. open/close ���� ����    2. �޴� ����     3. �Ǹ����    4. �ı����    5. �ڷΰ���");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
	}
	
	/*
	 * 1. open/close ���� �����ϱ�
	 * */
	public static void storeStatus() { //����
		StoresDTO store = new StoresDTO();
		String user_id =null;
		String status = null;
		if(store.getStore_status() == 0 ) status = "close";
		else status = "open";
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [open/close ���� ]                                 ");
		
		System.out.println("-------------������" + status + " �����Դϴ� -------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("	      	1. open              2. close               3.�ڷΰ���                ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				openStore(0,user_id);
				storeStatus();
				return; 
				
			case 2:
				closeStore(0, user_id);
				storeStatus();
				break;		
			case 3:
				manageStore();//�ڷΰ���
				break;
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				storeStatus();
				break;	

			}
		}
	}
	
	/**
	 * 1-1 open����
	 * */
	public static void openStore(int store_status, String user_id) {
		StoresController.storeStatusUpdate(store_status, user_id);
	}
	
	/**
	 * 1-2 close����
	 * */
	public static void closeStore(int store_status, String user_id) {
		StoresController.storeStatusUpdate(store_status, user_id);
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
					manageMenu();
					return;
				case 2:
					updateMenu();//�޴�����
					manageMenu();
					return;
				case 3:
					deleteMenu();//�޴�����
					manageMenu();
					return;
				case 4:
					showMenu();//�޴���ȸ
					manageMenu();
					return;
				case 5:
					manageStore(); //�ڷΰ���
					break;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					manageMenu();
					break;		
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 �޴����
	 * */
	public static void insertMenu() {
		
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                      ["+ "getCategoryCode" + " ī�װ� ��� ]                   ");
			System.out.println("\n");
			/*
			if(getCategoryCode ==1) {
				System.out.println("                 4. ����          5.�Ľ�Ÿ            6.������ũ            ");
				System.out.println("----------------------------------------------------------------------------------");
			}else if(getCategoryCode==2) {
				System.out.println("7.��             8.�丮             9.��             13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
			}else if(getCategoryCode ==3) {
				System.out.println("10.�           11.����          12.��/��          13.�ڷΰ���");
				System.out.println("----------------------------------------------------------------\n");
			}
			*/
			System.out.println("                     [ ��� ī�װ� ��� ]//�Ǹ��� ��û�� �Է��� ���޾ƿ���       ");
			System.out.println("\n");
			System.out.println("    4. ����          5.�Ľ�Ÿ      6.������ũ          //�� ������ ����            ");
			System.out.println("----------------------------------------------------------------------------------");

			
			
			System.out.println("* * *"+"getCategoryCode"+"  ī�װ� ��ȣ�� �Է����ּ��� >> ");
			String categoryNo = sc.nextLine();
			
			System.out.println("* * * �޴� �̸��� �Է����ּ��� >> ");
			String menuName = sc.nextLine();
			System.out.println("* * * �޴� ������ �Է����ּ��� >> ");
			String menuPrice = sc.nextLine();
			
			//MenuDTO menu =  new MenuDTO(categoryNo,?,?);
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
		StoresController.storesSales();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("               	1. ���� ���� ��ȸ              2. �ڷΰ���                        ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					salesDetail();//���� ���� ��ȸ 
					salesStatistics();
					return;
					
				case 2:
					//�ڷΰ���
					return;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					salesStatistics();
					break;	
				
			}
			
		}
	}
	/**
	 * 3-1 ���θ�����ȸ
	 * */
	public static void salesDetail() {//���Կ� 
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              [   ������ ���� ���� ��Ȳ ��ȸ  ]                                 ");
		System.out.println("       ��        �޴��ڵ�            �޴��̸�             �� ����                   ");		
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
		System.out.println("* * * ��ȣ�� �Է����ּ��� >> ");
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertReply();//����ۼ�
					manageReview();
					return;
					
				case 2:
					updateReply();//��ۼ���
					manageReview();
					return;
					
				case 3:
					deleteReply();//��ۻ���
					manageReview();
					return;
					
				case 4:
					//�ڷΰ���
					return;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					manageReview();
					break;	
				
			}
			
		}
	}//�޼ҵ峡
	
	
	/**	 
	  4-1 ����ۼ�
	*/
	public static void insertReply() {
					
			System.out.println("* * * �ı��ڵ带 �Է����ּ��� >> ");
			String reviewNo = sc.nextLine();
			System.out.println("* * * ����� �Է����ּ��� >> ");
			String content = sc.nextLine();
		
			
			//ReviewDTO(??) reply =  new ReviewDTO();
	    	//��Ʈ�ѷ�.insert(reply);
		}
		
	
	/**
	
	 4-2 ��ۼ���
*/ 
	public static void updateReply() {
		menuList();
		System.out.println("* * * ������ �ı� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		System.out.println("* * * ������ ��۳����� �Է����ּ��� >> ");
		String newContent = sc.nextLine();

		
		//ReviewDTO(??) reply =  new ReviewDTO(no,newContent);
    	//��Ʈ�ѷ�.update(reply);
	}
	/**
	 *4-3 ��ۻ���
	*/
	public static void deleteReply() {
		menuList();
		System.out.println("* * * ������ �ı� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		
		//��Ʈ�ѷ�.delete(no);
	}
	
	
	
	
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
	/**
	 * ��۸���Ʈ/�ı⸮��Ʈ
	 * */
	public static void  reviewList() {
	System.out.println("----------------------------------------------------------------------------------");
	System.out.println("                                [   ��   ��   ]                                   ");
	System.out.println("         �ı��ڵ�      usderid       ����        �ı�          �����              ");
	System.out.println("----------------------------------------------------------------------------------");
	System.out.println("          1111      ??usderid?           4          ���־���~       2022-09-01        ");
	System.out.println("----------------------------------------------------------------------------------");
		
	}
	
}
