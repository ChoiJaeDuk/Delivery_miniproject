package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BascketDTO;

public interface BascketService {
	/**
	 * 장바구니 조회하기
	 */
	public List<BascketDTO> bascketSelectAll(String user_id) throws SQLException;
	
	/**
	 * 장바구니 등록(추가)하기
	 */
	public int bascketInsert(BascketDTO bascket) throws SQLException;
	
	/**
	 * 장바구니 수정하기
	 */
	public int bascketUpdate(BascketDTO bascket, int num) throws SQLException;
	
	/**
	 * 장바구니 삭제(결제)하기
	 */
	public int bascketDelete(List<BascketDTO> list) throws SQLException;
}
