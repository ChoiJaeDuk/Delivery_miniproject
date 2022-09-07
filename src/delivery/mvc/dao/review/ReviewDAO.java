package delivery.mvc.dao.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public interface ReviewDAO {
	
	
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException;
	
	/**
	 * 고객 후기 작성
	 *  ? : 사장님은 reply?
	 *  
	 *  ppt67
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * 후기 목록조회 (해당 가게의 리뷰)
	 */
	List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException;
	
	/**
	 * 후기 목록조회(유저의 모든 리뷰)
	 */
	List<ReviewDTO> reviewUserAll(String user_id) throws SQLException;
	
	
	/**
	 *  후기 수정
	 *  ppt68
	 */
	int reviewUpdate(ReviewDTO reviewDTO) throws SQLException;

	
	/**
	 * 후기 삭제
	 * ppt69
	 */
	int reviewDelete(int review_code) throws SQLException;
	
	/**
	 * 후기작성이 안된 주문건 출력
	 * ppt67
	 */
	List<OrdersDTO> yetReview(String userId) throws SQLException;
	
	public int storeCodeSelectByOrderCode(int order_code) throws SQLException;


	int replyUpdate(String reply, int review_code) throws SQLException;
	
	int replyDelete(int review_code) throws SQLException;
}
