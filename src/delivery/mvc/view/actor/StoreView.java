package delivery.mvc.view.actor;

import java.util.Scanner;

import delivery.mvc.view.user.LoginLogoutView;
import delivery.mvc.view.user.RegisterView;
import kosta.mvc.controller.GoodsController;
import kosta.mvc.controller.OrderController;
import kosta.mvc.session.SessionSet;
import kosta.mvc.view.MenuView;



public class StoreView {
	private static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			StoreView.printMenuForStores();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				LoginLogoutView.login(); //�α���
				MenuView.printMenu();
				return;
				
			case 2:
				RegisterView.register();// ȸ������
				MenuView.printMenu();
				return;
				
			case 3:
				System.exit(0); //����
			}
		}

	}
	
	public static void printMenuForStores(String userId) {
	
		while(true) {
			//SessionSet ss = SessionSet.getInstance();
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("				1. �α���      2. ȸ������     3. ����"              );
			System.out.println("--------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			int menu =Integer.parseInt( sc.nextLine());
			switch(menu) {
				case 1 :
					login(userId);// 
					return; //�Լ��� ����������.
					//break;
					
				case 2 :
					GoodsController.goodsSelect();//��ü ��ǰ��ȸ
					break;
				case 3 :
					printInputOrder(userId);
					break;
				case 4 :
					OrderController.selectOrdersByUserId(userId);
					break;
				case 5 :
					MenuView.putCart(userId);// 
					break;	
		
				case 6 : 
					viewCart(userId);
					break;
				}
		}

	
}
