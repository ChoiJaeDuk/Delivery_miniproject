package delivery.mvc.dao.users;

import java.sql.SQLException;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersDAO {
	/**
	 * 로그인
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * 로그아웃??????????
	 */
	void usersLogout() throws SQLException;

	
	
	/**
	 * 회원가입
	 */
	UsersDTO join() throws SQLException;
	
	
	/**
	 * 아이디 찾기
	 */
	UsersDTO searchId(String users_id, String users_jumin) throws SQLException;
	
	
	/**
	 * 비밀번호 찾기
	 */
	UsersDTO searchPwd(String users_id, String users_name, String users_jumin) throws SQLException;
	
	
	
	/**
	 * 개인정보 수정
	 */
	int usersUpdate(UsersDTO usersDTO) throws SQLException;
	
	
	/**
	 * 배송시간 조회
	 */
	OrdersDTO selectDelivery_time(String deliveryTime) throws SQLException;
	
	
	/**
	 * 환불&주문 취소
	 */
	int cancelOrder(int order_code) throws SQLException;









}
