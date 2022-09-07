package delivery.mvc.dao.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * �� �ı� �ۼ�
	 *  ? : ������� reply?
	 *  
	 *  ppt67
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * �ı� �����ȸ (�ش� ������ ����)
	 */
	List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException;
	
	/**
	 * �ı� �����ȸ(������ ��� ����)
	 */
	List<ReviewDTO> reviewUserAll(String user_id) throws SQLException;
	
	
	/**
	 *  �ı� ����
	 *  ppt68
	 */
	int reviewUpdate(ReviewDTO reviewDTO) throws SQLException;

	
	/**
	 * �ı� ����
	 * ppt69
	 */
	int reviewDelete(int review_code) throws SQLException;
	
	public int storeCodeSelectByOrderCode(int order_code) throws SQLException;
}
