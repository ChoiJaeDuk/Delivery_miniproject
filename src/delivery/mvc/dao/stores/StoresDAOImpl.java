package delivery.mvc.dao.stores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;
import util.DbUtil;

public class StoresDAOImpl implements StoresDAO {
	
	
	/**
	 * 전체 가게 전체 정보 조회
	 * */
	@Override 
	public List<StoresDTO> storesInfoSelectAll(String arrange) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
		String sql = "select * from stores " + arrange;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {

				StoresDTO stores = new StoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
												rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), 
												rs.getString(11), rs.getString(12), rs.getString(13));
				list.add(stores);
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
			
		}
		
		return list;
		
	}
	
	/**
	 * 전체 가게 후기, 주문건 수 조회
	 * */
	
	@Override
	public List<StoresDTO> storesSelectAll(String arrange) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
	
		StoresDTO stores = null;
		
		String sql = "SELECT S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, "
				+ "COUNT(DISTINCT R.REVIEW_DETAIL) AS REVIEW_COUNT, NVL(AVG(R.STAR_GRADE),0) AS STAR_AVG , COUNT(DISTINCT O.ORDER_CODE) AS ORDER_COUNT\r\n"
				+ "FROM STORES S LEFT OUTER JOIN REVIEW R ON S.STORE_CODE = R.STORE_CODE \r\n"
				+ "LEFT OUTER JOIN ORDERS O ON S.STORE_CODE = O.STORE_CODE where s.store_regis_status = '승인' and s.store_status = 1  \r\n"
				+ "GROUP BY S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE " + arrange;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);				

			rs = ps.executeQuery();
				
			while(rs.next()) {
				
				stores = new StoresDTO(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));				
				list.add(stores);
				
			}
			
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
		
	}

	/**
	 * 가게코드에 해당하는 가게 전체 정보 조회
	 * */
	
	@Override
	public StoresDTO storeSelcetByCode(int store_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StoresDTO store = null;
	
		String sql = "select * from stores where store_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, store_code);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				store = new StoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), 
						rs.getString(11), rs.getString(12), rs.getString(13));
			
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return store;
	
	}
	
	
	/**
	 * 회원아이디에 해당하는 가게 전체 정보 조회
	 * */
	
	@Override 
	public StoresDTO storeSelectById(String user_id) throws SQLException {//RETURN STORESDTO 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StoresDTO stores = new StoresDTO();
		String sql = "select * from stores where users_id = ?";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				stores = new StoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9), rs.getInt(10), 
						rs.getString(11), rs.getString(12), rs.getString(13));
				
			}
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		
		return stores;
	}
	
	/**
	 * 메뉴이름에 해당하는 가게 정보, 후기, 주문건 수 조회(정렬포함)
	 * */
	
	@Override
	public List<StoresDTO> storesSelectByMenu(String arrange, String menu_name) throws SQLException{
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
		List<MenuDTO> menuList = new ArrayList<MenuDTO>();
		StoresDTO stores = null;
 		String store_name = null;
		String sql = "SELECT S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, COUNT(DISTINCT R.REVIEW_CODE) AS REVIEW_COUNT , NVL(AVG(R.STAR_GRADE),0) AS STAR_AVG , COUNT(DISTINCT O.ORDER_CODE) AS ORDER_COUNT \r\n"
				+ "FROM STORES S LEFT OUTER JOIN REVIEW R ON S.STORE_CODE = R.STORE_CODE \r\n"
				+ "LEFT OUTER JOIN ORDERS O ON S.STORE_CODE = O.STORE_CODE where s.store_regis_status = '승인' and s.store_status = 1 \r\n"
				+ "GROUP BY S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE\r\n" 
				+ "HAVING S.STORE_CODE = ?" + arrange;
		
		try {
			con = DbUtil.getConnection();
			menuList = this.storeCodeSelectByMenu(con, menu_name);
		
			for(MenuDTO m: menuList) {
				ps = con.prepareStatement(sql);
				ps.setInt(1, m.getStore_code());
				rs = ps.executeQuery();
				
				while(rs.next()) {
					stores = new StoresDTO(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));				
					list.add(stores);
				}
			}
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
	
	
	private List<MenuDTO> storeCodeSelectByMenu(Connection con , String menu_name) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MenuDTO> menuList = new ArrayList<MenuDTO>();
		String sql = "SELECT DISTINCT STORE_CODE FROM MENU WHERE MENU_NAME LIKE ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+menu_name+"%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				MenuDTO menu = new MenuDTO(rs.getInt(1));
				menuList.add(menu);
			}
			
		}finally {
			DbUtil.dbClose(null, ps, rs);
		}
		return menuList;
	}
	
	/**
	 * 카테고리코드에 해당하는 가게 정보, 후기, 주문건 수 조회(정렬포함)
	 * */

	@Override //조인 
	public List<StoresDTO> storesSelectByCategory(String arrange, int category_code) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
	
		StoresDTO stores = null;
 		
		String sql = "SELECT S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, COUNT(DISTINCT R.REVIEW_CODE) AS REVIEW_COUNT , NVL(AVG(R.STAR_GRADE),0) AS STAR_AVG , COUNT(DISTINCT O.ORDER_CODE) AS ORDER_COUNT \r\n"
				+ "FROM STORES S LEFT OUTER JOIN REVIEW R ON S.STORE_CODE = R.STORE_CODE \r\n"
				+ "LEFT OUTER JOIN ORDERS O ON S.STORE_CODE = O.STORE_CODE join menu m\r\n"
				+ "on m.store_code = s.store_code\r\n where s.store_regis_status = '승인' and s.store_status = 1"
				+ "GROUP BY S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, m.CATEGORY_CODE\r\n"
				+ "HAVING m.CATEGORY_CODE = ?" + arrange;
		
		try {
			
			con = DbUtil.getConnection();
	
			ps = con.prepareStatement(sql);
			ps.setInt(1, category_code);
				
			rs = ps.executeQuery();
				
			while(rs.next()) {
					
				stores = new StoresDTO(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));				
				list.add(stores);
				
			}
			
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	

	/**
	 * 가게 등록 신청 
	 * */
	
	@Override
	public int storeInsert(StoresDTO storesDTO) throws SQLException {//(String user_id, StoresDTO storeDTO)
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into stores values(store_code_seq.nextval,?,?,?,?,?,?,?,?,default,sysdate,default,null)";
		int result = 0;
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, storesDTO.getUser_id());
			ps.setString(2, storesDTO.getStore_name());
			ps.setString(3, storesDTO.getStore_addr());
			ps.setString(4, storesDTO.getStore_phone());
			ps.setString(5, storesDTO.getStore_business_no());
			ps.setInt(6, storesDTO.getCategory_code());
			ps.setString(7, storesDTO.getStore_detail());
			ps.setInt(8, storesDTO.getStore_delivery_fee());
			
			result = ps.executeUpdate();
				
		}finally {
			
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	/**
	 * 가게 정보 수정 
	 * */
	
	@Override
	public int storeUpdate(StoresDTO storesDTO) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update stores set store_name = ?, store_addr = ?, store_phone = ?, store_detail = ? where users_id = ?";
		int result = 0;
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1,storesDTO.getStore_name());
			ps.setString(2, storesDTO.getStore_addr());
			ps.setString(3, storesDTO.getStore_phone());
			ps.setString(4, storesDTO.getStore_detail());
			ps.setString(5, storesDTO.getUser_id());
			
			result = ps.executeUpdate();
				
		}finally {
			
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	/**
	 * 판매자의 가게 오픈 설정 변경
	 * */
	
	@Override 
	public int storeStatusUpdate(int store_status, String user_id) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update stores set store_status = ? where users_id = ?";
		int result = 0;
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1,store_status);
			ps.setString(2, user_id);
			
			result = ps.executeUpdate();
			
		}finally {
			
			DbUtil.dbClose(con, ps);
		}
		return result;
	}
	
	/**
	 * 운영자의 가게 신청 승인, 반려
	 * */
	
	@Override
	public int storeRegis(StoresDTO storesDTO) throws SQLException { 
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		if(storesDTO.getStore_regis_status().equals("승인")) {
			sql = "update stores set store_regis_status = ?, store_approval_date = sysdate where store_code = ? and store_regis_status = '대기' and store_approval_date is null";
		}else if(storesDTO.getStore_regis_status().equals("반려")){
			sql = "update stores set store_regis_status = ? where store_code = ? and store_regis_status = '대기' and store_approval_date is null";
		}
		
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
			
				ps.setString(1, storesDTO.getStore_regis_status());
				ps.setInt(2, storesDTO.getStore_code());
				
				System.out.println(storesDTO.getStore_regis_status());
				
				if(storesDTO.getStore_regis_status().equals("승인")) {
					int result2 = jobUpdate(con, storesDTO.getUser_id());
					System.out.println(result2);
				}
					
				result = ps.executeUpdate();
				
			}finally {
				DbUtil.dbClose(con, ps);
			}
			
		return result;
	}
	
	private int jobUpdate(Connection con, String user_id) throws SQLException{
	
		PreparedStatement ps = null;
		String sql = "update users set job_code = 'B' where user_id = ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user_id);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(null, ps);
		}
		
		return result;
}
	
	/**
	 * 가게별 매출 현황 조회 
	 * */
	@Override
	public List<StoresDTO> storesSales() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
		String sql = "SELECT stores.STORE_CODE, STORE_NAME, NVL(SUM(ORDER_TOTAL_PRICE),0) AS TOTAL_SALES,\r\n"
				+ "NVL((SUM(ORDER_TOTAL_PRICE)),0)-NVL((SUM(ORDER_TOTAL_PRICE)*0.03),0) AS TOTAL_SALES_FOR_STORES,\r\n"
				+ "(SUM(ORDER_TOTAL_PRICE)*0.03) AS TOTAL_SALES_FOR_MASTER\r\n"
				+ "FROM  (SELECT * FROM ORDERS WHERE DELIVERY_CODE = 1) ORDERS right join stores\r\n"
				+ "on orders.store_code = stores.store_code\r\n"
				+ "GROUP BY stores.STORE_CODE, store_name\r\n"
				+ "order by stores.STORE_CODE";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				StoresDTO stores = new StoresDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
				list.add(stores);
				
			}
			
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	/**
	 * 가게코드에 해당하는 가게의 월별 세부매출 조회
	 * */
	
	@Override
	public List<OrdersDTO> storeSalesByMonth(int store_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrdersDTO> list = new ArrayList<OrdersDTO>();

		String sql = "SELECT to_char(order_date, 'MM')||'월' as 구분, NVL(SUM(ORDER_TOTAL_PRICE),0) AS TOTAL_SALES,SUM(ORDER_TOTAL_PRICE)*0.03 AS TOTAL_SALES_FOR_MASTER, (SUM(ORDER_TOTAL_PRICE))-(SUM(ORDER_TOTAL_PRICE)*0.03) AS TOTAL_SALES_FOR_STORES\r\n"
				+ "		FROM ORDERS \r\n"
				+ "		GROUP BY store_code, to_char(order_date,'MM'),  DELIVERY_CODE\n"
				+ "		HAVING STORE_CODE = ? AND DELIVERY_CODE = 1\r\n"
				+ "		order by 구분";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, store_code);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				OrdersDTO orders = new OrdersDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				list.add(orders);
				
			}
			
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	/**
	 * 회원아이디에 해당하는 가게의 메뉴당 매출 조회
	 * */
	
	@Override
	public List<MenuDTO> menuSales(String users_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		String sql = "SELECT menu.menu_code, menu.menu_name, SUM(ORDER_LINE.ORDER_QUANTITY*MENU.MENU_PRICE) AS TOTAL_PROFIT\r\n"
				+ "FROM  MENU left JOIN ORDER_LINE ON ORDER_LINE.MENU_CODE = MENU.MENU_CODE \r\n"
				+ "join stores on menu.store_code = stores.store_code\r\n"
				+ "GROUP BY menu.menu_code, menu.menu_name, users_id, delivery_code\r\n"
				+ "HAVING users_id = ? AND DELIVERY_CODE = 1";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, users_id);
	
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				MenuDTO menu = new MenuDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(menu);
				
			}
			
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	/**
	 * 회원아이디와 메뉴코드에 해당하는 메뉴의 월별 세부 매출 조회
	 * */
	
	@Override
	public List<OrdersDTO> menuSalesByMonth(String users_id, int menu_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OrdersDTO> list = new ArrayList<OrdersDTO>();
		String sql = "SELECT TO_CHAR(ORDERS.ORDER_DATE,'MM') as 월, SUM(ORDER_LINE.ORDER_QUANTITY*MENU.MENU_PRICE) AS TOTAL_PROFIT\r\n"
				+ "		FROM ORDERS JOIN MENU ON ORDERS.STORE_CODE = MENU.STORE_CODE\r\n"
				+ "		JOIN ORDER_LINE ON ORDER_LINE.MENU_CODE = MENU.MENU_CODE join stores on stores.store_code = menu.store_code\r\n"
				+ "		GROUP BY MENU.MENU_CODE, stores.users_id, to_char(orders.order_date,'MM'), orders.delivery_code\r\n"
				+ "		HAVING stores.users_id = ? and menu.menu_code = ? AND DELIVERY_CODE = 1\r\n"
				+ "		order by 월";
		
		try {
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, users_id);
			ps.setInt(2, menu_code);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				OrdersDTO orders = new OrdersDTO(rs.getString(1), rs.getInt(2));
				list.add(orders);
				
			}
			
		}finally {
			
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
}
