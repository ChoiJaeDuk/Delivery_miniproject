package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.service.menu.MenuService;
import delivery.mvc.service.menu.MenuServiceImpl;
import delivery.mvc.service.stores.StoresService;
import delivery.mvc.service.stores.StoresServiceImpl;

public class MenuController {
	private static MenuService menuservice = new MenuServiceImpl();
	private static StoresService storeservice = new StoresServiceImpl();
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ������ �޴��� �����
	 */
	public static void menuSelectByAll(int store_id) {
		try {
			List<MenuDTO> list = menuservice.menuSelectAll(store_id);
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
	 * ���� : �ش� ���� �ڵ带 �������� ī�װ��� �����
	 */
	public static void menuSelectByStore(String user_id) {
		try {
			StoresDTO store = storeservice.storeSelectById(user_id);
			if(store.getCategory_code()==1) System.out.println("4.�Ľ�Ÿ 5.���� 6. ������ũ");
			else if (store.getCategory_code()==2) System.out.println("7.���� 8.���� 9. ������ũ");
			else if (store.getCategory_code()==1) System.out.println("4.���� 5.���� 6. ������ũ");
			else throw new SQLException("���� ī�װ��� �߸��Ǿ����ϴ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ���Կ��� �ۼ��� �޴� ������ �����ͺ��̽��� ������
	 */
	public static void menuInsert(MenuDTO menu, String user_id) {
		try {
			int store_code = storeservice.storeSelectById(user_id).getStore_code();
			menu.setStore_code(store_code);
			menuservice.menuInsert(menu);
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
			menuservice.menuUpdate(menu);
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
			menuservice.menuDelete(menu_code);
			System.out.println("�޴��� �����Ǿ����ϴ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}//class end
