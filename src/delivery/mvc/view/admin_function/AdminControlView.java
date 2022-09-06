package delivery.mvc.view.admin_function;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.actor.AdminView;

/**
 * 운영관리
 */
public class AdminControlView {
	
	static Scanner sc = new Scanner(System.in);

	public static void adminControl() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.가게 관리                2.매출 현황 조회               3.뒤로가기");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int adminControl = Integer.parseInt(sc.nextLine());
		switch(adminControl) {
			case 1:
				storeState();;//가게정보 조회
				
				System.out.println("* * * 가게 코드를 입력해주세요. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				storeControl(storeCode);//가게관리
				storeState();//가게 정보 업데이트 후 다시 조회!
								
				break;
				
			case 2:
				salesStatus();
				break;
			case 3:
				AdminView.admin(null);
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				adminControl();
				break;
		}//switch끝
	}
	
	
	
	/**
	 * 가게 정보
	 */
	public static void storeInfo() { //필요한가 ?
		System.out.println("--------------------------------------------------------------------\n");

		System.out.println("     가게코드           [ " + "storeName" + " 가게 정보 ]                   \n");
		System.out.println("가게정보 불러오기!!   \n\n\n\n");

		System.out.println("                [ " + "storeName" + " 가게 정보 ]                   \n");
		System.out.println("가게정보 불러오기!!   \n\n\n\n"); //가게 코드랑 가게 이름
		
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	
	/**
	 * 가게관리
	 */
	public static void storeControl(int store_code) {
		//System.out.println("* * * 가게 코드를 입력해주세요. >> ");
		//int storeCode = Integer.parseInt(sc.nextLine());
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.판매자 신청 승인하기     2.판매자 신청 거부하기     3.뒤로가기");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int storeControl = Integer.parseInt(sc.nextLine());
		switch(storeControl) {
			case 1:
		
				StoresController.storeRegis(new StoresDTO("승인",store_code));
				
				storeState(); //업데이트 된 가게 목록 불러오기!!!	
	
				adminControl();
				break;
			case 2:
				
				StoresController.storeRegis(new StoresDTO("반려",store_code));
			
				storeState(); //업데이트 된 가게 목록 불러오기!!!				
				adminControl();
				break;
			case 3:
				adminControl();
			
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			//	storeControl();
				break;
		}//switch끝
	}

	
	/**
	 * 판매자 승인 상태
	 */
	public static void storeState() {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                          [ 가게 목록 ]                         \n");
		System.out.println("가게 코드                 가게 이름             판매자 승인 상태");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("가게 승인상태 데이터 불러오기!!!           대기/승인/반려 \n\n\n");
		StoresController.storesSelectAll();
	
		System.out.println("----------------------------------------------------------------\n");
		
	}
	
	/**
	 * 매출현황조회
	 */
	public static void salesStatus( ) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                       [ 매출 현황 목록 ]                       \n");
		System.out.println("가게 코드   가게 이름     총 매출     가게 매출     운영자 매출");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = =");
		StoresController.storesSales();
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("1. 세부 매출 내역 조회     2.뒤로가기");
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int salesStatus = Integer.parseInt(sc.nextLine());
		switch(salesStatus) {
			case 1:
				System.out.println("* * * 가게코드를 입력해주세요. >> ");
				int storeCode = Integer.parseInt(sc.nextLine());
				salesDetail(storeCode); 
				salesStatus();
				break;
				
			case 2:
				adminControl();
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				salesStatus();
				break;
		}//switch끝
	}
	
	/**
	 * 세부매출내역 조회
	 */
	public static void salesDetail(int storeCode) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("            [ " + "storeName" + "세부 매출 현황 ]               \n");
		System.out.println("구분       총 매출             운영자 매출           판매자 매출");
		System.out.println("----------------------------------------------------------------\n");
		StoresController.storesSalesByMonth(storeCode);
		System.out.println("----------------------------------------------------------------\n");
	}
	
	public static void main(String[] args) {
		adminControl();
	}

}
