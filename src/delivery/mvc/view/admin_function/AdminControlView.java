package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.view.actor.AdminView;

/**
 * �����
 */
public class AdminControlView {
	
	static Scanner sc = new Scanner(System.in);

	public static void adminControl() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.���� ����                2.���� ��Ȳ ��ȸ               3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int adminControl = Integer.parseInt(sc.nextLine());
		switch(adminControl) {
			case 1:
				storeInfo();//�������� ��ȸ
				System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				
				storeControl();//���԰���
				storeInfo();//���� ���� ������Ʈ �� �ٽ� ��ȸ!
								
				break;
				
			case 2:
				break;
			case 3:
				AdminView.admin();
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				adminControl();
				break;
		}//switch��
	}
	
	
	
	/**
	 * ���� ����
	 */
	public static void storeInfo() {
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                [ " + "storeName" + " ���� ���� ]                   \n");
		System.out.println("�������� �ҷ�����!!   \n\n\n\n");
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	
	/**
	 * ���԰���
	 */
	public static void storeControl() {
		//System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");
		//int storeCode = Integer.parseInt(sc.nextLine());
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.�Ǹ��� ��û �����ϱ�     2.�Ǹ��� ��û �ź��ϱ�     3.�ڷΰ���");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int storeControl = Integer.parseInt(sc.nextLine());
		switch(storeControl) {
			case 1:
				storeState();
				
				System.out.println("* * * ���� �ڵ带 �Է����ּ���. >> ");				
				int storeCode = Integer.parseInt(sc.nextLine());
				
				storeState(); //������Ʈ �� ���� ��� �ҷ�����!!!				
				adminControl();
				break;
			case 2:
				storeState();
				break;
			case 3:
				adminControl();
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				storeControl();
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
		System.out.println("���� ���λ��� ������ �ҷ�����!!!           ���/����/�ݷ� \n\n\n");
		System.out.println("----------------------------------------------------------------\n");
		
	}
	
	/**
	 * ������Ȳ��ȸ
	 */
	
	
	
	

}
