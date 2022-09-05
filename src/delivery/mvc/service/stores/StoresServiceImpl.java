package delivery.mvc.service.stores;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.StoresDTO;

public class StoresServiceImpl implements StoresService {
	private StoresDAO storeDAO = new StoresDAOImpl();

	@Override
	public List<StoresDTO> storesInfoSelectAll() throws SQLException {
		List<StoresDTO> list = storeDAO.storesInfoSelectAll();
		
		if(list.size() == 0 || list.isEmpty())
			throw new SQLException("가게 정보가 없습니다.");
		
		return list;
	}

	@Override
	public List<StoresDTO> storesSelectAll() throws SQLException {
		List<StoresDTO> list = storeDAO.storesSelectAll();
		if(list.size() == 0)
			throw new SQLException("가게 정보가 없습니다.");
		
		return list;
	}

	@Override
	public StoresDTO storeSelcetByCode(int store_code) throws SQLException {
		StoresDTO storesDTO = storeDAO.storeSelcetByCode(store_code);
		if(storesDTO == null)
			throw new SQLException(store_code + "에 해당하는 가게가 없습니다.");
		
		return storesDTO;
	}

	@Override
	public StoresDTO storeSelectById(String user_id) throws SQLException {
		StoresDTO storesDTO = storeDAO.storeSelectById(user_id);
		if(storesDTO == null)
			throw new SQLException(user_id + "에 해당하는 가게 정보가 없습니다.");
		
		return storesDTO;
	}

	@Override
	public List<StoresDTO> storesSelectByMenu(String menu_name) throws SQLException {
		List<StoresDTO> list = storesSelectByMenu(menu_name);
		if(list.size() == 0)
			throw new SQLException(menu_name + "에 해당하는 가게 정보가 없습니다.");
	
		return list;
	}

	@Override
	public List<StoresDTO> storesSelectByCategory(int category_code) throws SQLException {

		List<StoresDTO> list = storesSelectByCategory(category_code);
		if(list.size() == 0)
			throw new SQLException(category_code + "에 해당하는 가게 정보가 없습니다.");
	
		return list;
	}

	@Override
	public void storeInsert(StoresDTO storesDTO) throws SQLException {
		int result = storeDAO.storeInsert(storesDTO);
		if(result == 0)
			throw new SQLException("가게 등록하지 못했습니다.");

	}

	@Override
	public void storeUpdate(StoresDTO storesDTO) throws SQLException {
		int result = storeDAO.storeUpdate(storesDTO);
		if(result == 0)
			throw new SQLException("가게정보를 수정하지 못했습니다.");


	}

	@Override
	public void storeStatusUpdate(StoresDTO storesDTO) throws SQLException {
		int result = storeDAO.storeStatusUpdate(storesDTO);
		if(result == 0)
			throw new SQLException("가게오픈설정을 실패했습니다.");

	}

	@Override
	public void storeRegis(StoresDTO storesDTO) throws SQLException {
		int result = storeDAO.storeRegis(storesDTO);
		if(result == 0)
			throw new SQLException("가게 등록 신청 업데이트를 못했습니다.");

	}

	@Override
	public List<StoresDTO> storesSales() throws SQLException {
		List<StoresDTO> list = storesSales();
		if(list.size() == 0)
			throw new SQLException("가게 매출정보가 없습니다.");
	
		return list;
	}

}
