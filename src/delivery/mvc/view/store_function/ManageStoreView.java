package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.actor.StoreView;

public class ManageStoreView {
	private static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		ManageStoreView.manageStore();
	}
	
	public static void manageStore() {
		while (true) {
			ManageStoreView.printMenu();
			int menuno = Integer.parseInt(sc.nextLine());
			
			switch (menuno) {
			case 1:
				ManageStoreView.storeStatus();//오픈 클로즈
				break;
				
			case 2:
				ManageStoreView.manageMenu();//메뉴관리
				break;
			case 3:
				ManageStoreView.salesStatistics();//판매통계
				break;
			case 4:
				ManageStoreView.manageReview();// 후기관리
				break;
			case 5:	
				StoreView.printMenuForStores();//종료 
				break;
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				manageStore();
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
	public static void storeStatus() { //세션
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
				storeStatus();
				return; 
				
			case 2:
				closeStore(0, user_id);
				storeStatus();
				break;		
			case 3:
				manageStore();//뒤로가기
				break;
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				storeStatus();
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
	public static void manageMenu() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ 메 뉴 관 리  ]                                   ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println(" 	1. 메뉴 등록     2. 메뉴 수정    3. 메뉴 삭제     4. 메뉴조회    5.뒤로가기   ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertMenu();//메뉴등록	
					manageMenu();
					return;
				case 2:
					updateMenu();//메뉴수정
					manageMenu();
					return;
				case 3:
					deleteMenu();//메뉴삭제
					manageMenu();
					return;
				case 4:
					showMenu();//메뉴조회
					manageMenu();
					return;
				case 5:
					manageStore(); //뒤로가기
					break;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					manageMenu();
					break;		
				
			}
			
		}
		
	}
	
	/**
	 * 2-1 메뉴등록
	 * */
	public static void insertMenu() {
		
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                      ["+ "getCategoryCode" + " 카테고리 목록 ]                   ");
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
			System.out.println("                     [ 양식 카테고리 목록 ]//판매자 신청때 입력한 값받아오기       ");
			System.out.println("\n");
			System.out.println("    4. 피자          5.파스타      6.스테이크          //위 값따라 설정            ");
			System.out.println("----------------------------------------------------------------------------------");

			
			
			System.out.println("* * *"+"getCategoryCode"+"  카테고리 번호를 입력해주세요 >> ");
			String categoryNo = sc.nextLine();
			
			System.out.println("* * * 메뉴 이름을 입력해주세요 >> ");
			String menuName = sc.nextLine();
			System.out.println("* * * 메뉴 가격을 입력해주세요 >> ");
			String menuPrice = sc.nextLine();
			
			//MenuDTO menu =  new MenuDTO(categoryNo,?,?);
	    	//컨트롤러.insert(menu);
		}
		
	
	
	
	/**
	 * 2-1 메뉴수정
	 * */
	public static void updateMenu() {
		menuList();
		System.out.println("* * * 수정할 메뉴 코드를 입력해주세요 >> ");
		String no = sc.nextLine();
		System.out.println("* * * 변경할 메뉴 이름을 입력해주세요 >> ");
		String newName = sc.nextLine();
		System.out.println("* * * 변경할 메뉴 가격을 입력해주세요 >> ");
		String newPrice = sc.nextLine();
		
		//MenuDTO menu =  new MenuDTO(bo,newname,newprice);
    	//컨트롤러.update(menu);
	}
	
	/**
	 * 2-1 메뉴삭제
	 * */
	public static void deleteMenu() {
		menuList();
		System.out.println("* * * 삭제할 메뉴 코드를 입력해주세요 >> ");
		String no = sc.nextLine();
		
		//컨트롤러.delete(no);
	}
	
	/**
	 * 2-1 메뉴조회
	 * */
	public static void showMenu() {
		menuList();
	}
	
	/*
	 * 3. 판매통계
	 * */
	
	public static void salesStatistics() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                               [ 매 출 현 황 조 회  ]                             ");
		System.out.println("               메뉴코드            메뉴이름             총 매출                   ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("              111111                  피자               5000000                  ");
		StoresController.storesSales();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("               	1. 세부 매출 조회              2. 뒤로가기                        ");
		System.out.println("----------------------------------------------------------------------------------");
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					salesDetail();//세부 매출 조회 
					salesStatistics();
					return;
					
				case 2:
					//뒤로가기
					return;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					salesStatistics();
					break;	
				
			}
			
		}
	}
	/**
	 * 3-1 세부매출조회
	 * */
	public static void salesDetail() {//가게에 
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              [   ㅇㅇㅇ 월별 매출 현황 조회  ]                                 ");
		System.out.println("       월        메뉴코드            메뉴이름             총 매출                   ");		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("     ex)            1111                피자              5,000,000        ");
		
		System.out.println("----------------------------------------------------------------------------------");
	
		
	}
	/*
	 * 4. 후기관리 
	 * */
	
	public static void manageReview	() {
		reviewList();
		System.out.println("        1. 댓글작성      2. 댓글수정       3. 댓글삭제       4. 뒤로가기          ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요 >> ");
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					insertReply();//댓글작성
					manageReview();
					return;
					
				case 2:
					updateReply();//댓글수정
					manageReview();
					return;
					
				case 3:
					deleteReply();//댓글삭제
					manageReview();
					return;
					
				case 4:
					//뒤로가기
					return;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					manageReview();
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
	public static void updateReply() {
		menuList();
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
	public static void deleteReply() {
		menuList();
		System.out.println("* * * 삭제할 후기 코드를 입력해주세요 >> ");
		String no = sc.nextLine();
		
		//컨트롤러.delete(no);
	}
	
	
	
	
	/**
	 * 메뉴리스트
	 * */
	public static void  menuList() {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                     [ 메 뉴  목 록  db에서 가저옴]                               ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("        메뉴코드      카테고리       메뉴이름        가격       품절여부           ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("          ㅇㅇ          323         010-        ㅁㅇ        대기/줍비/중/완료/취  ");
		System.out.println("----------------------------------------------------------------------------------");
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
