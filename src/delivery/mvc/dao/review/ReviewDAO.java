package delivery.mvc.dao.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public interface ReviewDAO {
	
	/**
	 * �������� �ı� ��ȸ
	 */
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException;
	
	/**
	 * �� �ı� �ۼ�
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * �ı� �����ȸ (�ش� ������ ����)
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
	 *  �ı� ����
	 */
	int reviewUpdate(ReviewDTO reviewDTO) throws SQLException;

	
	/**
	 * �ı� ����
	 */
	int reviewDelete(int review_code) throws SQLException;
	
	/**
	 * �ı��ۼ��� �ȵ� �ֹ��� ���
	 */
	List<OrdersDTO> yetReview(String userId) throws SQLException;
	
	
	/**
	 * ORDER_CODE�� �ش��ϴ� STORE_CODE ã��
	 */
	public int storeCodeSelectByOrderCode(int order_code) throws SQLException;

	/**
	 * �ı⿡ ���� �Ǹ��� ��� ������Ʈ
	 */
	int replyUpdate(String reply, int review_code) throws SQLException;
	
	
	/**
	 * �ı⿡ ���� �Ǹ��� ��� ����
	 */
	int replyDelete(int review_code) throws SQLException;
}
