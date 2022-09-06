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

	/*
	public static void main(String[] args) {
<<<<<<< HEAD
		System.out.println("이야야");
		BasketService s = new BasketServiceImpl();
		BasketDAOImpl a = new BasketDAOImpl();
		//MenuDAO a = new MenuDAOImpl();
		MenuView.menu();
		try {
			List<BasketDTO> list =a.basketSelectAll("testid3");
			System.out.println(list);
			
			//int result = a.basketInsert(new BascketDTO("testid3", 4, 1));
			//if(result==0) throw new SQLException("등록실패");
			//else System.out.println("등록성공");
			
			//int result = a.basketUpdate(new BascketDTO("testid3", 4), 1);
			//if(result==0) throw new SQLException("변경 실패");
			//else System.out.println("변경 성공");
			
			//int result = a.basketDelete(new BascketDTO("testid3", 4));
			//if(result==0) throw new SQLException("삭제 실패");
			//else System.out.println("삭제 성공");
			
			//List<MenuDTO> list = a.menuSelectAll(1);
			//System.out.println(list);
			
			//int result = a.menuInsert(new MenuDTO(12, 3, "새우알찜", 26000, 1));
			//if(result==0) throw new SQLException("등록 실패");
			//else System.out.println("등록 성공");
			
			//int result = a.menuUpdate(8, 16000, 1);
			//if(result==0) throw new SQLException("변경 실패");
			//else System.out.println("변경 성공");
			
			//int result = a.menuDelete(8);
			//if(result==0) throw new SQLException("삭제 실패");
			//else System.out.println("삭제 성공");
			//s.basketDelete(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	
	
	public static void main(String[] args) {
		MenuView.menu();
	}

}
