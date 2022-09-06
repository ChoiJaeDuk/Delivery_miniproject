package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * �ı� �����ȸ(�ش� ������ ����)
	 */
	List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException;
	
	/**
	 * �ı� �����ȸ(������ ��� ����)
	 */
	List<ReviewDTO> reviewUserAll(String user_id) throws SQLException;
	
	
	/**
	 * �� �ı� �ۼ�
	 */
	void reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
		
	/**
	 * �ı� ����
	 */
	void reviewUpdate(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * �ı� ����
	 */
	void reviewDelete(int review_code) throws SQLException;
	
}
