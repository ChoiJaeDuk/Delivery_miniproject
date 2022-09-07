package delivery.mvc.dao.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public interface ReviewDAO {
	
	
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException;
	
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
	List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException;
	
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
	
	/**
	 * �ı��ۼ��� �ȵ� �ֹ��� ���
	 * ppt67
	 */
	List<OrdersDTO> yetReview(String userId) throws SQLException;
	
	public int storeCodeSelectByOrderCode(int order_code) throws SQLException;


	int replyUpdate(String reply, int review_code) throws SQLException;
	
	int replyDelete(int review_code) throws SQLException;
}
