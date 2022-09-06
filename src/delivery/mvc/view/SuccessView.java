package delivery.mvc.view;

import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.CategoriesDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;


public class SuccessView {
	
	
	/**
	 * 가게 전체 목록 6
	 * */
	public static void storePrintAllForMaster(List<StoresDTO> storesInfoSelectAll) {
		System.out.println("--------- [가 게 목 록] ------------\n");
		for(StoresDTO storesDTO :storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_code()+"\t\t"+storesDTO.getStore_name()+storesDTO.getStore_regis_status()+"\t\n");
		}
		
	}
	/**
	 * 가게코드로 가게 정보 받기 7,8,9
	 * */
	public static void storeSelcetByCode(StoresDTO storesDTO) {
		System.out.println(storesDTO+"\n");
	}
	
	/**
	 * 아이디로 가게 정보 
	 * */
	public static void storeSelectById(StoresDTO stores) {
		System.out.println(stores.getStore_detail()+"\n");
	}
	
	/**
	 * 메뉴로 가게정보 검색
	 * */
	public static void storeSelectByMenu(List<StoresDTO> storesSelectByMenu) {
		for(StoresDTO storesDTO:storesSelectByMenu) {
			System.out.println(storesDTO);
			}
		}
	
	
	/**
	 * 카테고리별 가게정보 검색
	 * */
	public static void storesSelectByCategory(List<StoresDTO> storesSelectByCategory) {
		for(StoresDTO storesDTO:storesSelectByCategory) {
			System.out.println(storesDTO);
			}
		}
	
	/**
	 * 매출현황조회 10 
	 * 
	 * */
	public static void storesSales(List<StoresDTO> storesSales) {
		for(StoresDTO storesDTO:storesSales) {
		System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+storesDTO.getTotal_sales()+"\t"+storesDTO.getTotal_sales_for_stores()+"\t"+storesDTO.getTotal_sales_for_master()+"\t");
		}
	}
	
	/**
	 * 세부 매출내역 11 //안에서 STORESDTO (45)라인이거 맞는지
	 * */
	public static void storeSalesByMonth(List<OrdersDTO> storeSalesByMonth) {
		for(OrdersDTO ordersDTO :storeSalesByMonth) {
			System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.getTotal_sales()+"\t"+ordersDTO.getTotal_sales_for_stores()+"\t"+ordersDTO.getTotal_sales_for_master());
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
	 * 후기목록 13 --2
	 * */
	public static void reviewList(List<ReviewDTO> reviewSelectAll) {
		for (ReviewDTO reviewDTO: reviewSelectAll) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
		}
	}
	
	/**
	 * 가게 관리 open.close관리 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		if(storeDTO.getStore_status()==1) System.out.println("지금은  open 상태입니다.");
		else if(storeDTO.getStore_status()==0) System.out.println("지금은 closed 상태입니다. ");
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
	 *세부매출 내역 조회 25
	 * */
	public static void salesStatusForStores(List<OrdersDTO> storesSelectByMenu) {
		for(OrdersDTO ordersDTO:storesSelectByMenu) {
		System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.getTotal_sales());
		}
	}
	
	/**
	 * 후기조회 -28,293031,47
	 * */
	public static void reviewPrintAll (List<ReviewDTO> reviewSelectAll) {
		int total_price = 0;
		for(ReviewDTO reviewDTO:reviewSelectAll) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
			
			}
		
		System.out.println();
	}
	/**
	 * 주문관리 33-------------------------------------번호랑 주소(종민니
	 * */
	public static void orderPrintAll( List<OrdersDTO> selectOrderList) {
		for(OrdersDTO orderDTO:selectOrderList) {
			//System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getUser_id()+"\t"+orderDTO.번호+"\t"+orderDTO.주소+"\t"+orderDTO.getDelivery_status());
			}
	}
	
	/**
	 * 주문코드보고 주문상세 34,35,36 
	 * */
	public static void selectOrderLine( List<MenuDTO> selectOrderLine) {
		for(MenuDTO menuDTO:selectOrderLine) {
			System.out.println(menuDTO.getMenu_name()+menuDTO.getOrderLine().getOrder_quntity()+menuDTO.getMenu_price()+"\t"+menuDTO.getTotal_price());
			}
	}
	
	/**
	 * 마이페이지 383940 --전화번소랑 주소만 조회하면 됨
	 * */
	public static void storeInfoMypage (List<StoresDTO> storesInfoSelectAll) {
		//System.out.println("----------"++"가게 입니다. -----------");
		for(StoresDTO storesDTO:storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_phone()+"\n"+storesDTO.getStore_addr());
		}
	}
	/**
	 * 카테고리 조회 44 *********해원님 피드백
	 * */
	public static void categoryCode() {
		CategoriesDTO categoriesDTO= new CategoriesDTO();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                      ["+ categoriesDTO.getCategory() + " 카테고리 목록 ]                     ");
		System.out.println("\n");
		
		
		
		//if(cc==1) {
			System.out.println("                 4. 피자          5.파스타            6.스테이크            ");
			System.out.println("----------------------------------------------------------------------------------");
		//}else if(categoriesDTO.getCategory()==2) {
			System.out.println("7.면             8.요리             9.밥             13.뒤로가기");
			System.out.println("----------------------------------------------------------------\n");
		//}else if(categoriesDTO.getCategory()==3) {
			System.out.println("10.찌개           11.볶음          12.찜/탕          13.뒤로가기");
			System.out.println("----------------------------------------------------------------\n");
		//}
	
	}

	
	
	//4647 가게소개
	
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
		int total_price=0;
		//System.out.println("---------     [장 바 구 니 ] -------------\n");
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.println(basketDTO.getMenu_code()+"\t"+basketDTO.getStore_name()+"\t"+basketDTO.getMenu_name()+"\t"+basketDTO.getBasket_quantity()+"\t"+basketDTO.getSum_price());
			total_price += basketDTO.getSum_price();
		}
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("총 주문 금액 >> "+total_price);
	}
	
	/**
	 * 해당 회원의 장바구니에 저장되어있는 메뉴들을 가져오는 메소드
	 * */
	public static void basketMenuSelect(List<MenuDTO> basketMenuSelect) {
		for(MenuDTO menuDTO : basketMenuSelect) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getMenu_price()+"\t"+menuDTO.getBasket().getBasket_quantity());
			
		}
	}
	/**
	 * 가게전체검색 55 57 58
	 * */
	public static void selectStoreList(List<StoresDTO> storesInfoSelectAll) {
			//System.out.println("--------- [가 게 목 록] ------------\n");
			for(StoresDTO storesDTO :storesInfoSelectAll) {
				System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+"\t"+storesDTO.getStore_delivery_fee()+"\t"+storesDTO.getReview_count()+"/"+storesDTO.getAvg_star_grade()+storesDTO.getOrder_count());
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
	 * 주문상세내역 65
	 * */
	public static void printOrderLine(List<OrderLineDTO> oll) {
		for (OrderLineDTO orderLineDTO:oll) {
			System.out.println(orderLineDTO.getOrder_line_code()+"\t"+orderLineDTO.getStore().getStore_name()+"\t"+orderLineDTO.getMenu().getMenu_name()+"\t"+orderLineDTO.getOrder_quntity()+"\t"+orderLineDTO.getMenu().getMenu_price());
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
	public static void regisCheck(StoresDTO storeDTO) {
		
			System.out.println(storeDTO.getStore_regis_date()+"\t"+storeDTO.getStore_regis_status()+"\t"+storeDTO.getStore_approval_date());
		
	}
		
	/**
	 * 메세지 INSERT, UP, DE
	 * */
	public static void getmessagePrint(String message) {
		System.out.println(message);
	}
	/**
	 * 메뉴별 월별 조회
	 * */
	public static void menuSalesByMonth(List<OrdersDTO> menuSalesByMonth) {
		for(OrdersDTO ordersDTO:menuSalesByMonth) {
			System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.getMenu_sales());
		}
	}
	
	/**
	 * 가게에 메뉴 매출 조회
	 * */
	public static void menuSales(List<MenuDTO> menuSalesList) {
		for(MenuDTO menuDTO : menuSalesList) {
			System.out.println(menuDTO.getMenu_code() + "\t" + menuDTO.getMenu_name() + "\t" + menuDTO.getTotal_profit());
		}
	}
	
	
}
