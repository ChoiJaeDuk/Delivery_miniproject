package delivery.mvc.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import delivery.mvc.controller.MenuController;
import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;

public class StartView {

	public static void main(String[] args) {
		MenuController mc = new MenuController();
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("가게 선택하셈 ㅇㅇ");
		System.out.print("가게 코드 >>");
		int code = Integer.parseInt(sc.nextLine());
		mc.menuSelectByAll(code);
		*/
		
		/*
		System.out.println("임마 메뉴 등록하고 싶어");
		System.out.println("무슨 음식할건데?");
		
		//해당 판매자의 정보를 가저오는 구분
		StoresDAO storesDAO = new StoresDAOImpl();
		StoresDTO store = null;
		try {
			store = storesDAO.storeSelcetByCode(1);
			if(store.getCategory_code()==1) System.out.println("골라 : 4.파스타 5.스테이크 6.피자");
			else if (store.getCategory_code()==2) System.out.println("골라 : 7.면 8.밥 9.고기");
			else if (store.getCategory_code()==3) System.out.println("골라 : 10.면 11.밥 12.고기");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print("하위 카테고리 >>");
		int category = Integer.parseInt(sc.nextLine());
		
		System.out.println("메뉴 이름 좀 말해봐");
		String menu_name = sc.nextLine();
		
		System.out.println("가격은? 비싸게 하려고 ?");
		int menu_price = Integer.parseInt(sc.nextLine());
		
		mc.menuInsert(new MenuDTO(category, store.getStore_code(), menu_name, menu_price, 1));
		*/
	}
}
