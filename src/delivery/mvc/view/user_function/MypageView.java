package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.UsersController;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.view.actor.UsersView;

public class MypageView {
	private static final String usersId = null;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		mypage();
	}
	
	public static void mypage(){
		System.out.println("---------------------------------------------------------------------");
		System.out.println("                          [ 마이페이지 ]                             ");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1.개인정보수정   2.주문내역   3.후기   4.판매자 신청하기   5.뒤로가기");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int mypageForStore = Integer.parseInt(sc.nextLine());
		switch(mypageForStore) {
			case 1:
				System.out.println("* * * 비밀번호를 입력해주세요. >> ");
				String usersPwd = sc.nextLine();
				//컨트롤러 호출, 비밀번호 인증하기!
				personalInfo();
				break;
			case 2:
				orders();
				break;
			case 3:
				review();
				break;
			case 4:
				storeRegis();
				break;
			case 5:
				UsersView.users(usersId);
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				mypage();
				break;
				
		}
		
	}
	
	/**
	 * 개인정보수정 @@@@@@@@@@@@@@@ 완료?
	 */
	private static void personalInfo() {

		while(true) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                          [ " + "usersId" + "님 개인정보 ]                  \n\n\n\n");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1.닉네임 변경   2.주소 변경   3.전화번호 변경   4.비밀번호 변경   5.뒤로가기");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");
			
			int personalInfo = Integer.parseInt(sc.nextLine());
			switch(personalInfo) {
				case 1:
					System.out.println("* * * 현재 닉네임을 입력해주세요. >> ");
					String usersNick = sc.nextLine();					
					System.out.println("* * * 변경할 닉네임을 입력해주세요. >> ");
					String newUsersNick = sc.nextLine();
					//닉네임변경 메소드(controller)
					UsersController.nickUpdate(usersNick, newUsersNick);
					personalInfo();
					break;
					
				case 2:
					System.out.println("* * * 현재 주소를 입력해주세요. >> ");
					String usersAddr = sc.nextLine();
					System.out.println("* * * 변경할 주소를 입력해주세요. >> ");
					String newUsersAddr = sc.nextLine();
					UsersController.addrUpdate(usersAddr, newUsersAddr);
					personalInfo();
					break;
					
				case 3:
					System.out.println("* * * 현재 전화번호를 입력해주세요. >> ");
					String usersPhone = sc.nextLine();
					System.out.println("* * * 변경할 전화번호를 입력해주세요. >> ");
					String newUsersPhone = sc.nextLine();
					UsersController.phoneUpdate(usersPhone, newUsersPhone);
					personalInfo();
					break;
					
				case 4:
					System.out.println("* * * 현재 비밀번호를 입력해주세요. >> ");
					String usersPwd = sc.nextLine();
				
					//컨트롤러 호출, 비밀번호 인증하기!
					
					System.out.println("* * * 변경할 비밀번호를 입력해주세요. >> ");
					String newUsersPwd = sc.nextLine();
					UsersController.pwdUpdate(usersPwd, newUsersPwd);					
					personalInfo();
					break;
					
				case 5:
					mypage();
					break;
					
				default :
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					personalInfo();
					break;
				
			}//switch끝
			
		}//while끝
	}
	
	
	/**
	 * 주문내역
	 */
	private static void orders() {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                               [ 주문내역 ]                                 \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.주문코드      2.주문날짜      3.총 가격      4.배송상태     5.예상배송시간");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("주문내역 불러오기!! \n\n\n\n");//UsersController.selectOrderList(String user_id);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.주문 상세보기       2.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int orders = Integer.parseInt(sc.nextLine());
		switch(orders) {
			case 1:
				System.out.println("* * * 주문코드를 입력해주세요. >> ");
				int order_code = Integer.parseInt(sc.nextLine());
				orderLine(order_code);
				break;
			case 2:
				mypage();
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				orders();
				break;
			
		}//switch끝	
	}
	
	/**
	 * 주문상세보기
	 */
	private static void orderLine(int order_code) {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                             [ 주문상세보기 ]                               \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.주문내역_상세코드    2.가게이름        3.메뉴이름        4.수량     5.단가");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("주문상세보기 불러오기!!!! \n\n\n");//UsersController.selectDelivery_time(int order_code);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.환불(취소)하기     2.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int orderLine = Integer.parseInt(sc.nextLine());
		switch(orderLine) {
			case 1:		
				
				//주문취소 메소드(UsersController //난 order_code사용했는데..,?)
				UsersController.cancelOrder(order_code);
				
				System.out.println("환불(취소)되었습니다.");
				orders();//주문내역 --> 배송상태 업데이트 하기!!!
				break;
			case 2:
				orders();
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				orderLine(order_code);
				break;
		}
	}
	
	
	/**
	 * 후기조회
	 */
	private static void review() {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                          [ 내가 작성한 후기 목록 ]                         \n");
		System.out.println("usersId가 작성한 후기 목록 불러오기!!!\n\n\n\n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.후기 등록           2.후기 수정           3.후기 삭제           4.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int review = Integer.parseInt(sc.nextLine());
		switch(review) {
		case 1:
			reviewInsert();
			review();
			break;
		case 2:
			reviewUpdate();
			review();
			break;
		case 3:
			System.out.println("* * * 삭제할 후기코드를 입력해주세요. >> ");
			int reviewCode = Integer.parseInt(sc.nextLine());
			
			//리뷰 삭제 메소드
			ReviewController.reviewDelete(reviewCode);
			review();
			break;
		case 4:
			mypage();
			break;
		default :
			System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			review();
			break;
		}
	}
	
	/**
	 * 후기등록
	 */
	private static void reviewInsert() {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                           [ 최근 주문 내역 ]                               \n");
		System.out.println("후기가 없는 주문 내역을 select!!!!\n\n\n\n");//후기가 없는거 까지 출력이 가능할까요???
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 주문코드 입력해주세요. >> ");
		int orderCode = Integer.parseInt(sc.nextLine());
		
		//컨트롤러 호출? 서비스 호출? 이미 후기가 작성된 주문코드 입력 시 오류메세지 출력!!
		
		System.out.println("* * * 5점 만점 중 평점을 입력해주세요. >> ");
		int starGrade = Integer.parseInt(sc.nextLine());
		System.out.println("* * * 후기를 입력해주세요.(최대 30자)  >> ");
		String reviewDetail = sc.nextLine();
		
		//리뷰 작성 메소드 ReviewController
		// user_id를 세션에서 가져와야 할듯
		ReviewDTO review = new ReviewDTO(/*user_id, order_code, store_code, reviewDetail, starGrade*/);
		ReviewController.reviewInsert(review);
	}
	
	
	/**
	 * 후기수정
	 */
	private static void reviewUpdate() {
		System.out.println("* * * 수정할 후기코드를 입력해주세요. >> ");
		int newReviewCode = Integer.parseInt(sc.nextLine());
		System.out.println("* * * 5점 만점 중 평점을 입력해주세요. >> ");
		int starGrade = Integer.parseInt(sc.nextLine());
		System.out.println("* * * 후기를 입력해주세요.(최대 30자)  >> ");
		String reviewDetail = sc.nextLine();
		
		//리뷰 수정 메소드 ReviewController
		ReviewDTO review = new ReviewDTO(starGrade, reviewDetail, newReviewCode);
		ReviewController.reviewUpdate(review);
	}
	

	
	/**
	 * 판매자 신청서
	 */
	private static void storeRegis() {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                             [ 판매자 신청서 ]                              \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.판매자 신청            2.판매자 신청 승인 결과 조회             3.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int storeRegis = Integer.parseInt(sc.nextLine());
		switch(storeRegis) {
		case 1:
			System.out.println("* * * 가게 이름을 입력해주세요. >> ");
			String storeName = sc.nextLine();
			
			System.out.println("* * * 가게 주소를 입력해주세요. >> ");
			String storeAddr = sc.nextLine();
			
			System.out.println("* * * 가게 전화번호를 입력해주세요. >> ");
			String storePhone = sc.nextLine();
			
			System.out.println("* * * 사업자등록번호를 입력해주세요. >> ");
			String storeBusinessNo = sc.nextLine();
			
			System.out.println("* * * 음식 카테고리 중 1가지를 입력해주세요. >> ");
			System.out.println("(1.양식   2.중식   3.한식)");
			int categoryCode = Integer.parseInt(sc.nextLine());
			
			
			// 양식, 중식, 한식 외 입력 시 오류메세지!!  
			//2가지 입력 시 오류 메세지!!
			
			storeRegister();
			break;
			
		case 2:
			System.out.println("----------------------------------------------------------------------------\n");
			System.out.println("      가게 신청일            가게 신청 현황            가게 신청 승인일     ");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("판매자 신청 승인 결과 select!! \n\n\n");
			System.out.println("----------------------------------------------------------------------------");
			storeRegis();
			break;
			
		case 3:
			mypage();
			break;
			
		default :
			System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			storeRegis();
			break;
		}
		 
	}
	
	/**
	 * 판매자신청
	 */
	private static void storeRegister() {		
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.신청하기          2.취소하기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
		int storeRegister = Integer.parseInt(sc.nextLine());
		switch(storeRegister) {
			case 1:
				System.out.println("판매자 신청이 완료되었습니다.");
				storeRegis();
				break;
			case 2:
				System.out.println("판매자 신청이 취소되었습니다.");
				storeRegis();
				break;
			default :
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				storeRegister();
				break;
		}//switch끝
	}
}
