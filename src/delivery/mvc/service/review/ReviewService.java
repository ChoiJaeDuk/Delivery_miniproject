package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * �ı� �����ȸ
	 */
	List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException;
	
	
	/**
	 * �� �ı� �ۼ�
	 */
	void reviewInsert(String userId, int order_code, String reviewDetail, int starGrade) throws SQLException;
	
		
	/**
	 * �ı� ����
	 */
	void reviewUpdate(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * �ı� ����
	 */
	void reviewDelete(int review_code) throws SQLException;
	
}
