package delivery.mvc.dao.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import delivery.mvc.dto.ReviewDTO;
import util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {
	private Properties proFile = DbUtil.getProFile();
	
	@Override
	public List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select user_id, order_code, star_grade, review_detail, post_date "
				+ "from review where store_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, stores_code);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), 
						rs.getString(4), rs.getString(5));
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
		
		String sql = "INSERT INTO REVIEW VALUES(REVIEW_CODE_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, NULL)";
		
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
	
	public static void main(String[] args) {
		ReviewDAO review = new ReviewDAOImpl();
				
		
		try {
			List<ReviewDTO> rl = review.reviewSelectAll(2);
			for(ReviewDTO list : rl) {
				System.out.println(list.getUser_id() + "  " + list.getOrder_code() + "  " + list.getStar_grade() + "  " + list.getReview_detail() + "  " +list.getPost_date() );
			}
			System.out.println(rl);

//			ReviewDTO dto = new ReviewDTO("testid", 34, 3, "Âü¸À", 1);
//			int result = review.reviewInsert(dto);
//			System.out.println(result);
			
//			ReviewDTO dto = new ReviewDTO(5, "Âü´ë¸À", 10);
//			int result = review.reviewUpdate(dto);
//			System.out.println(result);


//			int result = review.reviewDelete(10);
//			System.out.println(result);
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
