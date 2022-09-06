package delivery.mvc.view;

import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.ReviewDTO;
import delivery.mvc.dto.StoresDTO;


public class SuccessView {
	
	
	/**
	 * ���� ��ü ��� 6
	 * */
	public static void storePrintAllForMaster(List<StoresDTO> storesInfoSelectAll) {
		//System.out.println("--------- [�� �� �� ��] ------------\n");
		for(StoresDTO storesDTO :storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_code()+"\t\t"+storesDTO.getStore_name()+storesDTO.getStore_regis_status()+"\t\t");
		}
		
	}
	/**
	 * �����ڵ�� ���� ���� �ޱ� 7,8,9
	 * */
	public static void storeSelcetByCode(StoresDTO storesDTO) {
		System.out.println(storesDTO+"\n");
	}
	/**
	 * ������Ȳ��ȸ 10 
	 * 
	 * */
	public static void salesStatusForMaster(List<StoresDTO> storesSales) {
		for(StoresDTO storesDTO:storesSales) {
		System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+storesDTO.getTotal_sales()+"\t"+storesDTO.getTotal_sales_for_stores()+"\t"+storesDTO.getTotal_sales_for_master()+"\t");
		}
	}
	
	/**
	 * ���� ���⳻�� 11 //�ȿ��� STORESDTO (45)�����̰� �´���
	 * */
	public static void menuSalesByMonth(List<OrdersDTO> menuSalesByMonth) {
		//StoresDTO storesDTO= new StoresDTO();
		//List<OrdersDTO> list = menuSalesByMonth
		for(OrdersDTO ordersDTO :menuSalesByMonth) {
			System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.get);
		}
	}
	
	/**
	 * �ı� ������ ���Ը�� 12
	 * */
	public static void storeListForMaster(List<StoresDTO> storeList) {
		for(StoresDTO storesDTO:storeList) {
			System.out.println(storesDTO.getStore_code()+"\t\t"+storesDTO.getStore_name() );
		}
	}
	/**
	 * �ı��� 13 --2��°�� ���� �̸� ,4��° ���� �����
	 * */
	public static void reviewList(List<ReviewDTO> reviewSelectAll) {
		
		for (ReviewDTO reviewDTO: reviewSelectAll) {
			System.out.println(reviewDTO.getReview_code()+"\t\t"+reviewDTO.getReview_detail()+"\t\t"+reviewDTO.());
		}
	}
	
	/**
	 * ���� ���� open.close���� 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		System.out.println("������  "+storeDTO.getStore_status()+" �����Դϴ�.");
	}
	
	/**
	 * �޴���� 19 -----�³�
	 * */
	
	public static void insertMenu() {
		StoresDTO storeDTO= new StoresDTO();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                      ["+ storeDTO.getCategory_code() + " ī�װ� ��� ]                     ");
		System.out.println("\n");
		
		if(storeDTO.getCategory_code() ==1) {
			System.out.println("                 4. ����          5.�Ľ�Ÿ            6.������ũ            ");
			System.out.println("----------------------------------------------------------------------------------");
		}else if(storeDTO.getCategory_code()==2) {
			System.out.println("7.��             8.�丮             9.��             13.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
		}else if(storeDTO.getCategory_code() ==3) {
			System.out.println("10.�           11.����          12.��/��          13.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
		}
	}
	
	/**
	 * �޴������� �޴���� 20,21,22
	 * */
	public static void menuList(List<MenuDTO> menuSelectAll) {
		for(MenuDTO menuDTO:menuSelectAll) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getCategory_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getMenu_price()+"\t"+menuDTO.getSoldout_status());
		}
	}
	
	/**
	 * �Ǹ���� 24
	 * */
	public static void salesStatus(List<MenuDTO> storeCodeSelectByMenu) {
		for(MenuDTO menuDTO:storeCodeSelectByMenu) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getTotal_price());
		}
	}
	/**
	 *���θ��� ���� ��ȸ 25 --------------------OrdersDTO �����ؼ� �ҷο��� �³���
	 * */
	public static void salesStatusForStores(List<StoresDTO> storesSelectByMenu) {
		OrdersDTO ordersDTO=new OrdersDTO();
		for(StoresDTO storesDTO:storesSelectByMenu) {
		System.out.println(storesDTO.getStore_code()+"\t"+ordersDTO.getMonth()+"\t"+storesDTO.getTotal_sales());
		}
	}
	
	/**
	 * �ı���ȸ -28,293031,47
	 * */
	public static void reviewPrintAll (List<ReviewDTO> reviewSelectAll) {
		for(ReviewDTO reviewDTO:reviewSelectAll) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
			}
	}
	/**
	 * �ֹ����� 33-------------------------------------��ȣ�� �ּ�
	 * */
	public static void orderPrintAll( List<OrdersDTO> selectOrderList) {
		for(OrdersDTO orderDTO:selectOrderList) {
			//System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getUser_id()+"\t"+orderDTO.��ȣ+"\t"+orderDTO.�ּ�+"\t"+orderDTO.getDelivery_status());
			}
	}
	
	/**
	 * �ֹ��ڵ庸�� �ֹ��� 34,35,36   --�����ٿ����ÿ� 179 ��
	 * */
	public static void orderPrintDetail( List<MenuDTO> orderPrintAll) {
		for(MenuDTO menuDTO:orderPrintAll) {
			System.out.println(menuDTO.getMenu_name());
			}
	}
	
	/**
	 * ���������� 383940
	 * */
	public static void storeInfoMypage() {
		
	}
	/**
	 * 40 ----45
	 * */
	
	
	//4647���� 
	
	/**
	 * �޴� ��ü��ȸ 49
	 * */
	public static void menuPrintAll(List<MenuDTO> menuSelectAll) {
		System.out.println("---------  [�� ��] ------------\n");
		for(MenuDTO menuDTO : menuSelectAll) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getMenu_price()+"\t");
		}	
	}
	
	/**
	 * ��ٱ��� ��ȸ 50-53
	 * */
	public static void basketPrintAll(List<BasketDTO> basketSelectAll)  {
		System.out.println("---------     [�� �� �� �� ] -------------\\n");
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.println(basketDTO.getMenu_code()+"\t"+basketDTO.getStore_name()+"\t"+basketDTO.getMenu_name()+"\t"+basketDTO.getBasket_quantity()+"\t"+basketDTO.getSum_price());
			
		}
	}
	
	/**
	 * ������ü�˻� 55 57 58
	 * */
	public static void selectStoreList(List<StoresDTO> storesInfoSelectAll) {
			//System.out.println("--------- [�� �� �� ��] ------------\n");
			for(StoresDTO storesDTO :storesInfoSelectAll) {
				System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+"\t"+storesDTO.getStore_delivery_fee()+"\t"+storesDTO.getReview_count()+"/"+storesDTO.getAvg_star_grade()+storesDTO.getTotal_sales());
			}
			
		}
	/**
	 * �������� 6263 ---------------------�������..
	 * */
	public static void printUserInfo() {
		
	}
	
	/**
	 * �ֹ����� 64
	 * */
	public static void printOrderList(List<OrdersDTO> selectOrderList) {
		for (OrdersDTO orderDTO:selectOrderList) {
			System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price()+"\t"+orderDTO.getDelivery_status()+"\t"+orderDTO.getOrder_delivery_time());
		}
	}
	/**
	 * �ֹ��󼼳��� 65-----------��
	 * */
	public static void printOrderLine(List<MenuDTO> selectOrderLine) {
		for (MenuDTO menuDTO:selectOrderLine) {
			//System.out.println(menuDTO.+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price()+"\t"+orderDTO.getDelivery_status()+"\t"+orderDTO.getOrder_delivery_time());
		}
	}
	
	/**
	 * ���� �ۼ��� �ı� ��� 66, 6869
	 * */
	public static void reviewListByUserId(List<ReviewDTO> reviewListByUserId) {
		for (ReviewDTO reviewDTO:reviewListByUserId) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
			}
	}
	/**
	 * �ֱ��ֹ� ���� 67--------------?
	 * */
	public static void recentOrderLine(List<OrdersDTO> recentOrderLine) {
		for (OrdersDTO orderDTO:recentOrderLine) {
			System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price()+"\t"+orderDTO.getDelivery_status()+"\t"+orderDTO.getOrder_delivery_time());
		}		
	}
	
	/**
	 * �Ǹ��� ���� ��û ��ȸ72
	 * */
	public static void storeRegisStatus(List<StoresDTO> storeRegisStatus) {
		for(StoresDTO storesDTO:storeRegisStatus) {
			System.out.println(storesDTO.getStore_regis_date()+"\t"+storesDTO.getStore_regis_status()+"\t"+storesDTO.getStore_approval_date());
		}
	}
		
	/**
	 * �޼��� INSERT, UP, DE
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	/**
	 * 
	 * */
	
	
}
