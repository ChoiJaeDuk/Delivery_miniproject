package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.MenuController;
import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.actor.StoreView;

public class ManageStoreView {
	private static Scanner sc= new Scanner(System.in);


	private static String users_id;


	
	public static void manageStore(String users_id) {
		while (true) {
			ManageStoreView.printMenu();
			int menuno = Integer.parseInt(sc.nextLine());
			
			switch (menuno) {
			case 1:
				ManageStoreView.storeStatus(users_id);//���� Ŭ����
				break;
				
			case 2:
				ManageStoreView.manageMenu(users_id);//�޴�����
				break;
			case 3:
				ManageStoreView.salesStatistics(users_id);//�Ǹ����
				break;
			case 4:
				ManageStoreView.manageReview(users_id);// �ı����
				break;
			case 5:	
				StoreView.printMenuForStores(users_id);//���� 
				break;
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				manageStore(users_id);
				break;	
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("                               [�� �� �� ��]                                         ");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. open/close ���� ����    2. �޴� ����     3. �Ǹ����    4. �ı����    5. �ڷΰ���");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
	}
	
	/*
	 * 1. open/close ���� �����ϱ�
	 * */
	public static void storeStatus(String user_id) { //����
		//StoresDTO store = new StoresDTO();
		//String user_id =null;
		//String status = null;
		//if(store.getStore_status() == 0 ) status = "close";
		//else status = "open";
		
	//	SessionSet ss = SessionSet.getInstance();
	//	String userId = ss.getSet().iterator().next().getSessionId();
		//System.out.println(userId);
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [open/close ���� ]                                 ");
		//System.out.println("-------------������" + status + " �����Դϴ� -------------------------------");
	
		StoresController.storeSelectStatus(user_id);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("	      	1. open              2. close               3.�ڷΰ���                ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				openStore(1, user_id);
				storeStatus(user_id);
				return; 
				
			case 2:
				closeStore(0, user_id);
				storeStatus(user_id);
				break;		
			case 3:
				manageStore(user_id);//�ڷΰ���
				break;
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				storeStatus(user_id);
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
	public static void manageMenu(String user_id) {
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ �� �� �� ��  ]                                   ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println(" 	1. �޴� ���     2. �޴� ����    3. �޴� ����     4. �޴���ȸ    5.�ڷΰ���   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertMenu(user_id);//�޴����	
					manageMenu(user_id);
					return;
				case 2:
					updateMenu(user_id);//�޴�����
					manageMenu(user_id);
					return;
				case 3:
					deleteMenu(user_id);//�޴�����
					manageMenu(user_id);
					return;
				case 4:
					showMenu(user_id);//�޴���ȸ
					manageMenu(user_id);
					return;
				case 5:
					manageStore(user_id); //�ڷΰ���
					break;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					manageMenu(user_id);
					break;		
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 �޴����
	 * */
	public static void insertMenu(String user_id) {
		
			MenuController.menuSelectByStore(user_id);
			
			System.out.println("* * *"+"getCategoryCode"+"  ī�װ� ��ȣ�� �Է����ּ��� >> ");
			int categoryNo = Integer.parseInt(sc.nextLine());
			
			System.out.println("* * * �޴� �̸��� �Է����ּ��� >> ");
			String menuName = sc.nextLine();
			System.out.println("* * * �޴� ������ �Է����ּ��� >> ");
			int menuPrice = Integer.parseInt(sc.nextLine());
			
			MenuController.menuInsert(new MenuDTO(categoryNo, 0, menuName, menuPrice, 1), user_id);
		}
		
	
	
	
	/**
	 * 2-1 �޴�����
	 * */
	public static void updateMenu(String user_id) {
		menuList(user_id);
		System.out.println("* * * ������ �޴� �ڵ带 �Է����ּ��� >> ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("* * * ������ �޴� �̸��� �Է����ּ��� >> ");
		String newName = sc.nextLine();
		System.out.println("* * * ������ �޴� ������ �Է����ּ��� >> ");
		int newPrice = Integer.parseInt(sc.nextLine());
		System.out.println("* * * ������ ǰ�� ���θ� �Է����ּ��� >> ");
		int status = Integer.parseInt(sc.nextLine());
		
		MenuController.menuUpdate(new MenuDTO(no, newName, newPrice, status));
	}
	
	/**
	 * 2-1 �޴�����
	 * */
	public static void deleteMenu(String user_id) {
		menuList(user_id);
		System.out.println("* * * ������ �޴� �ڵ带 �Է����ּ��� >> ");
		int no = Integer.parseInt(sc.nextLine());
		
		MenuController.menuDelete(no);
	}
	
	/**
	 * 2-1 �޴���ȸ
	 * */
	public static void showMenu(String user_id) {
		menuList(user_id);
	}
	
	/*
	 * 3. �Ǹ����
	 * */
	
	public static void salesStatistics(String users_id) {

		System.out.println("----------------------------------------------------------------------------------\n");
		System.out.println("                               [ �� �� �� Ȳ �� ȸ  ]                             \n");
		System.out.println("               �޴��ڵ�            �޴��̸�             �� ����                   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		StoresController.menuSales(users_id);
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("               	1. ���� ���� ��ȸ              2. �ڷΰ���                        ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					System.out.println("* * * �޴� �ڵ带 �Է����ּ��� >>");
					int menuCode = Integer.parseInt(sc.nextLine());
					salesDetail(users_id, menuCode);//���� ���� ��ȸ 
					salesStatistics(users_id);
					return;
					
				case 2:
					//�ڷΰ���
					return;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					salesStatistics(users_id);
					break;	
				
			}
			
		}
	}
	/**
	 * 3-1 ���θ�����ȸ
	 * */

	public static void salesDetail(String users_id, int menuCode) {//���Կ� 
		//StoresController.storesSelectByCategory(users_id, menuCode);

		StoresController.menuSalesByMonth(users_id, menuCode);
			
	}
	
	
	
	/*
	 * 4. �ı���� 
	 * */
	
	public static void manageReview	(String user_id) {
//		StoresDAO storesDAO = new StoresDAOImpl();
//		 StoresDTO storecode = storesDAO.storeSelectById(user_id);
		
		
		reviewList(user_id);
		System.out.println("        1. ����ۼ�      2. ��ۼ���       3. ��ۻ���       4. �ڷΰ���          ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ��� >> ");
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertReply(user_id);//����ۼ�
					manageReview(user_id);
					return;
					
				case 2:
					updateReply(user_id);//��ۼ���
					manageReview(user_id);
					return;
					
				case 3:
					deleteReply(user_id);//��ۻ���
					manageReview(user_id);
					return;
					
				case 4:
					manageStore(user_id);
					return;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					manageReview(user_id);
					break;	
				
			}
			
		}
	}//�޼ҵ峡
	
	
	/**	 
	  4-1 ����ۼ�
	 * @param user_id 
	*/
	public static void insertReply(String user_id) {
					
			System.out.println("* * * �ı��ڵ带 �Է����ּ��� >> ");
			String reviewNo = sc.nextLine();
			System.out.println("* * * ����� �Է����ּ��� >> ");
			String content = sc.nextLine();
		
			
			ReviewController.replyUpdate(content, Integer.parseInt(reviewNo));
			
		}
		
	
	/**
	
	 4-2 ��ۼ���
*/ 
	public static void updateReply(String user_id) {
		menuList(user_id);
		System.out.println("* * * ������ �ı� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		System.out.println("* * * ������ ��۳����� �Է����ּ��� >> ");
		String newContent = sc.nextLine();

		
		ReviewController.replyUpdate(newContent, Integer.parseInt(no));
		
		
	}
	/**
	 *4-3 ��ۻ���
	*/
	public static void deleteReply(String user_id) {
		menuList(user_id);
		System.out.println("* * * ������ �ı� �ڵ带 �Է����ּ��� >> ");
		String no = sc.nextLine();
		
		ReviewController.replyDelete(Integer.parseInt(no));
		
	}
	
	
	
	
	/**
	 * �޴�����Ʈ
	 * */
	public static void  menuList(String user_id) {
		MenuController.menuSelectByMenu(user_id);
	}


	/**
	 * ��۸���Ʈ/�ı⸮��Ʈ
	 * */
	public static void  reviewList(String user_id) {
	System.out.println("----------------------------------------------------------------------------------\n");
	System.out.println("                                [   ��   ��   ]                                   \n");
	System.out.println("�ı� �ڵ�          ȸ��ID            ����/�ı�           ���               �����");
	System.out.println("----------------------------------------------------------------------------------");

	ReviewController.reviewSelectAll(user_id);

	System.out.println("----------------------------------------------------------------------------------");
		
	}
	

	
}
