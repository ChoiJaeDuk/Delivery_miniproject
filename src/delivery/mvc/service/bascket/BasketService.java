package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;

public interface BasketService {
	/**
	 * 장바구니 조회하기
	 */
	public List<BasketDTO> bascketSelectAll(String user_id) throws SQLException;
	
	/**
	 * 장바구니 등록(추가)하기
	 */
	public int bascketInsert(BasketDTO bascket) throws SQLException;
	
	/**
	 * 장바구니 수정하기
	 */
	public int bascketUpdate(BasketDTO bascket, int num) throws SQLException;
	
	/**
	 * 장바구니 삭제하기
	 */
	int bascketDelete(int menu_code, String user_id) throws SQLException;
	
}
