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
		System.out.println("�̾߾�");
		BasketService s = new BasketServiceImpl();
		BasketDAOImpl a = new BasketDAOImpl();
		//MenuDAO a = new MenuDAOImpl();
		MenuView.menu();
		try {
			List<BasketDTO> list =a.basketSelectAll("testid3");
			System.out.println(list);
			
			//int result = a.basketInsert(new BascketDTO("testid3", 4, 1));
			//if(result==0) throw new SQLException("��Ͻ���");
			//else System.out.println("��ϼ���");
			
			//int result = a.basketUpdate(new BascketDTO("testid3", 4), 1);
			//if(result==0) throw new SQLException("���� ����");
			//else System.out.println("���� ����");
			
			//int result = a.basketDelete(new BascketDTO("testid3", 4));
			//if(result==0) throw new SQLException("���� ����");
			//else System.out.println("���� ����");
			
			//List<MenuDTO> list = a.menuSelectAll(1);
			//System.out.println(list);
			
			//int result = a.menuInsert(new MenuDTO(12, 3, "�������", 26000, 1));
			//if(result==0) throw new SQLException("��� ����");
			//else System.out.println("��� ����");
			
			//int result = a.menuUpdate(8, 16000, 1);
			//if(result==0) throw new SQLException("���� ����");
			//else System.out.println("���� ����");
			
			//int result = a.menuDelete(8);
			//if(result==0) throw new SQLException("���� ����");
			//else System.out.println("���� ����");
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
