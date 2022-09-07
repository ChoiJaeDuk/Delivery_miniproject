package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.controller.UsersController;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.actor.UsersView;

public class MypageView {
	
	static Scanner sc = new Scanner(System.in);

	public static void mypage(String usersId){
		
		SessionSet ss = SessionSet.getInstance();
		String userId = ss.getSet().iterator().next().getSessionId();
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("                          [ ���������� ]                             ");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1.������������   2.�ֹ�����   3.�ı�   4.�Ǹ��� ��û�ϱ�   5.�ڷΰ���");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int mypageForStore = Integer.parseInt(sc.nextLine());
		switch(mypageForStore) {
			case 1:
				System.out.println("* * * ��й�ȣ�� �Է����ּ���. >> ");
				String usersPwd = sc.nextLine();
				
				
				int result = UsersController.pwdCheck(userId, usersPwd);//��Ʈ�ѷ� ȣ��, ��й�ȣ �����ϱ�!
				if(result == 1) personalInfo();
				
				mypage(usersId);
				break;
				
			case 2:
				orders(userId);
				break;
			case 3:
				review(userId);
				break;
			case 4:
				storeRegis(userId);
				break;
			case 5:
				UsersView.users(usersId);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				mypage(usersId);
				break;
				
		}
		
	}
	
	/**
	 * ������������
	 * @param usersId 
	 */
	private static void personalInfo() {
		SessionSet ss = SessionSet.getInstance();
		String userId = ss.getSet().iterator().next().getSessionId();
     
        
		while(true) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                          [ " + userId + "�� �������� ]                  \n");
			UsersController.userInfoPrint(userId);
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1.�г��� ����   2.�ּ� ����   3.��ȭ��ȣ ����   4.��й�ȣ ����   5.�ڷΰ���");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int personalInfo = Integer.parseInt(sc.nextLine());
			switch(personalInfo) {
				case 1:					
					System.out.println("* * * ������ �г����� �Է����ּ���. >> ");
					String newUsersNick = sc.nextLine();
					
					UsersController.nickUpdate(newUsersNick, userId);//�г��Ӻ��� �޼ҵ�(controller)
					personalInfo();
					break;
					
				case 2:
					System.out.println("* * * ������ �ּҸ� �Է����ּ���. >> ");
					String newUsersAddr = sc.nextLine();
					UsersController.addrUpdate(newUsersAddr, userId);
					personalInfo();
					break;
					
				case 3:
					System.out.println("* * * ������ ��ȭ��ȣ�� �Է����ּ���. >> ");
					String newUsersPhone = sc.nextLine();
					UsersController.phoneUpdate(newUsersPhone, userId);
					personalInfo();
					break;
					
				case 4:
					System.out.println("* * * ���� ��й�ȣ�� �Է����ּ���. >> ");
					String usersPwd = sc.nextLine();
				

					//��Ʈ�ѷ� ȣ��, ��й�ȣ �����ϱ�!
					int result = UsersController.pwdCheck(userId, usersPwd);
					if(result == 1) {
//						UsersController.pwdCheck(userId, usersPwd);

						System.out.println("* * * ������ ��й�ȣ�� �Է����ּ���. >> ");
						String newUsersPwd = sc.nextLine();
						UsersController.pwdUpdate(usersPwd, newUsersPwd);					
						personalInfo();
					}

					break;
					
				case 5:
					mypage(userId);
					break;
					
				default :
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					personalInfo();
					break;
				
			}//switch��
			
		}//while��
	}
	
	
	/**
	 * �ֹ�����
	 * @param userId 
	 */
	private static void orders(String userId ) {
		
		
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                               [ �ֹ����� ]                                 \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.�ֹ��ڵ�      2.�ֹ���¥      3.�� ����      4.��ۻ���     5.�����۽ð�");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		UsersController.selectOrderList(userId);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.�ֹ� �󼼺���       2.�ڷΰ���");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int orders = Integer.parseInt(sc.nextLine());
		switch(orders) {
			case 1:
				System.out.println("* * * �ֹ��ڵ带 �Է����ּ���. >> ");
				int order_code = Integer.parseInt(sc.nextLine());
				orderLine(order_code);
				break;
			case 2:
				mypage(userId);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				orders(userId);
				break;
			
		}//switch��	
	}
	
	/**
	 * �ֹ��󼼺���
	 */

	private static void orderLine(int order_code) {

		SessionSet ss = SessionSet.getInstance();
		String userId = ss.getSet().iterator().next().getSessionId();
		

		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                             [ �ֹ��󼼺��� ]                               \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.�ֹ�����_���ڵ�    2.�����̸�        3.�޴��̸�        4.����     5.�ܰ�");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		UsersController.selectDelivery_time(order_code);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.ȯ��(���)�ϱ�     2.�ڷΰ���");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int orderLine = Integer.parseInt(sc.nextLine());
		switch(orderLine) {
			case 1:		
				
				
				UsersController.cancelOrder(order_code);
				orders(userId);//�ֹ����� --> ��ۻ��� ������Ʈ �ϱ�!!!
				break;
			case 2:
				orders(userId);
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				orderLine(order_code);
				break;
		}
	}
	
	
	/**
	 * �ı���ȸ
	 * @param userId 
	 */
	private static void review(String userId) {

		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                          [ ���� �ۼ��� �ı� ��� ]                         \n");

		System.out.println("	�ı� �ڵ�		���� �̸�		����		�ı�		���		�����   ");

		ReviewController.reviewUserAll(userId);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.�ı� ���           2.�ı� ����           3.�ı� ����           4.�ڷΰ���");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int review = Integer.parseInt(sc.nextLine());
		switch(review) {
		case 1:
			reviewInsert(userId);
			review(userId);
			break;
		case 2:
			reviewUpdate();
			review(userId);
			break;
		case 3:
			System.out.println("* * * ������ �ı��ڵ带 �Է����ּ���. >> ");
			int reviewCode = Integer.parseInt(sc.nextLine());

			//���� ���� �޼ҵ�
			ReviewController.reviewDelete(reviewCode);
			review(userId);

			break;
		case 4:
			mypage(userId);
			break;
		default :
			System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
			review(userId);
			break;
		}
	}
	
	/**
	 * �ı���
	 */

	

	private static void reviewInsert(String userId) {

		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                           [ �ֱ� �ֹ� ���� ]                               \n");
		ReviewController.yetReview(userId);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * �ֹ��ڵ� �Է����ּ���. >> ");
		int orderCode = Integer.parseInt(sc.nextLine());
		
		//��Ʈ�ѷ� ȣ��? ���� ȣ��? �̹� �ıⰡ �ۼ��� �ֹ��ڵ� �Է� �� �����޼��� ���!!
		
		System.out.println("* * * 5�� ���� �� ������ �Է����ּ���. >> ");
		int starGrade = Integer.parseInt(sc.nextLine());
		System.out.println("* * * �ı⸦ �Է����ּ���.(�ִ� 30��)  >> ");
		String reviewDetail = sc.nextLine();
		
		//���� �ۼ� �޼ҵ� ReviewController
		// user_id�� ���ǿ��� �����;� �ҵ�

		
		ReviewController.reviewInsert(userId, orderCode, reviewDetail, starGrade);

	}
	
	
	/**
	 * �ı����
	 */
	private static void reviewUpdate() {
		System.out.println("* * * ������ �ı��ڵ带 �Է����ּ���. >> ");
		int newReviewCode = Integer.parseInt(sc.nextLine());
		System.out.println("* * * 5�� ���� �� ������ �Է����ּ���. >> ");
		int starGrade = Integer.parseInt(sc.nextLine());
		System.out.println("* * * �ı⸦ �Է����ּ���.(�ִ� 30��)  >> ");
		String reviewDetail = sc.nextLine();
		
		//���� ���� �޼ҵ� ReviewController
		ReviewDTO review = new ReviewDTO(starGrade, reviewDetail, newReviewCode);
		ReviewController.reviewUpdate(review);
	}
	

	
	/**
	 * �Ǹ��� ��û��
	 * @param userId 
	 */
	private static void storeRegis(String userId) {
		int categoryCode =0;
		
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                             [ �Ǹ��� ��û�� ]                              \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.�Ǹ��� ��û            2.�Ǹ��� ��û ���� ��� ��ȸ             3.�ڷΰ���");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int storeRegis = Integer.parseInt(sc.nextLine());
		switch(storeRegis) {
		case 1:
			System.out.println("* * * ���� �̸��� �Է����ּ���. >> "); //���̺��� �ڸ��� �÷��ּ���.
			String storeName = sc.nextLine();
			
			System.out.println("* * * ���� �ּҸ� �Է����ּ���. >> ");//���̺��� �ڸ��� �÷��ּ���.
			String storeAddr = sc.nextLine();
			
			System.out.println("* * * ���� ��ȭ��ȣ�� �Է����ּ���. >> ");
			String storePhone = sc.nextLine();
			
			System.out.println("* * * ����ڵ�Ϲ�ȣ�� �Է����ּ���. >> ");
			String storeBusinessNo = sc.nextLine();
			
			boolean run = true;
			while(run) {
			System.out.println("* * * ���� ī�װ� �� 1������ �Է����ּ���. >> ");
			System.out.println("(1.���   2.�߽�   3.�ѽ�)");
				categoryCode = Integer.parseInt(sc.nextLine());
				switch(categoryCode) {
					case 1:
						run = false;
						break;
					case 2:
						run = false;
						break;
					case 3 : 
						run = false;
						break;
					default : 
						System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
						break;
						
				}
			}
			
			
			System.out.println("* * * ���� ������ �Է����ּ���. >> ");//���̺��� �ڸ��� ���� Ǯ���ּ���.
			String storeDetail = sc.nextLine();
			
			System.out.println("* * * ��޷Ḧ �Է����ּ���. >> ");
			int delivery_fee = Integer.parseInt(sc.nextLine());
			
			StoresDTO store = new StoresDTO(userId, storeName, storeAddr, storePhone, storeBusinessNo, categoryCode,  storeDetail,  delivery_fee);

			storeRegister(store);
			break;
			
		case 2:
			System.out.println("----------------------------------------------------------------------------\n");
			System.out.println("      ���� ��û��            ���� ��û ��Ȳ            ���� ��û ������     ");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			StoresController.regisCheck(userId);;
			System.out.println("----------------------------------------------------------------------------");
			storeRegis(userId);
			break;
			
		case 3:
			mypage(userId);
			break;
			
		default :
			System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
			storeRegis(userId);
			break;
		}
		 
	}
	
	/**
	 * �Ǹ��ڽ�û�� ���� ����Ȯ�� ����!!!
	 * @param userId 
	 */
	private static void storeRegister(StoresDTO store) {		
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.��û�ϱ�          2.����ϱ�");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
		
		int storeRegister = Integer.parseInt(sc.nextLine());
		switch(storeRegister) {
			case 1:
				StoresController.storeInsert(store);
				storeRegis(store.getUser_id());
				break;
			case 2:				
				System.out.println("�Ǹ��� ��û�� ��ҵǾ����ϴ�.");
				storeRegis(store.getUser_id());
				break;
			default :
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				storeRegister(store);
				break;
		}//switch��
	}
}
