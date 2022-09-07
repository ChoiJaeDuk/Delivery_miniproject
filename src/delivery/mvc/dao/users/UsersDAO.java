package delivery.mvc.dao.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersDAO {
	/**
	 * 로그인
	 * ppt 2 / 42
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * 로그아웃??????????
	 */
	void usersLogout() throws SQLException;

	
	
	/**
	 * 회원가입
	 * ppt 74 ~ 78
	 */
	int join(UsersDTO usersDTO) throws SQLException;
	
	
	/**
	 * 아이디 찾기
	 * ppt 80~81
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	
	/**
	 * 비밀번호 찾기(새로운 비밀번호 설정)
	 * ppt 82~83
	 */
	int searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	
	
	/**
	 * 개인정보 수정(닉네임)
	 * ppt 62~63
	 */
	int nickUpdate(String newNick, String user_id) throws SQLException;
	
	/**
	 * 개인정보 수정(주소)
	 * ppt 62~63
	 */
	int addrUpdate(String newAddr, String user_id) throws SQLException;
	
	/**
	 * 개인정보 수정(폰번호)
	 * ppt 62~63
	 */
	int phoneUpdate(String newPhone, String user_id) throws SQLException;
	
	/**
	 * 개인정보 수정(비번)
	 * ppt 62~63
	 */
	int pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	
	
	/**
	 * 주문리스트
	 * ppt 64
	 */
	List<OrdersDTO> selectOrderList(String user_id) throws SQLException;
	
	
	/**
	 * [주문 상세보기]
	 * ppt 65
	 */
	List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * 환불&주문 취소
	 * ppt65
	 */
	int cancelOrder(int order_code) throws SQLException;


	/**
	 * 비밀번호 확인
	 */
	String pwdCheck(String user_id, String user_pwd) throws SQLException;



	/**
	 * 주문시 주문내역에 들어갈 주문자의 주소와 전화번호를 가져오기 위한 메소드
	 * */
	public UsersDTO selectUserInfoByID(String user_id) throws SQLException;


}
