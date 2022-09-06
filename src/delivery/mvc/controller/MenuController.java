package delivery.mvc.controller;

import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.service.menu.MenuService;
import delivery.mvc.service.menu.MenuServiceImpl;

public class MenuController {
	private static MenuService service = new MenuServiceImpl();
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ������ �޴��� �����
	 */
	public static void menuSelectByAll(int store_id) {
		try {
			List<MenuDTO> list = service.menuSelectAll(store_id);
			for(MenuDTO menu : list) {
				System.out.println(menu.getMenu_code()
						+"\t"+menu.getMenu_name()
						+"\t"+menu.getMenu_price());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//menuSelectByAll() end
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ���Կ��� �ۼ��� �޴� ������ �����ͺ��̽��� ������
	 */
	public static void menuInsert(MenuDTO menu) {
		try {
			service.menuInsert(menu);
			System.out.println(menu.getMenu_name()+" �޴��� ��ϵǾ����ϴ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//menuInsert end
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ������ �޴� ������ ������
	 */
	public static void menuUpdate(MenuDTO menu) {
		try {
			service.menuUpdate(menu);
			System.out.println(menu.getMenu_name()+" �޴��� ����Ǿ����ϴ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//menuUpdate end
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ������ �޴��� ������
	 */
	public static void menuDelete(int menu_code) {
		try {
			service.menuDelete(menu_code);
			System.out.println("�޴��� �����Ǿ����ϴ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}//class end
