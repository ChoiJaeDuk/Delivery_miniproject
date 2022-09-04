package delivery.mvc.dao.bascket;
/**
 * 장바구니 정보를 데이터베이스에 저장 또는 읽어오는 클래스
 */
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BascketDTO;

public interface BascketDAO {
	/**
	 * 장바구니 전체검색
	 */
	List<BascketDTO> bascketSelectAll(String users_id) throws SQLException;
	
	/**
	 * 장바구니 등록(추가)하기
	 */
	int bascketInsert(BascketDTO bascket) throws SQLException;
	
	/**
	 * 장바구니 수정(수량)하기
	 */
	int bascketUpdate(BascketDTO bascket, int num) throws SQLException;
	
	/**
	 * 장바구니 삭제하기
	 */
	int  bascketDelete(List<BascketDTO> list) throws SQLException;	
}
