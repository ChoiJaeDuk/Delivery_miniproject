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
	 * ���� ��ü ��� 6
	 * */
	public static void storePrintAllForMaster(List<StoresDTO> storesInfoSelectAll) {
		System.out.println("--------- [�� �� �� ��] ------------\n");
		for(StoresDTO storesDTO :storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_code()+"\t\t"+storesDTO.getStore_name()+storesDTO.getStore_regis_status()+"\t\n");
		}
		
	}
	/**
	 * �����ڵ�� ���� ���� �ޱ� 7,8,9
	 * */
	public static void storeSelcetByCode(StoresDTO storesDTO) {
		System.out.println(storesDTO+"\n");
	}
	
	/**
	 * ���̵�� ���� ���� 
	 * */
	public static void storeSelectById(StoresDTO stores) {
		System.out.println(stores.getStore_detail()+"\n");
	}
	
	/**
	 * �޴��� �������� �˻�
	 * */
	public static void storeSelectByMenu(List<StoresDTO> storesSelectByMenu) {
		for(StoresDTO storesDTO:storesSelectByMenu) {
			System.out.println(storesDTO);
			}
		}
	
	
	/**
	 * ī�װ��� �������� �˻�
	 * */
	public static void storesSelectByCategory(List<StoresDTO> storesSelectByCategory) {
		for(StoresDTO storesDTO:storesSelectByCategory) {
			System.out.println(storesDTO);
			}
		}
	
	/**
	 * ������Ȳ��ȸ 10 
	 * 
	 * */
	public static void storesSales(List<StoresDTO> storesSales) {
		for(StoresDTO storesDTO:storesSales) {
		System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+storesDTO.getTotal_sales()+"\t"+storesDTO.getTotal_sales_for_stores()+"\t"+storesDTO.getTotal_sales_for_master()+"\t");
		}
	}
	
	/**
	 * ���� ���⳻�� 11 //�ȿ��� STORESDTO (45)�����̰� �´���
	 * */
	public static void storeSalesByMonth(List<OrdersDTO> storeSalesByMonth) {
		for(OrdersDTO ordersDTO :storeSalesByMonth) {
			System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.getTotal_sales()+"\t"+ordersDTO.getTotal_sales_for_stores()+"\t"+ordersDTO.getTotal_sales_for_master());
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
	 * �ı��� 13 --2
	 * */
	public static void reviewList(List<ReviewDTO> reviewSelectAll) {
		for (ReviewDTO reviewDTO: reviewSelectAll) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
		}
	}
	
	/**
	 * ���� ���� open.close���� 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		if(storeDTO.getStore_status()==1) System.out.println("������  open �����Դϴ�.");
		else if(storeDTO.getStore_status()==0) System.out.println("������ closed �����Դϴ�. ");
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
	 *���θ��� ���� ��ȸ 25
	 * */
	public static void salesStatusForStores(List<OrdersDTO> storesSelectByMenu) {
		for(OrdersDTO ordersDTO:storesSelectByMenu) {
		System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.getTotal_sales());
		}
	}
	
	/**
	 * �ı���ȸ -28,293031,47
	 * */
	public static void reviewPrintAll (List<ReviewDTO> reviewSelectAll) {
		int total_price = 0;
		for(ReviewDTO reviewDTO:reviewSelectAll) {
			System.out.println(reviewDTO.getUser_id()+"\t"+reviewDTO.getOrder_code()+"\t"+reviewDTO.getStar_grade()+"\t"+reviewDTO.getReview_detail()+"\t"+reviewDTO.getPost_date());
			
			}
		
		System.out.println();
	}
	/**
	 * �ֹ����� 33-------------------------------------��ȣ�� �ּ�(���δ�
	 * */
	public static void orderPrintAll( List<OrdersDTO> selectOrderList) {
		for(OrdersDTO orderDTO:selectOrderList) {
			//System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getUser_id()+"\t"+orderDTO.��ȣ+"\t"+orderDTO.�ּ�+"\t"+orderDTO.getDelivery_status());
			}
	}
	
	/**
	 * �ֹ��ڵ庸�� �ֹ��� 34,35,36 
	 * */
	public static void selectOrderLine( List<MenuDTO> selectOrderLine) {
		for(MenuDTO menuDTO:selectOrderLine) {
			System.out.println(menuDTO.getMenu_name()+menuDTO.getOrderLine().getOrder_quntity()+menuDTO.getMenu_price()+"\t"+menuDTO.getTotal_price());
			}
	}
	
	/**
	 * ���������� 383940 --��ȭ���Ҷ� �ּҸ� ��ȸ�ϸ� ��
	 * */
	public static void storeInfoMypage (List<StoresDTO> storesInfoSelectAll) {
		//System.out.println("----------"++"���� �Դϴ�. -----------");
		for(StoresDTO storesDTO:storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_phone()+"\n"+storesDTO.getStore_addr());
		}
	}
	/**
	 * ī�װ� ��ȸ 44 *********�ؿ��� �ǵ��
	 * */
	public static void categoryCode() {
		CategoriesDTO categoriesDTO= new CategoriesDTO();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                      ["+ categoriesDTO.getCategory() + " ī�װ� ��� ]                     ");
		System.out.println("\n");
		
		
		
		//if(cc==1) {
			System.out.println("                 4. ����          5.�Ľ�Ÿ            6.������ũ            ");
			System.out.println("----------------------------------------------------------------------------------");
		//}else if(categoriesDTO.getCategory()==2) {
			System.out.println("7.��             8.�丮             9.��             13.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
		//}else if(categoriesDTO.getCategory()==3) {
			System.out.println("10.�           11.����          12.��/��          13.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
		//}
	
	}

	
	
	//4647 ���ԼҰ�
	
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
		int total_price=0;
		//System.out.println("---------     [�� �� �� �� ] -------------\n");
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.println(basketDTO.getMenu_code()+"\t"+basketDTO.getStore_name()+"\t"+basketDTO.getMenu_name()+"\t"+basketDTO.getBasket_quantity()+"\t"+basketDTO.getSum_price());
			total_price += basketDTO.getSum_price();
		}
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("�� �ֹ� �ݾ� >> "+total_price);
	}
	
	/**
	 * �ش� ȸ���� ��ٱ��Ͽ� ����Ǿ��ִ� �޴����� �������� �޼ҵ�
	 * */
	public static void basketMenuSelect(List<MenuDTO> basketMenuSelect) {
		for(MenuDTO menuDTO : basketMenuSelect) {
			System.out.println(menuDTO.getMenu_code()+"\t"+menuDTO.getMenu_name()+"\t"+menuDTO.getMenu_price()+"\t"+menuDTO.getBasket().getBasket_quantity());
			
		}
	}
	/**
	 * ������ü�˻� 55 57 58
	 * */
	public static void selectStoreList(List<StoresDTO> storesInfoSelectAll) {
			//System.out.println("--------- [�� �� �� ��] ------------\n");
			for(StoresDTO storesDTO :storesInfoSelectAll) {
				System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+"\t"+storesDTO.getStore_delivery_fee()+"\t"+storesDTO.getReview_count()+"/"+storesDTO.getAvg_star_grade()+storesDTO.getOrder_count());
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
	 * �ֹ��󼼳��� 65
	 * */
	public static void printOrderLine(List<OrderLineDTO> oll) {
		for (OrderLineDTO orderLineDTO:oll) {
			System.out.println(orderLineDTO.getOrder_line_code()+"\t"+orderLineDTO.getStore().getStore_name()+"\t"+orderLineDTO.getMenu().getMenu_name()+"\t"+orderLineDTO.getOrder_quntity()+"\t"+orderLineDTO.getMenu().getMenu_price());
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
	public static void regisCheck(StoresDTO storeDTO) {
		
			System.out.println(storeDTO.getStore_regis_date()+"\t"+storeDTO.getStore_regis_status()+"\t"+storeDTO.getStore_approval_date());
		
	}
		
	/**
	 * �޼��� INSERT, UP, DE
	 * */
	public static void getmessagePrint(String message) {
		System.out.println(message);
	}
	/**
	 * �޴��� ���� ��ȸ
	 * */
	public static void menuSalesByMonth(List<OrdersDTO> menuSalesByMonth) {
		for(OrdersDTO ordersDTO:menuSalesByMonth) {
			System.out.println(ordersDTO.getMonth()+"\t"+ordersDTO.getMenu_sales());
		}
	}
	
	/**
	 * ���Կ� �޴� ���� ��ȸ
	 * */
	public static void menuSales(List<MenuDTO> menuSalesList) {
		for(MenuDTO menuDTO : menuSalesList) {
			System.out.println(menuDTO.getMenu_code() + "\t" + menuDTO.getMenu_name() + "\t" + menuDTO.getTotal_profit());
		}
	}
	
	
}
