package delivery.mvc.dao.basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;
import util.DbUtil;

public class BasketDAOImpl implements BasketDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public List<BasketDTO> basketSelectAll(String user_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BasketDTO> list = new ArrayList<BasketDTO>();
		String sql_bascket = "Select * from bascket where user_id=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql_bascket);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BasketDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5)));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	/**
	 * 이게 장바구니 검색인듯
	 */
	@Override
	public List<MenuDTO> basketMenuSelect(String users_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BasketDTO bascket = null;
		MenuDTO menuDTO = null;
		StoresDTO storeDTO = null;
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		String sql_bascket = "SELECT B.MENU_CODE, S.STORE_NAME, M.MENU_NAME, B.BASKET_QUANTITY, M.MENU_PRICE,SUM(M.MENU_PRICE*B.BASKET_QUANTITY)\r\n"
				+ "FROM BASCKET B JOIN MENU M ON B.MENU_CODE = M.MENU_CODE\r\n"
				+ "JOIN STORES S ON S.STORE_CODE = M.STORE_CODE\r\n"
				+ "GROUP BY B.MENU_CODE, S.STORE_NAME, M.MENU_NAME, B.BASKET_QUANTITY, B.USER_ID, M.MENU_PRICE\r\n"
				+ "HAVING B.USER_ID = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql_bascket);
			ps.setString(1, users_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				//public MenuDTO(int menu_code, StoresDTO store, String name, BasketDTO basket , int menu_price, int total_price) {
				bascket = new BasketDTO(rs.getInt(4));
				storeDTO = new StoresDTO(rs.getString(2));
		    	menuDTO = new MenuDTO(rs.getInt(1), storeDTO, rs.getNString(3), bascket, rs.getInt(5), rs.getInt(6));
		    	list.add(menuDTO);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int basketInsert(BasketDTO basket) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into bascket values(bascket_code_seq.nextval, ?, ?, ?, sysdate)";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, basket.getUser_id());
			ps.setInt(2, basket.getMenu_code());
			ps.setInt(3, basket.getBasket_quantity());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int basketUpdate(BasketDTO basket, int num) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update bascket set basket_quantity = ? where menu_code = ? and user_id =?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, basket.getMenu_code());
			ps.setString(3, basket.getUser_id());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int  basketDelete(int menu_code, String user_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql_delete = "delete from bascket where menu_code = ? and user_id =?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql_delete);
			ps.setInt(1, menu_code);
			ps.setString(2, user_id);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	/**
	 * 장바구니 결제하기
	 */
	@Override
	public int basketDelete(Connection con, OrdersDTO orders) throws SQLException {
		PreparedStatement ps = null;
		String sql_delete = "delete from bascket where user_id =?";
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql_delete);
			ps.setString(1, orders.getUser_id());
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(null, ps);
		}
		return result;
	}
}
