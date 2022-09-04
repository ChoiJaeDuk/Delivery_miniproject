package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.bascket.BascketDAO;
import delivery.mvc.dao.bascket.BascketDAOImpl;
import delivery.mvc.dto.BascketDTO;

public class BascketServiceImpl implements BascketService {
	BascketDAO bascketDAO = new BascketDAOImpl();

	@Override
	public List<BascketDTO> bascketSelectAll(String user_id) throws SQLException {
		List<BascketDTO> list = bascketDAO.bascketSelectAll(user_id);
		if(list.size()==0 || list.isEmpty()) throw new SQLException("�ش� ������ �����ϴ�");
		return list;
	}

	@Override
	public int bascketInsert(BascketDTO bascket) throws SQLException {
		int result = bascketDAO.bascketInsert(bascket);
		if(result==0) throw new SQLException("����� ���еǾ����ϴ�");
		return result;

	}

	@Override
	public int bascketUpdate(BascketDTO bascket, int num) throws SQLException {
		int result = bascketDAO.bascketUpdate(bascket, num);
		if(result==0) throw new SQLException("������ ���еǾ����ϴ�");
		return result;
	}

	@Override
	public int bascketDelete(int menu_code, String user_id) throws SQLException {
		int result = bascketDAO.bascketDelete(menu_code, user_id);
		if(result==0) throw new SQLException("���� ���еǾ����ϴ�");
		return result;
	}

	@Override
	public int bascketDelete(String users_id) throws SQLException {
		int result = bascketDAO.bascketDelete(users_id);
		if(result==0) throw new SQLException("���� ���еǾ����ϴ�");
		return result;
	}

}
