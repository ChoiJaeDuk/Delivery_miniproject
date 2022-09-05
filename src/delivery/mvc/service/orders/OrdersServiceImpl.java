package delivery.mvc.service.orders;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dao.orders.OrdersDAO;
import delivery.mvc.dao.orders.OrdersDAOImpl;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;

public class OrdersServiceImpl implements OrdersService {
	OrdersDAO ordersDao = new OrdersDAOImpl();
	@Override
	public void orderInsert(OrdersDTO orders) throws SQLException {
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
	public void cancelOrder(int order_code) throws SQLException {
		int result = ordersDao.cancelOrder(order_code);
		if(result == 0 ) throw new SQLException("주문하기 실패");
	}

}
