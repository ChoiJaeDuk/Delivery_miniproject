package delivery.mvc.service.stores;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;

public class StoresServiceImpl implements StoresService {
	private StoresDAO storesDAO = new StoresDAOImpl();

	@Override
	public List<StoresDTO> storesInfoSelectAll() throws SQLException {
		List<StoresDTO> list = storesDAO.storesInfoSelectAll();
		
		if(list.size() == 0 || list.isEmpty())
			throw new SQLException("���� ������ �����ϴ�.");
		
		return list;
	}

	@Override
	public List<StoresDTO> storesSelectAll() throws SQLException {
		List<StoresDTO> list = storesDAO.storesSelectAll();
		if(list.size() == 0)
			throw new SQLException("���� ������ �����ϴ�.");
		
		return list;
	}

	@Override
	public StoresDTO storeSelcetByCode(int store_code) throws SQLException {
		StoresDTO storesDTO = storesDAO.storeSelcetByCode(store_code);
		if(storesDTO == null)
			throw new SQLException(store_code + "�� �ش��ϴ� ���԰� �����ϴ�.");
		
		return storesDTO;
	}

	@Override
	public StoresDTO storeSelectById(String user_id) throws SQLException {
		StoresDTO storesDTO = storesDAO.storeSelectById(user_id);
		if(storesDTO == null)
			throw new SQLException(user_id + "�� �ش��ϴ� ���� ������ �����ϴ�.");
		
		return storesDTO;
	}

	@Override
	public List<StoresDTO> storesSelectByMenu(String menu_name) throws SQLException {
		List<StoresDTO> list = storesDAO.storesSelectByMenu(menu_name);
		if(list.size() == 0)
			throw new SQLException(menu_name + "�� �ش��ϴ� ���� ������ �����ϴ�.");
	
		return list;
	}

	@Override
	public List<StoresDTO> storesSelectByCategory(int category_code) throws SQLException {

		List<StoresDTO> list = storesDAO.storesSelectByCategory(category_code);
		if(list.size() == 0)
			throw new SQLException(category_code + "�� �ش��ϴ� ���� ������ �����ϴ�.");
	
		return list;
	}

	@Override
	public void storeInsert(StoresDTO storesDTO) throws SQLException {
		int result = storesDAO.storeInsert(storesDTO);
		if(result == 0)
			throw new SQLException("���� ������� ���߽��ϴ�.");

	}

	@Override
	public void storeUpdate(StoresDTO storesDTO) throws SQLException {
		int result = storesDAO.storeUpdate(storesDTO);
		if(result == 0)
			throw new SQLException("���������� �������� ���߽��ϴ�.");


	}

	@Override
	public void storeStatusUpdate(int store_status, String user_id) throws SQLException {
		int result = storesDAO.storeStatusUpdate(store_status, user_id);
		if(result == 0)
			throw new SQLException("���Կ��¼����� �����߽��ϴ�.");

	}

	@Override
	public void storeRegis(StoresDTO storesDTO) throws SQLException {
		int result = storesDAO.storeRegis(storesDTO);
		if(result == 0)
			throw new SQLException("���� ��� ��û ������Ʈ�� ���߽��ϴ�.");

	}

	@Override
	public List<StoresDTO> storesSales() throws SQLException {
		List<StoresDTO> list = storesDAO.storesSales();
		if(list.size() == 0)
			throw new SQLException("���� ���������� �����ϴ�.");
	
		return list;
	}
	
	@Override
	public List<OrdersDTO> storesSalesByMonth(int store_code) throws SQLException {
		List<OrdersDTO> list = storesDAO.storeSalesByMonth(store_code);
		if(list.size() == 0)
			throw new SQLException("���� ���� ���������� �����ϴ�.");
	
		return list;
	}


	@Override
	public List<OrdersDTO> menuSalesByMonth(int store_code, int menu_code) throws SQLException {
		List<OrdersDTO> list = menuSalesByMonth(store_code, menu_code);
				
		if(list.size() == 0)
			throw new SQLException(menu_code + "�� �ش��ϴ� ���������� �����ϴ�.");
	
		return list;
		
	}


}
