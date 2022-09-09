package delivery.mvc.view.orders;


import delivery.mvc.controller.ReviewController;
import delivery.mvc.session.SessionSet;


public class StoreReviewView {
	
	public static void review(int storeCode, String userId) {
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("회원아이디     주문코드     별점           후기           등록일");
		System.out.println("----------------------------------------------------------------");
		
		ReviewController.reviewSelectAll(userId);
		//ReviewController.storeReview(storeCode);
		//System.out.println(storeCode);
		
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		UserOrdersView.stores(storeCode, userId);
	}
	

}
