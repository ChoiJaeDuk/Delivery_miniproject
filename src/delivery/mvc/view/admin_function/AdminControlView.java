package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.StoresDTO;
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
				storeState();//�������� ��ȸ
				
				System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				storeControl(storeCode, userId);//���԰���
								
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
				return;
		}//switch��
	}
	
	

	/**
	 * ���԰���
	 */
	public static void storeControl(int store_code, String userId) {

		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.�Ǹ��� ��û �����ϱ�     2.�Ǹ��� ��û �ź��ϱ�     3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int storeControl = Integer.parseInt(sc.nextLine());
		switch(storeControl) {
			case 1:
		
				StoresController.storeRegis(new StoresDTO("����",store_code));
				
				storeState(); //������Ʈ �� ���� ��� �ҷ�����!!!	
	
				adminControl(userId);
				break;
			case 2:
				
				StoresController.storeRegis(new StoresDTO("�ݷ�",store_code));
			
				storeState(); //������Ʈ �� ���� ��� �ҷ�����!!!				
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
	public static void storeState() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ ���� ��� ]                         \n");
		System.out.println("���� �ڵ�                 ���� �̸�             �Ǹ��� ���� ����");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
	
		StoresController.storesInfoSelectAll("order by (case store_regis_status when '���' then 1 when '����' then 2 else 3 end)");
	
		System.out.println("----------------------------------------------------------------\n");
		
	}
	
	/**
	 * ������Ȳ��ȸ
	 */
	public static void salesStatus(String userId) {
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
		StoresController.storesSalesByMonth(storeCode);
	}
	


}
