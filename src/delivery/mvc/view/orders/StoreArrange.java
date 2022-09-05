package delivery.mvc.view.orders;

import java.util.Scanner;

public class StoreArrange {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * 전제가게 정렬
	 */
	public static void arrange() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("1.주문 많은 순    2.평점 높은 순    3.배달팁 낮은 순     4.뒤로가기");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int arrange = Integer.parseInt(sc.nextLine());
		
		switch(arrange) {
			case 1:
				UserCategorySelect.totalStoreList(); 
				System.out.println("주문 많은 순서로 전체 가게 목록 불러오기\n\n\n\n");
				return;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("평점 높은 순서로 전체 가게 목록 불러오기\n\n\n\n");
				return;
			case 3:
				System.out.println("배달팁 낮은 순서로 전체 가게 목록 불러오기\n\n\n\n");
				return;
			case 4:
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				arrange();
				return;
		}//switch끝
	}
	
}
