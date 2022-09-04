package delivery.mvc.dao.basket;
/**
 * ��ٱ��� ������ �����ͺ��̽��� ���� �Ǵ� �о���� Ŭ����
 */
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;

public interface BasketDAO {
	/**
	 * ��ٱ��� ��ü�˻�
	 */
	List<BasketDTO> basketSelectAll(String users_id) throws SQLException;
	
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
	int basketDelete(String users_id) throws SQLException;
}
