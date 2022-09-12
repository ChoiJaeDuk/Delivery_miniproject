package delivery.mvc.service.stores;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;

public interface StoresService {
	/**
	 * 정렬에 따른 전제 가게 정보 조회
	 * */
	 List<StoresDTO> storesInfoSelectAll(String arrange) throws SQLException;
	 
	 /**
	  * 정렬에 따른 전제 가게의 후기, 주문 건 수 조회
	  * */
	 List<StoresDTO> storesSelectAll(String arrange) throws SQLException;
	 
	 /**
	  * 가게코드에 해당하는 가게 조회
	  * */
	 StoresDTO storeSelcetByCode(int store_code) throws SQLException;
	 
	 /**
	  * 회원아이디(자신의 가게)에 해당하는 가게 정보 조회
	  * */
	 StoresDTO storeSelectById(String user_id) throws SQLException;
	 
	 /**
	  * 메뉴 이름에 해당하는 가게 조회(정렬 포함)
	  * */
	 List<StoresDTO> storesSelectByMenu(String arrange, String menu_name) throws SQLException;
	
	 /**
	  * 카테고리 코드에 해당하는 가게 조회(정렬 포함)
	  * */
	 List<StoresDTO> storesSelectByCategory(String arrange, int category_code) throws SQLException;
	 
	 /**
	  * 가게 신청 정보 입력
	  * */
	 void storeInsert(StoresDTO storesDTO) throws SQLException;
	
	 /**
	  * 가게 정보 수정
	  * */
	 void storeUpdate(StoresDTO storesDTO) throws SQLException;
	 
	 /**
	  * 가게 오픈 상황 설정
	  * */
	 void storeStatusUpdate(int store_status, String user_id) throws SQLException;
	 
	 /**
	  * 운영자의 가게 신청 승인, 반려
	  * */
	 void storeRegis(StoresDTO storesDTO) throws SQLException;
	 
	 /**
	  * 전체 가게의 매출 정보 조회
	  * */
	 List<StoresDTO> storesSales() throws SQLException;
	 
	 /**
	  * 가게당 월별 매출 조회
	  * */
	 List<OrdersDTO> storesSalesByMonth(int store_code) throws SQLException;
	 
	 /**
	  * 한 가게의 메뉴당 매출 조회
	  * */
	 List<MenuDTO> menuSales(String users_id) throws SQLException;
	 
	 /**
	  * 한 가게의 메뉴당 월별 매출 조회
	  * */
	 List<OrdersDTO> menuSalesByMonth(String users_id, int menu_code) throws SQLException;
	 
}
