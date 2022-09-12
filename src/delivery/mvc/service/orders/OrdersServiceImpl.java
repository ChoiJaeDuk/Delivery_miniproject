package delivery.mvc.service.orders;
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.basket.BasketDAO;
import delivery.mvc.dao.basket.BasketDAOImpl;
import delivery.mvc.dao.orders.OrdersDAO;
import delivery.mvc.dao.orders.OrdersDAOImpl;
import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dao.users.UsersDAO;
import delivery.mvc.dao.users.UsersDAOImpl;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public class OrdersServiceImpl implements OrdersService {
	OrdersDAO ordersDao = new OrdersDAOImpl();
	BasketDAO basketDao = new BasketDAOImpl();
	UsersDAO usersDao = new UsersDAOImpl();
	StoresDAO storeDao = new StoresDAOImpl();
	
	
	/**
	 * �ֹ������� ���� �ٸ��޼ҵ忡�� ������ ������ OrdersDTO��ü�� ������ DAO�� orderInsert�� �μ��� �־��ش�.
	 * */
	@Override
	public void orderInsert(String user_id) throws SQLException {
		int menuCode = 0;
		int basket_total_price = 0;
		List<MenuDTO> menuList = basketDao.basketMenuSelect(user_id);
	
		for(MenuDTO menu : menuList) {
			menuCode = menu.getMenu_code();
			basket_total_price += menu.getTotal_price();	
		}

		int storeCode = ordersDao.selectStoreCodeByMenuCode(menuCode, user_id);
		
		UsersDTO users = usersDao.selectUserInfoByID(user_id);
		
		OrdersDTO orders = new OrdersDTO(user_id, storeCode, basket_total_price, users.getUsers_addr(),users.getUsers_phone());		
		
		
		int result = ordersDao.orderInsert(orders);
		if(result == 0 ) throw new SQLException("�ֹ��ϱ� ����");
	}
	
	
	/**
	 * �ֹ��󼼳����� ����ϴ� �޼ҵ�
	 * */
	@Override
	public List<OrdersDTO> selectOrderList(String userid) throws SQLException {
		int store_code = storeDao.storeSelectById(userid).getStore_code();
		List<OrdersDTO> list = ordersDao.selectOrderList(store_code);
		if(list == null || list.size() == 0)throw new SQLException("�ֹ� ������ �����ϴ�.");
		return list;
	}

	/**
	 * �Ǹ��ڰ� ��� ����,�źθ� �����ϸ� Orders���̺��� delivery_code�� ���νð�(SYSDATE), �����۴��ð� ������Ʈ �Ѵ�.
	 * */
	@Override
	public void approveOrder(OrdersDTO orders, int delivery_time) throws SQLException {
		int result = ordersDao.approveOrder(orders, delivery_time);
		if(result == 0) throw new SQLException("�ֹ��ϱ� ����");	
	}

	/**
	 *  order_code�� �޾� �ش�Ǵ� �ֹ��ڵ��� �ֹ� �󼼸� ��ȸ�Ѵ�.
	 * */
	@Override
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException {
		List<MenuDTO> list = ordersDao.selectOrderLine(order_code);
		if(list == null || list.size() == 0)throw new SQLException("�ֹ� �󼼳����� �����ϴ�.");
		return list;
		
	}

	/**
	 * �Ǹ��ڰ� ��޽���, �ϷḦ �Է��ϸ� �ֹ������� delivery_code�� ������Ʈ �ȴ�.
	 * */
	@Override
	public void orderStatusUpdate(int order_code, int order_status_code) throws SQLException {
		int result = ordersDao.orderStatusUpdate(order_code, order_status_code);
		if(result == 0 ) throw new SQLException("�ֹ��ϱ� ����");
	}

}
