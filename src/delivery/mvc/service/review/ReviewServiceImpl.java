package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.review.ReviewDAO;
import delivery.mvc.dao.review.ReviewDAOImpl;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public class ReviewServiceImpl implements ReviewService {
	ReviewDAO reviewDAO = new ReviewDAOImpl();

	/**
	 * 관리자의 후기 조회
	 */
	@Override
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException {
		List<ReviewDTO> list = reviewDAO.reviewAdmintAll(store_code);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(store_code + "의 후기가 없습니다.");
		return list;
	}
	
	/**
	 * 후기 목록조회(해당 가게의 리뷰)
	 */
	@Override
	public List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException {
		List<ReviewDTO> list = reviewDAO.reviewSelectAll(user_id);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(user_id + "의 후기가 없습니다.");
		return list;
	}
	

	/**
	 * 가게의 리뷰 모든 리뷰 출력
	 */
	@Override
	public List<ReviewDTO> storeReview(int store_code) throws SQLException {
		List<ReviewDTO> list = reviewDAO.storeReview(store_code);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(store_code + "의 후기가 없습니다.");
		return list;
	}
	
	/**
	 * 후기 목록조회(유저의 모든 리뷰)
	 */
	@Override
	public List<ReviewDTO> reviewUserAll(String user_id) throws SQLException {
		List<ReviewDTO> list = reviewDAO.reviewUserAll(user_id);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(user_id + "의 후기가 없습니다.");
		return list;
	}

	/**
	 * 고객 후기 작성
	 */
	@Override
	public void reviewInsert(String userId, int order_code, String reviewDetail, int starGrade) throws SQLException {
		int storeCode = reviewDAO.storeCodeSelectByOrderCode(order_code);
		ReviewDTO reviewDTO = new ReviewDTO(userId, order_code, storeCode, reviewDetail, starGrade);
		int result = reviewDAO.reviewInsert(reviewDTO);
		if(result == 0) throw new SQLException("후기 등록을 실패했습니다.");
	}
	
	/**
	 * 후기에 대한 판매자 댓글 업데이트
	 */
	@Override
	public void replyUpdate(String reply, int review_code) throws SQLException {
		int result = reviewDAO.replyUpdate(reply, review_code);
		if(result == 0) throw new SQLException("댓글 입력을 실패했습니다.");

	}
	
	
	public static void main(String[] args) {
		try {
			new ReviewServiceImpl().reviewInsert("userte", 2, "존맛탱" , 5);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 후기 수정
	 */
	@Override
	public void reviewUpdate(ReviewDTO reviewDTO) throws SQLException {
		int result = reviewDAO.reviewUpdate(reviewDTO);
		if(result == 0) throw new SQLException("후기 수정을 실패했습니다.");

	}
	/**
	 * 후기작성이 안된 주문건 출력
	 */
	@Override
	public List<OrdersDTO> yetReview(String userId) throws SQLException {
		List<OrdersDTO> list = reviewDAO.yetReview(userId);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException("미작성 후기가 없습니다.");
		return list;
	}

	/**
	 * 후기 삭제
	 */
	@Override
	public void reviewDelete(int review_code) throws SQLException {
		int result = reviewDAO.reviewDelete(review_code);
		if(result == 0) throw new SQLException("후기 삭제를 실패했습니다.");

	}
	
	/**
	 * 후기에 대한 판매자 댓글 삭제
	 */
	@Override
	public void replyDelete(int review_code) throws SQLException {
		int result = reviewDAO.replyDelete(review_code);
		if(result == 0) throw new SQLException("댓글 삭제를 실패했습니다.");
		
	}



}
