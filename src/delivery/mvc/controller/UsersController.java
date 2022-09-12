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
	
	/**
	 * 로그인(계정의 아이디와 비밀번호를 입력받아 유효성검사를 함)
	 */
	public static void userLogin(String userId, String users_pwd) {
		try {

			UsersDTO user = usersService.usersLogin(userId, users_pwd);
		
	        if(user.getJob_code().equals("A")) UsersView.users(userId);
	        else if(user.getJob_code().equals("B")) StoreView.menu(userId);
	        else if(user.getJob_code().equals("C")) AdminView.admin(userId);
	        else throw new SQLException("존재하지 않는 등급입니다");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 로그아웃
	 */
	public static void usersLogout(String userId) {
		try {
			LoginLogoutView.logOut(userId);
			SuccessView.getmessagePrint("로그아웃 성공");
		
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		
		}
	}
	
	/**
	 * 회원가입(입력받은 정보를 DB에 등록 시킴)
	 */
	public static void join(UsersDTO usersDTO) {
		try {
			usersService.join(usersDTO);
			SuccessView.getmessagePrint("회원가입 성공");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 아이디 찾기(이름과 주민을 입력받아 일치하는 id를 출력함)
	 */
	public static void searchId(String users_id, String users_jumin) {
		try {
			String result = usersService.searchId(users_id,users_jumin);
			SuccessView.getmessagePrint("아이디 찾기 성공");
			
			System.out.println(result);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 비밀번호 찾기(새로운 비밀번호 설정)
	 */
	public static void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) {
		try {
			usersService.searchPwd(users_id,users_name, users_jumin, newpwd);
			SuccessView.getmessagePrint("비밀번호 찾기/재설정 성공");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 개인정보 수정(닉네임)
	 */
	public static void nickUpdate(String newNick, String user_id) {
		try {
			usersService.nickUpdate(newNick, user_id);
			SuccessView.getmessagePrint("닉네임 수정 성공하였습니다.");
			
			System.out.println(newNick+"으로 변경되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 개인정보 수정(주소)
	 */
	public static void addrUpdate(String newAddr, String user_id) {
		try {
			usersService.addrUpdate(newAddr, user_id);
			SuccessView.getmessagePrint("주소 수정 성공하였습니다.");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 개인정보 수정(폰번호)
	 */
	public static void phoneUpdate(String newPhone, String user_id) {
		try {
			usersService.phoneUpdate(newPhone, user_id);
			SuccessView.getmessagePrint("전화번호 수정 성공하였습니다.");
		
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 개인정보 수정(비번)
	 */
	public static void pwdUpdate(String oldPwd, String newPwd) {
		try {
			usersService.pwdUpdate(oldPwd,newPwd );
			SuccessView.getmessagePrint("비밀번호 수정 성공하였습니다.");
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 주문 상세보기(order_line)
	 */
	public static void selectOrderList(String user_id) {
		try {
			List<OrdersDTO> order = usersService.selectOrderList(user_id);
			SuccessView.printOrderList(order);
			
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 주문 리스트(order)
	 */
	public static void selectDelivery_time(int order_code) {
		try {
			List<OrderLineDTO> oll = usersService.selectDelivery_time(order_code);
			SuccessView.printOrderLine(oll);
			
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	/**
	 * 환불&주문 취소(ORDER_CODE를 입력 받아 ORDER.DELIVERY_CODE를 4(취소)로 변경)
	 */
	public static void cancelOrder(int order_code) {
		try {
			usersService.cancelOrder(order_code);
			SuccessView.getmessagePrint("환불(취소)되었습니다.");
		
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		
		}
	}
	
	/**
	 * 비밀번호 확인(비밀번호 유효성 검사)
	 */
	public static int pwdCheck(String user_id, String input_pwd) {
		int value =9999;
		try {
			String result = usersService.pwdCheck(user_id,input_pwd);
			if(result.equals(input_pwd)) {
				SuccessView.getmessagePrint("비밀번호가 일치합니다.");
				value = 1;
				
			}
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());

		}
		
		return value;
	}

	/**
	 * 회원정보 출력
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
