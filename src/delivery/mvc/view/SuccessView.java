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
	 * ���� ��ü ��� 6
	 * */
	public static void storePrintAllForMaster(List<StoresDTO> storesInfoSelectAll) {

		for(StoresDTO storesDTO :storesInfoSelectAll) {
			System.out.printf("%5s %25s %20s\n",
					storesDTO.getStore_code(),
					storesDTO.getStore_name(),
					storesDTO.getStore_regis_status());
					
		}
			
	}
	/**
	 * �����ڵ�� ���� ���� �ޱ� 7,8,9
	 * */
	public static void storeSelcetByCode(StoresDTO storesDTO) {
		System.out.printf("%5s\n",storesDTO);
	}
	
	/**
	 * ȸ���� �����ڵ�� �˻����� �� ���� �Ұ��� ��µǾ���մϴ�.
	 */
	public static void userSelectStore(StoresDTO storeDTO) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.printf("%50s",storeDTO.getStore_name()+"                        \n");
		System.out.printf("%30s\n",storeDTO.getStore_detail());
		System.out.println("----------------------------------------------------------------\n");
	}
	
	
	/**
	 * ���̵�� ���� ����
	 * */
	public static void storeSelectById(StoresDTO stores) {
		System.out.printf("%40s\n",stores.getStore_detail() );
	}

	/**
	 * ������Ȳ��ȸ 10 
	 * 
	 * */
	public static void storesSales(List<StoresDTO> storesSales) {
		for(StoresDTO storesDTO:storesSales) {
		System.out.printf("%5s %11s %12s %10s  %11s\n",
				storesDTO.getStore_code(),
				storesDTO.getStore_name(),
				storesDTO.getTotal_sales(),
				storesDTO.getTotal_sales_for_stores(),
				storesDTO.getTotal_sales_for_master());
		}
	}
	
	/**
	 * ���� ���⳻�� 11 
	 * */
	public static void storeSalesByMonth(List<OrdersDTO> storeSalesByMonth) {
		System.out.println("----------------------------------------------------------------\n");
		System.out.println("                         [ ���� ���� ���� ]                     \n");
		System.out.println("����       �� ����             ��� ����           �Ǹ��� ����");
		System.out.println("----------------------------------------------------------------\n");
		for(OrdersDTO ordersDTO :storeSalesByMonth) {
			System.out.printf("%2s %11s %20s %22s\n",
					ordersDTO.getMonth(),
					ordersDTO.getTotal_sales(),
					ordersDTO.getTotal_sales_for_stores(),
					ordersDTO.getTotal_sales_for_master());
		}
		System.out.println("----------------------------------------------------------------\n");
		
	}
	
	/**
	 * �ı� ������ ���Ը�� 12
	 * */
	public static void storeListForMaster(List<StoresDTO> storeList) {
		for(StoresDTO storesDTO:storeList) {
			System.out.printf("%20s %18s\n",storesDTO.getStore_code(),storesDTO.getStore_name() );
		}
	}
	
	
	
	
	/**
	 * �ı���ȸ 
	 * 13 : ��ڰ� ��ȸ�ϴ� �� ������ ��� �ı�
	 * 47 : ȸ���� ��ȸ�ϴ� ���Ժ� ��ü �ı� = �� ������ ��� �ı�
	 * */
	public static void reviewList(List<ReviewDTO> reviewSelectAll) {
		for (ReviewDTO reviewDTO : reviewSelectAll) {
			System.out.printf("%5s %11s %12s %10s %10s\n",
					reviewDTO.getOrder_code(),
					reviewDTO.getUser_id(), 
					reviewDTO.getStar_grade(),
					reviewDTO.getReview_detail(),
					reviewDTO.getPost_date());
		}
	}
	
	/**
	 * �ı���ȸ
	 * 28,29,30,31 : �Ǹ��ڰ� ��ȸ�ϴ� ���� ������ ��ü �ı� = �� ������ ��� �ı�
	 */
	
	public static void reviewListStore(List<ReviewDTO> reviewSelectAll) {
		for (ReviewDTO reviewDTO: reviewSelectAll) {
			System.out.printf("%5s %14s %6s %1s\t%-10s %s\n",
					reviewDTO.getReview_code(),
					reviewDTO.getUser_id(),
					reviewDTO.getStar_grade()+"/",
					reviewDTO.getReview_detail(),
					reviewDTO.getReply(),
					reviewDTO.getPost_date());
		}
	}
	

	
	/**
	 * ���� ���� open.close���� 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		if(storeDTO.getStore_status()==1) System.out.printf("%43s\n","������  open �����Դϴ�.");
		else if(storeDTO.getStore_status()==0) System.out.printf("%43s\n","������ closed �����Դϴ�. ");
	}
	
	/**
	 * �޴���� 19 
	 * */
	
	public static void insertMenu(StoresDTO store) {
		//StoresDTO storeDTO= new StoresDTO();
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                        [ "+ store.getCategory_code() + " ī�װ� ��� ]                      ");
		System.out.println("\n");
		System.out.println("--------------------------------------------------------------------");
		if(store.getCategory_code() ==1) {
			System.out.println("4. ����            5.�Ľ�Ÿ           6.������ũ         13.�ڷΰ���");
            
		}else if(store.getCategory_code()==2) {
			System.out.println("7.��               8.�丮             9.��               13.�ڷΰ���");
			System.out.println("--------------------------------------------------------------------\n");
		}else if(store.getCategory_code() ==3) {
			System.out.println("10.�            11.����           12.��/��            13.�ڷΰ���");
			System.out.println("--------------------------------------------------------------------\n");
		}
	}
	
		/**
	    * �޴������� �޴���� �Ǹ���-20,21,22 
	    * */
	   public static void menuList(List<MenuDTO> menuSelectAll) {
		  System.out.println("--------------------------------------------------------------------\n");
	      System.out.println("                             [ �޴� ��� ]                          \n");
	      System.out.println("--------------------------------------------------------------------\n");
	      System.out.println("�޴��ڵ�      ī�װ�       �޴��̸�          ����         ǰ������");
	      System.out.println("--------------------------------------------------------------------\n");
	      for(MenuDTO menu : menuSelectAll) {
	         System.out.printf( "%5d\t%5d\t\t%-5s\t\t%-5d\t\t%d\n",
	        		 menu.getMenu_code(),
	        		 menu.getCategory_code(),
	        		 menu.getMenu_name(),
	        		 menu.getMenu_price(),
	        		 menu.getSoldout_status());
	      }
	      System.out.println("--------------------------------------------------------------------");
	   }
	
	/**
	 * �Ǹ���� 24
	 * */
	public static void salesStatus(List<MenuDTO> storeCodeSelectByMenu) {
		for (MenuDTO menuDTO : storeCodeSelectByMenu) {
			System.out.printf("%20s %15s %15s",
					menuDTO.getMenu_code(),
					menuDTO.getMenu_name(),
					menuDTO.getTotal_price());
		} 
	}
	/**
	 *���θ��� ���� ��ȸ 25
	 * */
	public static void salesStatusForStores(List<OrdersDTO> storesSelectByMenu) {
		for(OrdersDTO ordersDTO:storesSelectByMenu) {
		System.out.printf("%10s %20s",
				ordersDTO.getMonth(),
				ordersDTO.getTotal_sales());
		}
	}
	
	
	/**
	 * �ֹ����� 33,36
	 * */
	public static void selectOrderList( List<OrdersDTO> selectOrderList) {
		for(OrdersDTO orderDTO:selectOrderList) {
			System.out.printf("%10s %18s %18s %6s %9s\n",
					orderDTO.getOrder_code(),
					orderDTO.getUser_id(),
					orderDTO.getUser_phone(),
					orderDTO.getDelivery_addr(),
					orderDTO.getDelivery_status().getDelivery_status());
			}
	}
	
	/**
	 * �ֹ��ڵ庸�� �ֹ��� 34,35
	 * */
	public static void selectOrderLine( List<MenuDTO> selectOrderLine, int store_code) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                            [ "+store_code +"  �ֹ� �� ]                        ");
		System.out.println("              �޴�         ����         �ݾ�          �ѱݾ�                   \n");
		for(MenuDTO menuDTO:selectOrderLine) {
			System.out.printf("%15s %10s %15s %15s\n",
					menuDTO.getMenu_name(),
					menuDTO.getOrderLine().getOrder_quntity(),
					menuDTO.getMenu_price(),
					menuDTO.getTotal_price());
			}
	
	}
	

	/**
	 * ���������� 383940 --��ȭ���Ҷ� �ּҸ� ��ȸ
	 * */
	public static void storeInfoMypage (List<StoresDTO> storesInfoSelectAll) {
		
		for(StoresDTO storesDTO:storesInfoSelectAll) {
			System.out.println(storesDTO.getStore_phone()+"\n"+storesDTO.getStore_addr());
		}
	}
	

	
	
	
	/**
	 * �ı⸦ ���� ���Լ����ϸ� �ش� ������ �̸�+���ԼҰ� layout
	 */
	
	public static void reviewDetailView(StoresDTO storeDTO) {
		System.out.println("----------------------------------------------------------------------------------\n");
		System.out.printf("%30s\n\n",storeDTO.getStore_name());
		System.out.printf("%35s\n",storeDTO.getStore_detail());
		System.out.println("----------------------------------------------------------------------------------\n");
	}
	
	
	
	/**
	 * �޴� ��ü��ȸ 49 - ȸ�� ����
	 * */
	public static void menuPrintAll(List<MenuDTO> menuSelectAll) {
	
		for(MenuDTO menuDTO : menuSelectAll) {
			System.out.printf("%5s %23s %20s\n",
					menuDTO.getMenu_code(),
					menuDTO.getMenu_name(),
					menuDTO.getMenu_price());
			
		}	
	}
	
	/**
	 * ��ٱ��� ��ȸ 50-53 
	 * */
	public static void basketPrintAll(List<BasketDTO> basketSelectAll)  {
		int total_price=0;
		
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.printf("%5s %10s %3s %5s %5s",
				basketDTO.getMenu_code(),
				basketDTO.getStore_name(),
				basketDTO.getMenu_name(),
				basketDTO.getBasket_quantity(),
				basketDTO.getSum_price());
							
			total_price += basketDTO.getSum_price();
		}
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("�� �ֹ� �ݾ� >> "+total_price);
	}
	
	/**
	 * �ش� ȸ���� ��ٱ��Ͽ� ����Ǿ��ִ� �޴����� �������� �޼ҵ�
	 * */
	public static void basketMenuSelect(List<MenuDTO> basketMenuSelect) {
		int total_price=0;
		for (MenuDTO menuDTO : basketMenuSelect) {	
			System.out.printf("%5s %13s %17s %10s %7s\n",
					menuDTO.getMenu_code() ,
					menuDTO.getStore().getStore_name(),
					menuDTO.getMenu_name(),
					menuDTO.getBasket().getBasket_quantity(),
					menuDTO.getMenu_price());
			total_price += menuDTO.getMenu_price()*menuDTO.getBasket().getBasket_quantity();

		}
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("�� �ֹ� �ݾ� >> "+total_price);
	}
	/**
	 * ������ü�˻� 45 55 57 58
	 * */
	public static void selectStoreList(List<StoresDTO> storesInfoSelectAll) {
		System.out.println("--------------------------------------------------------------------");
		for (StoresDTO storesDTO : storesInfoSelectAll) {
			System.out.printf("%5s %10s %10s %13s %1s %15s\n",
					storesDTO.getStore_code(),
					storesDTO.getStore_name(),
					storesDTO.getStore_delivery_fee(),
					storesDTO.getReview_count()+"/",
					storesDTO.getAvg_star_grade(),
					storesDTO.getOrder_count());
		}

	}
	/**
	 * �������� 6263
	 * */
	 public static void printUserInfo(UsersDTO userDTO) {
	      System.out.printf("\t\t\t"+"��   ��  :  "+userDTO.getUsers_name()+
	    		  "\n\t\t\t"+"�� �� �� :  "+userDTO.getUsers_nick()+
	    		  "\n\t\t\t"+"��   ��  : "+userDTO.getUsers_addr()+
	    		  "\n\t\t\t"+"��ȭ��ȣ :  "+userDTO.getUsers_phone()+"\n");
	      
	   }
	
	/**
	 * �ֹ����� 64- ȸ���� ���� �ֹ�����
	 * */
	public static void printOrderList(List<OrdersDTO> selectOrderList) {
		for (OrdersDTO orderDTO : selectOrderList) {
			System.out.printf("%5s \t%20s\t %10s\t\t %-10s %10s\n",
					orderDTO.getOrder_code(),
					orderDTO.getOrder_date(),
					orderDTO.getOrder_total_price(),
					orderDTO.getDelivery_status().getDelivery_status(),
					orderDTO.getOrder_delivery_time());
		}
	}
	/**
	 * �ֹ��󼼳��� 65 - ȸ��/����������/2�ֹ�����/�󼼺���
	 * */
	public static void printOrderLine(List<OrderLineDTO> oll) {
		for (OrderLineDTO orderLineDTO : oll) {
			System.out.printf("%5s %20s %10s %10s %10s\n",
					orderLineDTO.getOrder_line_code(),
					orderLineDTO.getStore().getStore_name(),
					orderLineDTO.getMenu().getMenu_name(),
					orderLineDTO.getOrder_quntity(),
					orderLineDTO.getMenu().getMenu_price());
		}
	}
	
	/**
	 * ȸ���� �ۼ��� �ı� ��� 66, 6869
	 * */
	   public static void reviewListByUserId(List<ReviewDTO> reviewListByUserId) {
		      for (ReviewDTO reviewDTO:reviewListByUserId) {
		         System.out.printf("%5s %10s %10s %1s\t %-10s %s\n",
		        		 reviewDTO.getReview_code(),
		        		 reviewDTO.getStoresDTO().getStore_name(),
		        		 reviewDTO.getStar_grade()+"/",
		        		 reviewDTO.getReview_detail(),
		        		 reviewDTO.getReply(),
		        		 reviewDTO.getPost_date());
		         }
		   }
	/**
	 * �ֱ��ֹ� ���� 67   
	 * */
	public static void recentOrderLine(List<OrdersDTO> recentOrderLine) {
		for (OrdersDTO orderDTO:recentOrderLine) {
			System.out.printf("%5s\t\t %7s\t\t %8s\t\t %s\n",
					orderDTO.getOrder_code(),
					orderDTO.getStoresDTO().getStore_name(),
					orderDTO.getOrder_date(),
					orderDTO.getOrder_total_price());
		}		
	}
	
	/**
	 * �Ǹ��� ���� ��û ��ȸ72
	 * */
	public static void regisCheck(StoresDTO storeDTO) {
		System.out.printf("%10s %23s %25s\n",
				storeDTO.getStore_regis_date(),
				storeDTO.getStore_regis_status(),
				storeDTO.getStore_approval_date());
	}
		
	
	
	/**
	 * �޼��� INSERT, UPDATE, DELETE
	 * */
	public static void getmessagePrint(String message) {
		System.out.println(message);
	}
	
	/**
	 * �޴��� ���� ��ȸ
	 * */
	public static void menuSalesByMonth(List<OrdersDTO> menuSalesByMonth) {
		System.out.println("-----------------------------------");
		System.out.println("        [ ���� ����  ��ȸ  ]        \n");
		System.out.println("     ��                  �� ����   ");		
		System.out.println("-----------------------------------");
		
		for(OrdersDTO ordersDTO:menuSalesByMonth) {
			System.out.printf("%8s %22s\n",
					ordersDTO.getMonth(),
					ordersDTO.getMenu_sales());
		}
		System.out.println("-----------------------------------");
	}
	
	/**
	 * ���Կ� �޴� ���� ��ȸ �Ǹ��� - ���� ���� -�Ǹ����
	 * */
	public static void menuSales(List<MenuDTO> menuSalesList) {
		for (MenuDTO menuDTO : menuSalesList) {
			System.out.printf("%15s %15s\t\t\t%d\n",
					menuDTO.getMenu_code(),
					menuDTO.getMenu_name(),
					menuDTO.getTotal_profit());
		}
	}
	
}
