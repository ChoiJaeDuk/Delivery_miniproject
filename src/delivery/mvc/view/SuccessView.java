package delivery.mvc.view;

import java.util.List;

import delivery.mvc.controller.StoresController;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.CategoriesDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.dto.UsersDTO;


public class SuccessView {

	
	/**
	 * 가게 전체 목록 6
	 * */
	public static void storePrintAllForMaster(List<StoresDTO> storesInfoSelectAll) {

		for(StoresDTO storesDTO :storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_code()+"     "+storesDTO.getStore_name()+"     "+storesDTO.getStore_regis_status()+"     ");
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
	 * 메뉴로 가게정보 검색56,57
	 * */
	/*public static void storeSelectByMenu(List<StoresDTO> storesSelectByMenu) {
		//가게목록
		
		for(StoresDTO storesDTO:storesSelectByMenu) {
			System.out.println(storesDTO);
			}
		}*/
	
	
	/**
	 * 카테고리별 가게정보 검색 45
	 * */
	/*public static void storesSelectByCategory(List<StoresDTO> storesSelectByCategory) {
		for(StoresDTO storesDTO:storesSelectByCategory) {
			System.out.println(storesDTO);
			}
		}*/
	
	/**
	 * 매출현황조회 10 
	 * 
	 * */
	public static void storesSales(List<StoresDTO> storesSales) {
		for(StoresDTO storesDTO:storesSales) {
		System.out.println(storesDTO.getStore_code()+"     "+storesDTO.getStore_name()+storesDTO.getTotal_sales()+
				"     "+storesDTO.getTotal_sales_for_stores()+"     "+storesDTO.getTotal_sales_for_master());
		}
	}
	
	/**
	 * 세부 매출내역 11 
	 * */
	public static void storeSalesByMonth(List<OrdersDTO> storeSalesByMonth) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                         [ 세부 매출 내역 ]                     \n");
		System.out.println("구분       총 매출             운영자 매출           판매자 매출");
		System.out.println("----------------------------------------------------------------\n");
		for(OrdersDTO ordersDTO :storeSalesByMonth) {
			System.out.println(ordersDTO.getMonth()+"     "+ordersDTO.getTotal_sales()+"     "
					+ordersDTO.getTotal_sales_for_stores()+"     "+ordersDTO.getTotal_sales_for_master());
		}
		System.out.println("----------------------------------------------------------------\n");
		
	}
	
	/**
	 * 후기 관리에 가게목록 12
	 * */
	public static void storeListForMaster(List<StoresDTO> storeList) {
		for(StoresDTO storesDTO:storeList) {
			System.out.println("             "+storesDTO.getStore_code()+"         "+storesDTO.getStore_name() );
		}
	}
	
	
	
	
	/**
	 * 후기조회 -
	 * 13 : 운영자가 조회하는 한 가게의 모든 후기
	 * 47 : 회원이 조회하는 가게별 전체 후기 = 한 가게의 모든 후기
	 * */
	public static void reviewList(List<ReviewDTO> reviewSelectAll) {
		for (ReviewDTO reviewDTO : reviewSelectAll) {
			System.out.println(
					reviewDTO.getOrder_code() + "		" + reviewDTO.getUser_id() + "		" + reviewDTO.getStar_grade()
							+ "		" + reviewDTO.getReview_detail() + "		" + reviewDTO.getPost_date());
		}
	}
	
	/**
	 * 후기조회 -
	 * 28,29,30,31 : 판매자가 조회하는 본인 가게의 전체 후기 = 한 가게의 모든 후기
	 */
	
	public static void reviewListStore(List<ReviewDTO> reviewSelectAll) {
		for (ReviewDTO reviewDTO: reviewSelectAll) {
			System.out.println("  "+ reviewDTO.getReview_code()+
					"\t	    "+reviewDTO.getUser_id()+
					"		"+reviewDTO.getStar_grade()+"/"+reviewDTO.getReview_detail()+
					"\t	"+reviewDTO.getPost_date());
		}
	}
	

	
	/**
	 * 가게 관리 open.close관리 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		if(storeDTO.getStore_status()==1) System.out.println("			지금은  open 상태입니다.");
		else if(storeDTO.getStore_status()==0) System.out.println("			지금은 closed 상태입니다. ");
	}
	
	/**
	 * 메뉴등록 19 -----
	 * */
	
	public static void insertMenu(StoresDTO store) {
		//StoresDTO storeDTO= new StoresDTO();
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                        [ "+ store.getCategory_code() + " 카테고리 목록 ]                      ");
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------------");
		if(store.getCategory_code() ==1) {
			System.out.println("4. 피자            5.파스타           6.스테이크         13.뒤로가기");
            
		}else if(store.getCategory_code()==2) {
			System.out.println("7.면               8.요리             9.밥               13.뒤로가기");
			System.out.println("--------------------------------------------------------------------\n");
		}else if(store.getCategory_code() ==3) {
			System.out.println("10.찌개            11.볶음           12.찜/탕            13.뒤로가기");
			System.out.println("--------------------------------------------------------------------\n");
		}
	}
	
		/**
	    * 메뉴수정에 메뉴목록 판매자-20,21,22
	    * */
	   public static void menuList(List<MenuDTO> menuSelectAll) {
		  System.out.println("--------------------------------------------------------------------\n");
	      System.out.println("                             [ 메뉴 목록 ]                          \n");
	      System.out.println("--------------------------------------------------------------------\n");
	      System.out.println("메뉴코드      카테고리       메뉴이름          가격         품절여부");
	      System.out.println("--------------------------------------------------------------------\n");
	      for(MenuDTO menu : menuSelectAll) {
	         System.out.println("  "+menu.getMenu_code()
	        		
	               +"		"+menu.getCategory_code()
	               +"\t	"+menu.getMenu_name()
	               +"\t	"+menu.getMenu_price()
	               +"\t	"+menu.getSoldout_status());
	      }
	      System.out.println("--------------------------------------------------------------------");
	   }
	
	/**
	 * 판매통계 24
	 * */
	public static void salesStatus(List<MenuDTO> storeCodeSelectByMenu) {
		for (MenuDTO menuDTO : storeCodeSelectByMenu) {
			System.out.println("		"+menuDTO.getMenu_code() + "\t	 " + menuDTO.getMenu_name() + "\t	 "
					+ menuDTO.getTotal_price());
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
	 * 주문관리 33,36-------------------------------------
	 * */
	public static void selectOrderList( List<OrdersDTO> selectOrderList) {
		for(OrdersDTO orderDTO:selectOrderList) {
			System.out.println(orderDTO.getOrder_code()+"   "+orderDTO.getUser_id()+"   "+orderDTO.getUser_phone()+"   "+
					orderDTO.getDelivery_addr()+"   "+orderDTO.getDelivery_status().getDelivery_status());
			}
	}
	
	/**
	 * 주문코드보고 주문상세 34,35
	 * */
	public static void selectOrderLine( List<MenuDTO> selectOrderLine, int store_code) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("            ["+ store_code +"  주문 상세 ]                            ");
		System.out.println("                 메뉴         수량         금액          총금액                   ");
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
	

	
	
	//4647 회원-가게소개
	/**
	 * 후기 -회원이 조회하는 가게전체후기 목록 조회
	 */
	
	public static void reviewDetailView(StoresDTO storeDTO) {
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                "+storeDTO.getStore_name()+"                        \n");
		System.out.println(storeDTO.getStore_detail());
		System.out.println("--------------------------------------------------------------------\n");
	}
	
	
	
	/**
	 * 메뉴 전체조회 49 - 회원 시점
	 * */
	public static void menuPrintAll(List<MenuDTO> menuSelectAll) {
	
		for(MenuDTO menuDTO : menuSelectAll) {
			System.out.println("  "+menuDTO.getMenu_code()+"\t\t\t    "+menuDTO.getMenu_name()+"\t\t\t   "+menuDTO.getMenu_price());
			
		}	
	}
	
	/**
	 * 장바구니 조회 50-53
	 * */
	public static void basketPrintAll(List<BasketDTO> basketSelectAll)  {
		int total_price=0;
		
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.println("  "+basketDTO.getMenu_code()+"\t"+basketDTO.getStore_name()+"\t\t"+basketDTO.getMenu_name()+"\t"+basketDTO.getBasket_quantity()+"\t"+basketDTO.getSum_price());
			
			total_price += basketDTO.getSum_price();
		}
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("총 주문 금액 >> "+total_price);
	}
	
	/**
	 * 해당 회원의 장바구니에 저장되어있는 메뉴들을 가져오는 메소드
	 * */
	public static void basketMenuSelect(List<MenuDTO> basketMenuSelect) {
		int total_price=0;
		for (MenuDTO menuDTO : basketMenuSelect) {
			System.out.println(
					"  "+menuDTO.getMenu_code() + "\t\t" + menuDTO.getStore().getStore_name() + "\t\t  " + menuDTO.getMenu_name()
							+ "\t\t" + menuDTO.getBasket().getBasket_quantity() + "\t" + menuDTO.getMenu_price());
			total_price += menuDTO.getMenu_price()*menuDTO.getBasket().getBasket_quantity();

		}
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("총 주문 금액 >> "+total_price);
	}
	/**
	 * 가게전체검색 45 55 57 58
	 * */
	public static void selectStoreList(List<StoresDTO> storesInfoSelectAll) {

		for (StoresDTO storesDTO : storesInfoSelectAll) {
			System.out.println("  " + storesDTO.getStore_code() + "\t     " + storesDTO.getStore_name() + "\t     "
					+ storesDTO.getStore_delivery_fee() + "\t     " + storesDTO.getReview_count() + "/"
					+ storesDTO.getAvg_star_grade() + "\t     " + storesDTO.getOrder_count());
		}

	}
	/**
	 * 개인정보 6263
	 * */
	 public static void printUserInfo(UsersDTO userDTO) {
	      System.out.println("\t\t\t"+"이   름  :  "+userDTO.getUsers_name()+
	    		  "\n\t\t\t"+"닉 네 임 :  "+userDTO.getUsers_nick()+
	    		  "\n\t\t\t"+"주   소  : "+userDTO.getUsers_addr()+
	    		  "\n\t\t\t"+"전화번호 :  "+userDTO.getUsers_phone());
	      
	   }
	
	/**
	 * 주문내역 64
	 * */
	public static void printOrderList(List<OrdersDTO> selectOrderList) {
		for (OrdersDTO orderDTO : selectOrderList) {
			System.out.println("  "+orderDTO.getOrder_code() + "\t\t" + orderDTO.getOrder_date() + "\t"
					+ orderDTO.getOrder_total_price() + "\t\t" + orderDTO.getDelivery_status().getDelivery_status() + "\t\t"
					+ orderDTO.getOrder_delivery_time());
		}
	}
	/**
	 * 주문상세내역 65
	 * */
	public static void printOrderLine(List<OrderLineDTO> oll) {
		for (OrderLineDTO orderLineDTO : oll) {
			System.out.println("\t"+orderLineDTO.getOrder_line_code() + "\t\t" + orderLineDTO.getStore().getStore_name()
					+ "\t\t" + orderLineDTO.getMenu().getMenu_name() + "\t\t" + orderLineDTO.getOrder_quntity() + "\t"
					+ orderLineDTO.getMenu().getMenu_price());
		}
	}
	
	/**
	 * 내가(회원 작성한 후기 목록 66, 6869
	 * */
	   public static void reviewListByUserId(List<ReviewDTO> reviewListByUserId) {
		      for (ReviewDTO reviewDTO:reviewListByUserId) {
		         System.out.println("  "+reviewDTO.getReview_code()+"		"+
		      reviewDTO.getStoresDTO().getStore_name()+"\t	"+reviewDTO.getStar_grade()+"/"+
		        		 reviewDTO.getReview_detail()+"\t	"+reviewDTO.getReply()+"	"+reviewDTO.getPost_date());
		         }
		   }
	/**
	 * 최근주문 내역 67--------------?
	 * */
	public static void recentOrderLine(List<OrdersDTO> recentOrderLine) {
		for (OrdersDTO orderDTO:recentOrderLine) {
			System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getStoresDTO().getStore_name()+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price());
		}		
	}
	
	/**
	 * 판매자 승인 신청 조회72
	 * */
	public static void regisCheck(StoresDTO storeDTO) {
		System.out.println("  "+storeDTO.getStore_regis_date() + "\t\t" + storeDTO.getStore_regis_status() + "\t\t\t"
				+ storeDTO.getStore_approval_date());
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
		System.out.println("-----------------------------------");
		System.out.println("        [월별 매출  조회  ]        \n");
		System.out.println("     월                  총 매출   ");		
		System.out.println("-----------------------------------");
		
		for(OrdersDTO ordersDTO:menuSalesByMonth) {
			System.out.println("     "+ordersDTO.getMonth()+"          	   "+ordersDTO.getMenu_sales());
		}
		System.out.println("-----------------------------------");
	}
	
	/**
	 * 가게에 메뉴 매출 조회
	 * */
	public static void menuSales(List<MenuDTO> menuSalesList) {
		for (MenuDTO menuDTO : menuSalesList) {
			System.out.println("		" + menuDTO.getMenu_code() + "		   " + menuDTO.getMenu_name() + "			"
					+ menuDTO.getTotal_profit());
		}
	}
	
}
