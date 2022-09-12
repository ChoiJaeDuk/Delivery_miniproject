package delivery.mvc.service.stores;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;

public class StoresServiceImpl implements StoresService {
	private StoresDAO storesDAO = new StoresDAOImpl();
	
	/**
	 * 정렬에 따른 전제 가게 정보 조회
	 * */
	@Override
	public List<StoresDTO> storesInfoSelectAll(String arrange) throws SQLException {
		List<StoresDTO> list = storesDAO.storesInfoSelectAll(arrange);
		if(list.size() == 0 || list.isEmpty()) throw new SQLException("가게 정보가 없습니다.");
		return list;
	}

	 /**
	  * 정렬에 따른 전제 가게의 후기, 주문 건 수 조회
	  * */
	@Override
	public List<StoresDTO> storesSelectAll(String arrange) throws SQLException {
		List<StoresDTO> list = storesDAO.storesSelectAll(arrange);
		if(list.size() == 0) throw new SQLException("가게 정보가 없습니다.");
		
		return list;
	}

	/**
	  * 가게코드에 해당하는 가게 조회
	  * */
	@Override
	public StoresDTO storeSelcetByCode(int store_code) throws SQLException {
		StoresDTO storesDTO = storesDAO.storeSelcetByCode(store_code);
		if(storesDTO == null) throw new SQLException(store_code + "에 해당하는 가게가 없습니다.");
		return storesDTO;
	}

	 /**
	  * 회원아이디(자신의 가게)에 해당하는 가게 정보 조회
	  * */
	@Override
	public StoresDTO storeSelectById(String user_id) throws SQLException {
		StoresDTO storesDTO = storesDAO.storeSelectById(user_id);
		if(storesDTO == null) throw new SQLException(user_id + "에 해당하는 가게 정보가 없습니다.");
		return storesDTO;
	}

	 /**
	  * 메뉴 이름에 해당하는 가게 조회(정렬 포함)
	  * */
	@Override
	public List<StoresDTO> storesSelectByMenu(String arrange, String menu_name) throws SQLException {
		List<StoresDTO> list = storesDAO.storesSelectByMenu(arrange, menu_name);
		if(list.size() == 0) throw new SQLException(menu_name + "에 해당하는 가게 정보가 없습니다.");
		return list;
	}

	 /**
	  * 카테고리 코드에 해당하는 가게 조회(정렬 포함)
	  * */
	@Override
	public List<StoresDTO> storesSelectByCategory(String arrange, int category_code) throws SQLException {
		List<StoresDTO> list = storesDAO.storesSelectByCategory(arrange, category_code);
		if(list.size() == 0) throw new SQLException(category_code + "에 해당하는 가게 정보가 없습니다.");
		return list;
	}

	 /**
	  * 가게 신청 정보 입력
	  * */
	@Override
	public void storeInsert(StoresDTO storesDTO) throws SQLException {
		int result = storesDAO.storeInsert(storesDTO);
		if(result == 0) throw new SQLException("가게 등록하지 못했습니다.");
	}

	 /**
	  * 가게 정보 수정
	  * */
	@Override
	public void storeUpdate(StoresDTO storesDTO) throws SQLException {
		int result = storesDAO.storeUpdate(storesDTO);
		if(result == 0) throw new SQLException("가게정보를 수정하지 못했습니다.");
	}

	 /**
	  * 가게 오픈 상황 설정
	  * */
	@Override
	public void storeStatusUpdate(int store_status, String user_id) throws SQLException {
		int result = storesDAO.storeStatusUpdate(store_status, user_id);
		if(result == 0) throw new SQLException("가게오픈설정을 실패했습니다.");
	}

	 /**
	  * 운영자의 가게 신청 승인, 반려
	  * */
	@Override
	public void storeRegis(StoresDTO storesDTO) throws SQLException {
		int result = storesDAO.storeRegis(storesDTO);
		if(result == 0) throw new SQLException("가게 등록 신청 업데이트를 못했습니다.");
	}

	 /**
	  * 전체 가게의 매출 정보 조회
	  * */
	@Override
	public List<StoresDTO> storesSales() throws SQLException {
		List<StoresDTO> list = storesDAO.storesSales();
		if(list.size() == 0) throw new SQLException("가게 매출정보가 없습니다.");
		return list;
	}
	
	 /**
	  * 가게당 월별 매출 조회
	  * */
	@Override
	public List<OrdersDTO> storesSalesByMonth(int store_code) throws SQLException {
		List<OrdersDTO> list = storesDAO.storeSalesByMonth(store_code);
		if(list.size() == 0) throw new SQLException("가게 세부 매출정보가 없습니다.");
		return list;
	}
	
	 /**
	  * 한 가게의 메뉴당 매출 조회
	  * */
	public List<MenuDTO> menuSales(String users_id) throws SQLException{
		List<MenuDTO> list = storesDAO.menuSales(users_id);
		if(list.size() == 0) throw new SQLException("메뉴 매출정보가 없습니다.");
		return list;
	}

	 /**
	  * 한 가게의 메뉴당 월별 매출 조회
	  * */
	@Override
	public List<OrdersDTO> menuSalesByMonth(String users_id, int menu_code) throws SQLException {
		List<OrdersDTO> list = storesDAO.menuSalesByMonth(users_id, menu_code);
		if(list.size() == 0) throw new SQLException(menu_code + "에 해당하는 매출정보가 없습니다.");
		return list;
	}
}
