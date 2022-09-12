package delivery.mvc.service.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersService {
	/**
	 * 로그인(계정의 아이디와 비밀번호를 입력받아 유효성검사를 함)
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * 로그아웃
	 */
	void usersLogout() throws SQLException;
	
	/**
	 * 회원가입(입력받은 정보를 DB에 등록 시킴)
	 */
	void join(UsersDTO usersDTO) throws SQLException;
	
	/**
	 * 아이디 찾기(이름과 주민을 입력받아 일치하는 id를 출력함)
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	/**
	 * 비밀번호 찾기(새로운 비밀번호 설정)
	 */
	void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	/**
	 * 개인정보 수정(닉네임)
	 */
	void nickUpdate(String newNick, String user_id) throws SQLException;
	
	/**
	 * 개인정보 수정(주소)
	 */
	void addrUpdate(String newAddr, String user_id) throws SQLException;
	
	/**
	 * 개인정보 수정(폰번호)
	 */
	void phoneUpdate(String newPhone, String user_id) throws SQLException;
	
	/**
	 * 개인정보 수정(비번)
	 */
	void pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	/**
	 * 주문 상세보기(order_line)
	 */
	List<OrdersDTO> selectOrderList(String user_id) throws SQLException;
	
	
	/**
	 * 주문 리스트(order)
	 */
	List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * 환불&주문 취소(ORDER_CODE를 입력 받아 ORDER.DELIVERY_CODE를 4(취소)로 변경)
	 */
	void cancelOrder(int order_code) throws SQLException;
	
	/**
	 * 비밀번호 확인(비밀번호 유효성 검사)
	 */
	String pwdCheck(String user_id, String input_pwd) throws SQLException;
	
	/**
	 * 회원정보 (마이페이지의 회정보출력)
	 */
	UsersDTO selectUserInfoAllPrint(String user_id) throws SQLException;
}
