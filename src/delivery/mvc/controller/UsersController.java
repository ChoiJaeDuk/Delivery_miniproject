package delivery.mvc.controller;

import delivery.mvc.dto.UsersDTO;
import delivery.mvc.service.users.UsersServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.actor.UsersView;


/*
import kosta.mvc.model.dto.Customer;
import kosta.mvc.view.FailView;
import kosta.mvc.view.MenuView;
*/

public class UsersController {
	
	static UsersServiceImpl usersServiceImpl = new UsersServiceImpl();
	/**
	 * ·Î±×ÀÎ
	 */
	
	public static void login(String users_id, String users_pwd) {
		try {
			UsersDTO user = usersServiceImpl.usersLogin(users_id, users_pwd);
			UsersView.users(users_id);
			
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/*
		public static void login(String userId, String userPwd) {
			try {
				Customer customer = customerService.login(userId, userPwd);
				MenuView.printUserMenu(userId);
				//MenuView.menu();
			}catch (Exception e) {
				//e.printStackTrace();
				FailView.errorMessage(e.getMessage());
				
			}
		}*/
	
	 
}
