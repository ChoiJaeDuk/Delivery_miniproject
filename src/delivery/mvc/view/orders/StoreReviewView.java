package delivery.mvc.view.orders;

public class StoreReviewView {
	
	
	public static void review() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("닉네임     주문코드     별점           후기               등록일");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("후기불러오기\n\n\n\n");
		
		OrdersView.stores();
	}
	

}
