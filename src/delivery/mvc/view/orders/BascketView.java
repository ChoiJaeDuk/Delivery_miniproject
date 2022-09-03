package delivery.mvc.view.orders;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class BascketView {
	static Scanner sc = new Scanner(System.in);
	/**
	 * 장바구니 조회
	 */
	public static void bascket() {
		
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("                              [ 장바구니 ]                          ");
			System.out.println();
			System.out.println("메뉴 코드     가게이름              메뉴이름           수량     가격");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
			System.out.println("\n\n\n\n");// 장바구니에 담긴 내역
			System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("총 금액 : " + "???원");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.수량 수정하기      2.메뉴 삭제하기      3.주문하기      4.뒤로가기");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int bascket = Integer.parseInt(sc.nextLine());
		
			switch (bascket) {
				case 1:
					//수량 수정하기
				case 2:
					//메뉴 삭제하기
				case 3:
					//주문하기
				case 4:
					UsersView.users(); //뒤로가기
					return;
				
				//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}

}
