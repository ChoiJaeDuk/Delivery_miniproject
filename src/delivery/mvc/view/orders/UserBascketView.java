package delivery.mvc.view.orders;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class UserBascketView {
	private static final String usersId = null;
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		bascket();
	}
	
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
					bascketUpdate();
					break;
				case 2:
					bascketDelet();
					break;
				case 3:
					bascketOrder();
					break;
				case 4:
					UsersView.users(usersId); //뒤로가기
					return;				
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}
	
	
	/**
	 * 장바구니 수량 수정
	 */
	public static void bascketUpdate() {
		System.out.println("* * * 수정할 메뉴코드를 입력해주세요. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		System.out.println("* * * 수정할 수량을 입력해주세요. >> ");
		int bascketQuantity = Integer.parseInt(sc.nextLine());
		
		bascket(); //수정 사항 업데이트한 후, 장바구니 조회
	}
	
	
	/**
	 * 장바구니 메뉴 삭제
	 */
	public static void bascketDelet() {
		System.out.println("* * * 삭제할 메뉴코드를 입력해주세요. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		bascket(); //업데이트한 후, 장바구니 조회
	}
	
	/**
	 * 장바구니 주문하기
	 */
	public static void bascketOrder() {
		System.out.println("* * * 주문이 완료되었습니다. >> ");
		System.out.println("* * * 주문 승인을 대기 중입니다. >> \n\n");
		
		UsersView.users(usersId);
	}
	
	

}
