package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.view.actor.UsersView;

public class UserOrdersView {
	
	private static final String usersId = null;


	public static void main(String[] args) {
		deliveryMenu();
		
	}
	
	static Scanner sc = new Scanner(System.in);
	static int category = 0;
	
	
	/**
	 *  양식,중식,한식 검색
	 *  가게, 메뉴 검색
	 */
	public static void deliveryMenu() {
		while(true) {
			
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.양식   2.중식   3.한식   4.가게 검색   5.메뉴 검색   6. 뒤로가기  ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			category = Integer.parseInt(sc.nextLine());
			
			switch(category) {
				case 1:
					category(category);
					break;
				case 2:
					category(category);
					break;
				case 3:
					category(category);
					break;
				case 4:
					UserCategorySelect.totalStoreList(); 				
					storeSelect(9, 0); //두번째 인수 index는 0이면 전체 가게 목록 select, 1이면 %메뉴% 포함한 가게목록 select
					break;
				case 5:
					UserCategorySelect.menuSelect();
					storeSelect(9, 1);//두번째 인수 index는 0이면 전체 가게 목록 select , 1이면 %메뉴% 포함한 가게목록 select
					break;
				case 6:
					UsersView.users(usersId);
					return;
					
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				
			}
			
						
			
		}//while끝
	}

	
	
	/**s
	 * 음식 카테고리
	 */
	public static void category(int category) {
		
		switch(category) {
			case 1:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ 양식 ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("4.피자          5.파스타          6.스테이크         13.뒤로가기");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * 번호를 입력해주세요. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category);
				return;
			
			case 2:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ 중식 ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("7.면             8.요리             9.밥             13.뒤로가기");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * 번호를 입력해주세요. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category);
				return;
			
			case 3:
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("                            [ 한식 ]                            \n");
				System.out.println("----------------------------------------------------------------");
				System.out.println("10.찌개           11.볶음          12.찜/탕          13.뒤로가기");
				System.out.println("----------------------------------------------------------------\n");
				
				System.out.println("* * * 번호를 입력해주세요. >> ");
				category =Integer.parseInt(sc.nextLine());
				
				subFood(category);
				return;
			
			case 13:
				deliveryMenu();
				return;
		
			default:
			   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
		}//switch끝
		
		
	}

	
	/**
	 * 하위 카테고리 - 가게목록
	 */
	public static void subFood(int subFood) {
		
		//while(true) {
			//System.out.println("* * * 번호를 입력해주세요. >> ");
			//int subFood =Integer.parseInt(sc.nextLine());
			
			switch(subFood) {
				case 4:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ 피자 가게 목록 ]                       \n");
										
					subFoodList(4);
					//storeSelect();
					return;
				
				case 5:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                     [ 파스타 가게 목록 ]                       \n");
										
					subFoodList(5);
					//storeSelect();
					return;
				
				case 6:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                    [ 스테이크 가게 목록 ]                      \n");
										
					subFoodList(6);
					//storeSelect();
					return;
				
				case 7:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ 면 가게 목록 ]                         \n");
										
					subFoodList(7);
					//storeSelect();
					return;
				
				case 8:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ 요리 가게 목록 ]                        \n");
										
					subFoodList(8);
					//storeSelect();
					return;
				
				case 9:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                       [ 밥 가게 목록 ]                         \n");
										
					subFoodList(9);
					//storeSelect();
					return;
				
				case 10:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ 찌개 가게 목록 ]                        \n");
										
					subFoodList(10);
					//storeSelect();
					return;
				
				case 11:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ 볶음 가게 목록 ]                        \n");
										
					subFoodList(11);
					//storeSelect();
					return;
				
				case 12:
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("                      [ 찜/탕 가게 목록 ]                       \n");
										
					subFoodList(12);
					//storeSelect();
					return;
				
				case 13:
					deliveryMenu();
					return;
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					   category(category);
		
			}//switch끝
		//}//while끝
	}//subFood메소드끝
	
	
	

	public static int subFoodList(int subFoodList) {
		

		System.out.println("가게코드    가게이름      배달팁          후기/평점       주문건");		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		
		switch(subFoodList ) {//subFoodList에 가게목록을 담아서 리턴해준다.
			case 4:
				System.out.println("피자 가게목록\n\n\n\n");
				storeSelect(9, 2);
				break;
			case 5:
				System.out.println("파스타 가게목록\n\n\n\n");
				storeSelect(9, 2);
				break;
			case 6:
				System.out.println("스테이크 가게목록\n\n\n\n");
				storeSelect(9, 2);
				break;
			case 7:
				System.out.println("면 가게목록");
				storeSelect(9, 2);
				break;
			case 8:
				System.out.println("요리 가게목록");
				storeSelect(9, 2);
				break;
			case 9:
				System.out.println("밥 가게목록");
				storeSelect(9, 2);
				break;
			case 10:
				System.out.println("찌개 가게목록");
				storeSelect(9, 2);
				break;
			case 11:
				System.out.println("볶음 가게목록");
				storeSelect(9, 2);
				break;
			case 12:
				System.out.println("찜/탕 가게목록");
				storeSelect(9, 2);
				break;
			
		}//switch끝
		
		return subFoodList;
	}
	
	
	public static void storeSelect(int subFoodList , int ...index ) {//index=0이면arragne(), =1 menuarrage() 
		System.out.println("----------------------------------------------------------------");
		System.out.println("1.가게선택                   2.정렬                   3.뒤로가기");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int storeSelect =Integer.parseInt(sc.nextLine());
		
		switch(storeSelect) {
			case 1:
				System.out.println("* * * 가게 코드를 입력해주세요. >> ");
				int storeCode =Integer.parseInt(sc.nextLine());
				stores(subFoodList);
				break;
			case 2:
				if (index[0] == 0)
					// 하위카테고리(예:피자)만 파는 가게목록을 띄워줘야함. ???? 사용자 입력값에 따라 가게목록 호출해야하는데.....어렵다...
					StoreArrange.arrange(); // 전체가게조회 --> 전체 가게목록을 정렬해서 출력해야함.
				else if (index[0] == 1)
					StoreArrange.menuarrange(); // %메뉴%를 파는 가게 목록 정렬하기...
				else if(index[0] == 2)
					StoreArrange.categoryArrange();
				break;
			
			case 3:
				deliveryMenu();
				//category(category);
				//subFood(subFoodList); //3 , 4 , 
				return;
			case 4 :
				category(category);
				 //subFood(subFoodList); //3 , 4 , 
				break;
		
			default:
				   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				   subFood(storeSelect);
				   return;
		}//switch끝
	}

	
	/**
	 * 가게
	 */
	public static void stores( int ... subFoodList) {
				
		System.out.println("----------------------------------------------------------------");
		System.out.println("                      [ " + "가게이름" + " ]                    \n");
		System.out.println("가게를 소개하는 부분입니다. 가게를 소개해주세요. 안녕하세요.    \n\n\n");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("1.메뉴 선택             2.후기             3.뒤로가기           ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int stores = Integer.parseInt(sc.nextLine());
		switch(stores) {
			case 1:
				menu();
				break;
			case 2:
				StoreReviewView.review();
				break;
			case 3:
				//deliveryMenu();
				subFoodList(subFoodList[0]); //[0]의미는 뭘까.....? 초기화??????
				return;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				stores();
				return;
		}//switch끝
	}
	
	
	
	
	/**
	 * 메뉴
	 */
	public static void menu() {
		System.out.println("\n\n----------------------------------------------------------------");
		System.out.println("                            [ 메뉴 ]                            \n");
		System.out.println("1.메뉴코드                  2.메뉴이름                   3.가격");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("메뉴목록\n\n\n\n");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("1.주문하기          2.장바구니(결제)          3.뒤로가기");
		System.out.println("----------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int menu = Integer.parseInt(sc.nextLine());
		switch(menu) {
			case 1:			
				System.out.println("* * * 메뉴코드를 입력해주세요. >> ");
				menu = Integer.parseInt(sc.nextLine());
				
				System.out.println("* * * 수량을 입력해주세요. >> ");
				menu = Integer.parseInt(sc.nextLine());
				
				menu();
				break;
				
			case 2:
				UserBascketView.bascket();
				break;
				
			case 3:
				stores();
				break;
				
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				menu();
				return;
			
		}
	}
	
	
}