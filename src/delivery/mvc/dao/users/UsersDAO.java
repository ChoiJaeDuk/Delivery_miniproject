package delivery.mvc.dao.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersDAO {
	/**
	 * �α���
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * �α׾ƿ�??????????
	 */
	void usersLogout() throws SQLException;

	
	
	/**
	 * ȸ������
	 */
	int join(UsersDTO usersDTO) throws SQLException;
	
	
	/**
	 * ���̵� ã��
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	
	/**
	 * ��й�ȣ ã��(���ο� ��й�ȣ ����)
	 */
	int searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	
	
	/**
	 * �������� ����(�г���)
	 */
	int nickUpdate(String oldNick, String newNick) throws SQLException;
	
	/**
	 * �������� ����(�ּ�)
	 */
	int addrUpdate(String oldAddr, String newAddr) throws SQLException;
	
	/**
	 * �������� ����(����ȣ)
	 */
	int phoneUpdate(String oldPhone, String newPhone) throws SQLException;
	
	/**
	 * �������� ����(���)
	 */
	int pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	
	
	
	
	/**
	 * ��۽ð� ��ȸ
	 */
	List<OrdersDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * ȯ��&�ֹ� ���
	 */
	int cancelOrder(int order_code) throws SQLException;









}
