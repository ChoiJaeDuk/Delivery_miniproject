package delivery.mvc.view.orders;

import java.util.Scanner;

public class StoreArrange {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * �������� ����
	 */
	public static void arrange() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("1.�ֹ� ���� ��    2.���� ���� ��    3.����� ���� ��     4.�ڷΰ���");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int arrange = Integer.parseInt(sc.nextLine());
		
		switch(arrange) {
			case 1:
				UserCategorySelect.totalStoreList(); 
				System.out.println("�ֹ� ���� ������ ��ü ���� ��� �ҷ�����\n\n\n\n");
				return;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("���� ���� ������ ��ü ���� ��� �ҷ�����\n\n\n\n");
				return;
			case 3:
				System.out.println("����� ���� ������ ��ü ���� ��� �ҷ�����\n\n\n\n");
				return;
			case 4:
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				arrange();
				return;
		}//switch��
	}
	
}
