package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.session.SessionSet;


public class StoreArrange {

	//UserOrdersView uov = new UserOrdersView();
	static int category = UserOrdersView.category;
	static int subFoodList;
	
	static Scanner sc = new Scanner(System.in);
	//UserOrdersView uo = new UserOrdersView();
	
	
	
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
				//UserCategorySelect.totalStoreList(); 
			
				StoresController.storesSelectAll("ORDER BY ORDER_COUNT DESC");
				break;
			case 2:
				//UserCategorySelect.totalStoreList(); 
				
				StoresController.storesSelectAll("ORDER BY STAR_AVG DESC");
				break;
			case 3:
				StoresController.storesSelectAll("ORDER BY STORE_DELIVERY_FEE");
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
	public static void menuarrange(String menuName) {
		//System.out.println("\n\n-------------------------------------------------------------------");
		//System.out.println("1.주문 많은 순    2.평점 높은 순    3.배달팁 낮은 순     4.뒤로가기");
		//System.out.println("-------------------------------------------------------------------");
		
		arrangeLayout();
		
		
		int menuarrange = Integer.parseInt(sc.nextLine());

		switch(menuarrange) {
			case 1:
			
				StoresController.storesSelectByMenu("ORDER BY ORDER_COUNT DESC", menuName);
				break;
			case 2:
			
				StoresController.storesSelectByMenu("ORDER BY STAR_AVG DESC", menuName);
				break;
			case 3:
			
				StoresController.storesSelectByMenu("ORDER BY STORE_DELIVERY_FEE", menuName);
				break;
			case 4:
				UserOrdersView.storeSelect(1);
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				menuarrange(menuName);
				break;
		}//switch끝
	}
	
	/**
	 * 하위 카테고리 정렬(피자, 찌개, ...)
	 */
	
	public static void categoryArrange(int categoryCode) {
		SessionSet ss = SessionSet.getInstance();
		   String userId = ss.getSet().iterator().next().getSessionId();
		arrangeLayout();
		

		int categoryArrange = Integer.parseInt(sc.nextLine());
		switch(categoryArrange) {
			case 1:
				 
				StoresController.storesSelectByCategory("ORDER BY ORDER_COUNT DESC", categoryCode);
				
				//System.out.println("주문 많은 순서로 하위카테고리 포함된 가게 목록 불러오기\n\n\n\n");
				break;
			case 2:
	
				StoresController.storesSelectByCategory("ORDER BY STAR_AVG DESC", categoryCode);
				break;
			case 3:
				
				StoresController.storesSelectByCategory("ORDER BY STORE_DELIVERY_FEE", categoryCode);
				break;
			case 4:
				UserOrdersView.category(category, userId);
				//UserOrdersView.subFood(subFoodList);
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				categoryArrange(categoryCode);
				break;
		}//switch끝) 
	}	
}
