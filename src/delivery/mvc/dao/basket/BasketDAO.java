package delivery.mvc.dao.basket;

import java.sql.Connection;
/**
 * ��ٱ��� ������ �����ͺ��̽��� ���� �Ǵ� �о���� Ŭ����
 */
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;

public interface BasketDAO {
	/**
	 * ��ٱ��� ��ü�˻�
	 */
	List<BasketDTO> basketSelectAll(String users_id) throws SQLException;
	
	/**
	 * ��ٱ��� �˻�
	 */
	List<MenuDTO> basketMenuSelect(String users_id) throws SQLException;
	
	/**
	 * ��ٱ��� ���(�߰�)�ϱ�
	 */
	int basketInsert(BasketDTO bascket) throws SQLException;
	
	/**
	 * ��ٱ��� ����(����)�ϱ�
	 */
	int basketUpdate(BasketDTO bascket, int num) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	int  basketDelete(int menu_code, String users_id) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	int basketDelete(Connection con, OrdersDTO orders) throws SQLException;
}
