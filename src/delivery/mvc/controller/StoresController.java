package delivery.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.service.stores.StoresService;
import delivery.mvc.service.stores.StoresServiceImpl;
import delivery.mvc.view.FailView;
import delivery.mvc.view.SuccessView;

public class StoresController {
	private static StoresService storesService = new StoresServiceImpl();
	
	
	//운영자가 보는 가게 목록 6p -가게이름과 코드만
	public static void storesInfoSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesInfoSelectAll();
			//SuccessView.getmessagePrint("가게목록 출력\n" + list);
			SuccessView.storePrintAllForMaster(list);
		}catch(SQLException e){
			//System.out.println("오류");
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storesNameCodeSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesInfoSelectAll();
			//SuccessView.getmessagePrint("가게목록 출력\n" + list);
			SuccessView.storeListForMaster(list);
		}catch(SQLException e){
			//System.out.println("오류");
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	//회원이 가게 조회
	public static void storesSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesSelectAll();
			SuccessView.selectStoreList(list);

			
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	//가게코드로 가게 정보 받기 
	public static void storeSelcetByCode(int store_code) {
		try {
			StoresDTO stores = storesService.storeSelcetByCode(store_code);
			SuccessView.storeSelcetByCode(stores);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	//아이디로 가게 정보
	public static void storeSelectById(String user_id) {
		try {
			StoresDTO stores = storesService.storeSelectById(user_id);
			SuccessView.storeSelectById(stores);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	//설명 : 가게 오픈 정보 출력
	public static void storeSelectStatus(String user_id) {
		try {
			StoresDTO stores = storesService.storeSelectById(user_id);
			StoresDTO aa = storesService.storeSelcetByCode(stores.getStore_code());
			SuccessView.storeStatus(aa);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	public static void storesSelectByMenu(String menu_name){
		try {
			List<StoresDTO> list = storesService.storesSelectByMenu(menu_name);
			SuccessView.storeSelectByMenu(list);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storesSelectByCategory(int category_code){
		
		
		try {
			
			if(category_code == 4 || category_code == 5 || category_code == 6) {
				List<StoresDTO> list = storesService.storesSelectByCategory(1);
				SuccessView.storesSelectByCategory(list);
			}else if (category_code == 7 || category_code == 8 || category_code == 9) {
				List<StoresDTO> list = storesService.storesSelectByCategory(2);
				SuccessView.storesSelectByCategory(list);
				
			}else if (category_code == 10 || category_code == 11 || category_code == 12) {
				List<StoresDTO> list = storesService.storesSelectByCategory(3);
				SuccessView.storesSelectByCategory(list);
			}
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storeInsert(StoresDTO storesDTO){
		try {
			storesService.storeInsert(storesDTO);
			SuccessView.getmessagePrint("가게등록 성공하였습니다");
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storeUpdate(StoresDTO storesDTO){
		try {
			storesService.storeUpdate(storesDTO);
			SuccessView.getmessagePrint("가게 정보를 수정하였습니다.");
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storeStatusUpdate(int store_status, String user_id){
		try {
			storesService.storeStatusUpdate(store_status,user_id);
			SuccessView.getmessagePrint("가게 정보를 업데이트 하였습니다.");
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storeRegis(StoresDTO storesDTO){
		
		try {
			String user_id = storesService.storeSelcetByCode(storesDTO.getStore_code()).getUser_id();
			storesDTO.setUser_id(user_id);
			storesService.storeRegis(storesDTO);
			SuccessView.getmessagePrint("가게 등록 신청 업데이트를 했습니다.");
		}catch(SQLException e){
			e.printStackTrace();
			//FailView.errorMessage(e.getMessage());
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	public static void regisCheck(String userid) {
		try {
			StoresDTO store = storesService.storeSelectById(userid);
			SuccessView.regisCheck(store);
		}catch(SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storesSales() {
		try {
			List<StoresDTO> list = storesService.storesSales();
			SuccessView.storesSales(list);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storesSalesByMonth(int store_code) {
		try {
			List<OrdersDTO> list = storesService.storesSalesByMonth(store_code);
			SuccessView.storeSalesByMonth(list);
		
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void menuSales(String users_id) {
		try {
			List<MenuDTO> list = storesService.menuSales(users_id);
			SuccessView.menuSales(list);
		}catch(SQLException e){
			FailView.errorMessage(e.getMessage());
			
		}
	}
	
	
	
	public static void menuSalesByMonth(String users_id, int menu_code) {
		try {
			List<OrdersDTO> list = storesService.menuSalesByMonth(users_id, menu_code);
			SuccessView.menuSalesByMonth(list);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
}
