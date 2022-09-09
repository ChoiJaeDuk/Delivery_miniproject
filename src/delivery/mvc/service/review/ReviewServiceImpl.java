package delivery.mvc.service.review;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.review.ReviewDAO;
import delivery.mvc.dao.review.ReviewDAOImpl;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;

public class ReviewServiceImpl implements ReviewService {
	ReviewDAO reviewDAO = new ReviewDAOImpl();


	@Override
	public List<ReviewDTO> reviewAdmintAll(int store_code) throws SQLException {
		List<ReviewDTO> list = reviewDAO.reviewAdmintAll(store_code);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(store_code + "�� �ıⰡ �����ϴ�.");
		return list;
	}
	
	
	@Override
	public List<ReviewDTO> reviewSelectAll(String user_id) throws SQLException {
		List<ReviewDTO> list = reviewDAO.reviewSelectAll(user_id);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(user_id + "�� �ıⰡ �����ϴ�.");
		return list;
	}
	


	@Override
	public List<ReviewDTO> storeReview(int store_code) throws SQLException {
		List<ReviewDTO> list = reviewDAO.storeReview(store_code);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(store_code + "�� �ıⰡ �����ϴ�.");
		return list;
	}
	
	@Override
	public List<ReviewDTO> reviewUserAll(String user_id) throws SQLException {
		List<ReviewDTO> list = reviewDAO.reviewUserAll(user_id);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException(user_id + "�� �ıⰡ �����ϴ�.");
		return list;
	}

	@Override
	public void reviewInsert(String userId, int order_code, String reviewDetail, int starGrade) throws SQLException {
		int storeCode = reviewDAO.storeCodeSelectByOrderCode(order_code);
		System.out.println(storeCode);
		ReviewDTO reviewDTO = new ReviewDTO(userId, order_code, storeCode, reviewDetail, starGrade);
		int result = reviewDAO.reviewInsert(reviewDTO);
		if(result == 0) throw new SQLException("�ı� ����� �����߽��ϴ�.");
	}
	
	@Override
	public void replyUpdate(String reply, int review_code) throws SQLException {
		int result = reviewDAO.replyUpdate(reply, review_code);
		if(result == 0) throw new SQLException("��� �Է��� �����߽��ϴ�.");

	}
	
	public static void main(String[] args) {
		try {
			new ReviewServiceImpl().reviewInsert("userte", 2, "������" , 5);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void reviewUpdate(ReviewDTO reviewDTO) throws SQLException {
		int result = reviewDAO.reviewUpdate(reviewDTO);
		if(result == 0) throw new SQLException("�ı� ������ �����߽��ϴ�.");

	}

	@Override
	public List<OrdersDTO> yetReview(String userId) throws SQLException {
		List<OrdersDTO> list = reviewDAO.yetReview(userId);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException("���ۼ� �ıⰡ �����ϴ�.");
		return list;
	}

	@Override
	public void reviewDelete(int review_code) throws SQLException {
		int result = reviewDAO.reviewDelete(review_code);
		if(result == 0) throw new SQLException("�ı� ������ �����߽��ϴ�.");

	}

	@Override
	public void replyDelete(int review_code) throws SQLException {
		int result = reviewDAO.replyDelete(review_code);
		if(result == 0) throw new SQLException("��� ������ �����߽��ϴ�.");
		
	}



}
