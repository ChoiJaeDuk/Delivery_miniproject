package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.MenuController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.actor.StoreView;

public class ManageStoreView {
	private static Scanner sc= new Scanner(System.in);
	private static String users_id;
	
	public static void main(String[] args) {
		ManageStoreView.manageStore("testid");
	}
	
	public static void manageStore(String users_id) {
		while (true) {
			ManageStoreView.printMenu();
			int menuno = Integer.parseInt(sc.nextLine());
			
			switch (menuno) {
			case 1:
				ManageStoreView.storeStatus(users_id);//오픈 클로즈
				break;
				
			case 2:
				ManageStoreView.manageMenu(users_id);//메뉴관리
				break;
			case 3:
				ManageStoreView.salesStatistics(users_id);//판매통계
				break;
			case 4:
				ManageStoreView.manageReview(users_id);// 후기관리
				break;
			case 5:	
				StoreView.printMenuForStores(users_id);//종료 
				break;
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				manageStore(users_id);
				break;	
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [가 게 관 리]                                      ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("1. open/close 상태 설정    2. 메뉴 관리     3. 판매통계    4. 후기관리    5. 뒤로가기");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
	}
	
	/*
	 * 1. open/close 상태 설정하기
	 * */
	public static void storeStatus(String users_id) { //세션
		StoresDTO store = new StoresDTO();
		String user_id =null;
		String status = null;
		if(store.getStore_status() == 0 ) status = "close";
		else status = "open";
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [open/close 상태 ]                                 ");
		System.out.println("-------------지금은" + status + " 상태입니다 -------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("	      	1. open              2. close               3.뒤로가기                ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				openStore(0,user_id);
				storeStatus(users_id);
				return; 
				
			case 2:
				closeStore(0, user_id);
				storeStatus(users_id);
				break;		
			case 3:
				manageStore(user_id);//뒤로가기
				break;
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				storeStatus(users_id);
				break;	

			}
		}
	}
	
	/**
	 * 1-1 open상태
	 * */
	public static void openStore(int store_status, String user_id) {
		StoresController.storeStatusUpdate(store_status, user_id);
	}
	
	/**
	 * 1-2 close상태
	 * */
	public static void closeStore(int store_status, String user_id) {
		StoresController.storeStatusUpdate(store_status, user_id);
	}


	
	
	/*
	 * 2. 메뉴관리
	 * */
	public static void manageMenu(String users_id) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ 메 뉴 관 리  ]                                   ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println(" 	1. 메뉴 등록     2. 메뉴 수정    3. 메뉴 삭제     4. 메뉴조회    5.뒤로가기   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertMenu(users_id);//메뉴등록	
					manageMenu(users_id);
					return;
				case 2:
					updateMenu(users_id);//메뉴수정
					manageMenu(users_id);
					return;
				case 3:
					deleteMenu(users_id);//메뉴삭제
					manageMenu(users_id);
					return;
				case 4:
					showMenu(users_id);//메뉴조회
					manageMenu(users_id);
					return;
				case 5:
					manageStore(users_id); //뒤로가기
					break;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					manageMenu(users_id);
					break;		
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 메뉴등록
	 * */
	public static void insertMenu(String user_id) {
		
			System.out.println("----------------------------------------------------------------------------------");
			//System.out.println("                      ["+ getCategoryCode + " 카테고리 목록 ]                   ");
			System.out.println("\n");
			/*
			if(getCategoryCode ==1) {
				System.out.println("                 4. 피자          5.파스타            6.스테이크            ");
				System.out.println("----------------------------------------------------------------------------------");
			}else if(getCategoryCode==2) {
				System.out.println("7.면             8.요리             9.밥             13.뒤로가기");
				System.out.println("----------------------------------------------------------------\n");
			}else if(getCategoryCode ==3) {
				System.out.println("10.찌개           11.볶음          12.찜/탕          13.뒤로가기");
				System.out.println("----------------------------------------------------------------\n");
			}
			*/
			MenuController.menuSelectByStore(user_id);
			System.out.println("                     [ 양식 카테고리 목록 ]//판매자 신청때 입력한 값받아오기       ");
			System.out.println("\n");
			System.out.println("    4. 피자          5.파스타      6.스테이크          //위 값따라 설정            ");
			System.out.println("----------------------------------------------------------------------------------");

			
			
			System.out.println("* * *"+"getCategoryCode"+"  카테고리 번호를 입력해주세요 >> ");
			int categoryNo = Integer.parseInt(sc.nextLine());
			
			System.out.println("* * * 메뉴 이름을 입력해주세요 >> ");
			String menuName = sc.nextLine();
			System.out.println("* * * 메뉴 가격을 입력해주세요 >> ");
			int menuPrice = Integer.parseInt(sc.nextLine());
			
			MenuController.menuInsert(new MenuDTO(categoryNo, 0, menuName, menuPrice, 1), user_id);
		}
		
	
	
	
	/**
	 * 2-1 메뉴수정
	 * */
	public static void updateMenu(String user_id) {
		menuList(user_id);
		System.out.println("* * * 수정할 메뉴 코드를 입력해주세요 >> ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("* * * 변경할 메뉴 이름을 입력해주세요 >> ");
		String newName = sc.nextLine();
		System.out.println("* * * 변경할 메뉴 가격을 입력해주세요 >> ");
		int newPrice = Integer.parseInt(sc.nextLine());
		System.out.println("* * * 변경할 품절 여부를 입력해주세요 >> ");
		int status = Integer.parseInt(sc.nextLine());
		
		MenuController.menuUpdate(new MenuDTO(no, newName, newPrice, status));
	}
	
	/**
	 * 2-1 메뉴삭제
	 * */
	public static void deleteMenu(String user_id) {
		menuList(user_id);
		System.out.println("* * * 삭제할 메뉴 코드를 입력해주세요 >> ");
		int no = Integer.parseInt(sc.nextLine());
		
		MenuController.menuDelete(no);
	}
	
	/**
	 * 2-1 메뉴조회
	 * */
	public static void showMenu(String user_id) {
		menuList(user_id);
	}
	
	/*
	 * 3. 판매통계
	 * */
	
	public static void salesStatistics(String users_id) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ 매 출 현 황 조 회  ]                             ");
		System.out.println("               메뉴코드            메뉴이름             총 매출                   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		StoresController.storesSales();
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("               	1. 세부 매출 조회              2. 뒤로가기                        ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					System.out.println("* * * 메뉴 코드를 입력해주세요 >>");
					int menuCode = Integer.parseInt(sc.nextLine());
					salesDetail(users_id, menuCode);//세부 매출 조회 
					salesStatistics(users_id);
					return;
					
				case 2:
					//뒤로가기
					return;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					salesStatistics(users_id);
					break;	
				
			}
			
		}
	}
	/**
	 * 3-1 세부매출조회
	 * */
	public static void salesDetail(String users_id, int menuCode) {//가게에 
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              [   ㅇㅇㅇ 월별 매출 현황 조회  ]                                 ");
		System.out.println("       월        메뉴코드            메뉴이름             총 매출                   ");		
		System.out.println("----------------------------------------------------------------------------------");
		StoresController.menuSalesByMonth(users_id, menuCode);
		
		System.out.println("----------------------------------------------------------------------------------");
	
		
	}
	/*
	 * 4. 후기관리 
	 * */
	
	public static void manageReview	(String user_id) {
		reviewList();
		System.out.println("        1. 댓글작성      2. 댓글수정       3. 댓글삭제       4. 뒤로가기          ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요 >> ");
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertReply();//댓글작성
					manageReview(user_id);
					return;
					
				case 2:
					updateReply(user_id);//댓글수정
					manageReview(user_id);
					return;
					
				case 3:
					deleteReply(user_id);//댓글삭제
					manageReview(user_id);
					return;
					
				case 4:
					//뒤로가기
					return;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					manageReview(user_id);
					break;	
				
			}
			
		}
	}//메소드끝
	
	
	/**	 
	  4-1 댓글작성
	*/
	public static void insertReply() {
					
			System.out.println("* * * 후기코드를 입력해주세요 >> ");
			String reviewNo = sc.nextLine();
			System.out.println("* * * 댓글을 입력해주세요 >> ");
			String content = sc.nextLine();
		
			
			//ReviewDTO(??) reply =  new ReviewDTO();
	    	//컨트롤러.insert(reply);
		}
		
	
	/**
	
	 4-2 댓글수정
*/ 
	public static void updateReply(String user_id) {
		menuList(user_id);
		System.out.println("* * * 수정할 후기 코드를 입력해주세요 >> ");
		String no = sc.nextLine();
		System.out.println("* * * 변경할 댓글내용을 입력해주세요 >> ");
		String newContent = sc.nextLine();

		
		//ReviewDTO(??) reply =  new ReviewDTO(no,newContent);
    	//컨트롤러.update(reply);
	}
	/**
	 *4-3 댓글삭제
	*/
	public static void deleteReply(String user_id) {
		menuList(user_id);
		System.out.println("* * * 삭제할 후기 코드를 입력해주세요 >> ");
		String no = sc.nextLine();
		
		//컨트롤러.delete(no);
	}
	
	
	
	
	/**
	 * 메뉴리스트
	 * */
	public static void  menuList(String user_id) {
		/*
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                     [ 메 뉴  목 록  db에서 가저옴]                               ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        메뉴코드      카테고리       메뉴이름        가격       품절여부           ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("          ㅇㅇ          323         010-        ㅁㅇ        대기/줍비/중/완료/취  ");
		System.out.println("----------------------------------------------------------------------------------");
		*/
		MenuController.menuSelectByMenu(user_id);
	}
	/**
	 * 댓글리스트/후기리스트
	 * */
	public static void  reviewList() {
	System.out.println("----------------------------------------------------------------------------------");
	System.out.println("                                [   후   기   ]                                   ");
	System.out.println("         후기코드      usderid       별점        후기          등록일              ");
	System.out.println("----------------------------------------------------------------------------------");
	System.out.println("          1111      ??usderid?           4          맛있어유~       2022-09-01        ");
	System.out.println("----------------------------------------------------------------------------------");
		
	}
	
}
