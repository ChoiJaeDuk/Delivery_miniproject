package delivery.mvc.controller;


import delivery.mvc.dto.UsersDTO;
import delivery.mvc.service.users.UsersServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.actor.UsersView;

import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;
import delivery.mvc.service.users.UsersService;
import delivery.mvc.service.users.UsersServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.SuccessView;



public class UsersController {
	private static UsersService usersService = new UsersServiceImpl();
	
	public static void userLogin(String userId, String users_pwd) {
		try {
			 UsersDTO user = usersService.usersLogin(userId, users_pwd);
//	         SuccessView.getmessagePrint("�α��� ����");
	         System.out.println(user.getUsers_name()+"�� �α��� ����");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void usersLogout() {
		try {
			usersService.usersLogout();
//			SuccessView.getmessagePrint("�α׾ƿ� ����");
			System.out.println("�α׾ƿ� ����");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void join(UsersDTO usersDTO) {
		try {
			usersService.join(usersDTO);
//			SuccessView.getmessagePrint("ȸ������ ����");
			System.out.println("ȸ������ ����");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void searchId(String users_id, String users_jumin) {
		try {
			String result = usersService.searchId(users_id,users_jumin);
//			SuccessView.getmessagePrint("���̵� ã�� ����");
			System.out.println("���̵�ã�� ����");
			System.out.println(result);
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) {
		try {
			usersService.searchPwd(users_id,users_name, users_jumin, newpwd);
//			SuccessView.getmessagePrint("��й�ȣ ã��/�缳�� ����");
			System.out.println("��й�ȣ ã��/�缳�� ����");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void nickUpdate(String oldNick, String newNick) {
		try {
			usersService.nickUpdate(oldNick,newNick);
//			SuccessView.getmessagePrint("�г��� ���� ����");
			System.out.println("�о� ����");
			System.out.println(newNick+"���� ����Ǿ����ϴ�.");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	
	public static void addrUpdate(String oldAddr, String newAddr) {
		try {
			usersService.addrUpdate(oldAddr,newAddr);
//			SuccessView.getmessagePrint("�г��� ���� ����");
			System.out.println("�־� ����");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void phoneUpdate(String oldPhone, String newPhone) {
		try {
			usersService.phoneUpdate(oldPhone,newPhone);
//			SuccessView.getmessagePrint("�г��� ���� ����");
			System.out.println("���� ����");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void pwdUpdate(String oldPwd, String newPwd) {
		try {
			usersService.pwdUpdate(oldPwd,newPwd);
//			SuccessView.getmessagePrint("�г��� ���� ����");
			System.out.println("��� ����");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void selectOrderList(String user_id) {
		try {
			List<OrdersDTO> order = usersService.selectOrderList(user_id);
//			SuccessView.getmessagePrint("�ֹ����� ���\n" + list);
			System.out.println("�ֹ���� ����");
			for(OrdersDTO list : order) {
				System.out.println(list.getOrder_code()+ "  " +  list.getOrder_date() + "  " + list.getOrder_total_price()+ "  " + list.getDelivery_code() + "  " + list.getOrder_delivery_time() );
			}
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void selectDelivery_time(int order_code) {
		try {
			List<OrderLineDTO> oll = usersService.selectDelivery_time(order_code);
//			SuccessView.getmessagePrint("�ֹ� �󼼳��� ���\n" + list);
			System.out.println("����� ����");
			for(OrderLineDTO list : oll) {
				System.out.println(list.getOrder_line_code()+ "  " +  list.getStore().getStore_name() + "  " + list.getMenu().getMenu_name() + "  " + list.getOrder_quntity() + "  " + list.getMenu().getMenu_price() );
			}
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}
	
	public static void cancelOrder(int order_code) {
		try {
			usersService.cancelOrder(order_code);
//			SuccessView.getmessagePrint("ȯ��/�ֹ� ���");
			System.out.println("ȯ��/�ֹ� ���");
			
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
	}

}
