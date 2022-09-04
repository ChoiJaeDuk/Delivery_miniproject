package delivery.mvc.dao.orders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;

public interface OrdersDAO {
	List<OrdersDTO> list = new ArrayList<OrdersDTO>();
	
	
	/**
	 * Orders �� �����Ѵ� (�����Ͱ� �����ϴ� ���̱� ������ ���ϰ� ����!)
	 * �� ����(order_total_price)�� ��ٱ��Ͽ��� ������ ����!!!!
	 * */
	public int orderInsert(String user_id, int store_code, int order_total_price, int delivery_code) throws SQLException;
	
	
	/**
	 * Store_Code�� �Է¹޾� �ش�Ǵ� ������ ����Ʈ�� ��ȯ�Ѵ�
	 * ppt 33p �ֹ���� �ҷ�����
	 * */
	public List<OrdersDTO> selectOrderList(int store_code) throws SQLException;
	
	
	/**
	 * �Ǹ��ڰ� ��� ����,�ź� �� �Է�  Orders���̺��� delivery_code�� ���νð�(SYSDATE), �����۴��ð� ������Ʈ �Ѵ�.
	 * ppt 34p ~ 35p �ֹ� ���� ����ϱ�
	 * */
	public OrdersDTO approveOrder(int delivery_code, int order_delivery_time, int ordercode) throws SQLException;		
	

	/**
	 *  order_code�� �޾� �ش�Ǵ� �ֹ� �󼼸� ��ȸ�Ѵ�.
	 * ppt 35p �ֹ��󼼺���
	 * */
	public List<OrderLineDTO> selectOrderLine(int order_code) throws SQLException;

	/**
	 * ȸ���� �ֹ��� ȯ�ҽ�û�Ѵ�.
	 * ppt 65p
	 * */
	public int cancelOrder(int order_code) throws SQLException;
	
	
	/**
	 * �ֹ������� �Է��� �Ѱ��� �� ��������
	 * Select sum(m.menu_price * b.basket_quantity) as total_price from menu m , bascket b where m.menu_code = b.menu_code;
	 * */
	public int totalPriceSelect(String user_id) throws SQLException;
	
}