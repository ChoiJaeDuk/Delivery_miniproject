package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.service.menu.MenuService;
import delivery.mvc.service.menu.MenuServiceImpl;
import delivery.mvc.service.stores.StoresService;
import delivery.mvc.service.stores.StoresServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.SuccessView;

public class MenuController {
	private static MenuService menuservice = new MenuServiceImpl();
	private static StoresService storeservice = new StoresServiceImpl();

	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게의 메뉴를 출력함 - 판매자 시점
	 */
	public static void menuSelectByAll(int store_id) {
		try {
			List<MenuDTO> list = menuservice.menuSelectAll(store_id);
			SuccessView.menuList(list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//menuSelectByAll() end
	
	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게의 메뉴를 출력함 - 회원 시점
	 */
	public static void menuSelectByAllByUser(int store_id) {
		try {
			
			List<MenuDTO> list = menuservice.menuSelectAll(store_id);
			SuccessView.menuPrintAll(list);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//menuSelectByAll() end

	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게 코드를 기준으로 카테고리를 출력함
	 */
	public static void menuSelectByStore(String user_id) {
		try {
			StoresDTO store = storeservice.storeSelectById(user_id);
			SuccessView.insertMenu(store);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 작성자 : 박해원
	 * 설명 : 판매자 기준의 메뉴를 출력함
	 */
	public static void menuSelectByMenu(String user_id) {
		try {
			StoresDTO store = storeservice.storeSelectById(user_id);
			MenuController.menuSelectByAll(store.getStore_code());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게에서 작성한 메뉴 정보를 데이터베이스에 저장함
	 */
	public static void menuInsert(MenuDTO menu, String user_id) {
		try {
			int store_code = storeservice.storeSelectById(user_id).getStore_code();
			menu.setStore_code(store_code);
			menuservice.menuInsert(menu);
			SuccessView.getmessagePrint(menu.getMenu_name()+" 메뉴가 등록되었습니다");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//menuInsert end

	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게의 메뉴 정보를 수정함
	 */
	public static void menuUpdate(MenuDTO menu) {
		try {

			menuservice.menuUpdate(menu);
			SuccessView.getmessagePrint("메뉴가 변경되었습니다");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}//menuUpdate end

	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게의 메뉴를 삭제함
	 */
	public static void menuDelete(int menu_code) {
		try {
			menuservice.menuDelete(menu_code);
			SuccessView.getmessagePrint("메뉴가 삭제되었습니다.");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}//class end
