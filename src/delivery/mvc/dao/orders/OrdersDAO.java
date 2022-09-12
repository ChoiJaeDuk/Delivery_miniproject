package delivery.mvc.dao.orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.UsersDTO;

public interface OrdersDAO {
	List<BasketDTO> bascketDTO = new ArrayList<BasketDTO>(); 
	List<OrdersDTO> ordersList = new ArrayList<OrdersDTO>();
	
	/**
	 * Orders 테이블에 주문내역을 등록한다.
	 * 이 과정에서 OrderLine (주문상세)을 등록하고
	 * basketDelete(장바구니삭제) 해당 userid의 장바구니 비우기를 트랜잭션 처리한다.
	 * @return 값이 0 이면 등록 실패.
	 * */
	public int orderInsert(OrdersDTO orders) throws SQLException;
	
	
	/**
	 * 주문상세내역을 등록하는 메소드
	 * */
	public int[] orderLineInsert(Connection con  , OrdersDTO orders) throws SQLException;
	
	/**
	 * Store_Code를 입력받아 해당되는 주문내역 리스트를 리턴한다.
	 * */
	public List<OrdersDTO> selectOrderList(int store_code) throws SQLException;
	
	
	/**
	 * 판매자가 배달 승인,거부를 선택하면 Orders테이블의 delivery_code와 승인시간(SYSDATE), 예상배송대기시간 업데이트 한다.
	 * */
	public int approveOrder(OrdersDTO orders, int delivery_time) throws SQLException;		
	

	/**
	 *  order_code를 받아 해당되는 주문코드의 주문 상세를 조회한다.
	 * */
	public List<MenuDTO> selectOrderLine(int order_code) throws SQLException;

	/**
	 * 회원이 주문을 환불신청을 하면 주문내역의 delivery_code가 4(취소)상태로 바뀐다.
	 * */
	public int orderStatusUpdate(int order_code, int order_status_code) throws SQLException;
	
	
	/**
	 * menuCode와 user_id를 통해 store_code값을 리턴하는 메소드
	 * */
	public int selectStoreCodeByMenuCode(int menuCode, String user_id) throws SQLException;
	
	
	
}