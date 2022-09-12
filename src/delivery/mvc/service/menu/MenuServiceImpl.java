package delivery.mvc.service.menu;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.menu.MenuDAO;
import delivery.mvc.dao.menu.MenuDAOImpl;
import delivery.mvc.dto.MenuDTO;

public class MenuServiceImpl implements MenuService {
	private MenuDAO menuDAO= new MenuDAOImpl();

	/**
	 * 해당 가게의 메뉴 전체 검색
	 */
	@Override
	public List<MenuDTO> menuSelectAll(int store_id) throws SQLException {
		List<MenuDTO> list = menuDAO.menuSelectAll(store_id);
		if(list.size()==0 || list.isEmpty()) throw new SQLException("정보가 존재하지 않습니다");
		return list;
	}

	/**
	 * 메뉴 등록
	 */
	@Override
	public void menuInsert(MenuDTO menu) throws SQLException {
		int result = menuDAO.menuInsert(menu);
		if(result==0) throw new SQLException("등록 실패");
	}

	/**
	 * 메뉴 수정
	 */
	@Override
	public void menuUpdate(MenuDTO menu) throws SQLException {
		int result = menuDAO.menuUpdate(menu);
		if(result==0) throw new SQLException("변경 실패");
	}

	/**
	 * 메뉴 삭제
	 */
	@Override
	public void menuDelete(int menu_code) throws SQLException {
		int result = menuDAO.menuDelete(menu_code);
		if(result==0) throw new SQLException("삭제 실패");
	}
}
