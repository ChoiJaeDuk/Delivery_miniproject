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
	public int reviewInsert(ReviewDTO reviewDTO) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO REVIEW VALUES(REVIEW_CODE_SEQ.NEXTVAL,?,?,?,?,SYSDATE,?,NULL)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, reviewDTO.getOrder_code());
			ps.setString(2, reviewDTO.getUser_id());
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
	public List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select * from review where store_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, stores_code);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
				list.add(review);
			}
			
		}finally {
			DbUtil.close(con, ps, rs);
		}		
		
		return list;
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

	@Override //id를 받아야 ?
	public int reviewDelete(int review_code) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE REVIEW WHERE USER_ID = ? AND REVIEW_CODE = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
//			ps.setString(1, get);
			ps.setInt(2, review_code);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}

		
		return result;
	}
/*	
	public static void main(String[] args) {
		ReviewDAO review = new ReviewDAOImpl();
		ReviewDTO dto = new ReviewDTO(45, 45, "tt", 0, "tt", "tt", 0, "tt");
				
		
		try {
			List<ReviewDTO> list = review.reviewSelectAll(1);
			System.out.println(list);
			review.reviewInsert(dto);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
