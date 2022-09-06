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
	public static void storePrintAll(List<StoresDTO> storesInfoSelectAll) {
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
	 * ���� ���⳻�� 11 //�� ���� �������� ..
	 * */
	public static void salesDetail(List<StoresDTO> storeSales) {
		for(StoresDTO storeDTO :storeSales) {
			System.out.println();
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
			//System.out.println(reviewDTO.getReview_code()+"\t\t"+reviewDTO.getReview_detail()+"\t\t"+reviewDTO.());
		}
	}
	
	/**
	 * ���� ���� open.close���� 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		System.out.println("������  "+storeDTO.getStore_status()+" �����Դϴ�.");
	}
	
	/**
	 * �޴���� 19 ---��..................
	 * */
	
	public static void insertMenu() {
		StoresDTO storeDTO= new StoresDTO();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                      ["+ storeDTO.getCategory_code() + " ī�װ� ��� ]                     ");
		System.out.println("\n");
		/*
		if(getCategoryCode ==1) {
			System.out.println("                 4. ����          5.�Ľ�Ÿ            6.������ũ            ");
			System.out.println("----------------------------------------------------------------------------------");
		}else if(getCategoryCode==2) {
			System.out.println("7.��             8.�丮             9.��             13.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
		}else if(getCategoryCode ==3) {
			System.out.println("10.�           11.����          12.��/��          13.�ڷΰ���");
			System.out.println("----------------------------------------------------------------\n");
		}
		*/
		
		
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
	 *���θ��� ���� ��ȸ 25 ----------------------------------------------?
	 * */
	public static void salesStatusForStores(List<StoresDTO> storesSelectByMenu) {
		for(StoresDTO storesDTO:storesSelectByMenu) {
		System.out.println(storesDTO.getStore_code()+"\t"+storesDTO.getStore_name()+storesDTO.getTotal_sales());
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
			//System.out.println(menuDTO.getStore_code()+"\t"+menuDTO.+"\t"+orderDTO.��ȣ+"\t"+orderDTO.�ּ�+"\t"+orderDTO.getDelivery_status());
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
	 * ��ٱ��� ��ȸ 50
	 * */
	public static void basketPrintAll(List<BasketDTO> basketSelectAll)  {
		System.out.println("---------     [�� �� �� �� ] -------------\\n");
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.println();
			
		}
		
	}
	
	
	
	
	
	
	
	
	/**
	 * ��ٱ��� �˻�
	 */
	public static void basketMenuSelect() {
		
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
