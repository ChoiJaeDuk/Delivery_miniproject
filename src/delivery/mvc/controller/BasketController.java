package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.exception.NotFoundException;
import delivery.mvc.service.bascket.BasketService;
import delivery.mvc.service.bascket.BasketServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.SuccessView;

public class BasketController {
	private static BasketService service = new BasketServiceImpl();

	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 회원의 장바구니에 저장되어있는 메뉴들을 가져오는 메소드
	 */
	public static void basketMenuSelect(String user_id) {
		try {
			List<MenuDTO> list = service.basketMenuSelect(user_id);
			System.out.println(list);
			SuccessView.basketMenuSelect(list);
		
		} catch (SQLException e) {
			FailView.errorMessage("장바구니가 비어있습니다.");
		}
	}//basketMenuSelect() end
	
	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 회원이 메뉴를 장바구니에 담을 때 데이터 데이터베이스 저장되는 메소드
	 */
	public static void basketInsert(BasketDTO basket) {
		try {
			List<BasketDTO> basketList = service.bascketSelectAll(basket.getUser_id());
			for (BasketDTO basketDto : basketList) {
				if (basket.getStore_code() != basketDto.getStore_code()) throw new SQLException("같은 가게의 메뉴만 주문 가능합니다!");
			}
			service.bascketInsert(basket);
			SuccessView.getmessagePrint("장바구니에 추가되었습니다");
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 회원의 장바구니에 담겨있는 메뉴들의 수량을 수정하는 메소드
	 */
	public static void basketUpdate(BasketDTO basket, int num) {
		try {
			service.bascketUpdate(basket, num);
			SuccessView.getmessagePrint("수량 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 회원의 장바구니에 선택된 메뉴를 삭제하는 메소드
	 */
	public static void basketDelete(int menu_code, String user_id) {
		try {
			service.bascketDelete(menu_code, user_id);
			SuccessView.getmessagePrint("삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}//BasketController end