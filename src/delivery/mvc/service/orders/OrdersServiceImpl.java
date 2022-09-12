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
	 * 주문내역에 값을 다른메소드에서 가져와 저장후 OrdersDTO객체를 생성해 DAO의 orderInsert에 인수로 넣어준다.
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
		if(result == 0 ) throw new SQLException("주문하기 실패");
	}
	
	
	/**
	 * 주문상세내역을 등록하는 메소드
	 * */
	@Override
	public List<OrdersDTO> selectOrderList(String userid) throws SQLException {
		int store_code = storeDao.storeSelectById(userid).getStore_code();
		List<OrdersDTO> list = ordersDao.selectOrderList(store_code);
		if(list == null || list.size() == 0)throw new SQLException("주문 내역이 없습니다.");
		return list;
	}

	/**
	 * 판매자가 배달 승인,거부를 선택하면 Orders테이블의 delivery_code와 승인시간(SYSDATE), 예상배송대기시간 업데이트 한다.
	 * */
	@Override
	public void approveOrder(OrdersDTO orders, int delivery_time) throws SQLException {
		int result = ordersDao.approveOrder(orders, delivery_time);
		if(result == 0) throw new SQLException("주문하기 실패");	
	}

	/**
	 *  order_code를 받아 해당되는 주문코드의 주문 상세를 조회한다.
	 * */
	@Override
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException {
		List<MenuDTO> list = ordersDao.selectOrderLine(order_code);
		if(list == null || list.size() == 0)throw new SQLException("주문 상세내역이 없습니다.");
		return list;
		
	}

	/**
	 * 판매자가 배달시작, 완료를 입력하면 주문내역의 delivery_code가 업데이트 된다.
	 * */
	@Override
	public void orderStatusUpdate(int order_code, int order_status_code) throws SQLException {
		int result = ordersDao.orderStatusUpdate(order_code, order_status_code);
		if(result == 0 ) throw new SQLException("주문하기 실패");
	}

}
