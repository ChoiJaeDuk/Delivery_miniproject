package delivery.mvc.controller;

import java.util.List;

import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.service.review.ReviewService;
import delivery.mvc.service.review.ReviewServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.SuccessView;

public class ReviewController {
	private static ReviewService reviewService = new ReviewServiceImpl();
	
	/**
	 * 해당 가게 후기 목록조회 (인수 : 가게코드)
	 */
	public static void reviewSelectAll(int stores_code) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewSelectAll(stores_code);
			SuccessView.reviewList(rl);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
//			System.out.println("오류");
		}
		
	}
	
	/**
	 * 유저의 모든 후기 목록조회 (인수 : 유저아이디)
	 */
	public static void revieUserAll(String user_id) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewUserAll(user_id);
			SuccessView.reviewListByUserId(rl);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
//			System.out.println("오류");
		}
		
	}
	
	
	public static void reviewInsert(String userId, int order_code, String reviewDetail, int starGrade ) {
		try {
			reviewService.reviewInsert(userId, order_code, reviewDetail, starGrade);
			SuccessView.getmessagePrint("등록되었습니다.");
			//System.out.println("등록되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
			//System.out.println("오류");
		}
	}
	
	public static void reviewUpdate(ReviewDTO reviewDTO) {
		try {
			reviewService.reviewUpdate(reviewDTO);
			SuccessView.getmessagePrint("수정되었습니다.");
			//System.out.println("수정되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
		//System.out.println("오류");
		}
	}
	
	public static void reviewDelete(int review_code) {
		try {
			reviewService.reviewDelete(review_code);
			SuccessView.getmessagePrint("삭제되었습니다.");
//			System.out.println("삭제되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
//			System.out.println("오류");
		}
	}
}
