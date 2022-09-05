package delivery.mvc.view.orders;

import java.util.Scanner;

public class UserCategorySelect {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 가게검색 - 전체 가게 목록 조회
	 */
	public static void totalStoreList() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ 가게 목록 ]                         \n");
		System.out.println("가게코드    가게이름      배달팁          후기/평점       주문건");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		
	}
	
	/**
	 * 메뉴검색
	 */
	public static void menuSelect() {
		System.out.println("* * * 메뉴이름을 입력해주세요. >> ");
		String menuName =sc.nextLine();
		
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ 가게 목록 ]                         \n");
		System.out.println("가게코드    가게이름      배달팁          후기/평점       주문건");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("%메뉴이름%" + "select 결과 가져오기\n\n\n\n\n");
	}
}
