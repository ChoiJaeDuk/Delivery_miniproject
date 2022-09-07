package delivery.mvc.service.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersService {
	/**
	 * 로그인
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * 로그아웃
	 */
	void usersLogout() throws SQLException;
	
	/**
	 * 회원가입
	 */
	void join(UsersDTO usersDTO) throws SQLException;
	
	/**
	 * 아이디 찾기
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	/**
	 * 비밀번호 찾기(새로운 비밀번호 설정)
	 */
	void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	/**
	 * 개인정보 수정(닉네임)
	 */
	void nickUpdate(String oldNick, String newNick) throws SQLException;
	
	/**
	 * 개인정보 수정(주소)
	 */
	void addrUpdate(String oldAddr, String newAddr) throws SQLException;
	
	/**
	 * 개인정보 수정(폰번호)
	 */
	void phoneUpdate(String oldPhone, String newPhone) throws SQLException;
	
	/**
	 * 개인정보 수정(비번)
	 */
	void pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	/**
	 * 주문 리스트(회원아이디) 
	 */
	List<OrdersDTO> selectOrderList(String user_id) throws SQLException;
	
	
	/**
	 * 배송시간 조회
	 */
	List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * 환불&주문 취소
	 */
	void cancelOrder(int order_code) throws SQLException;
	
	/**
	 * 비밀번호 체크
	 */
	String pwdCheck(String user_id, String input_pwd) throws SQLException;
}
