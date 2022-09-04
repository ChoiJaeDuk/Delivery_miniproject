package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BascketDTO;

public interface BascketService {
	/**
	 * ��ٱ��� ��ȸ�ϱ�
	 */
	public List<BascketDTO> bascketSelectAll(String user_id) throws SQLException;
	
	/**
	 * ��ٱ��� ���(�߰�)�ϱ�
	 */
	public int bascketInsert(BascketDTO bascket) throws SQLException;
	
	/**
	 * ��ٱ��� �����ϱ�
	 */
	public int bascketUpdate(BascketDTO bascket, int num) throws SQLException;
	
	/**
	 * ��ٱ��� ����(����)�ϱ�
	 */
	public int bascketDelete(List<BascketDTO> list) throws SQLException;
}
