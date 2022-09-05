package delivery.mvc.service.bascket;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.basket.BasketDAO;
import delivery.mvc.dao.basket.BasketDAOImpl;
import delivery.mvc.dto.BasketDTO;

public class BasketServiceImpl implements BasketService {
	BasketDAO bascketDAO = new BasketDAOImpl();

	@Override
	public List<BasketDTO> bascketSelectAll(String user_id) throws SQLException {
		List<BasketDTO> list = bascketDAO.basketSelectAll(user_id);
		if(list.size()==0 || list.isEmpty()) throw new SQLException("해당 정보가 없습니다");
		return list;
	}

	@Override
	public int bascketInsert(BasketDTO bascket) throws SQLException {
		int result = bascketDAO.basketInsert(bascket);
		if(result==0) throw new SQLException("등록이 실패되었습니다");
		return result;

	}

	@Override
	public int bascketUpdate(BasketDTO bascket, int num) throws SQLException {
		int result = bascketDAO.basketUpdate(bascket, num);
		if(result==0) throw new SQLException("변경이 실패되었습니다");
		return result;
	}

	@Override
	public int bascketDelete(int menu_code, String user_id) throws SQLException {
		int result = bascketDAO.basketDelete(menu_code, user_id);
		if(result==0) throw new SQLException("삭제 실패되었습니다");
		return result;
	}

}
