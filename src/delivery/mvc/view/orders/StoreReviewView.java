package delivery.mvc.view.orders;

import delivery.mvc.controller.ReviewController;

public class StoreReviewView {
	//����
	
	public static void review() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("ȸ�����̵�     �ֹ��ڵ�     ����           �ı�               �����");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		ReviewController.reviewSelectAll(stores_code);
		
		UserOrdersView.stores();
	}
	

}
