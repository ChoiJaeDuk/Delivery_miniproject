package delivery.mvc.controller;

import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.service.menu.MenuService;
import delivery.mvc.service.menu.MenuServiceImpl;

public class MenuController {
	private static MenuService service = new MenuServiceImpl();
	
	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게의 메뉴를 출력함
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
	 * 작성자 : 박해원
	 * 설명 : 해당 가게에서 작성한 메뉴 정보를 데이터베이스에 저장함
	 */
	public static void menuInsert(MenuDTO menu) {
		try {
			service.menuInsert(menu);
			System.out.println(menu.getMenu_name()+" 메뉴가 등록되었습니다");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}//menuInsert end
	
	/**
	 * 작성자 : 박해원
	 * 설명 : 해당 가게의 메뉴 정보를 수정함
	 */
	public static void menuUpdate(int menu_code, int price, int status) {
		try {
			service.menuUpdate(menu_code, price, status);
			System.out.println(menu.getMenu_name()+" 메뉴가 변경되었습니다");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}//class end
