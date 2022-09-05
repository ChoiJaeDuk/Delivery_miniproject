package delivery.mvc.view.orders;

import java.util.Scanner;



public class StoreArrange {
	static Scanner sc = new Scanner(System.in);
	private static int[] subFoodList;
	//UserOrdersView uo = new UserOrdersView();
	static int c= UserOrdersView.category;
	
	
	/**
	 * 정렬레이아웃
	 */
	
	public static void arrangeLayout() {
		System.out.println("\n\n-------------------------------------------------------------------");
		System.out.println("1.주문 많은 순    2.평점 높은 순    3.배달팁 낮은 순     4.뒤로가기");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
	}
	
	/**
	 * 전제가게 정렬
	 */
	public static void arrange() {
		//System.out.println("\n\n-------------------------------------------------------------------");
		//System.out.println("1.주문 많은 순    2.평점 높은 순    3.배달팁 낮은 순     4.뒤로가기");
		//System.out.println("-------------------------------------------------------------------");
		//System.out.println("* * * 번호를 입력해주세요. >> ");
		arrangeLayout();
		
		int arrange = Integer.parseInt(sc.nextLine());
		
		switch(arrange) {
			case 1:
				UserCategorySelect.totalStoreList(); 
				System.out.println("주문 많은 순서로 전체 가게 목록 불러오기\n\n\n\n");
				break;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("평점 높은 순서로 전체 가게 목록 불러오기\n\n\n\n");
				break;
			case 3:
				System.out.println("배달팁 낮은 순서로 전체 가게 목록 불러오기\n\n\n\n");
				break;
			case 4:
				UserOrdersView.storeSelect(0);
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				arrange();
				break;
		}//switch끝
	}
	
	
	/**
	 * %메뉴% 가게 정렬
	 */
	public static void menuarrange() {
		//System.out.println("\n\n-------------------------------------------------------------------");
		//System.out.println("1.주문 많은 순    2.평점 높은 순    3.배달팁 낮은 순     4.뒤로가기");
		//System.out.println("-------------------------------------------------------------------");
		
		arrangeLayout();
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int menuarrange = Integer.parseInt(sc.nextLine());
		
		switch(menuarrange) {
			case 1:
				UserCategorySelect.menuSelect(); 
				System.out.println("주문 많은 순서로 %메뉴%가 포함된 가게 목록 불러오기\n\n\n\n");
				break;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("평점 높은 순서로 %메뉴%가 포함된 가게 목록 불러오기\n\n\n\n");
				break;
			case 3:
				System.out.println("배달팁 낮은 순서로 %메뉴%가 포함된 가게 목록 불러오기\n\n\n\n");
				break;
			case 4:
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				menuarrange();
				break;
		}//switch끝
	}
	
	/**
	 * 하위 카테고리 정렬(피자, 찌개, ...)
	 */
	
	public static void categoryArrange() {
		arrangeLayout();
		
		
		
		int categoryArrange = Integer.parseInt(sc.nextLine());
		switch(categoryArrange) {
			case 1:
				UserCategorySelect.menuSelect(); 
				System.out.println("주문 많은 순서로 하위카테고리 포함된 가게 목록 불러오기\n\n\n\n");
				break;
			case 2:
				UserCategorySelect.totalStoreList(); 
				System.out.println("평점 높은 순서로 하위카테고리가 포함된 가게 목록 불러오기\n\n\n\n");
				break;
			case 3:
				System.out.println("배달팁 낮은 순서로 하위카테고리가 포함된 가게 목록 불러오기\n\n\n\n");
				break;
			case 4:
				UserOrdersView.category(c);
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				menuarrange();
				break;
		}//switch끝) 
	}	
}