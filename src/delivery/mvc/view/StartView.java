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
		System.out.println("���� �����ϼ� ����");
		System.out.print("���� �ڵ� >>");
		int code = Integer.parseInt(sc.nextLine());
		mc.menuSelectByAll(code);
		*/
		
		/*
		System.out.println("�Ӹ� �޴� ����ϰ� �;�");
		System.out.println("���� �����Ұǵ�?");
		
		//�ش� �Ǹ����� ������ �������� ����
		StoresDAO storesDAO = new StoresDAOImpl();
		StoresDTO store = null;
		try {
			store = storesDAO.storeSelcetByCode(1);
			if(store.getCategory_code()==1) System.out.println("��� : 4.�Ľ�Ÿ 5.������ũ 6.����");
			else if (store.getCategory_code()==2) System.out.println("��� : 7.�� 8.�� 9.���");
			else if (store.getCategory_code()==3) System.out.println("��� : 10.�� 11.�� 12.���");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.print("���� ī�װ� >>");
		int category = Integer.parseInt(sc.nextLine());
		
		System.out.println("�޴� �̸� �� ���غ�");
		String menu_name = sc.nextLine();
		
		System.out.println("������? ��ΰ� �Ϸ��� ?");
		int menu_price = Integer.parseInt(sc.nextLine());
		
		mc.menuInsert(new MenuDTO(category, store.getStore_code(), menu_name, menu_price, 1));
		*/
	}
}
