package delivery.mvc.service.menu;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.menu.MenuDAO;
import delivery.mvc.dao.menu.MenuDAOImpl;
import delivery.mvc.dto.MenuDTO;

public class MenuServiceImpl implements MenuService {
	private MenuDAO menuDAO= new MenuDAOImpl();

	@Override
	public List<MenuDTO> menuSelectAll(int store_id) throws SQLException {
		List<MenuDTO> list = menuDAO.menuSelectAll(store_id);
		if(list.size()==0 || list.isEmpty()) throw new SQLException("정보가 존재하지 않습니다");
		return list;
	}

	@Override
	public void menuInsert(MenuDTO menu) throws SQLException {
		int result = menuDAO.menuInsert(menu);
		if(result==0) throw new SQLException("등록 실패");
	}

	@Override
	public void menuUpdate(int menu_code, int price, int status) throws SQLException {
		int result = menuDAO.menuUpdate(menu_code, price, status);
		if(result==0) throw new SQLException("변경 실패");
	}

	@Override
	public void menuDelete(int menu_code) throws SQLException {
		int result = menuDAO.menuDelete(menu_code);
		if(result==0) throw new SQLException("삭제 실패");
	}
}
