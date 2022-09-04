package delivery.mvc.view;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.bascket.BascketDAOImpl;
import delivery.mvc.dao.menu.MenuDAO;
import delivery.mvc.dao.menu.MenuDAOImpl;
import delivery.mvc.dto.BascketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.service.bascket.BascketService;
import delivery.mvc.service.bascket.BascketServiceImpl;

public class StartView {

	public static void main(String[] args) {
		System.out.println("�̾߾�");
		BascketService s = new BascketServiceImpl();
		BascketDAOImpl a = new BascketDAOImpl();
		//MenuDAO a = new MenuDAOImpl();
		
		try {
			List<BascketDTO> list =a.bascketSelectAll("testid3");
			System.out.println(list);
			
			//int result = a.bascketInsert(new BascketDTO("testid3", 4, 1));
			//if(result==0) throw new SQLException("��Ͻ���");
			//else System.out.println("��ϼ���");
			
			//int result = a.bascketUpdate(new BascketDTO("testid3", 4), 1);
			//if(result==0) throw new SQLException("���� ����");
			//else System.out.println("���� ����");
			
			//int result = a.bascketDelete(new BascketDTO("testid3", 4));
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
			s.bascketDelete(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*
	public static void main(String[] args) {
		MenuView.menu();
		 System.out.println("-----------");
		 System.out.println("test");
		 System.out.println("-----------");
	}
*/
}
