package delivery.mvc.dao.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.utill.DbUtil;
import kosta.mvc.model.dto.Goods;
import kosta.mvc.model.dto.OrderLine;
import kosta.mvc.model.dto.Orders;

public class OrdersDAOImpl implements OrdersDAO {

	
	/**
	 * Orders �� �����Ѵ� (�����Ͱ� �����ϴ� ���̱� ������ ���ϰ� ����!)
	 * �� ����(order_total_price)�� ��ٱ��Ͽ��� ������ ����!!!!
	 * INSERT INTO ORDERS VALUES(ORDER_CODE_SEQ.NEXTVAL,?, ?, SYSDATE, ?,NULL,NULL,?)
	 * */
	@Override
	public int orderInsert(String user_id, int store_code, int order_total_price, int delivery_code) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		//String sql = 
		OrdersDTO orders = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement("INSERT INTO ORDERS VALUES(ORDER_CODE_SEQ.NEXTVAL,?, ?, SYSDATE, ?,NULL,NULL,?)");
			ps.setString(1,user_id);
			ps.setInt(2, store_code );
			ps.setInt(3, order_total_price);
			ps.setInt(4, delivery_code);
	       
			result = ps.executeUpdate(); 
	        
			if(result == 0) {
				throw new SQLException("����� �� �����ϴ�.");
			}else {
				orderLineInsert(con, orders);
			}
		}finally {
			DbUtil.close(con, ps);
		}
		return result;
	}
	
	
	/**
	 * �ֹ��� ����ϱ� 
	 * OrdersDTO�� orderlinelist��ü �����ؾ���.
	 * */
	public int[] orderLineInsert(Connection con  , OrdersDTO orders) throws SQLException{
		
		  PreparedStatement ps=null;
		  String sql="";
		 try {
			 ps = con.prepareStatement(sql);
			 for( OrderLineDTO orderline : orders.getOrderLineList()) {
			  
//			   ps.setString(1, );
//			   ps.setInt(2, );//
//			   ps.setInt(3, );//
//			   ps.setInt(4, ));//
//			   ps.addBatch(); //�ϰ�ó���� �۾��� �߰�
//			   ps.clearParameters();
			   
		  }
		  result = ps.executeBatch();//�ϰ�ó��
		  
		   
    }finally {
    	DbUtil.close(null, ps);
    }
		
		return result;
		
	}
	
	/**
	 * Store_Code�� �Է¹޾� �ش�Ǵ� ������ ����Ʈ�� ��ȯ�Ѵ�
	 * ppt 33p �ֹ���� �ҷ�����
	 * */
	@Override
	public List<OrdersDTO> selectOrderList(int store_code) {
		
		return null;
	}

	
	/**
	 * �Ǹ��ڰ� ��� ����,�ź� �� �Է�  Orders���̺��� delivery_code�� ���νð�(SYSDATE), �����۴��ð� ������Ʈ �Ѵ�.
	 * ppt 34p �ֹ� ���� ����ϱ�
	 * UPDATE ORDERS SET DELIVERY_CODE = ?, ORDER_APPROVAL_TIME = CURRENT_DATE ,ORDER_DELIVERY_TIME = (CURRENT_DATE + ?/(24*60)) WHERE ORDER_CODE = ?
	 * */
	@Override
	public OrdersDTO approveOrder(int delivery_code, int order_delivery_time, int order_code) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		OrdersDTO orders = null;
		  
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("UPDATE ORDERS "
					+ "SET DELIVERY_CODE = ?, ORDER_APPROVAL_TIME = CURRENT_DATE ,ORDER_DELIVERY_TIME = (CURRENT_DATE + ?/(24*60)) "
					+ "WHERE ORDER_CODE = ?");
			
			ps.setInt(1, delivery_code);
			ps.setInt(2, order_delivery_time);
			ps.setInt(3, order_code);
			
			ps.executeUpdate(); 
	        
		}finally {
			DbUtil.close(con, ps);
		}
		return orders;
	}

	
	
	/**
	 *  order_code�� �޾� �ش�Ǵ� �ֹ� �󼼸� ��ȸ�Ѵ�.
	 * ppt 35p �ֹ��󼼺���
	 * */
	public List<OrderLineDTO> selectOrderLine(int order_code) throws SQLException{
		return null;
	}
	
	
	/**
	 * ȸ���� �ֹ��� ȯ�ҽ�û�Ѵ�.
	 * UPDATE ORDERS SET DELIVERY_CODE = 3 WHERE ORDER_CODE = ?
	 * ppt 65p
	 * */
	@Override
	public int cancelOrder(int order_code) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result = 0;
		 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("UPDATE ORDERS SET DELIVERY_CODE = 3 WHERE ORDER_CODE = ?");
			
			ps.setInt(1, order_code);
			
			result = ps.executeUpdate(); 
	        if (result == 0) {
	        	throw new SQLException("����");
	        }
		}finally {
			DbUtil.close(con, ps);
		}
		return result;
	}
	
	
	
	
	/**
	 * �ֹ������� �Է��� �Ѱ��� �� ��������
	 * Select sum(m.menu_price * b.basket_quantity) as total_price from menu m , bascket b where m.menu_code = b.menu_code and b.user_id = ?
	 * */
	public int totalPriceSelect(String user_id) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int bascket_totalPrice = 0;
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement("Select sum(m.menu_price * b.basket_quantity) as total_price from menu m , bascket b where m.menu_code = b.menu_code and b.user_id = ?");
			ps.setString(1, user_id);
		    rs = ps.executeQuery(); 
		    
		    if(rs.next()) {
		    	bascket_totalPrice = rs.getInt(1);
		    }
		    
		}finally {
			DbUtil.close(null, ps, rs);
		}
		return bascket_totalPrice;
	}
	
	
	//�׽�Ʈ�մϴ�!!!!!
	public static void main(String [] args) {
		try {
			OrdersDAOImpl orderDAO = new OrdersDAOImpl();
			//orderDAO.orderInsert("testid",3, 50000,3);
			//orderDAO.approveOrder(2, 20, 12);
			//orderDAO.cancelOrder(1);
			int i = orderDAO.totalPriceSelect("testid");
			System.out.println("����Ϸ�" + i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
