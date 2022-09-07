package delivery.mvc.service.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersService {
	/**
	 * �α���
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * �α׾ƿ�
	 */
	void usersLogout() throws SQLException;
	
	/**
	 * ȸ������
	 */
	void join(UsersDTO usersDTO) throws SQLException;
	
	/**
	 * ���̵� ã��
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	/**
	 * ��й�ȣ ã��(���ο� ��й�ȣ ����)
	 */
	void searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	/**
	 * �������� ����(�г���)
	 */
	void nickUpdate(String oldNick, String newNick) throws SQLException;
	
	/**
	 * �������� ����(�ּ�)
	 */
	void addrUpdate(String oldAddr, String newAddr) throws SQLException;
	
	/**
	 * �������� ����(����ȣ)
	 */
	void phoneUpdate(String oldPhone, String newPhone) throws SQLException;
	
	/**
	 * �������� ����(���)
	 */
	void pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	/**
	 * �ֹ� ����Ʈ(ȸ�����̵�) 
	 */
	List<OrdersDTO> selectOrderList(String user_id) throws SQLException;
	
	
	/**
	 * ��۽ð� ��ȸ
	 */
	List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * ȯ��&�ֹ� ���
	 */
	void cancelOrder(int order_code) throws SQLException;
	
	/**
	 * ��й�ȣ üũ
	 */
	String pwdCheck(String user_id, String input_pwd) throws SQLException;
}
