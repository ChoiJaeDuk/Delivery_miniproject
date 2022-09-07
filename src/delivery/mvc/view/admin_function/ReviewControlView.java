package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.view.actor.AdminView;
import delivery.mvc.session.SessionSet;

/**
 * �ı���� - ���Ը��
 */
public class ReviewControlView {
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static void storeList(String userId) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ ���� ��� ]                         \n");
		System.out.println("              �����ڵ�           ���� �̸�\n");
		System.out.println("----------------------------------------------------------------\n");
		StoresController.storesNameCodeSelectAll();
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("* * * �����ڵ带 �Է����ּ���. >> ");
		int storeCode = Integer.parseInt(sc.nextLine());
		
		reviewList(storeCode);
		
	}
	
	/**
	 *  ��ڰ� �Ǽ� �ı⸦ �����Ѵ�.
	 */
	public static void reviewList(int storeCode) {
			SessionSet ss = SessionSet.getInstance();
			String userId = ss.getSet().iterator().next().getSessionId();
		
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("                          [ �ı� ��� ]                         \n");
			System.out.println("		�ı� �ڵ�		ȸ��ID		����		�ı�		���		�����		   ");
			System.out.println("----------------------------------------------------------------\n");
			ReviewController.reviewAdmintAll(storeCode);
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("1.�ı� �����ϱ�       2.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int reviewList = Integer.parseInt(sc.nextLine());
			
			switch(reviewList) {
				case 1:
					System.out.println("* * * ������ �ı� �ڵ带 �Է����ּ���. >> ");
					int reviewCode = Integer.parseInt(sc.nextLine());
					ReviewController.reviewDelete(reviewCode);
					reviewList(storeCode);//������ ��� ��ȸ!!
					break;
				case 2:
					AdminView.admin(userId);
					break;
				default :
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					reviewList(storeCode);
					break;
			}	
	}
	
}
