package delivery.mvc.view.user;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class mypageView {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 *  마이페이지
	 */
	public static void mypage() {
		while(true) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ 마이페이지 ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1.개인정보 수정   2.주문내역   3.후기   4.판매자 신청하기   5.뒤로가기");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int mypage = Integer.parseInt(sc.nextLine());
		
			switch (mypage) {
				case 1:
					//개인정보 수정
				case 2:
					//주문내역
				case 3:
					//후기
				case 4:
					//판매자 신청하기
				case 5:					
					UsersView.users(); //뒤로가기
					return;
				
				//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}
}
