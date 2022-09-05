package delivery.mvc.dao.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersDAO {
	/**
	 * �α���
	 * ppt 2 / 42
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * �α׾ƿ�??????????
	 */
	void usersLogout() throws SQLException;

	
	
	/**
	 * ȸ������
	 * ppt 74 ~ 78
	 */
	int join(UsersDTO usersDTO) throws SQLException;
	
	
	/**
	 * ���̵� ã��
	 * ppt 80~81
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	
	/**
	 * ��й�ȣ ã��(���ο� ��й�ȣ ����)
	 * ppt 82~83
	 */
	int searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	
	
	/**
	 * �������� ����(�г���)
	 * ppt 62~63
	 */
	int nickUpdate(String oldNick, String newNick) throws SQLException;
	
	/**
	 * �������� ����(�ּ�)
	 * ppt 62~63
	 */
	int addrUpdate(String oldAddr, String newAddr) throws SQLException;
	
	/**
	 * �������� ����(����ȣ)
	 * ppt 62~63
	 */
	int phoneUpdate(String oldPhone, String newPhone) throws SQLException;
	
	/**
	 * �������� ����(���)
	 * ppt 62~63
	 */
	int pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	
	
	/**
	 * �ֹ�����Ʈ
	 * ppt 64
	 */
	List<OrdersDTO> selectOrderList(String user_id) throws SQLException;
	
	
	/**
	 * [�ֹ� �󼼺���]
	 * ppt 65
	 */
	List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * ȯ��&�ֹ� ���
	 * ppt65
	 */
	int cancelOrder(int order_code) throws SQLException;









}
