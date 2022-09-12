package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * �������� �ı� ��ȸ
	 */
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException;
	
	
	/**
	 * �ı� �����ȸ(�ش� ������ ����)
	 */
	List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException;
	
	/**
	 * ������ ���� ��� ���� ���
	 */
	List<ReviewDTO> storeReview(int store_code) throws SQLException;
	
	
	/**
	 * �ı� �����ȸ(������ ��� ����)
	 */
	List<ReviewDTO> reviewUserAll(String user_id) throws SQLException;
	
	
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
	
	/**
	 * �ı��ۼ��� �ȵ� �ֹ��� ���
	 */
	List<OrdersDTO> yetReview(String userId) throws SQLException;

	/**
	 * �ı⿡ ���� �Ǹ��� ��� ������Ʈ
	 */
	void replyUpdate(String reply, int review_code) throws SQLException;

	/**
	 * �ı⿡ ���� �Ǹ��� ��� ����
	 */
	void replyDelete(int review_code) throws SQLException;
	
}
