package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.review.ReviewDAO;
import delivery.mvc.dao.review.ReviewDAOImpl;
import delivery.mvc.dto.ReviewDTO;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAOImpl();

	@Override
	public List<ReviewDTO> reviewSelectAll(int stores_code) throws SQLException {
		List<ReviewDTO> list = reviewDAO.reviewSelectAll(stores_code);
		if(list.size() == 0) throw new SQLException(stores_code + "의 후기가 없습니다.");
		return list;
	}

	@Override
	public void reviewInsert(ReviewDTO reviewDTO) throws SQLException {
		int result = reviewDAO.reviewInsert(reviewDTO);
		if(result == 0) throw new SQLException("등록을 실패했습니다.");

	}

	@Override
	public void reviewUpdate(ReviewDTO reviewDTO) throws SQLException {
		int result = reviewDAO.reviewUpdate(reviewDTO);
		if(result == 0) throw new SQLException("수정을 실패했습니다.");

	}

	@Override
	public void reviewDelete(int review_code) throws SQLException {
		int result = reviewDAO.reviewDelete(review_code);
		if(result == 0) throw new SQLException("삭제를 실패했습니다.");

	}

}
