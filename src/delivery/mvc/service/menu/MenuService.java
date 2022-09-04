package delivery.mvc.service.menu;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;

public interface MenuService {
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
	int menuUpdate(int menu_code, int price, int status) throws SQLException;

	/**
	 * 메뉴 삭제하기
	 */
	int menuDelete(int menu_code) throws SQLException;	
}
