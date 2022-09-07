package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.service.review.ReviewService;
import delivery.mvc.service.review.ReviewServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.SuccessView;

public class ReviewController {
	private static ReviewService reviewService = new ReviewServiceImpl();
	
	
	/**
	 * 운영자 악성 후기조회
	 */
	public static void reviewAdmintAll(int store_code) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewAdmintAll(store_code);
			SuccessView.reviewListStore(rl);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage()); 
		}
		
	}
	
	
	/**
	 * 해당 가게 후기 목록조회 (인수 : 가게코드)
	 */
	public static void reviewSelectAll(String user_id) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewSelectAll(user_id);
			SuccessView.reviewListStore(rl);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage()); 
		}
		
	}
	
	/**
	 * 유저가 작성한 모든 후기 목록조회 (인수 : 유저아이디)
	 */
	public static void reviewUserAll(String user_id) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewUserAll(user_id);
			SuccessView.reviewList(rl);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage()); 
		}
		
	}
	
	
	public static void reviewInsert(String userId, int order_code, String reviewDetail, int starGrade ) {
		try {
			reviewService.reviewInsert(userId, order_code, reviewDetail, starGrade);
			SuccessView.getmessagePrint("등록되었습니다."); 
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() ); 
		}
	}
	
	
	public static void replyUpdate(String reply, int review_code) {
		try {
			reviewService.replyUpdate(reply, review_code);
			SuccessView.getmessagePrint("등록되었습니다."); 
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
		}
	}
	
	public static void reviewUpdate(ReviewDTO reviewDTO) {
		try {
			reviewService.reviewUpdate(reviewDTO);
			SuccessView.getmessagePrint("수정되었습니다."); 
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
		}
	}
	
	public static void reviewDelete(int review_code) {
		try {
			reviewService.reviewDelete(review_code);
			SuccessView.getmessagePrint("삭제되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );

		}
	}
	
	public static void replyDelete(int review_code) {
		try {
			reviewService.replyDelete(review_code);
			SuccessView.getmessagePrint("삭제되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );

		}
	}
	
	public static void yetReview(String userId) {
		try {
			List<OrdersDTO> list = reviewService.yetReview(userId);
			SuccessView.recentOrderLine(list);
			
		}catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
		}
	}
}
