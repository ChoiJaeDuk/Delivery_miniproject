package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.MenuController;
import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.actor.StoreView;

public class ManageStoreView {
	private static Scanner sc= new Scanner(System.in);


	private static String users_id;


	
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
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("                               [가 게 관 리]                                         ");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("1. open/close 상태 설정    2. 메뉴 관리     3. 판매통계    4. 후기관리    5. 뒤로가기");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
	}
	
	/*
	 * 1. open/close 상태 설정하기
	 * */
	public static void storeStatus(String user_id) { //세션
		//StoresDTO store = new StoresDTO();
		//String user_id =null;
		//String status = null;
		//if(store.getStore_status() == 0 ) status = "close";
		//else status = "open";
		
	//	SessionSet ss = SessionSet.getInstance();
	//	String userId = ss.getSet().iterator().next().getSessionId();
		//System.out.println(userId);
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [open/close 상태 ]                                 ");
		//System.out.println("-------------지금은" + status + " 상태입니다 -------------------------------");
	
		StoresController.storeSelectStatus(user_id);
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("	      	1. open              2. close               3.뒤로가기                ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while (true) {
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				openStore(1, user_id);
				storeStatus(user_id);
				return; 
				
			case 2:
				closeStore(0, user_id);
				storeStatus(user_id);
				break;		
			case 3:
				manageStore(user_id);//뒤로가기
				break;
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				storeStatus(user_id);
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
	public static void manageMenu(String user_id) {
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ 메 뉴 관 리  ]                                   ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println(" 	1. 메뉴 등록     2. 메뉴 수정    3. 메뉴 삭제     4. 메뉴조회    5.뒤로가기   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertMenu(user_id);//메뉴등록	
					manageMenu(user_id);
					return;
				case 2:
					updateMenu(user_id);//메뉴수정
					manageMenu(user_id);
					return;
				case 3:
					deleteMenu(user_id);//메뉴삭제
					manageMenu(user_id);
					return;
				case 4:
					showMenu(user_id);//메뉴조회
					manageMenu(user_id);
					return;
				case 5:
					manageStore(user_id); //뒤로가기
					break;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					manageMenu(user_id);
					break;		
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 메뉴등록
	 * */
	public static void insertMenu(String user_id) {
		
			MenuController.menuSelectByStore(user_id);
			
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

		System.out.println("----------------------------------------------------------------------------------\n");
		System.out.println("                               [ 매 출 현 황 조 회  ]                             \n");
		System.out.println("               메뉴코드            메뉴이름             총 매출                   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		StoresController.menuSales(users_id);
		
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
		//StoresController.storesSelectByCategory(users_id, menuCode);

		StoresController.menuSalesByMonth(users_id, menuCode);
			
	}
	
	
	
	/*
	 * 4. 후기관리 
	 * */
	
	public static void manageReview	(String user_id) {
//		StoresDAO storesDAO = new StoresDAOImpl();
//		 StoresDTO storecode = storesDAO.storeSelectById(user_id);
		
		
		reviewList(user_id);
		System.out.println("        1. 댓글작성      2. 댓글수정       3. 댓글삭제       4. 뒤로가기          ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요 >> ");
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertReply(user_id);//댓글작성
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
					manageStore(user_id);
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
	 * @param user_id 
	*/
	public static void insertReply(String user_id) {
					
			System.out.println("* * * 후기코드를 입력해주세요 >> ");
			String reviewNo = sc.nextLine();
			System.out.println("* * * 댓글을 입력해주세요 >> ");
			String content = sc.nextLine();
		
			
			ReviewController.replyUpdate(content, Integer.parseInt(reviewNo));
			
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

		
		ReviewController.replyUpdate(newContent, Integer.parseInt(no));
		
		
	}
	/**
	 *4-3 댓글삭제
	*/
	public static void deleteReply(String user_id) {
		menuList(user_id);
		System.out.println("* * * 삭제할 후기 코드를 입력해주세요 >> ");
		String no = sc.nextLine();
		
		ReviewController.replyDelete(Integer.parseInt(no));
		
	}
	
	
	
	
	/**
	 * 메뉴리스트
	 * */
	public static void  menuList(String user_id) {
		MenuController.menuSelectByMenu(user_id);
	}


	/**
	 * 댓글리스트/후기리스트
	 * */
	public static void  reviewList(String user_id) {
	System.out.println("----------------------------------------------------------------------------------\n");
	System.out.println("                                [   후   기   ]                                   \n");
	System.out.println("후기 코드          회원ID            평점/후기           댓글               등록일");
	System.out.println("----------------------------------------------------------------------------------");

	ReviewController.reviewSelectAll(user_id);

	System.out.println("----------------------------------------------------------------------------------");
		
	}
	

	
}
