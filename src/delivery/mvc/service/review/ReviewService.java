package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * 운영자 후기 조회
	 */
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException;
	
	
	/**
	 * 후기 목록조회(해당 가게의 리뷰)
	 */
	List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException;
	
	/**
	 * 후기 목록조회(유저의 모든 리뷰)
	 */
	List<ReviewDTO> reviewUserAll(String user_id) throws SQLException;
	
	
	/**
	 * 고객 후기 작성
	 */
	void reviewInsert(String userId, int order_code, String reviewDetail, int starGrade) throws SQLException;
	
		
	/**
	 * 후기 수정
	 */
	void reviewUpdate(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * 후기 삭제
	 */
	void reviewDelete(int review_code) throws SQLException;
	
	/**
	 * 후기가 없는 주문건 출력
	 */
	List<OrdersDTO> yetReview(String userId) throws SQLException;

	void replyUpdate(String reply, int review_code) throws SQLException;
	void replyDelete(int review_code) throws SQLException;
	
}
