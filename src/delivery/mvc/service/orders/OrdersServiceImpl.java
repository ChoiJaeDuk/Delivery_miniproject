package delivery.mvc.service.orders;
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.basket.BasketDAO;
import delivery.mvc.dao.basket.BasketDAOImpl;
import delivery.mvc.dao.orders.OrdersDAO;
import delivery.mvc.dao.orders.OrdersDAOImpl;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;

public class OrdersServiceImpl implements OrdersService {
	OrdersDAO ordersDao = new OrdersDAOImpl();
	BasketDAO basketDao = new BasketDAOImpl();
	@Override
	public void orderInsert(String user_id) throws SQLException {
		int menuCode = 0;
		int basket_total_price = 0;
		List<MenuDTO> menuList = basketDao.basketMenuSelect(user_id);
		System.out.println(basket_total_price);
		for(MenuDTO menu : menuList) {
			menuCode = menu.getMenu_code();
			basket_total_price += menu.getTotal_price();	
		}

		int storeCode = ordersDao.selectStoreCodeByMenuCode(menuCode, user_id);
		
		OrdersDTO orders = new OrdersDTO(user_id, storeCode, basket_total_price);		
		
		
		int result = ordersDao.orderInsert(orders);
		if(result == 0 ) throw new SQLException("주문하기 실패");
	
	}
	
	@Override
	public List<OrdersDTO> selectOrderList(int store_code) throws SQLException {
		List<OrdersDTO> list = ordersDao.selectOrderList(store_code);
		if(list == null || list.size() == 0)throw new SQLException("주문 내역이 없습니다.");
		return list;
	}

	@Override
	public void approveOrder(OrdersDTO orders, int delivery_time) throws SQLException {
		int result = ordersDao.approveOrder(orders, delivery_time);
		if(result == 0) throw new SQLException("주문하기 실패");	
	}

	@Override
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException {
		List<MenuDTO> list = ordersDao.selectOrderLine(order_code);
		if(list == null || list.size() == 0)throw new SQLException("주문 상세내역이 없습니다.");
		return list;
		
	}

	@Override
	public void orderStatusUpdate(int order_code, int order_status_code) throws SQLException {
		int result = ordersDao.orderStatusUpdate(order_code, order_status_code);
		if(result == 0 ) throw new SQLException("주문하기 실패");
	}

}
