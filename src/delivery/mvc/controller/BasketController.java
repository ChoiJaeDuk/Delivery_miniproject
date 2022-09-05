package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
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
						+"\t"+menu.getMenu_price()
						+"\t"+menu.getBascket().getBasket_quantity());
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//basketMenuSelect() end
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ȸ���� ��ٱ��Ͽ� ����ִ� �޴����� ������ �����ϴ� �޼ҵ�
	 */
	
	public static void basketUpdate(BasketDTO basket, int num) {
		try {
			service.bascketUpdate(basket, num);
			System.out.println("�����Ǿ����ϴ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}//BasketController end