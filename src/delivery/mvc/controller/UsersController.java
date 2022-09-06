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
//	         SuccessView.getmessagePrint("로그인 성공");
	         System.out.println(user.getUsers_name()+"님 로그인 성공");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void usersLogout() {
		try {
			usersService.usersLogout();
//			SuccessView.getmessagePrint("로그아웃 성공");
			System.out.println("로그아웃 성공");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void join(UsersDTO usersDTO) {
		try {
			usersService.join(usersDTO);
//			SuccessView.getmessagePrint("회원가입 성공");
			System.out.println("회원가입 성공");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void searchId(String users_id, String users_jumin) {
		try {
			String result = usersService.searchId(users_id,users_jumin);
//			SuccessView.getmessagePrint("아이디 찾기 성공");
			System.out.println("아이디찾기 성공");
			System.out.println(result);
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) {
		try {
			usersService.searchPwd(users_id,users_name, users_jumin, newpwd);
//			SuccessView.getmessagePrint("비밀번호 찾기/재설정 성공");
			System.out.println("비밀번호 찾기/재설정 성공");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void nickUpdate(String oldNick, String newNick) {
		try {
			usersService.nickUpdate(oldNick,newNick);
//			SuccessView.getmessagePrint("닉네임 수정 성공");
			System.out.println("닉업 성공");
			System.out.println(newNick+"으로 변경되었습니다.");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	
	public static void addrUpdate(String oldAddr, String newAddr) {
		try {
			usersService.addrUpdate(oldAddr,newAddr);
//			SuccessView.getmessagePrint("닉네임 수정 성공");
			System.out.println("주업 성공");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void phoneUpdate(String oldPhone, String newPhone) {
		try {
			usersService.phoneUpdate(oldPhone,newPhone);
//			SuccessView.getmessagePrint("닉네임 수정 성공");
			System.out.println("폰업 성공");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void pwdUpdate(String oldPwd, String newPwd) {
		try {
			usersService.pwdUpdate(oldPwd,newPwd);
//			SuccessView.getmessagePrint("닉네임 수정 성공");
			System.out.println("비업 성공");
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void selectOrderList(String user_id) {
		try {
			List<OrdersDTO> order = usersService.selectOrderList(user_id);
//			SuccessView.getmessagePrint("주문내역 출력\n" + list);
			System.out.println("주문출력 성공");
			for(OrdersDTO list : order) {
				System.out.println(list.getOrder_code()+ "  " +  list.getOrder_date() + "  " + list.getOrder_total_price()+ "  " + list.getDelivery_code() + "  " + list.getOrder_delivery_time() );
			}
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void selectDelivery_time(int order_code) {
		try {
			List<OrderLineDTO> oll = usersService.selectDelivery_time(order_code);
//			SuccessView.getmessagePrint("주문 상세내역 출력\n" + list);
			System.out.println("상세출력 성공");
			for(OrderLineDTO list : oll) {
				System.out.println(list.getOrder_line_code()+ "  " +  list.getStore().getStore_name() + "  " + list.getMenu().getMenu_name() + "  " + list.getOrder_quntity() + "  " + list.getMenu().getMenu_price() );
			}
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}
	
	public static void cancelOrder(int order_code) {
		try {
			usersService.cancelOrder(order_code);
//			SuccessView.getmessagePrint("환불/주문 취소");
			System.out.println("환불/주문 취소");
			
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
	}

}
