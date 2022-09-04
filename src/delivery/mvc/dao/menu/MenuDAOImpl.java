package delivery.mvc.dao.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.BascketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.util.DBUtil;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<MenuDTO> menuSelectAll(int store_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		String sql = "select * from menu where store_code = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, store_code);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new MenuDTO(
						rs.getInt(1),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7),
						rs.getInt(2),
						rs.getInt(3)));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int menuInsert(MenuDTO menu) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		String sql = "insert into menu values(menu_code_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, menu.getCategory_code());
			ps.setInt(2, menu.getStore_code());
			ps.setString(3, menu.getMenu_name());
			ps.setInt(4, menu.getMenu_price());
			ps.setInt(5, menu.getSoldout_status());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int menuUpdate(int menu_code, int price, int status) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		String sql = "update menu set menu_price=?, soldout_status=? where menu_code=?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, price);
			ps.setInt(2, status);
			ps.setInt(3, menu_code);
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int menuDelete(int menu_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps =null;
		String sql = "delete from menu where menu_code=?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, menu_code);
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

}
