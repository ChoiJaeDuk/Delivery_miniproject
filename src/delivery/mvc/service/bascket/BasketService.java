package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;

public interface BasketService {
	/**
	 * 장바구니 조회하기
	 */
	 List<BasketDTO> bascketSelectAll(String user_id) throws SQLException;
	
	/**
	 * 장바구니 검색
	 */
	 List<MenuDTO> basketMenuSelect(String users_id) throws SQLException;
	
	/**
	 * 장바구니 등록(추가)하기
	 */
	 void bascketInsert(BasketDTO bascket) throws SQLException;
	
	/**
	 * 장바구니 수정하기
	 */
	 void bascketUpdate(BasketDTO bascket, int num) throws SQLException;
	
	/**
	 * 장바구니 삭제하기
	 */
	void bascketDelete(int menu_code, String user_id) throws SQLException;
	
}
