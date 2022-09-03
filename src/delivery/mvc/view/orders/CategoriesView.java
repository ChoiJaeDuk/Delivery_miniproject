package delivery.mvc.view.orders;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class CategoriesView {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * 양식
	 */
	public static void westernFood() {
		while(true) {
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ 양식 ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("4.피자          5.파스타          6.스테이크          7.뒤로가기");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int westernFood = Integer.parseInt(sc.nextLine());
		
			switch (westernFood) {
				case 4:
					//피자
				case 5:
					//파스타
				case 6:
					//스테이크
				case 7:										
					UsersView.users(); //뒤로가기
					return;
				
				//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}
	
	
	
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
			System.out.println("7.면              8.요리             9.밥             10.뒤로가기");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int chineseFood = Integer.parseInt(sc.nextLine());
		
			switch (chineseFood) {
				case 4:
					//면
				case 5:
					//요리
				case 6:
					//밥
				case 7:										
					UsersView.users(); //뒤로가기
					return;
				
				//그 외 번호 입력 시 오류메세지		
					
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
			System.out.println("                            [ 중식 ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println("10.찌개           11.볶음          12.찜/탕          13.뒤로가기");
			System.out.println("----------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int koreanFood = Integer.parseInt(sc.nextLine());
		
			switch (koreanFood) {
				case 4:
					//찌개
				case 5:
					//볶음
				case 6:
					//찜/탕
				case 7:										
					UsersView.users(); //뒤로가기
					return;
				
				//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}

}
