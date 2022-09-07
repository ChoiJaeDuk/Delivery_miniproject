package delivery.mvc.controller;


import delivery.mvc.dto.UsersDTO;
import delivery.mvc.service.users.UsersServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.actor.AdminView;
import delivery.mvc.view.actor.StoreView;
import delivery.mvc.view.actor.UsersView;
import delivery.mvc.view.user_function.LoginLogoutView;

import java.sql.SQLException;
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

			//usersService.usersLogin(users_id, users_pwd);
			//SuccessView.getmessagePrint("�α��� ����");
			UsersDTO user = usersService.usersLogin(userId, users_pwd);
			//SuccessView.getmessagePrint("�α��� ����");
	        System.out.println(user.getUsers_name()+"�� �α��� ����");

	        if(user.getJob_code().equals("A")) UsersView.users(userId);
	        else if(user.getJob_code().equals("B")) StoreView.menu(userId);
	        else if(user.getJob_code().equals("C")) AdminView.admin(userId);
	        else throw new SQLException("�������� �ʴ� ����Դϴ�");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void usersLogout(String userId) {
		try {
			LoginLogoutView.logOut(userId);
			SuccessView.getmessagePrint("�α׾ƿ� ����");
			//System.out.println("�α׾ƿ� ����");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void join(UsersDTO usersDTO) {
		try {
			usersService.join(usersDTO);
			SuccessView.getmessagePrint("ȸ������ ����");
			//System.out.println("ȸ������ ����");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void searchId(String users_id, String users_jumin) {
		try {
			String result = usersService.searchId(users_id,users_jumin);
			SuccessView.getmessagePrint("���̵� ã�� ����");
			//System.out.println("���̵�ã�� ����");
			System.out.println(result);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) {
		try {
			usersService.searchPwd(users_id,users_name, users_jumin, newpwd);
			SuccessView.getmessagePrint("��й�ȣ ã��/�缳�� ����");
			//System.out.println("��й�ȣ ã��/�缳�� ����");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void nickUpdate(String oldNick, String newNick) {
		try {
			usersService.nickUpdate(oldNick,newNick);
			SuccessView.getmessagePrint("�г��� ���� ����");
			//System.out.println("�о� ����");
			System.out.println(newNick+"���� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	
	public static void addrUpdate(String oldAddr, String newAddr) {
		try {
			usersService.addrUpdate(oldAddr,newAddr);
			SuccessView.getmessagePrint("�ּ� ���� ����");
			//System.out.println("�־� ����");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void phoneUpdate(String oldPhone, String newPhone) {
		try {
			usersService.phoneUpdate(oldPhone,newPhone);
			SuccessView.getmessagePrint("���� ���� ����");
			//System.out.println("���� ����");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void pwdUpdate(String oldPwd, String newPwd) {
		try {
			usersService.pwdUpdate(oldPwd,newPwd);
			SuccessView.getmessagePrint("��� ���� ����");
			//System.out.println("��� ����");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	
	public static void selectOrderList(String user_id) {
		try {
			List<OrdersDTO> order = usersService.selectOrderList(user_id);
			SuccessView.printOrderList(order);
			//System.out.println("�ֹ���� ����");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void selectDelivery_time(int order_code) {
		try {
			List<OrderLineDTO> oll = usersService.selectDelivery_time(order_code);
			SuccessView.printOrderLine(oll);
			//System.out.println("����� ����");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	public static void cancelOrder(int order_code) {
		try {
			usersService.cancelOrder(order_code);
			SuccessView.getmessagePrint("ȯ��(���)�Ǿ����ϴ�.");
			//System.out.println("ȯ��/�ֹ� ���");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			//System.out.println("����");
		}
	}
	
	
	public static int pwdCheck(String user_id, String input_pwd) {
		int value =0;
		try {
			String result = usersService.pwdCheck(user_id,input_pwd);
			if(result.equals(input_pwd)) {
				SuccessView.getmessagePrint("��й�ȣ�� ��ġ�մϴ�.");
				value = 1;
				
			}
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			SuccessView.getmessagePrint("��й�ȣ�� ��ġ�����ʽ��ϴ�.");
		}
		
		return value;
	}

	
}
