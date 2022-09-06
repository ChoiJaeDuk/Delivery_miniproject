package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.view.actor.AdminView;

/**
 * 후기관리 - 가게목록
 */
public class ReviewControlView {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void storeList() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ 가게 목록 ]                         \n");
		System.out.println("              가게코드           가게 이름\n");
		System.out.println("----------------------------------------------------------------\n");
		StoresController.storesNameCodeSelectAll();
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("* * * 가게코드를 입력해주세요. >> ");
		int storeCode = Integer.parseInt(sc.nextLine());
		
		reviewList();
		
	}
	
	/**
	 * 후기목록-------------------------------------------수정해야됨
	 */
	public static void reviewList() {
		
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("                          [ 후기 목록 ]                         \n");
			System.out.println("      후기 코드         가게 이름           후기         평점   ");
			System.out.println("----------------------------------------------------------------\n");
			
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("1.후기 삭제하기       2.뒤로가기");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int reviewList = Integer.parseInt(sc.nextLine());
			
			switch(reviewList) {
				case 1:
					System.out.println("* * * 삭제할 후기 코드를 입력해주세요. >> ");
					int reviewCode = Integer.parseInt(sc.nextLine());
					reviewList();//삭제된 목록 조회!!
					break;
				case 2:
					AdminView.admin(null);
					break;
				default :
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					reviewList();
					break;
			}
		
		
	}
	
	
	/**
	 * 후기삭제
	 */
	
	public static void reviewDelete() {
		reviewList();
		int reviewList = Integer.parseInt(sc.nextLine());
		switch(reviewList) {
			case 1:
				System.out.println("* * * 삭제할 후기 코드를 입력해주세요. >> ");
				int reviewCode = Integer.parseInt(sc.nextLine());
				return;
			case 2:
				storeList();
				break;
			default :
				break;
		}
	}
	
}
