package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.service.stores.StoresService;
import delivery.mvc.service.stores.StoresServiceImpl;
import delivery.mvc.view.FailView;

public class StoresController {
	private static StoresService storesService = new StoresServiceImpl();
	
	public static void storesInfoSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesInfoSelectAll();
			for(StoresDTO stores:list) {
			System.out.println(stores.getStore_code() + "\t" + stores.getStore_name() + "\t" + stores.getStore_regis_status());
			}
		}catch(SQLException e){
			System.out.println("오류");
		}
	}
	
	public static void storesSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesSelectAll();
			for(StoresDTO stores:list) {
			System.out.println(stores.getStore_code() + "\t" + stores.getAvg_star_grade() + "\t" + stores.getOrder_count());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void storeSelcetByCode(int store_code) {
		try {
			StoresDTO stores = storesService.storeSelcetByCode(store_code);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storeSelectById(String user_id) {
		try {
			StoresDTO stores = storesService.storeSelectById(user_id);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storesSelectByMenu(String menu_name){
		try {
			List<StoresDTO> list = storesService.storesSelectByMenu(menu_name);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storesSelectByCategory(int category_code){
		try {
			List<StoresDTO> list = storesService.storesSelectByCategory(category_code);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storeInsert(StoresDTO storesDTO){
		try {
			storesService.storeInsert(storesDTO);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storeUpdate(StoresDTO storesDTO){
		try {
			storesService.storeUpdate(storesDTO);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storeStatusUpdate(int store_status, String user_id){
		try {
			storesService.storeStatusUpdate(store_status,user_id);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storeRegis(StoresDTO storesDTO){
		try {
			storesService.storeRegis(storesDTO);
			System.out.println("변경");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storesSales() {
		try {
			List<StoresDTO> list = storesService.storesSales();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storesSalesByMonth(int store_code) {
		try {
			List<OrdersDTO> list = storesService.storesSalesByMonth(store_code);
			for(OrdersDTO od :list) {
				System.out.println(od.getMonth() + od.getTotal_sales() + od.getTotal_sales_for_master() + od.getTotal_sales_for_stores());
			}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void menuSalesByMonth(String users_id, int menu_code) {
		try {
			List<OrdersDTO> list = storesService.menuSalesByMonth(users_id, menu_code);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
