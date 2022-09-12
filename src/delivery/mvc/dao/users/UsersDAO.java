package delivery.mvc.dao.users;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface UsersDAO {
	/**
	 * �α���(������ ���̵�� ��й�ȣ�� �Է¹޾� ��ȿ���˻縦 ��)
	 */
	UsersDTO usersLogin(String users_id, String users_pwd) throws SQLException;
	
	/**
	 * �α׾ƿ�
	 */
	void usersLogout() throws SQLException;

	
	
	/**
	 * ȸ������(�Է¹��� ������ DB�� ��� ��Ŵ)
	 */
	int join(UsersDTO usersDTO) throws SQLException;
	
	
	/**
	 * ���̵� ã��(�̸��� �ֹ��� �Է¹޾� ��ġ�ϴ� id�� �����)
	 */
	String searchId(String users_id, String users_jumin) throws SQLException;
	
	
	/**
	 * ��й�ȣ ã��(���ο� ��й�ȣ ����)
	 */
	int searchPwd(String users_id, String users_name, String users_jumin, String newpwd) throws SQLException;
	
	
	
	/**
	 * �������� ����(�г���)
	 */
	int nickUpdate(String newNick, String user_id) throws SQLException;
	
	/**
	 * �������� ����(�ּ�)
	 */
	int addrUpdate(String newAddr, String user_id) throws SQLException;
	
	/**
	 * �������� ����(����ȣ)
	 */
	int phoneUpdate(String newPhone, String user_id) throws SQLException;
	
	/**
	 * �������� ����(���)
	 */
	int pwdUpdate(String oldPwd, String newPwd) throws SQLException;
	
	
	/**
	 * �ֹ� �󼼺���(order_line)
	 */
	List<OrdersDTO> selectOrderList(String user_id) throws SQLException;
	
	
	/**
	 * �ֹ� ����Ʈ(order)
	 */
	List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException;
	
	
	/**
	 * ȯ��&�ֹ� ���(ORDER_CODE�� �Է� �޾� ORDER.DELIVERY_CODE�� 4(���)�� ����)
	 */
	int cancelOrder(int order_code) throws SQLException;


	/**
	 * ��й�ȣ Ȯ��(��й�ȣ ��ȿ�� �˻�)
	 */
	String pwdCheck(String user_id, String user_pwd) throws SQLException;



	/**
	 * �ֹ��� �ֹ������� �� �ֹ����� �ּҿ� ��ȭ��ȣ�� �������� ���� �޼ҵ�
	 * */
	public UsersDTO selectUserInfoByID(String user_id) throws SQLException;
	
	/**
	 * ȸ������ (������������ ȸ�������)
	 */
	
	public UsersDTO selectUserInfoAllPrint(String user_id) throws SQLException;


}
