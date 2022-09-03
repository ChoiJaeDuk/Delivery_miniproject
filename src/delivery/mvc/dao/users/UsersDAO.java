package delivery.mvc.dao.users;

import java.sql.SQLException;

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
	UsersDTO join() throws SQLException;
	
	
	/**
	 * ���̵� ã��
	 */
	UsersDTO searchId(String users_id, String users_jumin) throws SQLException;
	
	
	/**
	 * ��й�ȣ ã��
	 */
	UsersDTO searchPwd(String users_id, String users_name, String users_jumin) throws SQLException;
	
	
	
	/**
	 * �������� ����
	 */
	int usersUpdate(UsersDTO usersDTO) throws SQLException;
	
	
	/**
	 * ��۽ð� ��ȸ
	 */
	OrdersDTO selectDelivery_time(String deliveryTime) throws SQLException;
	
	
	/**
	 * ȯ��&�ֹ� ���
	 */
	int cancelOrder(int order_code) throws SQLException;









}
