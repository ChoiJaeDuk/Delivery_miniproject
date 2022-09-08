package delivery.mvc.service.stores;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;

public interface StoresService {
	 List<StoresDTO> storesInfoSelectAll(String arrange) throws SQLException;
	 
	 List<StoresDTO> storesSelectAll(String arrange) throws SQLException;
	 
	 StoresDTO storeSelcetByCode(int store_code) throws SQLException;
	 
	 StoresDTO storeSelectById(String user_id) throws SQLException;
	 
	 List<StoresDTO> storesSelectByMenu(String arrange, String menu_name) throws SQLException;
	 
	 List<StoresDTO> storesSelectByCategory(String arrange, int category_code) throws SQLException;
	 
	 void storeInsert(StoresDTO storesDTO) throws SQLException;
	 
	 void storeUpdate(StoresDTO storesDTO) throws SQLException;
	 
	 void storeStatusUpdate(int store_status, String user_id) throws SQLException;
	 
	 void storeRegis(StoresDTO storesDTO) throws SQLException;
	 
	 List<StoresDTO> storesSales() throws SQLException;
	 
	 List<OrdersDTO> storesSalesByMonth(int store_code) throws SQLException;
	 
	 List<MenuDTO> menuSales(String users_id) throws SQLException;
	 
	 List<OrdersDTO> menuSalesByMonth(String users_id, int menu_code) throws SQLException;
	 
}
