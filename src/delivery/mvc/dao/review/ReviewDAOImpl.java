package delivery.mvc.dao.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;
import util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DbUtil.getProFile();
	@Override
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select review_code, r.user_id,  star_grade, review_detail, post_date, reply\r\n"
				+ "from review r join stores s\r\n"
				+ "on r.store_code = s.store_code\r\n"
				+ "where s.store_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, store_code);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO(rs.getInt(1), 0, rs.getString(2), store_code, 
						rs.getString(4), rs.getString(5), rs.getInt(3), rs.getString(6));
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}		
		
		return list;
	}
	
	
	/**
	 * 가게코드를 받고 가게코드의 회원아이디
	 */
	@Override
	public List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select review_code, r.user_id,  star_grade, review_detail, post_date, reply\r\n"
				+ "from review r join stores s\r\n"
				+ "on r.store_code = s.store_code\r\n"
				+ "where s.users_id = ?";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO(rs.getInt(1), 0, rs.getString(2), 0, 
						rs.getString(4), rs.getString(5), rs.getInt(3), rs.getString(6));
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}		
		
		return list;
	}
	
	/**
	 * 가게의 리뷰 모든 리뷰 출력
	 */
	public List<ReviewDTO> storeReview(int store_code) throws SQLException{
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select review_code, r.user_id,  star_grade, review_detail, post_date, reply\r\n"
				+ "from review r join stores s \r\n"
				+ "on r.store_code = s.store_code \r\n"
				+ "join users u on s.users_id = u.user_id\r\n"
				+ "where s.store_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, store_code);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO(rs.getInt(1), 0, rs.getString(2), 0, 
						rs.getString(4), rs.getString(5), rs.getInt(3), rs.getString(6));
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return list;
		
	}
	
	
	/**
	 * 본인이 작성한 후기 조회
	 */
	@Override
	public List<ReviewDTO> reviewUserAll(String user_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		
		StoresDTO store = null;
		ReviewDTO review = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select review_code, s.store_name, star_grade, review_detail, reply, post_date\r\n"
				+ "from review r join stores s on r.store_code = s.store_code where r.user_id = ?";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				store = new StoresDTO(rs.getString(2));
				review = new ReviewDTO(rs.getInt(1), 0, user_id, 0, 
						rs.getString(4), rs.getString(6), rs.getInt(3), rs.getString(5), store);
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}		
		
		return list;
	}
	

	@Override
	public int reviewInsert(ReviewDTO reviewDTO) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO REVIEW VALUES(REVIEW_CODE_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ' ')";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, reviewDTO.getUser_id());
			ps.setInt(2, reviewDTO.getOrder_code());
			ps.setInt(3, reviewDTO.getStore_code());
			ps.setString(4, reviewDTO.getReview_detail());
			ps.setInt(5, reviewDTO.getStar_grade());
			
			result = ps.executeUpdate();
			
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	@Override
	public int replyUpdate(String reply, int review_code) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE REVIEW SET reply = ? WHERE REVIEW_CODE= ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, reply);
			ps.setInt(2, review_code);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		
		return result;
	}

	@Override
	public int reviewUpdate(ReviewDTO reviewDTO) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE REVIEW SET STAR_GRADE=?, REVIEW_DETAIL=? WHERE REVIEW_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, reviewDTO.getStar_grade());
			ps.setString(2, reviewDTO.getReview_detail());
			ps.setInt(3, reviewDTO.getReview_code());
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		
		return result;
	}

	@Override 
	public int reviewDelete(int review_code) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM REVIEW WHERE REVIEW_CODE=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
//			ps.setString(1, get);
			ps.setInt(1, review_code);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}

		
		return result;
	}
	

	@Override
	public int replyDelete(int review_code) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE REVIEW SET reply = '  ' WHERE REVIEW_CODE= ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, review_code);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	
	public List<OrdersDTO> yetReview(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		
		List<OrdersDTO> list = new ArrayList<OrdersDTO>();
		StoresDTO store = null;
		OrdersDTO yetReview = null;
		
		String sql = "select orders.order_code, stores.store_name, order_date, order_total_price from orders \r\n"
				+ "left outer join review \r\n"
				+ "on review.order_code = orders.order_code join stores\r\n"
				+ "on stores.store_code = orders.store_code \r\n"
				+ "where review.order_code is null and orders.user_id = ? and orders.delivery_code = 1";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				store = new StoresDTO(rs.getString(2));
				yetReview = new OrdersDTO(rs.getInt(1), store, rs.getString(3), 
						rs.getInt(4));
				list.add(yetReview);
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		ReviewDAO review = new ReviewDAOImpl();
				
		
		try {
			List<ReviewDTO> rl = review.reviewSelectAll("2");
			for(ReviewDTO list : rl) {
				System.out.println(list.getUser_id() + "  " + list.getOrder_code() + "  " + list.getStar_grade() + "  " + list.getReview_detail() + "  " +list.getPost_date() );
			}
			System.out.println(rl);

//			ReviewDTO dto = new ReviewDTO("testid", 34, 3, "참맛", 1);
//			int result = review.reviewInsert(dto);
//			System.out.println(result);
			
//			ReviewDTO dto = new ReviewDTO(5, "참대맛", 10);
//			int result = review.reviewUpdate(dto);
//			System.out.println(result);


//			int result = review.reviewDelete(10);
//			System.out.println(result);
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int storeCodeSelectByOrderCode(int order_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		int store_code = 0;
		String sql = "SELECT STORE_CODE FROM ORDERS WHERE ORDER_CODE = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);		
//			ps.setString(1, get);
			ps.setInt(1, order_code);
			rs = ps.executeQuery();
			if(rs.next()){
				
				store_code = rs.getInt(1);
				
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		
		return store_code;
	}




}
