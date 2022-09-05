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
	 * 해당 가게 후기 목록조회 
	 * ppt66
	 */
	public static void reviewSelectAll(int stores_code) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewSelectAll(stores_code);
//			SuccessView.selectPrint("리뷰 리스트\n" + list);
			for(ReviewDTO list : rl) {
				System.out.println(list.getUser_id() + "  " + list.getOrder_code() + "  " + list.getStar_grade() + "  " + list.getReview_detail() + "  " +list.getPost_date() );
			}
			
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("오류");
		}
		
	}
	
	
	public static void reviewInsert(ReviewDTO reviewDTO) {
		try {
			reviewService.reviewInsert(reviewDTO);
//			SuccessView.messagePrint("등록되었습니다.");
			System.out.println("등록되었습니다.");
		} catch (Exception e) {
//			FailView.errorMessage( e.getMessage() );
			System.out.println("오류");
		}
	}
	
	public static void reviewUpdate(ReviewDTO reviewDTO) {
		try {
			reviewService.reviewUpdate(reviewDTO);
//			SuccessView.messagePrint("수정되었습니다.");
			System.out.println("수정되었습니다.");
		} catch (Exception e) {
//			FailView.errorMessage( e.getMessage() );
			System.out.println("오류");
		}
	}
	
	public static void reviewDelete(int review_code) {
		try {
			reviewService.reviewDelete(review_code);
//			SuccessView.messagePrint("삭제되었습니다.");
			System.out.println("삭제되었습니다.");
		} catch (Exception e) {
//			FailView.errorMessage( e.getMessage() );
			System.out.println("오류");
		}
	}
}
