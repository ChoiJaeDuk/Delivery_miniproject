package delivery.mvc.dao.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * �� �ı� �ۼ�
	 *  ? : ������� reply?
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * �ı� �����ȸ
	 */
	List<ReviewDTO> reviewSelectAll() throws SQLException;
	
	
	/**
	 *  �ı� ����
	 */
	int reviewUpdate(ReviewDTO reviewDTO) throws SQLException;

	
	/**
	 * �ı� ����
	 */
	int reviewDelete(int review_code) throws SQLException;
	
	
}
