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
	 * �ش� ���� �ı� �����ȸ (�μ� : �����ڵ�)
	 */
	public static void reviewSelectAll(int stores_code) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewSelectAll(stores_code);
			SuccessView.reviewList(rl);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
//			System.out.println("����");
		}
		
	}
	
	/**
	 * ������ ��� �ı� �����ȸ (�μ� : �������̵�)
	 */
	public static void revieUserAll(String user_id) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewUserAll(user_id);
			SuccessView.reviewListByUserId(rl);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
//			System.out.println("����");
		}
		
	}
	
	
	public static void reviewInsert(String userId, int order_code, String reviewDetail, int starGrade ) {
		try {
			reviewService.reviewInsert(userId, order_code, reviewDetail, starGrade);
			SuccessView.getmessagePrint("��ϵǾ����ϴ�.");
			//System.out.println("��ϵǾ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
			//System.out.println("����");
		}
	}
	
	public static void reviewUpdate(ReviewDTO reviewDTO) {
		try {
			reviewService.reviewUpdate(reviewDTO);
			SuccessView.getmessagePrint("�����Ǿ����ϴ�.");
			//System.out.println("�����Ǿ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
		//System.out.println("����");
		}
	}
	
	public static void reviewDelete(int review_code) {
		try {
			reviewService.reviewDelete(review_code);
			SuccessView.getmessagePrint("�����Ǿ����ϴ�.");
//			System.out.println("�����Ǿ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage( e.getMessage() );
//			System.out.println("����");
		}
	}
}
