package delivery.mvc.dao.bascket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import delivery.mvc.dto.BascketDTO;
import delivery.mvc.util.DBUtil;

public class BascketDAOImpl implements BascketDAO {
	private Properties proFile = DBUtil.getProFile();
	
	@Override
	public List<BascketDTO> bascketSelectAll(String users_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BascketDTO> list = new ArrayList<BascketDTO>();
		String sql = "select * from bascket where user_id = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, users_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BascketDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5)));
			}
		} finally {
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int bascketInsert(BascketDTO bascket) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into bascket values(bascket_code_seq.nextval, ?, ?, ?, sysdate)";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bascket.getUser_id());
			ps.setInt(2, bascket.getMenu_code());
			ps.setInt(3, bascket.getBasket_quantity());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int bascketUpdate(BascketDTO bascket, int num) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update bascket set basket_quantity = ? where menu_code = ? and user_id =?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, bascket.getMenu_code());
			ps.setString(3, bascket.getUser_id());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int bascketDelete(BascketDTO bascket) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from bascket where menu_code = ? and user_id =?";
		int result = 0;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bascket.getMenu_code());
			ps.setString(2, bascket.getUser_id());
			result = ps.executeUpdate();
		} finally {
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
}
