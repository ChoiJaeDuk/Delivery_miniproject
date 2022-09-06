package delivery.mvc.dao.orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;

public interface OrdersDAO {
	List<BasketDTO> bascketDTO = new ArrayList<BasketDTO>(); 
	List<OrdersDTO> ordersList = new ArrayList<OrdersDTO>();
	
	/**
	 * Orders �� �����Ѵ� (�����Ͱ� �����ϴ� ���̱� ������ ���ϰ� ����!)
	 * �� ����(order_total_price)�� ��ٱ��Ͽ��� ������ ����!!!!
	 * */
	public int orderInsert(OrdersDTO orders) throws SQLException;
	
	
	public int[] orderLineInsert(Connection con  , OrdersDTO orders) throws SQLException;
	
	/**
	 * Store_Code�� �Է¹޾� �ش�Ǵ� ������ ����Ʈ�� ��ȯ�Ѵ�
	 * ppt 33p �ֹ���� �ҷ�����
	 * */
	public List<OrdersDTO> selectOrderList(int store_code) throws SQLException;
	
	
	/**
	 * �Ǹ��ڰ� ��� ����,�ź� �� �Է�  Orders���̺��� delivery_code�� ���νð�(SYSDATE), �����۴��ð� ������Ʈ �Ѵ�.
	 * ppt 34p ~ 35p �ֹ� ���� ����ϱ�
	 * */
	public int approveOrder(OrdersDTO orders, int delivery_time) throws SQLException;		
	

	/**
	 *  order_code�� �޾� �ش�Ǵ� �ֹ� �󼼸� ��ȸ�Ѵ�.
	 * ppt 35p �ֹ��󼼺���
	 * */
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException;

	/**
	 * ȸ���� �ֹ��� ȯ�ҽ�û�Ѵ�.
	 * ppt 65p
	 * */
	public int orderStatusUpdate(int order_code, int order_status_code) throws SQLException;
	
	/**
	 * User���忡���� �ֹ���� ��ȸ 65p
	 * */
	
	/**
	 * �ֹ������� �Է��� �Ѱ��� �� ��������
	 * Select sum(m.menu_price * b.basket_quantity) as total_price from menu m , bascket b where m.menu_code = b.menu_code;
	 * */
	public int selectStoreCodeByMenuCode(int menuCode, String user_id) throws SQLException;
	
	
}