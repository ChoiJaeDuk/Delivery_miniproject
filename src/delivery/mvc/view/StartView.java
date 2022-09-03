package delivery.mvc.view;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.bascket.BascketDAOImpl;
import delivery.mvc.dto.BascketDTO;

public class StartView {

	public static void main(String[] args) {
		System.out.println("ÀÌ¾ß¾ß");
		BascketDAOImpl a = new BascketDAOImpl();
		try {
			List<BascketDTO> list =a.bascketSelectAll("testid");
			System.out.println(list);
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
