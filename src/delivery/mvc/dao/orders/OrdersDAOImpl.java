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
	 * Orders 값 삽입한다 (데이터값 삽입하는 것이기 때문에 리턴값 없음!)
	 * 총 가격(order_total_price)는 장바구니에서 가져올 예정!!!!
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
				throw new SQLException("등록할 수 없습니다.");
			}else {
				orderLineInsert(con, orders);
			}
		}finally {
			DbUtil.close(con, ps);
		}
		return result;
	}
	
	
	/**
	 * 주문상세 등록하기 
	 * OrdersDTO에 orderlinelist객체 생성해야함.
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
//			   ps.addBatch(); //일괄처리할 작업에 추가
//			   ps.clearParameters();
			   
		  }
		  result = ps.executeBatch();//일괄처리
		  
		   
    }finally {
    	DbUtil.close(null, ps);
    }
		
		return result;
		
	}
	
	/**
	 * Store_Code를 입력받아 해당되는 데이터 리스트를 반환한다
	 * ppt 33p 주문목록 불러오기
	 * */
	@Override
	public List<OrdersDTO> selectOrderList(int store_code) {
		
		return null;
	}

	
	/**
	 * 판매자가 배달 승인,거부 값 입력  Orders테이블의 delivery_code와 승인시간(SYSDATE), 예상배송대기시간 업데이트 한다.
	 * ppt 34p 주문 승인 취소하기
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
	 *  order_code를 받아 해당되는 주문 상세를 조회한다.
	 * ppt 35p 주문상세보기
	 * */
	public List<OrderLineDTO> selectOrderLine(int order_code) throws SQLException{
		return null;
	}
	
	
	/**
	 * 회원이 주문을 환불신청한다.
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
	        	throw new SQLException("실패");
	        }
		}finally {
			DbUtil.close(con, ps);
		}
		return result;
	}
	
	
	
	
	/**
	 * 주문내역에 입력할 총가격 값 가져오기
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
	
	
	//테스트합니다!!!!!
	public static void main(String [] args) {
		try {
			OrdersDAOImpl orderDAO = new OrdersDAOImpl();
			//orderDAO.orderInsert("testid",3, 50000,3);
			//orderDAO.approveOrder(2, 20, 12);
			//orderDAO.cancelOrder(1);
			int i = orderDAO.totalPriceSelect("testid");
			System.out.println("실행완료" + i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
