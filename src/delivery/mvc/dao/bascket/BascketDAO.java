package delivery.mvc.dao.bascket;
/**
 * ��ٱ��� ������ �����ͺ��̽��� ���� �Ǵ� �о���� Ŭ����
 */
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BascketDTO;

public interface BascketDAO {
	/**
	 * ��ٱ��� ��ü�˻�
	 */
	List<BascketDTO> bascketSelectAll(String users_id) throws SQLException;
	
	/**
	 * ��ٱ��� ���(�߰�)�ϱ�
	 */
	int bascketInsert(BascketDTO bascket) throws SQLException;
	
	/**
	 * ��ٱ��� ����(����)�ϱ�
	 */
	int bascketUpdate(BascketDTO bascket, int num) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	int  bascketDelete(List<BascketDTO> list) throws SQLException;	
}
