package delivery.mvc.view.orders;

import java.util.Scanner;

import delivery.mvc.controller.BasketController;
import delivery.mvc.controller.OrdersController;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.view.actor.UsersView;

public class UserBascketView {

	static Scanner sc = new Scanner(System.in);

	/**
	 * 장바구니 조회
	 */
	public static void bascket(String user_id) {
		
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("                              [ 장바구니 ]                          ");
			System.out.println();
			System.out.println("메뉴 코드     가게이름              메뉴이름           수량     가격");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
			BasketController.basketMenuSelect(user_id);
		
			System.out.println("--------------------------------------------------------------------");
			System.out.println("1.수량 수정하기      2.메뉴 삭제하기      3.주문하기      4.뒤로가기");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int bascket = Integer.parseInt(sc.nextLine());
		
			switch (bascket) {
				case 1:
					bascketUpdate(user_id);
					break;
				case 2:
					bascketDelet(user_id);
					break;
				case 3:
					bascketOrder(user_id);
					break;
				case 4:
					UsersView.users(user_id); //뒤로가기
					return;				
				default:
					   System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");//그 외 번호 입력 시 오류메세지		
					
			}//switch끝	
		}//while끝
	}
	
	
	/**
	 * 장바구니 수량 수정
	 */
	public static void bascketUpdate(String user_id) {
		System.out.println("* * * 수정할 메뉴코드를 입력해주세요. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		System.out.println("* * * 수정할 수량을 입력해주세요. >> ");
		int bascketQuantity = Integer.parseInt(sc.nextLine());
		
		BasketController.basketUpdate(new BasketDTO(user_id, menuCode), bascketQuantity);
	}
	
	
	/**
	 * 장바구니 메뉴 삭제
	 */
	public static void bascketDelet(String user_id) {
		System.out.println("* * * 삭제할 메뉴코드를 입력해주세요. >> ");
		int menuCode = Integer.parseInt(sc.nextLine());
		
		BasketController.basketDelete(menuCode, user_id);
	}
	
	/**
	 * 장바구니 주문하기
	 */
	public static void bascketOrder(String user_id) {
		System.out.println("* * * 주문이 완료되었습니다. >> ");
		System.out.println("* * * 주문 승인을 대기 중입니다. >> \n\n");
		OrdersController.insertOrders(user_id);
	}
}
