package delivery.mvc.view.orders;

import delivery.mvc.controller.ReviewController;

public class StoreReviewView {
	//수정
	
	public static void review() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("회원아이디     주문코드     별점           후기               등록일");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		ReviewController.reviewSelectAll(stores_code);
		
		UserOrdersView.stores();
	}
	

}
