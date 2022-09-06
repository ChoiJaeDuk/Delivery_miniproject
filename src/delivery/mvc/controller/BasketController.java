package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.service.bascket.BasketService;
import delivery.mvc.service.bascket.BasketServiceImpl;
import delivery.mvc.view.SuccessView;

public class BasketController {
	private static BasketService service = new BasketServiceImpl();

	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ȸ���� ��ٱ��Ͽ� ����Ǿ��ִ� �޴����� �������� �޼ҵ�
	 */
	public static void basketMenuSelect(String user_id) {
		try {
			List<MenuDTO> list = service.basketMenuSelect(user_id);
			System.out.println(list);
			SuccessView.basketMenuSelect(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//basketMenuSelect() end
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ȸ���� �޴��� ��ٱ��Ͽ� ���� �� ������ �����ͺ��̽� ����Ǵ� �޼ҵ�
	 */
	public static void basketInsert(BasketDTO basket) {
		try {
			service.bascketInsert(basket);
			SuccessView.getmessagePrint("��ٱ��Ͽ� �߰��Ǿ����ϴ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ȸ���� ��ٱ��Ͽ� ����ִ� �޴����� ������ �����ϴ� �޼ҵ�
	 */
	public static void basketUpdate(BasketDTO basket, int num) {
		try {
			service.bascketUpdate(basket, num);
			SuccessView.getmessagePrint("���� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ۼ��� : ���ؿ�
	 * ���� : �ش� ȸ���� ��ٱ��Ͽ� ���õ� �޴��� �����ϴ� �޼ҵ�
	 */
	public static void basketDelete(int menu_code, String user_id) {
		try {
			service.bascketDelete(menu_code, user_id);
			SuccessView.getmessagePrint("�����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}//BasketController end