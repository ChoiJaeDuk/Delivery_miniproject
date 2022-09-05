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
		}catch(SQLException e){
			
		}
	}
	
	public static void storesSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesSelectAll();
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
	
	public static void storeStatusUpdate(StoresDTO storesDTO){
		try {
			storesService.storeStatusUpdate(storesDTO);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void storeRegis(StoresDTO storesDTO){
		try {
			storesService.storeRegis(storesDTO);
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
	
	public static void menuSalesByMonth(int store_code, int menu_code) {
		try {
			List<OrdersDTO> list = storesService.menuSalesByMonth(store_code, menu_code);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
}
