package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.view.actor.UsersView;

public class CategoriesView {
	static Scanner sc = new Scanner(System.in);
	/**
	 * 중식
	 */
	public static void chineseFood() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ 중식 ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("7.면             8.요리             9.밥             10.뒤로가기");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int chineseFood = Integer.parseInt(sc.nextLine());
		
			switch (chineseFood) {
				case 7:
					//면
				case 8:
					//요리
				case 9:
					//밥
				case 10:										
				//	UsersView.category(); //뒤로가기
					return;				
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}
	
	
	
	
	/**
	 * 한식
	 */
	public static void koreanFood() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ 한식 ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("10.찌개           11.볶음          12.찜/탕          13.뒤로가기");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int koreanFood = Integer.parseInt(sc.nextLine());
		
			switch (koreanFood) {
				case 10:
					//찌개
				case 11:
					//볶음
				case 12:
					//찜/탕
				case 13:										
				//	UsersView.category(); //뒤로가기
					return;				
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");//그 외 번호 입력 시 오류메세지	
					
			}//switch끝	
		}//while끝
	}
	

}
