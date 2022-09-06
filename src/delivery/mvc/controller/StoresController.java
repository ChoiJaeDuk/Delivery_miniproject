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
	
	
	//��ڰ� ���� ���� ��� 6p -�����̸��� �ڵ常
	public static void storesInfoSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesInfoSelectAll();
			//SuccessView.getmessagePrint("���Ը�� ���\n" + list);
			SuccessView.storePrintAllForMaster(list);
		}catch(SQLException e){
			//System.out.println("����");
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storesNameCodeSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesInfoSelectAll();
			//SuccessView.getmessagePrint("���Ը�� ���\n" + list);
			SuccessView.storeListForMaster(list);
		}catch(SQLException e){
			//System.out.println("����");
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	//ȸ���� ���� ��ȸ
	public static void storesSelectAll() {
		try {
			List<StoresDTO> list = storesService.storesSelectAll();
			SuccessView.selectStoreList(list);

			
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	//�����ڵ�� ���� ���� �ޱ� 
	public static void storeSelcetByCode(int store_code) {
		try {
			StoresDTO stores = storesService.storeSelcetByCode(store_code);
			SuccessView.storeSelcetByCode(stores);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	//���̵�� ���� ����
	public static void storeSelectById(String user_id) {
		try {
			StoresDTO stores = storesService.storeSelectById(user_id);
			SuccessView.storeSelectById(stores);
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	//���� : ���� ���� ���� ���
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
			SuccessView.getmessagePrint("���Ե�� �����Ͽ����ϴ�");
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storeUpdate(StoresDTO storesDTO){
		try {
			storesService.storeUpdate(storesDTO);
			SuccessView.getmessagePrint("���� ������ �����Ͽ����ϴ�.");
		}catch(SQLException e){
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void storeStatusUpdate(int store_status, String user_id){
		try {
			storesService.storeStatusUpdate(store_status,user_id);
			SuccessView.getmessagePrint("���� ������ ������Ʈ �Ͽ����ϴ�.");
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
			SuccessView.getmessagePrint("���� ��� ��û ������Ʈ�� �߽��ϴ�.");
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
