package delivery.mvc.dao.users;

import java.sql.SQLException;
import java.util.List;

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
	int join(UsersDTO usersDTO) throws SQLException;
	
	
	/**
	 * 아이디 찾기
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	
	/**
	 * 비밀번호 찾기(새로운 비밀번호 설정)
	 */
	int searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	
	
	/**
	 * 개인정보 수정(닉네임)
	 */
	int nickUpdate(String oldNick, String newNick) throws SQLException;
	
	/**
	 * 개인정보 수정(주소)
	 */
	int addrUpdate(String oldAddr, String newAddr) throws SQLException;
	
	/**
	 * 개인정보 수정(폰번호)
	 */
	int phoneUpdate(String oldPhone, String newPhone) throws SQLException;
	
	/**
	 * 개인정보 수정(비번)
	 */
	int pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	
	
	
	
	/**
	 * 배송시간 조회
	 */
	List<OrdersDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * 환불&주문 취소
	 */
	int cancelOrder(int order_code) throws SQLException;









}
