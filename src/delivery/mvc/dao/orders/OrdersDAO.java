package delivery.mvc.dao.orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface OrdersDAO {
	List<BasketDTO> bascketDTO = new ArrayList<BasketDTO>(); 
	List<OrdersDTO> ordersList = new ArrayList<OrdersDTO>();
	
	/**
	 * Orders ���̺� �ֹ������� ����Ѵ�.
	 * �� �������� OrderLine (�ֹ���)�� ����ϰ�
	 * basketDelete(��ٱ��ϻ���) �ش� userid�� ��ٱ��� ���⸦ Ʈ����� ó���Ѵ�.
	 * @return ���� 0 �̸� ��� ����.
	 * */
	public int orderInsert(OrdersDTO orders) throws SQLException;
	
	
	/**
	 * �ֹ��󼼳����� ����ϴ� �޼ҵ�
	 * */
	public int[] orderLineInsert(Connection con  , OrdersDTO orders) throws SQLException;
	
	/**
	 * Store_Code�� �Է¹޾� �ش�Ǵ� �ֹ����� ����Ʈ�� �����Ѵ�.
	 * */
	public List<OrdersDTO> selectOrderList(int store_code) throws SQLException;
	
	
	/**
	 * �Ǹ��ڰ� ��� ����,�źθ� �����ϸ� Orders���̺��� delivery_code�� ���νð�(SYSDATE), �����۴��ð� ������Ʈ �Ѵ�.
	 * */
	public int approveOrder(OrdersDTO orders, int delivery_time) throws SQLException;		
	

	/**
	 *  order_code�� �޾� �ش�Ǵ� �ֹ��ڵ��� �ֹ� �󼼸� ��ȸ�Ѵ�.
	 * */
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException;

	/**
	 * ȸ���� �ֹ��� ȯ�ҽ�û�� �ϸ� �ֹ������� delivery_code�� 4(���)���·� �ٲ��.
	 * */
	public int orderStatusUpdate(int order_code, int order_status_code) throws SQLException;
	
	
	/**
	 * menuCode�� user_id�� ���� store_code���� �����ϴ� �޼ҵ�
	 * */
	public int selectStoreCodeByMenuCode(int menuCode, String user_id) throws SQLException;
	
	
	
}