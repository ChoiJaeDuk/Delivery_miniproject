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

	@Override
	public UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException {
		UsersDTO user = usersDAO.usersLogin(users_id, users_pwd);
		if(user == null) throw new SQLException("정보가 일치 하지 않습니다.");
		
		Session session = new Session(users_id);
		SessionSet sessionSet = SessionSet.getInstance();
		
		sessionSet.add(session);
		
		return user;
	}

	@Override
	public void usersLogout() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void join(UsersDTO usersDTO) throws SQLException {
		int result = usersDAO.join(usersDTO);
		if(result == 0) throw new SQLException("등록을 실패했습니다.");

	}

	@Override
	public String searchId(String users_id, String users_jumin) throws SQLException {
		String result = usersDAO.searchId(users_id, users_jumin);
		if(result == null) throw new SQLException("정보를 찾을 수 없습니다.");
		return result;
	}

	@Override
	public void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException {
		int result = usersDAO.searchPwd(users_id, users_name, users_jumin, newpwd);
		if(result == 0) throw new SQLException("비밀번호 찾기에 실패했습니다.");

	}

	@Override
	public void nickUpdate(String oldNick, String newNick) throws SQLException {
		int result = usersDAO.nickUpdate(oldNick, newNick);
		if(result ==0) throw new SQLException("닉네임 재설정에 실패했습니다.");

	}

	@Override
	public void addrUpdate(String oldAddr, String newAddr) throws SQLException {
		int result = usersDAO.addrUpdate(oldAddr, newAddr);
		if(result ==0) throw new SQLException("주소 재설정에 실패했습니다.");

	}

	@Override
	public void phoneUpdate(String oldPhone, String newPhone) throws SQLException {
		int result = usersDAO.phoneUpdate(oldPhone, newPhone);
		if(result ==0) throw new SQLException("핸드폰번호 재설정에 실패했습니다.");

	}

	@Override
	public void pwdUpdate(String oldPwd, String newPwd) throws SQLException {
		int result = usersDAO.pwdUpdate(oldPwd, newPwd);
		if(result ==0) throw new SQLException("비밀번호 재설정에 실패했습니다.");

	}

	@Override
	public List<OrdersDTO> selectOrderList(String user_id) throws SQLException {
		List<OrdersDTO> list = usersDAO.selectOrderList(user_id);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(user_id + "에 해당하는 정보가 없습니다.");
		return list;
	}
	

	@Override
	public List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException {
		List<OrderLineDTO> list = usersDAO.selectDelivery_time(order_code);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(order_code + "에 해당하는 정보가 없습니다.");
		return list;
	}

	@Override
	public void cancelOrder(int order_code) throws SQLException {
		int result = usersDAO.cancelOrder(order_code);
		if(result ==0) throw new SQLException(order_code + "의 주문취소를 실패했습니다.");
	}



}
