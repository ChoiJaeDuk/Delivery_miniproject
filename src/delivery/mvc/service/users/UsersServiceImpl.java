package delivery.mvc.service.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.users.UsersDAO;
import delivery.mvc.dao.users.UsersDAOImpl;
import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;
import delivery.mvc.session.Session;
import delivery.mvc.session.SessionSet;

public class UsersServiceImpl implements UsersService {
	UsersDAO usersDAO = new UsersDAOImpl();

	/**
	 * 로그인(계정의 아이디와 비밀번호를 입력받아 유효성검사를 함)
	 */
	@Override
	public UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException {
		UsersDTO user = usersDAO.usersLogin(users_id, users_pwd);
		if(user == null) throw new SQLException("정보가 일치 하지 않습니다.");
		
		Session session = new Session(users_id);
		SessionSet sessionSet = SessionSet.getInstance();
		
		sessionSet.add(session);
		
		return user;
	}

	/**
	 * 로그아웃
	 */
	@Override
	public void usersLogout() throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * 회원가입(입력받은 정보를 DB에 등록 시킴)
	 */
	@Override
	public void join(UsersDTO usersDTO) throws SQLException {
		int result = usersDAO.join(usersDTO);
		if(result == 0) throw new SQLException("등록을 실패했습니다.");

	}

	/**
	 * 아이디 찾기(이름과 주민을 입력받아 일치하는 id를 출력함)
	 */
	@Override
	public String searchId(String users_id, String users_jumin) throws SQLException {
		String result = usersDAO.searchId(users_id, users_jumin);
		if(result == null) throw new SQLException("정보를 찾을 수 없습니다.");
		return result;
	}

	/**
	 * 비밀번호 찾기(새로운 비밀번호 설정)
	 */
	@Override
	public void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException {
		int result = usersDAO.searchPwd(users_id, users_name, users_jumin, newpwd);
		if(result == 0) throw new SQLException("비밀번호 찾기에 실패했습니다.");

	}

	/**
	 * 개인정보 수정(닉네임)
	 */
	@Override
	public void nickUpdate(String newNick, String user_id) throws SQLException {
		int result = usersDAO.nickUpdate(newNick,user_id);
		if(result ==0) throw new SQLException("닉네임 수정에 실패했습니다.");

	}

	/**
	 * 개인정보 수정(주소)
	 */
	@Override
	public void addrUpdate(String newAddr, String user_id) throws SQLException {
		int result = usersDAO.addrUpdate(newAddr,user_id);
		if(result ==0) throw new SQLException("주소 수정에 실패했습니다.");

	}
	
	/**
	 * 개인정보 수정(폰번호)
	 */
	@Override
	public void phoneUpdate(String newPhone, String user_id) throws SQLException {
		int result = usersDAO.phoneUpdate(newPhone,user_id);
		if(result ==0) throw new SQLException("전화번호 수정에 실패했습니다.");

	}
	
	/**
	 * 개인정보 수정(비번)
	 */
	@Override
	public void pwdUpdate(String oldPwd, String newPwd) throws SQLException {
		int result = usersDAO.pwdUpdate(oldPwd, newPwd);
		if(result ==0) throw new SQLException("비밀번호 수정에 실패했습니다.");

	}

	/**
	 * 주문 상세보기(order_line)
	 */
	@Override
	public List<OrdersDTO> selectOrderList(String user_id) throws SQLException {
		List<OrdersDTO> list = usersDAO.selectOrderList(user_id);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(user_id + "에 해당하는 정보가 없습니다.");
		return list;
	}
	
	/**
	 * 주문 리스트(order)
	 */
	@Override
	public List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException {
		List<OrderLineDTO> list = usersDAO.selectDelivery_time(order_code);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(order_code + "에 해당하는 정보가 없습니다.");
		return list;
	}

	/**
	 * 환불&주문 취소(ORDER_CODE를 입력 받아 ORDER.DELIVERY_CODE를 4(취소)로 변경)
	 */
	@Override
	public void cancelOrder(int order_code) throws SQLException {
		int result = usersDAO.cancelOrder(order_code);
		if(result ==0) throw new SQLException(order_code + "의 주문취소를 실패했습니다.");
	}

	/**
	 * 비밀번호 확인(비밀번호 유효성 검사)
	 */
	@Override
	public String pwdCheck(String user_id, String input_pwd) throws SQLException {
		String result = usersDAO.pwdCheck(user_id, input_pwd);
		if(result == null) throw new SQLException("서비스 : 비밀번호가 일치하지 않습니다.");

		return result;
	}

	/**
	 * 회원정보
	 */
	@Override
	public UsersDTO selectUserInfoAllPrint(String user_id) throws SQLException {
		UsersDTO user = usersDAO.selectUserInfoAllPrint(user_id);
		if(user == null) throw new SQLException("정보를 찾을 수 없습니다.");
		return user;
	}
	

	
	


}
