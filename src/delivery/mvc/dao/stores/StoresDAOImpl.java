package delivery.mvc.dao.stores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery.mvc.dto.StoresDTO;
import delivery.mvc.util.DbUtil;

public class StoresDAOImpl implements StoresDAO {

	@Override //후기/별점, 주문건 컬럼 조인필요
	public List<StoresDTO> storesSelectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
		String sql = "select * from stores";
		
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

	@Override //가게 상세정보 조인필요 카테고리 부분 
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

	@Override
	public List<StoresDTO> storeSelectById(String users_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
		String sql = "select * from stores where users_id = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, users_id);
			
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

	@Override // 조인해결필요 메뉴 이름
	public List<StoresDTO> storesSelectByMenu(String menu_name) throws SQLException{
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
		String store_name = null;
		String sql = "select * from stores join menu on stores.store_code = menu.store_code where menu_name like ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+menu_name+"%");
			
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

	@Override
	public List<StoresDTO> storesSelectByCategory(int category_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<StoresDTO> list = new ArrayList<StoresDTO>();
		String sql = "select * from stores where category_code = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, category_code);
			
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

	@Override
	public int storeInsert(StoresDTO storesDTO) throws SQLException {
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

	@Override
	public int storeUpdate(StoresDTO storesDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update stores set (stores_name = ?, store_addr = ?, store_phone = ?, store_detail = ?) \r\n"
				+ "	 * where user_id = ?";
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

	@Override //db에는 close = 0, open = 1 레이아웃 open = 1, close = 2
	/*public int storeStatus(StoresDTO storesDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update stores set store_status = ? where user_id = ?";
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1,storesDTO.getStore_status());
			ps.setString(2, storesDTO.getUser_id());
			
			result = ps.executeUpdate();
				
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}*/
	
	public int storeStatus(int no, String user_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = null;
		
		if(no ==1) {
			sql = "update stores set store_status = 1 where users_id = ?";
		}else {
			sql = "update stores set store_status = 0 where users_id = ?";
		}
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user_id);
			
			result = ps.executeUpdate();
				
		}finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int storeRegis(int no, int store_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		if(no == 1) {
			sql = "update stores set store_regis_status = '승인', store_approval_date = sysdate where store_code = ? and store_regis_status = '대기' and store_approval_date is null";
		}else {
			sql = "update stores set store_regis_status = '반려' where store_code = ? and store_regis_status = '대기' and store_approval_date is null";
		}
		
			try {
				con = DbUtil.getConnection();
				ps = con.prepareStatement(sql);
			
				ps.setInt(1, store_code);
					
				result = ps.executeUpdate();
				
			}finally {
				DbUtil.dbClose(con, ps);
			}
			
			
		return result;
	}
	
	public static void main(String[] args)  {
		StoresDAOImpl dao = new StoresDAOImpl();
	
		try{
			
			//StoresDTO store = dao.storeSelcetByCode(1);
			//System.out.println(store);
			
			
			//int result = dao.storeRegis(1,4);
			//System.out.println(result);
			int result = dao.storeStatus(1, "testid3");
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}


}
