package delivery.mvc.view.orders;

import delivery.mvc.session.SessionSet;

public class StoreReviewView {
	
	
	public static void review(int storeCode, String userId) {
	
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("�г���     �ֹ��ڵ�     ����           �ı�               �����");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("�ı�ҷ�����\n\n\n\n");
		
		UserOrdersView.stores(storeCode);
	}
	

}
