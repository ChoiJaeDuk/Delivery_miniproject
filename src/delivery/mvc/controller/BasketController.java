package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.service.bascket.BasketService;
import delivery.mvc.service.bascket.BasketServiceImpl;

public class BasketController {
	private static BasketService service = new BasketServiceImpl();

	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ȸ���� ��ٱ��Ͽ� ����Ǿ��ִ� �޴����� �������� �޼ҵ�
	 */
	public static void basketMenuSelect(String user_id) {
		try {
			List<MenuDTO> list = service.basketMenuSelect(user_id);
			System.out.println(list);
			for(MenuDTO menu : list) {
				System.out.print(menu.getMenu_code()
						+"\t"+menu.getMenu_name()
						+"\t"+menu.getMenu_price());
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//basketMenuSelect() end
	
	/**
	 * 
	 */
}//BasketController end