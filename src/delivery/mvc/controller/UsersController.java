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

			UsersDTO user = usersService.usersLogin(userId, users_pwd);
		
	        if(user.getJob_code().equals("A")) UsersView.users(userId);
	        else if(user.getJob_code().equals("B")) StoreView.menu(userId);
	        else if(user.getJob_code().equals("C")) AdminView.admin(userId);
	        else throw new SQLException("�������� �ʴ� ����Դϴ�");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void usersLogout(String userId) {
		try {
			LoginLogoutView.logOut(userId);
			SuccessView.getmessagePrint("�α׾ƿ� ����");
		
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		
		}
	}
	
	public static void join(UsersDTO usersDTO) {
		try {
			usersService.join(usersDTO);
			SuccessView.getmessagePrint("ȸ������ ����");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void searchId(String users_id, String users_jumin) {
		try {
			String result = usersService.searchId(users_id,users_jumin);
			SuccessView.getmessagePrint("���̵� ã�� ����");
			
			System.out.println(result);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) {
		try {
			usersService.searchPwd(users_id,users_name, users_jumin, newpwd);
			SuccessView.getmessagePrint("��й�ȣ ã��/�缳�� ����");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void nickUpdate(String oldNick, String newNick) {
		try {
			usersService.nickUpdate(oldNick,newNick);
			SuccessView.getmessagePrint("�г��� ���� �����Ͽ����ϴ�.");
			
			System.out.println(newNick+"���� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	
	public static void addrUpdate(String oldAddr, String newAddr) {
		try {
			usersService.addrUpdate(oldAddr,newAddr);
			SuccessView.getmessagePrint("�ּ� ���� �����Ͽ����ϴ�.");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void phoneUpdate(String oldPhone, String newPhone) {
		try {
			usersService.phoneUpdate(oldPhone,newPhone);
			SuccessView.getmessagePrint("��ȭ��ȣ ���� �����Ͽ����ϴ�.");
		
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void pwdUpdate(String oldPwd, String newPwd) {
		try {
			usersService.pwdUpdate(oldPwd,newPwd);
			SuccessView.getmessagePrint("��й�ȣ ���� �����Ͽ����ϴ�.");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	
	public static void selectOrderList(String user_id) {
		try {
			List<OrdersDTO> order = usersService.selectOrderList(user_id);
			SuccessView.printOrderList(order);
			
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void selectDelivery_time(int order_code) {
		try {
			List<OrderLineDTO> oll = usersService.selectDelivery_time(order_code);
			SuccessView.printOrderLine(oll);
			
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	public static void cancelOrder(int order_code) {
		try {
			usersService.cancelOrder(order_code);
			SuccessView.getmessagePrint("ȯ��(���)�Ǿ����ϴ�.");
		
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		
		}
	}
	
	
	public static int pwdCheck(String user_id, String input_pwd) {
		int value =9999;
		try {
			String result = usersService.pwdCheck(user_id,input_pwd);
			if(result.equals(input_pwd)) {
				SuccessView.getmessagePrint("��й�ȣ�� ��ġ�մϴ�.");
				value = 1;
				
			}
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());

		}
		
		return value;
	}

	/**
	 * ȸ������ ���
	 * @param userDTO 
	 */
	public static void userInfoPrint(String user_id) {
		try {
			UsersDTO usersDTO = usersService.selectUserInfoAllPrint(user_id);
			SuccessView.printUserInfo(usersDTO);
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	
}
