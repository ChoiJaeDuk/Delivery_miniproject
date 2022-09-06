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
	 * �ش� ���� �ı� �����ȸ 
	 * ppt66
	 */
	public static void reviewSelectAll(int stores_code) {
		try {
			List<ReviewDTO>/*list*/ rl = reviewService.reviewSelectAll(stores_code);
//			SuccessView.selectPrint("���� ����Ʈ\n" + list);
			for(ReviewDTO list : rl) {
				System.out.println(list.getUser_id() + "  " + list.getOrder_code() + "  " + list.getStar_grade() + "  " + list.getReview_detail() + "  " +list.getPost_date() );
			}
			
		} catch (Exception e) {
//			FailView.errorMessage(e.getMessage());
			System.out.println("����");
		}
		
	}
	
	
	public static void reviewInsert(ReviewDTO reviewDTO) {
		try {
			reviewService.reviewInsert(reviewDTO);
//			SuccessView.messagePrint("��ϵǾ����ϴ�.");
			System.out.println("��ϵǾ����ϴ�.");
		} catch (Exception e) {
//			FailView.errorMessage( e.getMessage() );
			System.out.println("����");
		}
	}
	
	public static void reviewUpdate(ReviewDTO reviewDTO) {
		try {
			reviewService.reviewUpdate(reviewDTO);
//			SuccessView.messagePrint("�����Ǿ����ϴ�.");
			System.out.println("�����Ǿ����ϴ�.");
		} catch (Exception e) {
//			FailView.errorMessage( e.getMessage() );
			System.out.println("����");
		}
	}
	
	public static void reviewDelete(int review_code) {
		try {
			reviewService.reviewDelete(review_code);
//			SuccessView.messagePrint("�����Ǿ����ϴ�.");
			System.out.println("�����Ǿ����ϴ�.");
		} catch (Exception e) {
//			FailView.errorMessage( e.getMessage() );
			System.out.println("����");
		}
	}
}
