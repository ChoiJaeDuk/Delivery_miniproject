package delivery.mvc.view;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.basket.BasketDAOImpl;
import delivery.mvc.dao.menu.MenuDAO;
import delivery.mvc.dao.menu.MenuDAOImpl;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.service.bascket.BasketService;
import delivery.mvc.service.bascket.BasketServiceImpl;

public class StartView {

	/*
	public static void main(String[] args) {
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
