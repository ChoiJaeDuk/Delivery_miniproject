package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * 후기 목록조회
	 */
	List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException;
	
	
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
	
}
