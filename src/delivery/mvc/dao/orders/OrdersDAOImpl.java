package delivery.mvc.dao.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dao.basket.BasketDAO;
import delivery.mvc.dao.basket.BasketDAOImpl;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.Delivery_StatusDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;
import util.DbUtil;

public class OrdersDAOImpl implements OrdersDAO {
	BasketDAO basketDao = new BasketDAOImpl();
	List<BasketDTO> bascketlist = new ArrayList<BasketDTO>(); 
	List<OrdersDTO> ordersList = new ArrayList<OrdersDTO>();
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
			con.setAutoCommit(false);
			
			ps= con.prepareStatement("INSERT INTO ORDERS VALUES(ORDER_CODE_SEQ.NEXTVAL,?, ?, SYSDATE, ?,NULL,NULL,?)");
			ps.setString(1,user_id);
			ps.setInt(2, store_code );
			ps.setInt(3, order_total_price);
			ps.setInt(4, delivery_code);
			
			orders = new OrdersDTO(user_id);
			
			result = ps.executeUpdate(); 
	        
			if(result == 0) {
				con.rollback();
				throw new SQLException("����� �� �����ϴ�.");
			}else {
				int re [] = orderLineInsert(con, orders);
				for(int i : re) {
					if(i != 1) {//
						con.rollback();
						throw new SQLException("�ֹ��� �� �����ϴ�...");
					}
				}
				basketDao.basketDelete(con, orders);
				con.commit();
			}
			
		}finally {
			con.commit();
			DbUtil.dbClose(con, ps, null);
		}
		return result;
	}
	
	
	/**
	 * �ֹ��� ����ϱ� 
	 * OrdersDTO�� orderlinelist��ü �����ؾ���.
	 * */
	public int[] orderLineInsert(Connection con  , OrdersDTO orders) throws SQLException{
			
		  PreparedStatement ps=null;
		  String sql="INSERT INTO ORDER_LINE VALUES(ORDER_LINE_CODE_SEQ.NEXTVAL,ORDER_CODE_SEQ.CURRVAL,?,?)";
		  int result [] = null;
		 try {
			 ps = con.prepareStatement(sql);
		//	 for( OrderLineDTO orderline : orders.getOrderLineList()) {
				 bascketlist = basketDao.basketSelectAll(orders.getUser_id());
				 for (BasketDTO bascket : bascketlist) {
						
					 ps.setInt(1, bascket.getMenu_code());
					 ps.setInt(2, bascket.getBasket_quantity());
					 ps.addBatch();
					 ps.clearParameters();
				 }
			   
		//  }
		  result = ps.executeBatch();//�ϰ�ó��
		  
		   
    }finally {
    	DbUtil.dbClose(null, ps, null);
    }
		
		return result;
		
	}
	
	/**
	 * Store_Code�� �Է¹޾� �ش�Ǵ� ������ ����Ʈ�� ��ȯ�Ѵ�
	 * ppt 33p �ֹ���� �ҷ�����
	 * */
	@Override
	public List<OrdersDTO> selectOrderList(int store_code)throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		OrdersDTO orders = null;
		UsersDTO users = null;	
		Delivery_StatusDTO delivery_status = null;
		
		List<OrdersDTO> listOrders = new ArrayList<OrdersDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement("SELECT O.ORDER_CODE, O.USER_ID, U.USER_PHONE, U.USER_ADDR, D.DELIVERY_STATUS\r\n"
					+ "FROM USERS U , ORDERS O ,DELIVERY_STATUS D \r\n"
					+ "WHERE U.USER_ID = O.USER_ID AND O.DELIVERY_CODE = D.DELIVERY_CODE AND O.STORE_CODE = ?");
			
			ps.setInt(1, store_code);
		    rs = ps.executeQuery(); 
		    
		    while(rs.next()) {
		    	
		    	users = new UsersDTO(rs.getString(3), rs.getString(4));
		    	delivery_status = new Delivery_StatusDTO(rs.getString(5));
		    	orders = new OrdersDTO(rs.getInt(1), rs.getString(2), users, delivery_status);
		    	listOrders.add(orders);
		    }
		      
		    
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return listOrders;
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
			DbUtil.dbClose(con, ps);
		}
		return orders;
	}

	
	
	/**
	 *  user_id�� �޾� �ش�Ǵ� �ֹ� �󼼸� ��ȸ�Ѵ�.
	 * ppt 35p �ֹ��󼼺���
	 * */
	public List<MenuDTO> selectOrderLine(String user_id) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		BasketDTO bascket = null;
		
		MenuDTO menuDTO = null;
		List<MenuDTO> listMenu = new ArrayList<MenuDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement("SELECT M.MENU_NAME, B.BASKET_QUANTITY, M.MENU_PRICE, SUM(M.MENU_PRICE*B.BASKET_QUANTITY)\r\n"
					+ "FROM BASCKET B JOIN MENU M \r\n"
					+ "ON B.MENU_CODE = M.MENU_CODE\r\n"
					+ "GROUP BY  M.MENU_NAME, B.BASKET_QUANTITY, B.USER_ID, M.MENU_PRICE\r\n"
					+ "HAVING B.USER_ID = ?");
			
			ps.setString(1, user_id);
		    rs = ps.executeQuery(); 
		    
		    while(rs.next()) {
		    	
		    	bascket = new BasketDTO(rs.getInt(2));
		    	menuDTO = new MenuDTO(rs.getString(1), bascket, rs.getInt(3), rs.getInt(4));
		    	listMenu.add(menuDTO);
		    }
		      
		    
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return listMenu;

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
			DbUtil.dbClose(con, ps);
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
			DbUtil.dbClose(null, ps, rs);
		}
		return bascket_totalPrice;
	}
	
	
	//�׽�Ʈ�մϴ�!!!!!
	public static void main(String [] args) {
		try {
			OrdersDAOImpl orderDAO = new OrdersDAOImpl();
			orderDAO.orderInsert("testid",3, 990000,1);
			
//			
//		
//			orderDAO.approveOrder(2, 20, 12);
//			//orderDAO.cancelOrder(1);
//			//int i = orderDAO.totalPriceSelect("testid");
//			
			/*
			List<MenuDTO> l = orderDAO.selectOrderLine("testid");
			for (MenuDTO list : l) {
				System.out.println(list.getMenu_name() + "  " + list.getBascket().getBasket_quantity() + "   " + list.getMenu_price() + "   " + list.getTotal_price() );
			}
		*/
			/*
			List<OrdersDTO> ordersList = orderDAO.selectOrderList(2);
			for (OrdersDTO o: ordersList) {
				System.out.println(o.getOrder_code() + "  " + o.getUser_id() + "  " + o.getUsers().getUsers_phone() + "  " + o.getUsers().getUsers_addr() + "  " + o.getDelivery_status().getDelivery_status());
			}
			*/
			System.out.println("����");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
