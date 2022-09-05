package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;

public interface BasketService {
	/**
	 * ��ٱ��� ��ȸ�ϱ�
	 */
	 List<BasketDTO> bascketSelectAll(String user_id) throws SQLException;
	
	/**
	 * ��ٱ��� �˻�
	 */
	 List<MenuDTO> basketMenuSelect(String users_id) throws SQLException;
	
	/**
	 * ��ٱ��� ���(�߰�)�ϱ�
	 */
	 void bascketInsert(BasketDTO bascket) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	 void bascketUpdate(BasketDTO bascket, int num) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	void bascketDelete(int menu_code, String user_id) throws SQLException;
	
}
