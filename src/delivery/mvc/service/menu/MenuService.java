package delivery.mvc.service.menu;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;

public interface MenuService {
	/**
	 * �޴� ��ü�˻�
	 */
	List<MenuDTO> menuSelectAll(int store_id) throws SQLException;

	/**
	 * �޴� ����ϱ�
	 */
	void menuInsert(MenuDTO menu) throws SQLException;

	/**
	 * �޴� �����ϱ�
	 */
	void menuUpdate(int menu_code, int price, int status) throws SQLException;

	/**
	 * �޴� �����ϱ�
	 */
	void menuDelete(int menu_code) throws SQLException;	
}
