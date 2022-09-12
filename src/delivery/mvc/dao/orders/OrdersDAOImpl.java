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
import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;
import util.DbUtil;

public class OrdersDAOImpl implements OrdersDAO {
	BasketDAO basketDao = new BasketDAOImpl();
	List<BasketDTO> bascketlist = new ArrayList<BasketDTO>(); 
	List<OrdersDTO> ordersList = new ArrayList<OrdersDTO>();
	
	/**
	 * Orders 테이블에 주문내역을 등록한다.
	 * 이 과정에서 OrderLine (주문상세)을 등록하고
	 * basketDelete(장바구니삭제) 해당 userid의 장바구니 비우기를 트랜잭션 처리한다.
	 * @return 값이 0 이면 등록 실패.
	 * */
	@Override
	public int orderInsert(OrdersDTO orders) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		//String sql = 
	
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			ps= con.prepareStatement("INSERT INTO ORDERS VALUES(ORDER_CODE_SEQ.NEXTVAL,?, ?, CURRENT_DATE, ?,NULL,NULL,0, ?, ?)");
			ps.setString(1,orders.getUser_id());
			ps.setInt(2, orders.getStore_code());
			ps.setInt(3, orders.getOrder_total_price());
			ps.setString(4, orders.getDelivery_addr());
			ps.setString(5, orders.getUser_phone());
	
			
			
			result = ps.executeUpdate(); 
	        
			if(result == 0) {
				con.rollback();
				throw new SQLException("등록할 수 없습니다.");
			}else {
				int re [] = orderLineInsert(con, orders);
				for(int i : re) {
					if(i != 1) {//
						con.rollback();
						throw new SQLException("주문할 수 없습니다...");
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
	 * 주문상세내역을 등록하는 메소드
	 * */
	public int[] orderLineInsert(Connection con, OrdersDTO orders) throws SQLException {

		PreparedStatement ps = null;
		String sql = "INSERT INTO ORDER_LINE VALUES(ORDER_LINE_CODE_SEQ.NEXTVAL,ORDER_CODE_SEQ.CURRVAL,?,?)";
		int result[] = null;
		try {
			ps = con.prepareStatement(sql);
			// for( OrderLineDTO orderline : orders.getOrderLineList()) {
			bascketlist = basketDao.basketSelectAll(orders.getUser_id());
			for (BasketDTO bascket : bascketlist) {

				ps.setInt(1, bascket.getMenu_code());
				ps.setInt(2, bascket.getBasket_quantity());
				ps.addBatch();
				ps.clearParameters();
			}
			// }
			result = ps.executeBatch();// 일괄처리

		} finally {
			DbUtil.dbClose(null, ps, null);
		}
		return result;
	}
	
	
	/**
	 * Store_Code를 입력받아 해당되는 주문내역 리스트를 리턴한다.
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
			ps= con.prepareStatement("SELECT O.ORDER_CODE, O.USER_ID, O.USER_PHONE, O.DELIVERY_ADDR, D.DELIVERY_STATUS\r\n"
					+ "FROM  ORDERS O ,DELIVERY_STATUS D \r\n"
					+ "WHERE O.DELIVERY_CODE = D.DELIVERY_CODE AND O.STORE_CODE = ? ORDER BY DELIVERY_STATUS");
			
			ps.setInt(1, store_code);
		    rs = ps.executeQuery(); 
		    
		    while(rs.next()) {
		 
		    	
		    	delivery_status = new Delivery_StatusDTO(rs.getString(5));
		    	orders = new OrdersDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), delivery_status);
		    	listOrders.add(orders);
		    }
		      
		    
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return listOrders;
	}

	
	/**
	 * 판매자가 배달 승인,거부를 선택하면 Orders테이블의 delivery_code와 승인시간(SYSDATE), 예상배송대기시간 업데이트 한다.
	 * */
	@Override
	public int approveOrder(OrdersDTO orders, int delivery_time) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result = 0;
		  
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("UPDATE ORDERS "
					+ "SET DELIVERY_CODE = ?, ORDER_APPROVAL_TIME = CURRENT_DATE ,ORDER_DELIVERY_TIME = (CURRENT_DATE + ?/(24*60)) "
					+ "WHERE ORDER_CODE = ?");
			
			ps.setInt(1, orders.getDelivery_code());
			ps.setInt(2, delivery_time);
			ps.setInt(3, orders.getOrder_code());
			
			result = ps.executeUpdate(); 
	        
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	
	
	/**
	 *  order_code를 받아 해당되는 주문코드의 주문 상세를 조회한다.
	 * */
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		OrderLineDTO orderLine = null;
		MenuDTO menuDTO = null;
		List<MenuDTO> listMenu = new ArrayList<MenuDTO>();
		
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement("SELECT M.MENU_NAME, OL.ORDER_QUANTITY, M.MENU_PRICE, OL.ORDER_QUANTITY * M.MENU_PRICE AS TOTAL\r\n"
					+ "FROM MENU M, ORDER_LINE OL\r\n"
					+ "WHERE M.MENU_CODE = OL.MENU_CODE AND ORDER_CODE = ?");
			
			ps.setInt(1, order_code);
		    rs = ps.executeQuery(); 
		    
		    while(rs.next()) {
		    	
		    	orderLine = new OrderLineDTO(rs.getInt(2));
		    	menuDTO = new MenuDTO(rs.getString(1), orderLine, rs.getInt(3), rs.getInt(4));
		    	listMenu.add(menuDTO);
		    }
		      
		    
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return listMenu;

	}
	
	
	
	
	/**
	 * 회원이 주문을 환불신청을 하면 주문내역의 delivery_code가 4(취소)상태로 바뀐다.
	 * */
	@Override
	public int orderStatusUpdate(int order_code, int order_status_code) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result = 0;
		 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("UPDATE ORDERS SET DELIVERY_CODE = ? WHERE ORDER_CODE = ?");
			
			ps.setInt(1, order_status_code);
			ps.setInt(2, order_code);
			result = ps.executeUpdate(); 
	        if (result == 0) {
	        	throw new SQLException("실패");
	        }
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}


	/**
	 * menuCode와 user_id를 통해 store_code값을 리턴하는 메소드
	 * */
	@Override
	public int selectStoreCodeByMenuCode(int menuCode ,String user_id) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int store_code = 0;
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement("SELECT DISTINCT M.STORE_CODE \r\n"
					+ "FROM MENU M, BASCKET B \r\n"
					+ "WHERE M.MENU_CODE = B.MENU_CODE AND M.MENU_CODE = ? AND B.USER_ID = ?\r\n"
					+ "");
			
			ps.setInt(1, menuCode);
			ps.setString(2,user_id);
		    rs = ps.executeQuery(); 
	    
		    if(rs.next()) {
		    	store_code = rs.getInt(1);
		    }
		      
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return store_code;
	}



	
	
	

	
	
	
	//테스트합니다!!!!!
	/*
	 * public static void main(String [] args) {
		try {
			OrdersDAOImpl orderDAO = new OrdersDAOImpl();
			//orderDAO.orderInsert("testid",3, 990000,1);
			
//			
//		
			//orderDAO.approveOrder(2, 20, 12);
//			//orderDAO.cancelOrder(1);
			int i = orderDAO.totalPriceSelect("testid");
//			
			/*
			
			List<MenuDTO> l = orderDAO.selectOrderLine(1);
			for (MenuDTO list : l) {
				System.out.println(list.getMenu_name() + "  " + list.getOrderLine().getOrder_quntity() + "   " + list.getMenu_price() + "   " + list.getTotal_price() );
				
			}
			*/
			/*
			List<OrdersDTO> ordersList = orderDAO.selectOrderList(2);
			for (OrdersDTO o: ordersList) {
				System.out.println(o.getOrder_code() + "  " + o.getUser_id() + "  " + o.getUsers().getUsers_phone() + "  " + o.getUsers().getUsers_addr() + "  " + o.getDelivery_status().getDelivery_status());
			}
			
			System.out.println("성공");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
