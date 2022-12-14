package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.ReviewController;
import delivery.mvc.controller.StoresController;
import delivery.mvc.controller.UsersController;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.session.SessionSet;
import delivery.mvc.view.actor.UsersView;

public class MypageView {

	static Scanner sc = new Scanner(System.in);

	public static void mypage(String userId) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("                          [ 마이페이지 ]                             ");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1.개인정보수정   2.주문내역   3.후기   4.판매자 신청하기   5.뒤로가기");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");

		int mypageForStore = Integer.parseInt(sc.nextLine());
		switch (mypageForStore) {
		case 1:
			//System.out.println("* * * 비밀번호를 입력해주세요. >> ");
			//String usersPwd = sc.nextLine();
			//int result = UsersController.pwdCheck(userId, usersPwd);// 컨트롤러 호출, 비밀번호 인증하기!
			//if (result == 1)
				personalInfo();
			//mypage(userId);
			break;
		case 2:
			orders(userId);
			break;
		case 3:
			review(userId);
			break;
		case 4:
			storeRegis(userId);
			break;
		case 5:
			UsersView.users(userId);
			break;
		default:
			System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			mypage(userId);
			break;
		}
	}

	/**
	 * 개인정보수정
	 * 
	 * @param usersId
	 */

	private static void personalInfo() {
		SessionSet ss = SessionSet.getInstance();
		String userId = ss.getSet().iterator().next().getSessionId();
		
		boolean run = true;
	      while(run) {
	         System.out.println("* * * 비밀번호를 입력해주세요. >> ");
	         String oldusersPwd = sc.nextLine();
	         int pwresult = UsersController.pwdCheck(userId, oldusersPwd);// 컨트롤러 호출, 비밀번호 인증하기!
	         if (pwresult == 1) run=false;
	      }

		while (true) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                          [ " + userId + "님 개인정보 ]                   \n");
			UsersController.userInfoPrint(userId);
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("1.닉네임 변경   2.주소 변경   3.전화번호 변경   4.비밀번호 변경   5.뒤로가기");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >> ");

			int personalInfo = Integer.parseInt(sc.nextLine());
			switch (personalInfo) {
			case 1:
				System.out.println("* * * 변경할 닉네임을 입력해주세요. >> ");
				String newUsersNick = sc.nextLine();

				UsersController.nickUpdate(newUsersNick, userId);// 닉네임변경 메소드(controller)
				personalInfo();
				break;

			case 2:
				System.out.println("* * * 변경할 주소를 입력해주세요. >> ");
				String newUsersAddr = sc.nextLine();
				UsersController.addrUpdate(newUsersAddr, userId);
				personalInfo();
				break;

			case 3:
				System.out.println("* * * 변경할 전화번호를 입력해주세요. >> ");
				String newUsersPhone = sc.nextLine();
				UsersController.phoneUpdate(newUsersPhone, userId);
				personalInfo();

				break;

			case 4:
				System.out.println("* * * 현재 비밀번호를 입력해주세요. >> ");
				String usersPwd = sc.nextLine();

				// 컨트롤러 호출, 비밀번호 인증하기!
				int result = UsersController.pwdCheck(userId, usersPwd);
				if (result == 1) {
					System.out.println("* * * 변경할 비밀번호를 입력해주세요. >> ");
					String newUsersPwd = sc.nextLine();
					UsersController.pwdUpdate(usersPwd, newUsersPwd);
					personalInfo();
				}

				break;

			case 5:
				mypage(userId);
				break;

			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				personalInfo();
				break;
			}// switch끝
		} // while끝
	}

	/**
	 * 주문내역
	 * 
	 * @param userId
	 */

	private static void orders(String userId) {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                               [ 주문내역 ]                                 \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("  주문코드        주문날짜           총 가격          배송상태         예상배송시간");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");

		UsersController.selectOrderList(userId);

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.주문 상세보기       2.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");

		int orders = Integer.parseInt(sc.nextLine());
		switch (orders) {
		case 1:
			System.out.println("* * * 주문코드를 입력해주세요. >> ");
			int order_code = Integer.parseInt(sc.nextLine());
			orderLine(order_code);
			break;
		case 2:
			mypage(userId);
			break;
		default:
			System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			orders(userId);
			break;
		}// switch끝
	}

	/**
	 * 주문상세보기
	 */

	private static void orderLine(int order_code) {

		SessionSet ss = SessionSet.getInstance();
		String userId = ss.getSet().iterator().next().getSessionId();

		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                             [ 주문상세보기 ]                               \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("주문내역_상세코드    가게이름        메뉴이름        수량     단가");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");

		UsersController.selectDelivery_time(order_code);

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.환불(취소)하기     2.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");

		int orderLine = Integer.parseInt(sc.nextLine());
		switch (orderLine) {
		case 1:
			UsersController.cancelOrder(order_code);
			orders(userId);// 주문내역 --> 배송상태 업데이트 하기!!!
			break;
		case 2:
			orders(userId);
			break;
		default:
			System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			orderLine(order_code);
			break;
		}
	}

	/**
	 * 후기조회
	 * 
	 * @param userId
	 */

	private static void review(String userId) {
		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                          [ 내가 작성한 후기 목록 ]                         \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("후기 코드     가게 이름       평점/후기             댓글           등록일   ");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");

		ReviewController.reviewUserAll(userId);

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.후기 등록           2.후기 수정           3.후기 삭제           4.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");

		int review = Integer.parseInt(sc.nextLine());
		switch (review) {
		case 1:
			reviewInsert(userId);
			review(userId);
			break;
		case 2:
			reviewUpdate();
			review(userId);
			break;
		case 3:
			System.out.println("* * * 삭제할 후기코드를 입력해주세요. >> ");
			int reviewCode = Integer.parseInt(sc.nextLine());

			ReviewController.reviewDelete(reviewCode); // 후기 삭제 메소드
			review(userId);
			break;
		case 4:
			mypage(userId);
			break;
		default:
			System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			review(userId);
			break;
		}
	}

	/**
	 * 후기등록
	 */

	private static void reviewInsert(String userId) { // user_id를 세션에서 가져와야 할듯

		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                           [ 최근 주문 내역 ]                               \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("주문 코드           가게 이름             주문 날짜                  총 가격");
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = = = = = =");

		ReviewController.yetReview(userId);

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 주문코드 입력해주세요. >> ");
		int orderCode = Integer.parseInt(sc.nextLine());

		System.out.println("* * * 5점 만점 중 평점을 입력해주세요. >> ");
		int starGrade = Integer.parseInt(sc.nextLine());
		System.out.println("* * * 후기를 입력해주세요. >> ");
		String reviewDetail = sc.nextLine();

		// 컨트롤러 호출?
		// 후기 작성 메소드 ReviewController
		ReviewController.reviewInsert(userId, orderCode, reviewDetail, starGrade);

	}

	/**
	 * 후기수정
	 */

	private static void reviewUpdate() {
		System.out.println("* * * 수정할 후기코드를 입력해주세요. >> ");
		int newReviewCode = Integer.parseInt(sc.nextLine());

		System.out.println("* * * 5점 만점 중 평점을 입력해주세요. >> ");
		int starGrade = Integer.parseInt(sc.nextLine());

		System.out.println("* * * 후기를 입력해주세요. >> ");
		String reviewDetail = sc.nextLine();

		// 리뷰 수정 메소드 ReviewController
		ReviewDTO review = new ReviewDTO(starGrade, reviewDetail, newReviewCode);
		ReviewController.reviewUpdate(review);
	}

	/**
	 * 판매자 신청서
	 * 
	 * @param userId
	 */
	
	private static void storeRegis(String userId) {
		int categoryCode = 0;

		System.out.println("----------------------------------------------------------------------------\n");
		System.out.println("                             [ 판매자 신청서 ]                              \n");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.판매자 신청            2.판매자 신청 승인 결과 조회             3.뒤로가기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");

		int storeRegis = Integer.parseInt(sc.nextLine());
		switch (storeRegis) {
		case 1:
			System.out.println("* * * 가게 이름을 입력해주세요. >> "); // 테이블에서 자릿수 늘려주세요.
			String storeName = sc.nextLine();

			System.out.println("* * * 가게 주소를 입력해주세요. >> ");// 테이블에서 자릿수 늘려주세요.
			String storeAddr = sc.nextLine();

			System.out.println("* * * 가게 전화번호를 입력해주세요. >> ");
			String storePhone = sc.nextLine();

			System.out.println("* * * 사업자등록번호를 입력해주세요. >> ");
			String storeBusinessNo = sc.nextLine();

			boolean run = true;
			while (run) {
				System.out.println("* * * 음식 카테고리 중 1가지를 입력해주세요. >> ");
				System.out.println("(1.양식   2.중식   3.한식)");
				categoryCode = Integer.parseInt(sc.nextLine());
				switch (categoryCode) {
				case 1:
					run = false;
					break;
				case 2:
					run = false;
					break;
				case 3:
					run = false;
					break;
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					break;
				}
			}

			System.out.println("* * * 가게 설명을 입력해주세요. >> ");// 테이블에서 자릿수 제한 풀어주세요.
			String storeDetail = sc.nextLine();

			System.out.println("* * * 배달료를 입력해주세요. >> ");
			int delivery_fee = Integer.parseInt(sc.nextLine());

			StoresDTO store = new StoresDTO(userId, storeName, storeAddr, storePhone, storeBusinessNo,
					categoryCode, storeDetail, delivery_fee);
			storeRegister(store);
			break;

		case 2:
			System.out.println("----------------------------------------------------------------------------\n");
			System.out.println("      가게 신청일            가게 신청 현황            가게 신청 승인일     ");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			
			StoresController.regisCheck(userId);
			
			System.out.println("----------------------------------------------------------------------------");
			storeRegis(userId);
			break;

		case 3:
			mypage(userId);
			break;

		default:
			System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
			storeRegis(userId);
			break;
		}

	}

	/**
	 * 판매자신청서
	 * 
	 * @param userId
	 */
	
	private static void storeRegister(StoresDTO store) {

		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1.신청하기          2.취소하기");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");

		int storeRegister = Integer.parseInt(sc.nextLine());
		switch (storeRegister) {
			case 1:
				StoresController.storeInsert(store);
				storeRegis(store.getUser_id());
				break;
			case 2:
				System.out.println("판매자 신청이 취소되었습니다.");
				storeRegis(store.getUser_id());
				break;
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
				storeRegister(store);
				break;
		}
	}
}
