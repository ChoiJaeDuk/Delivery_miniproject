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
			System.out.println(storesDTO.getStore_code()+"     "+storesDTO.getStore_name()+"     "+storesDTO.getStore_regis_status()+"     ");
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
	 * �޴��� �������� �˻�56,57
	 * */
	/*public static void storeSelectByMenu(List<StoresDTO> storesSelectByMenu) {
		//���Ը��
		
		for(StoresDTO storesDTO:storesSelectByMenu) {
			System.out.println(storesDTO);
			}
		}*/
	
	
	/**
	 * ī�װ��� �������� �˻� 45
	 * */
	/*public static void storesSelectByCategory(List<StoresDTO> storesSelectByCategory) {
		for(StoresDTO storesDTO:storesSelectByCategory) {
			System.out.println(storesDTO);
			}
		}*/
	
	/**
	 * ������Ȳ��ȸ 10 
	 * 
	 * */
	public static void storesSales(List<StoresDTO> storesSales) {
		for(StoresDTO storesDTO:storesSales) {
		System.out.println(storesDTO.getStore_code()+"     "+storesDTO.getStore_name()+storesDTO.getTotal_sales()+
				"     "+storesDTO.getTotal_sales_for_stores()+"     "+storesDTO.getTotal_sales_for_master());
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
			System.out.println(ordersDTO.getMonth()+"     "+ordersDTO.getTotal_sales()+"     "
					+ordersDTO.getTotal_sales_for_stores()+"     "+ordersDTO.getTotal_sales_for_master());
		}
		System.out.println("----------------------------------------------------------------\n");
		
	}
	
	/**
	 * �ı� ������ ���Ը�� 12
	 * */
	public static void storeListForMaster(List<StoresDTO> storeList) {
		for(StoresDTO storesDTO:storeList) {
			System.out.println("             "+storesDTO.getStore_code()+"         "+storesDTO.getStore_name() );
		}
	}
	
	
	
	
	/**
	 * �ı���ȸ -
	 * 13 : ��ڰ� ��ȸ�ϴ� �� ������ ��� �ı�
	 * 47 : ȸ���� ��ȸ�ϴ� ���Ժ� ��ü �ı� = �� ������ ��� �ı�
	 * */
	public static void reviewList(List<ReviewDTO> reviewSelectAll) {
		for (ReviewDTO reviewDTO : reviewSelectAll) {
			System.out.println(
					reviewDTO.getOrder_code() + "		" + reviewDTO.getUser_id() + "		" + reviewDTO.getStar_grade()
							+ "		" + reviewDTO.getReview_detail() + "		" + reviewDTO.getPost_date());
		}
	}
	
	/**
	 * �ı���ȸ -
	 * 28,29,30,31 : �Ǹ��ڰ� ��ȸ�ϴ� ���� ������ ��ü �ı� = �� ������ ��� �ı�
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
	 * ���� ���� open.close���� 15
	 * */
	public static void storeStatus(StoresDTO storeDTO) {
		if(storeDTO.getStore_status()==1) System.out.println("			������  open �����Դϴ�.");
		else if(storeDTO.getStore_status()==0) System.out.println("			������ closed �����Դϴ�. ");
	}
	
	/**
	 * �޴���� 19 -----
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
	         System.out.println("  "+menu.getMenu_code()
	        		
	               +"		"+menu.getCategory_code()
	               +"\t	"+menu.getMenu_name()
	               +"\t	"+menu.getMenu_price()
	               +"\t	"+menu.getSoldout_status());
	      }
	      System.out.println("--------------------------------------------------------------------");
	   }
	
	/**
	 * �Ǹ���� 24
	 * */
	public static void salesStatus(List<MenuDTO> storeCodeSelectByMenu) {
		for (MenuDTO menuDTO : storeCodeSelectByMenu) {
			System.out.println("		"+menuDTO.getMenu_code() + "\t	 " + menuDTO.getMenu_name() + "\t	 "
					+ menuDTO.getTotal_price());
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
	 * �ֹ����� 33,36-------------------------------------
	 * */
	public static void selectOrderList( List<OrdersDTO> selectOrderList) {
		for(OrdersDTO orderDTO:selectOrderList) {
			System.out.println(orderDTO.getOrder_code()+"   "+orderDTO.getUser_id()+"   "+orderDTO.getUser_phone()+"   "+
					orderDTO.getDelivery_addr()+"   "+orderDTO.getDelivery_status().getDelivery_status());
			}
	}
	
	/**
	 * �ֹ��ڵ庸�� �ֹ��� 34,35
	 * */
	public static void selectOrderLine( List<MenuDTO> selectOrderLine, int store_code) {
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("            ["+ store_code +"  �ֹ� �� ]                            ");
		System.out.println("                 �޴�         ����         �ݾ�          �ѱݾ�                   ");
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
	

	
	
	//4647 ȸ��-���ԼҰ�
	/**
	 * �ı� -ȸ���� ��ȸ�ϴ� ������ü�ı� ��� ��ȸ
	 */
	
	public static void reviewDetailView(StoresDTO storeDTO) {
		System.out.println("--------------------------------------------------------------------\n");
		System.out.println("                "+storeDTO.getStore_name()+"                        \n");
		System.out.println(storeDTO.getStore_detail());
		System.out.println("--------------------------------------------------------------------\n");
	}
	
	
	
	/**
	 * �޴� ��ü��ȸ 49 - ȸ�� ����
	 * */
	public static void menuPrintAll(List<MenuDTO> menuSelectAll) {
	
		for(MenuDTO menuDTO : menuSelectAll) {
			System.out.println("  "+menuDTO.getMenu_code()+"\t\t\t    "+menuDTO.getMenu_name()+"\t\t\t   "+menuDTO.getMenu_price());
			
		}	
	}
	
	/**
	 * ��ٱ��� ��ȸ 50-53
	 * */
	public static void basketPrintAll(List<BasketDTO> basketSelectAll)  {
		int total_price=0;
		
		for(BasketDTO basketDTO : basketSelectAll) {
			System.out.println("  "+basketDTO.getMenu_code()+"\t"+basketDTO.getStore_name()+"\t\t"+basketDTO.getMenu_name()+"\t"+basketDTO.getBasket_quantity()+"\t"+basketDTO.getSum_price());
			
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
			System.out.println(
					"  "+menuDTO.getMenu_code() + "\t\t" + menuDTO.getStore().getStore_name() + "\t\t  " + menuDTO.getMenu_name()
							+ "\t\t" + menuDTO.getBasket().getBasket_quantity() + "\t" + menuDTO.getMenu_price());
			total_price += menuDTO.getMenu_price()*menuDTO.getBasket().getBasket_quantity();

		}
		System.out.println("= = = = = = = = = = =  = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("�� �ֹ� �ݾ� >> "+total_price);
	}
	/**
	 * ������ü�˻� 45 55 57 58
	 * */
	public static void selectStoreList(List<StoresDTO> storesInfoSelectAll) {

		for (StoresDTO storesDTO : storesInfoSelectAll) {
			System.out.println("  " + storesDTO.getStore_code() + "\t     " + storesDTO.getStore_name() + "\t     "
					+ storesDTO.getStore_delivery_fee() + "\t     " + storesDTO.getReview_count() + "/"
					+ storesDTO.getAvg_star_grade() + "\t     " + storesDTO.getOrder_count());
		}

	}
	/**
	 * �������� 6263
	 * */
	 public static void printUserInfo(UsersDTO userDTO) {
	      System.out.println("\t\t\t"+"��   ��  :  "+userDTO.getUsers_name()+
	    		  "\n\t\t\t"+"�� �� �� :  "+userDTO.getUsers_nick()+
	    		  "\n\t\t\t"+"��   ��  : "+userDTO.getUsers_addr()+
	    		  "\n\t\t\t"+"��ȭ��ȣ :  "+userDTO.getUsers_phone());
	      
	   }
	
	/**
	 * �ֹ����� 64
	 * */
	public static void printOrderList(List<OrdersDTO> selectOrderList) {
		for (OrdersDTO orderDTO : selectOrderList) {
			System.out.println("  "+orderDTO.getOrder_code() + "\t\t" + orderDTO.getOrder_date() + "\t"
					+ orderDTO.getOrder_total_price() + "\t\t" + orderDTO.getDelivery_status().getDelivery_status() + "\t\t"
					+ orderDTO.getOrder_delivery_time());
		}
	}
	/**
	 * �ֹ��󼼳��� 65
	 * */
	public static void printOrderLine(List<OrderLineDTO> oll) {
		for (OrderLineDTO orderLineDTO : oll) {
			System.out.println("\t"+orderLineDTO.getOrder_line_code() + "\t\t" + orderLineDTO.getStore().getStore_name()
					+ "\t\t" + orderLineDTO.getMenu().getMenu_name() + "\t\t" + orderLineDTO.getOrder_quntity() + "\t"
					+ orderLineDTO.getMenu().getMenu_price());
		}
	}
	
	/**
	 * ����(ȸ�� �ۼ��� �ı� ��� 66, 6869
	 * */
	   public static void reviewListByUserId(List<ReviewDTO> reviewListByUserId) {
		      for (ReviewDTO reviewDTO:reviewListByUserId) {
		         System.out.println("  "+reviewDTO.getReview_code()+"		"+
		      reviewDTO.getStoresDTO().getStore_name()+"\t	"+reviewDTO.getStar_grade()+"/"+
		        		 reviewDTO.getReview_detail()+"\t	"+reviewDTO.getReply()+"	"+reviewDTO.getPost_date());
		         }
		   }
	/**
	 * �ֱ��ֹ� ���� 67--------------?
	 * */
	public static void recentOrderLine(List<OrdersDTO> recentOrderLine) {
		for (OrdersDTO orderDTO:recentOrderLine) {
			System.out.println(orderDTO.getOrder_code()+"\t"+orderDTO.getStoresDTO().getStore_name()+"\t"+orderDTO.getOrder_date()+"\t"+orderDTO.getOrder_total_price());
		}		
	}
	
	/**
	 * �Ǹ��� ���� ��û ��ȸ72
	 * */
	public static void regisCheck(StoresDTO storeDTO) {
		System.out.println("  "+storeDTO.getStore_regis_date() + "\t\t" + storeDTO.getStore_regis_status() + "\t\t\t"
				+ storeDTO.getStore_approval_date());
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
		System.out.println("-----------------------------------");
		System.out.println("        [���� ����  ��ȸ  ]        \n");
		System.out.println("     ��                  �� ����   ");		
		System.out.println("-----------------------------------");
		
		for(OrdersDTO ordersDTO:menuSalesByMonth) {
			System.out.println("     "+ordersDTO.getMonth()+"          	   "+ordersDTO.getMenu_sales());
		}
		System.out.println("-----------------------------------");
	}
	
	/**
	 * ���Կ� �޴� ���� ��ȸ
	 * */
	public static void menuSales(List<MenuDTO> menuSalesList) {
		for (MenuDTO menuDTO : menuSalesList) {
			System.out.println("		" + menuDTO.getMenu_code() + "		   " + menuDTO.getMenu_name() + "			"
					+ menuDTO.getTotal_profit());
		}
	}
	
}
