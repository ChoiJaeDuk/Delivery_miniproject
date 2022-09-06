package delivery.mvc.view.admin_function;

import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.actor.AdminView;

/**
 * �����
 */
public class AdminControlView {
	
	static Scanner sc = new Scanner(System.in);

	public static void adminControl(String userId) {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.���� ����                2.���� ��Ȳ ��ȸ               3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int adminControl = Integer.parseInt(sc.nextLine());
		switch(adminControl) {
			case 1:
				storeState(userId);;//�������� ��ȸ
				
				System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				storeControl(storeCode, userId);//���԰���
				storeState(userId);//���� ���� ������Ʈ �� �ٽ� ��ȸ!
								
				break;
				
			case 2:
				salesStatus(userId);
				break;
			case 3:
				AdminView.admin(userId);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				adminControl(userId);
				break;
		}//switch��
	}
	
	
	
	/**
	 * ���� ����
	 */
	public static void storeInfo() { 
		System.out.println("--------------------------------------------------------------------\n");
		StoresController.storesInfoSelectAll();
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	
	/**
	 * ���԰���
	 * @param userId 
	 */
	public static void storeControl(int store_code, String userId) {
		//System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
		//int storeCode = Integer.parseInt(sc.nextLine());
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.�Ǹ��� ��û �����ϱ�     2.�Ǹ��� ��û �ź��ϱ�     3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int storeControl = Integer.parseInt(sc.nextLine());
		switch(storeControl) {
			case 1:
		
				StoresController.storeRegis(new StoresDTO("����",store_code));
				storeState(userId); //������Ʈ �� ���� ��� �ҷ�����!!!	
				adminControl(userId);
				break;
				
			case 2:
				
				StoresController.storeRegis(new StoresDTO("�ݷ�",store_code));
			
				storeState(userId); //������Ʈ �� ���� ��� �ҷ�����!!!				
				adminControl(userId);
				break;
			case 3:
				adminControl(userId);
			
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
			//	storeControl();
				break;
		}//switch��
	}

	
	/**
	 * �Ǹ��� ���� ����
	 */
	public static void storeState(String userId) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ ���� ��� ]                         \n");
		System.out.println("���� �ڵ�                 ���� �̸�             �Ǹ��� ���� ����");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		StoresController.storesInfoSelectAll();
		System.out.println("----------------------------------------------------------------\n");
		
	}
	
	/**
	 * ������Ȳ��ȸ
	 * @param userId 
	 */
	public static void salesStatus(String userId ) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                       [ ���� ��Ȳ ��� ]                       \n");
		System.out.println("���� �ڵ�   ���� �̸�     �� ����     ���� ����     ��� ����");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		StoresController.storesSales();
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("1. ���� ���� ���� ��ȸ     2.�ڷΰ���");
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int salesStatus = Integer.parseInt(sc.nextLine());
		switch(salesStatus) {
			case 1:
				System.out.println("* * * �����ڵ带 �Է����ּ���. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				salesDetail(storeCode); 
				salesStatus(userId);
				break;
				
			case 2:
				adminControl(userId);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				salesStatus(userId);
				break;
		}//switch��
	}
	
	/**
	 * ���θ��⳻�� ��ȸ
	 */
	public static void salesDetail(int storeCode) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("            [ " + "storeName" + "���� ���� ��Ȳ ]               \n");
		System.out.println("����       �� ����             ��� ����           �Ǹ��� ����");
		System.out.println("----------------------------------------------------------------\n");
		StoresController.storesSalesByMonth(storeCode);
		System.out.println("----------------------------------------------------------------\n");
	}
	
	

}
