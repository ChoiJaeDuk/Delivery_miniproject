package delivery.mvc.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import delivery.mvc.controller.BasketController;
import delivery.mvc.controller.MenuController;
import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;

public class StartView {

	public static void main(String[] args) {
		MenuController mc = new MenuController();
		BasketController bc = new BasketController();
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("내 장바구니 정보 좀 가져와봥");
		bc.basketMenuSelect("testid3");
		*/
		
		/*
		System.out.println("나 이거 살거야!!!!");
		System.out.println("메뉴 정보를 가져와바");
		mc.menuSelectByAll(1);
		
		System.out.println("추가할 메뉴 코드는 ?");
		System.out.print("메뉴 코드 >>");
		int menu_code = Integer.parseInt(sc.nextLine());
		
		System.out.println("추가할 메뉴의 수량은 ?");
		System.out.print("수량 >>");
		int basket_quantity = Integer.parseInt(sc.nextLine());
		
		bc.basketInsert(new BasketDTO("testid3", menu_code, basket_quantity));
		*/
		
		/*
		System.out.println("이 메뉴 할인행사 들어가서 수정해야할것같아");
		System.out.println("내 장바구니 정보 좀 가져와봥");
		bc.basketMenuSelect("testid3");
		
		System.out.println("변경할 메뉴 코드 는 ?");
		System.out.print("메뉴 코드 >>");
		int menu_code = Integer.parseInt(sc.nextLine());
		
		System.out.println("변경할 수량은 ?");
		int basket_quantity = Integer.parseInt(sc.nextLine());
		
		bc.basketUpdate(new BasketDTO("testid3", menu_code), basket_quantity);
		*/
		
		/*
		System.out.println("나 이거 안살거야");
		System.out.println("내 장바구니 정보 좀 가져와봥");
		bc.basketMenuSelect("testid3");
		
		System.out.println("삭제할 메뉴 코드 는 ?");
		System.out.print("메뉴 코드 >>");
		int menu_code = Integer.parseInt(sc.nextLine());
		
		bc.basketDelete(menu_code, "testid3");
		*/
		
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
		
		/*
		System.out.println("나 메뉴 가격 비싸게 팔거임 수정 ㄱㄱ");
		System.out.println("내 메뉴들 가지고 와봐");
		System.out.println("가게 선택하셈 ㅇㅇ");
		System.out.print("가게 코드 >>");
		int store_code = Integer.parseInt(sc.nextLine());
		mc.menuSelectByAll(store_code);
		
		System.out.println("변경할 메뉴 코드 ㄱㄱ");
		System.out.print("메뉴 코드 >>");
		int menu_code = Integer.parseInt(sc.nextLine());
		
		//변경사항
		System.out.println("변경할 이름 ㄱㄱ");
		String menu_name = sc.nextLine();
		System.out.println("변경할 가격 ㄱㄱ");
		int menu_price = Integer.parseInt(sc.nextLine());
		System.out.println("변경할 품절여부 ㄱㄱ");
		int status = Integer.parseInt(sc.nextLine());
		
		mc.menuUpdate(new MenuDTO(menu_code, menu_name, menu_price, status));
		*/
		
		/*
		System.out.println("나 이 메뉴 더이상 안할거임");
		System.out.println("메뉴 코드들 가지고 와봐");
		System.out.println("가게 선택하셈 ㅇㅇ");
		System.out.print("가게 코드 >>");
		int store_code = Integer.parseInt(sc.nextLine());
		mc.menuSelectByAll(store_code);
		
		System.out.println("삭제할 메뉴 코드 ㄱㄱ");
		System.out.print("메뉴 코드 >>");
		int menu_code = Integer.parseInt(sc.nextLine());
		
		mc.menuDelete(menu_code);
		*/
	}
}
