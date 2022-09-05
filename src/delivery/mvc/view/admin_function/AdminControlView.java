package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.view.actor.AdminView;

/**
 * 운영관리
 */
public class AdminControlView {
	
	static Scanner sc = new Scanner(System.in);

	public static void adminControl() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.가게 관리                2.매출 현황 조회               3.뒤로가기");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int adminControl = Integer.parseInt(sc.nextLine());
		switch(adminControl) {
			case 1:
				System.out.println("* * * 가게 코드를 입력해주세요. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				storeControl();				
				break;
				
			case 2:
				break;
			case 3:
				AdminView.admin();
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				adminControl();
				break;
		}//switch끝
	}
	
	
	
	/**
	 * 가게관리
	 */
	public static void storeControl() {
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                [ " + "storeName" + " 가게 정보 ]                   \n");
		System.out.println("가게정보 불러오기!!   \n\n\n\n");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.판매자 신청 승인하기     2.판매자 신청 거부하기     3.뒤로가기");
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	
	/**
	 * 매출현황조회
	 */
	

}
