package delivery.mvc.dao.menu;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BascketDTO;
import delivery.mvc.dto.MenuDTO;

/**
 * �޴� ������ �����ͺ��̽��� ���� �Ǵ� �о���� �������̽�
 */
public interface MenuDAO {
	/**
	 * �޴� ��ü�˻�
	 */
	List<MenuDTO> menuSelectAll(int store_id) throws SQLException;
	
	/**
	 * �޴� ����ϱ�
	 */
	int menuInsert(MenuDTO menu) throws SQLException;
	
	/**
	 * �޴� �����ϱ�
	 */
	
	/**
	 * �޴� �����ϱ�
	 */

	int menuUpdate(int menu_code, int price, int status) throws SQLException;

	int menuDelete(int menu_code) throws SQLException;	
	
	
}
