package delivery.mvc.view;

import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;


public class SuccessView {
	
	
	/**
	 * 가게 전체 목록 6
	 * */
	public static void storePrintAllForMaster(List<StoresDTO> storesInfoSelectAll) {
		//System.out.println("--------- [가 게 목 록] ------------\n");
		for(StoresDTO storesDTO :storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_code()+"\t\t"+storesDTO.getStore_name()+storesDTO.getStore_regis_status()+"\t\t");
		}
		
	}
	/**
	 * 가게코드로 가게 정보 받기 7,8,9
	 * */
	public static void storeSelcetByCode(StoresDTO storesDTO) {
		System.out.println(storesDTO+"\n");
	}
	/**
	 * 매출현황조회 10 
	 * 
	 * */
	public static void salesStatusForMaster(List<StoresDTO> storesSales) {
		for(StoresDTO storesDTO:storesSales) {
		System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+storesDTO.getTotal_sales()+"\t"+storesDTO.getTotal_sales_for_stores()+"\t"+storesDTO.getTotal_sales_for_master()+"\t");
		}
	}
	
	/**
	 * 세부 매출내역 11 //안에서 STORESDTO (45)라인이거 맞는지
	 * */
	public static void menuSalesByMonth(List<OrdersDTO> menuSalesByMonth) {
		//StoresDTO storesDTO= new StoresDTO();
		//List<OrdersDTO> list = menuSalesByMonth
		for(OrdersDTO ordersDTO :menuSalesByMonth) {
			System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.get);
		}
	}
	
	/**
	 * 후기 관리에 가게목록 12
	 * */
	public static void storeListForMaster(List<StoresDTO> storeList) {
		for(StoresDTO storesDTO:storeList) {
			System.out.println(storesDTO.getStore_code()+"\t\t"+storesDTO.getStore_name() );
		}
	}
	/**
	 * 후기목록 13 --2번째에 가게 이름 ,4번째 별점 어딨남
	 * */
	public static void reviewList(List<ReviewDTO> reviewSelectAll) {
		
		for (ReviewDTO reviewDTO: reviewSelectAll) {
			System.out.println(reviewDTO.getReview_code()+"\t\t"+reviewDTO.getReview_detail()+"\t\t"+reviewDTO.());
		}
	}
	
	/**
	 * 가게 관리 open.close관리 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		System.out.println("지금은  "+storeDTO.getStore_status()+" 상태입니다.");
	}
	
	/**
	 * 메뉴등록 19 -----맞나
	 * */
	
	public static void insertMenu() {
		StoresDTO storeDTO= new StoresDTO();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                      ["+ storeDTO.getCategory_code() + " 카테고리 목록 ]                     ");
		System.out.println("\n");
		
		if(storeDTO.getCategory_code() ==1) {
			System.out.println("                 4. 피자          5.파스타            6.스테이크            ");
			System.out.println("----------------------------------------------------------------------------------");
		}else if(storeDTO.getCategory_code()==2) {
			System.out.println("7.면             8.요리             9.밥             13.뒤로가기");
			System.out.println("----------------------------------------------------------------\n");
		}else if(storeDTO.getCategory_code() ==3) {
			System.out.println("10.찌개           11.볶음          12.찜/탕          13.뒤로가기");
			System.out.println("----------------------------------------------------------------\n");
		}
	}
	
	/**
	 * 메뉴수정에 메뉴목록 20,21,22
	 * */
	public static void menuList(List<MenuDTO> menuSelectAll) {
		for(MenuDTO menuDTO:menuSelectAll) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getCategory_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getMenu_price()+"\t"+menuDTO.getSoldout_status());
		}
	}
	
	/**
	 * 판매통계 24
	 * */
	public static void salesStatus(List<MenuDTO> storeCodeSelectByMenu) {
		for(MenuDTO menuDTO:storeCodeSelectByMenu) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getTotal_price());
		}
	}
	/**
	 *세부매출 내역 조회 25 --------------------OrdersDTO 생성해서 불로오기 맞나요
	 * */
	public static void salesStatusForStores(List<StoresDTO> storesSelectByMenu) {
		OrdersDTO ordersDTO=new OrdersDTO();
		for(StoresDTO storesDTO:storesSelectByMenu) {
		System.out.println(storesDTO.getStore_code()+"\t"+ordersDTO.getMonth()+"\t"+storesDTO.getTotal_sales());
		}
	}
	
	/**
	 * 후기조회 -28,293031,47
	 * */
	public static void reviewPrintAll (List<ReviewDTO> reviewSelectAll) {
		for(ReviewDTO reviewDTO:reviewSelectAll) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
			}
	}
	/**
	 * 주문관리 33-------------------------------------번호랑 주소
	 * */
	public static void orderPrintAll( List<OrdersDTO> selectOrderList) {
		for(OrdersDTO orderDTO:selectOrderList) {
			//System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getUser_id()+"\t"+orderDTO.번호+"\t"+orderDTO.주소+"\t"+orderDTO.getDelivery_status());
			}
	}
	
	/**
	 * 주문코드보고 주문상세 34,35,36   --오더다오임플에 179 줄
	 * */
	public static void orderPrintDetail( List<MenuDTO> orderPrintAll) {
		for(MenuDTO menuDTO:orderPrintAll) {
			System.out.println(menuDTO.getMenu_name());
			}
	}
	
	/**
	 * 마이페이지 383940
	 * */
	public static void storeInfoMypage() {
		
	}
	/**
	 * 40 ----45
	 * */
	
	
	//4647위에 
	
	/**
	 * 메뉴 전체조회 49
	 * */
	public static void menuPrintAll(List<MenuDTO> menuSelectAll) {
		System.out.println("---------  [메 뉴] ------------\n");
		for(MenuDTO menuDTO : menuSelectAll) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getMenu_price()+"\t");
		}	
	}
	
	/**
	 * 장바구니 조회 50-53
	 * */
	public static void basketPrintAll(List<BasketDTO> basketSelectAll)  {
		System.out.println("---------     [장 바 구 니 ] -------------\\n");
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.println(basketDTO.getMenu_code()+"\t"+basketDTO.getStore_name()+"\t"+basketDTO.getMenu_name()+"\t"+basketDTO.getBasket_quantity()+"\t"+basketDTO.getSum_price());
			
		}
	}
	
	/**
	 * 가게전체검색 55 57 58
	 * */
	public static void selectStoreList(List<StoresDTO> storesInfoSelectAll) {
			//System.out.println("--------- [가 게 목 록] ------------\n");
			for(StoresDTO storesDTO :storesInfoSelectAll) {
				System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+"\t"+storesDTO.getStore_delivery_fee()+"\t"+storesDTO.getReview_count()+"/"+storesDTO.getAvg_star_grade()+storesDTO.getTotal_sales());
			}
			
		}
	/**
	 * 개인정보 6263 ---------------------어디있지..
	 * */
	public static void printUserInfo() {
		
	}
	
	/**
	 * 주문내역 64
	 * */
	public static void printOrderList(List<OrdersDTO> selectOrderList) {
		for (OrdersDTO orderDTO:selectOrderList) {
			System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price()+"\t"+orderDTO.getDelivery_status()+"\t"+orderDTO.getOrder_delivery_time());
		}
	}
	/**
	 * 주문상세내역 65-----------모름
	 * */
	public static void printOrderLine(List<MenuDTO> selectOrderLine) {
		for (MenuDTO menuDTO:selectOrderLine) {
			//System.out.println(menuDTO.+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price()+"\t"+orderDTO.getDelivery_status()+"\t"+orderDTO.getOrder_delivery_time());
		}
	}
	
	/**
	 * 내가 작성한 후기 목록 66, 6869
	 * */
	public static void reviewListByUserId(List<ReviewDTO> reviewListByUserId) {
		for (ReviewDTO reviewDTO:reviewListByUserId) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
			}
	}
	/**
	 * 최근주문 내역 67--------------?
	 * */
	public static void recentOrderLine(List<OrdersDTO> recentOrderLine) {
		for (OrdersDTO orderDTO:recentOrderLine) {
			System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price()+"\t"+orderDTO.getDelivery_status()+"\t"+orderDTO.getOrder_delivery_time());
		}		
	}
	
	/**
	 * 판매자 승인 신청 조회72
	 * */
	public static void storeRegisStatus(List<StoresDTO> storeRegisStatus) {
		for(StoresDTO storesDTO:storeRegisStatus) {
			System.out.println(storesDTO.getStore_regis_date()+"\t"+storesDTO.getStore_regis_status()+"\t"+storesDTO.getStore_approval_date());
		}
	}
		
	/**
	 * 메세지 INSERT, UP, DE
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	/**
	 * 
	 * */
	
	
}
