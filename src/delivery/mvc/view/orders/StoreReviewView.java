package delivery.mvc.view.orders;


import delivery.mvc.controller.ReviewController;
import delivery.mvc.session.SessionSet;


public class StoreReviewView {
	//����
	
	public static void review(int storeCode, String userId) {
	
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("ȸ�����̵�     �ֹ��ڵ�     ����           �ı�               �����");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		//ReviewController.reviewSelectAll(stores_code);
		
		UserOrdersView.stores(storeCode);

	}
	

}
