package delivery.mvc.dao.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.ReviewDTO;

public interface ReviewDAO {
	/**
	 * 고객 후기 작성
	 *  ? : 사장님은 reply?
	 *  
	 *  ppt67
	 */
	int reviewInsert(ReviewDTO reviewDTO) throws SQLException;
	
	
	/**
	 * 후기 목록조회
	 * ppt66
	 */
	List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException;
	
	
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
	
	
}
