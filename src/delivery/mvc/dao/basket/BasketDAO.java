package delivery.mvc.dao.basket;

import java.sql.Connection;
/**
 * 장바구니 정보를 데이터베이스에 저장 또는 읽어오는 클래스
 */
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;

public interface BasketDAO {
	/**
	 * 장바구니 전체검색
	 */
	List<BasketDTO> basketSelectAll(String users_id) throws SQLException;
	
	/**
	 * 장바구니 검색
	 */
	List<MenuDTO> basketMenuSelect(String users_id) throws SQLException;
	
	/**
	 * 장바구니 등록(추가)하기
	 */
	int basketInsert(BasketDTO bascket) throws SQLException;
	
	/**
	 * 장바구니 수정(수량)하기
	 */
	int basketUpdate(BasketDTO bascket, int num) throws SQLException;
	
	/**
	 * 장바구니 삭제하기
	 */
	int  basketDelete(int menu_code, String users_id) throws SQLException;
	
	/**
	 * 장바구니 결제하기
	 */
	int basketDelete(Connection con, OrdersDTO orders) throws SQLException;
}
