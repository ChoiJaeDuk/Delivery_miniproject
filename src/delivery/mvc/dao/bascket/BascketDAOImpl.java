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
		String sql_bascket = "SELECT B.MENU_CODE, S.STORE_NAME, M.MENU_NAME, B.BASKET_QUANTITY, SUM(M.MENU_PRICE*B.BASKET_QUANTITY), s.Store_code\r\n"
				+ "FROM BASCKET B JOIN MENU M ON B.MENU_CODE = M.MENU_CODE\r\n"
				+ "JOIN STORES S ON S.STORE_CODE = M.STORE_CODE\r\n"
				+ "GROUP BY B.MENU_CODE, S.STORE_NAME, M.MENU_NAME, B.BASKET_QUANTITY, B.USER_ID, s.store_code\r\n"
				+ "HAVING B.USER_ID = ?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql_bascket);
			ps.setString(1, users_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BascketDTO(
						users_id,
						rs.getInt(1),
						rs.getInt(4),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(5),
						rs.getInt(6)));
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
	public int bascketDelete(List<BascketDTO> list) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql_delete = "delete from bascket where menu_code = ? and user_id =?";
		String sql_insert_1 = "insert into orders values(ORDER_CODE_SEQ.nextval, ?, ?, sysdate, ?, null, null, 1)";
		String sql_insert_2="insert into order_line values(ORDER_LINE_CODE_SEQ.nextval, ORDER_CODE_SEQ.CURRVAL, ?, ?)";
		int result = 0;
		int sum = 0;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			
			for(BascketDTO bb : list) {
				sum =+ bb.getSum_price();
			}
			
			BascketDTO b = list.get(0);
			ps = con.prepareStatement(sql_insert_1);
			ps.setString(1, b.getUser_id());
			ps.setInt(2, b.getStore_code());
			ps.setInt(3, sum);
			result = ps.executeUpdate();
			if(result==0) throw new SQLException("주문 등록 실패");
			ps.close();
			
			for(BascketDTO bascket : list) {
			ps = con.prepareStatement(sql_delete);
			ps.setInt(1, bascket.getMenu_code());
			ps.setString(2, bascket.getUser_id());
			result = ps.executeUpdate();
			if(result==0) throw new SQLException("장바구니 삭제실패");
			ps.close();
			
			ps = con.prepareStatement(sql_insert_2);
			ps.setInt(1, bascket.getMenu_code());
			ps.setInt(2, bascket.getBasket_quantity());
			result = ps.executeUpdate();
			if(result==0) throw new SQLException("주문 상세 등록 실패");
			}
			con.commit();
		} finally {
			con.rollback();
			DBUtil.dbClose(con, ps);
		}
		return result;
	}
}
