package delivery.mvc.service.users;

import java.sql.SQLException;

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
	 * ��۽ð� ��ȸ
	 */
	OrdersDTO selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * ȯ��&�ֹ� ���
	 */
	int cancelOrder(int order_code) throws SQLException;
}
