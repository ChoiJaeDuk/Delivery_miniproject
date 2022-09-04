package delivery.mvc.view.orders;

import delivery.mvc.view.actor.UsersView;
import java.util.Scanner;

public class OrdersView {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * 가게검색
	 */
	public static void storeSelect() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                          [ 가게 목록 ]                         ");
			System.out.println();
			System.out.println("가게코드     가게이름          배달팁         후기/평점   주문건");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
			System.out.println("\n\n\n\n");// 전체가게목록
			System.out.println("----------------------------------------------------------------");
			System.out.println("1.가게 선택                  2.정렬                   3.뒤로가기");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int storeSelect = Integer.parseInt(sc.nextLine());
		
			switch (storeSelect) {
				case 1:
					//가게선택
				case 2:
					//정렬
				case 3:															
				//	UsersView.category(); //뒤로가기
					return;				
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}
	

	
	/**
	 * 메뉴검색
	 */
	public static void menuSelect() {
		
			System.out.println("* * * 메뉴 이름을 입력해주세요.(예시:김치) >> ");		
			int storeSelect = Integer.parseInt(sc.nextLine());
			
			//입력받은 메뉴를 파는 가게 목록 가져오기.
			//가게검색 메소드 이용하기 storeSelect();
			
		
	}
	
	
}
