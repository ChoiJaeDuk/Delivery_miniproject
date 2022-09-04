package delivery.mvc.dao.menu;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BascketDTO;
import delivery.mvc.dto.MenuDTO;

/**
 * 메뉴 정보를 데이터베이스에 저장 또는 읽어오는 인터페이스
 */
public interface MenuDAO {
	/**
	 * 메뉴 전체검색
	 */
	List<MenuDTO> menuSelectAll(int store_id) throws SQLException;
	
	/**
	 * 메뉴 등록하기
	 */
	int menuInsert(MenuDTO menu) throws SQLException;
	
	/**
	 * 메뉴 수정하기
	 */
	
	/**
	 * 메뉴 삭제하기
	 */

	int menuUpdate(int menu_code, int price, int status) throws SQLException;

	int menuDelete(int menu_code) throws SQLException;	
	
	
}
