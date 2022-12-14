package delivery.mvc.dao.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public interface ReviewDAO {
	
	/**
	 * 관리자의 후기 조회
	 */
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException;
	
	/**
	 * 고객 후기 작성
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * 후기 목록조회 (해당 가게의 리뷰)
	 */
	List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException;
	
	
	/**
	 * 가게의 리뷰 모든 리뷰 출력
	 */
	List<ReviewDTO> storeReview(int store_code) throws SQLException;
	
	/**
	 * 후기 목록조회(유저의 모든 리뷰)
	 */
	List<ReviewDTO> reviewUserAll(String user_id) throws SQLException;
	
	
	/**
	 *  후기 수정
	 */
	int reviewUpdate(ReviewDTO reviewDTO) throws SQLException;

	
	/**
	 * 후기 삭제
	 */
	int reviewDelete(int review_code) throws SQLException;
	
	/**
	 * 후기작성이 안된 주문건 출력
	 */
	List<OrdersDTO> yetReview(String userId) throws SQLException;
	
	
	/**
	 * ORDER_CODE에 해당하는 STORE_CODE 찾기
	 */
	public int storeCodeSelectByOrderCode(int order_code) throws SQLException;

	/**
	 * 후기에 대한 판매자 댓글 업데이트
	 */
	int replyUpdate(String reply, int review_code) throws SQLException;
	
	
	/**
	 * 후기에 대한 판매자 댓글 삭제
	 */
	int replyDelete(int review_code) throws SQLException;
}
