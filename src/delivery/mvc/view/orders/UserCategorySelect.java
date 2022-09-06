package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;

public class UserCategorySelect {
	static Scanner sc = new Scanner(System.in);


	/**
	 * 가게조회 레이아웃
	 */
	
	public static void selectLayout() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ 가게 목록 ]                         \n");
		System.out.println("가게코드    가게이름      배달팁          후기/평점       주문건");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
	}
	
	/**
	 * 전체 가게 목록 조회
	 */
	public static void totalStoreList() {
		selectLayout();
		//StoresController.storesInfoSelectAll();
		StoresController.storesSelectAll();
		
	}
	
	/**
	 * %메뉴% 검색 -가게 목록 조회
	 */
	public static void menuSelect() {
		System.out.println("* * * 메뉴이름을 입력해주세요. >> ");
		String menuName =sc.nextLine();
		
			selectLayout();

		StoresController.storesSelectByMenu(menuName);
	}

}
