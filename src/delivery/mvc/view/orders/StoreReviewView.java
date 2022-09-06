package delivery.mvc.view.orders;

import delivery.mvc.session.SessionSet;

public class StoreReviewView {
	
	
	public static void review(int storeCode, String userId) {
	
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("닉네임     주문코드     별점           후기               등록일");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("후기불러오기\n\n\n\n");
		
		UserOrdersView.stores(storeCode);
	}
	

}
