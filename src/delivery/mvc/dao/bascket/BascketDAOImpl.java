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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bascketUpdate(BascketDTO bascket, int num) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bascketDelete(String menu_code) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) throws SQLException {
		BascketDAOImpl a = new BascketDAOImpl();
		a.bascketSelectAll("testid");
	}

}
