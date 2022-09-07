package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.view.actor.AdminView;
import delivery.mvc.session.SessionSet;

/**
 * 후기관리 - 가게목록
 */
public class ReviewControlView {
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static void storeList(String userId) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ 가게 목록 ]                         \n");
		System.out.println("              가게코드           가게 이름\n");
		System.out.println("----------------------------------------------------------------\n");
		StoresController.storesNameCodeSelectAll();
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("* * * 가게코드를 입력해주세요. >> ");
		int storeCode = Integer.parseInt(sc.nextLine());
		
		reviewList(storeCode);
		
	}
	
	/**
	 *  운영자가 악성 후기를 삭제한다.
	 */
	public static void reviewList(int storeCode) {
			SessionSet ss = SessionSet.getInstance();
			String userId = ss.getSet().iterator().next().getSessionId();
		
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("                          [ 후기 목록 ]                         \n");
			System.out.println("		후기 코드		회원ID		평점		후기		댓글		등록일		   ");
			System.out.println("----------------------------------------------------------------\n");
			ReviewController.reviewAdmintAll(storeCode);
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("1.후기 삭제하기       2.뒤로가기");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int reviewList = Integer.parseInt(sc.nextLine());
			
			switch(reviewList) {
				case 1:
					System.out.println("* * * 삭제할 후기 코드를 입력해주세요. >> ");
					int reviewCode = Integer.parseInt(sc.nextLine());
					ReviewController.reviewDelete(reviewCode);
					reviewList(storeCode);//삭제된 목록 조회!!
					break;
				case 2:
					AdminView.admin(userId);
					break;
				default :
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					reviewList(storeCode);
					break;
			}	
	}
	
}
