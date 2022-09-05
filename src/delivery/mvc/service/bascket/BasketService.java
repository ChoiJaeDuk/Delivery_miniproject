package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;

public interface BasketService {
	/**
	 * ��ٱ��� ��ȸ�ϱ�
	 */
	public List<BasketDTO> bascketSelectAll(String user_id) throws SQLException;
	
	/**
	 * ��ٱ��� ���(�߰�)�ϱ�
	 */
	public int bascketInsert(BasketDTO bascket) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	public int bascketUpdate(BasketDTO bascket, int num) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	int bascketDelete(int menu_code, String user_id) throws SQLException;
	
}
