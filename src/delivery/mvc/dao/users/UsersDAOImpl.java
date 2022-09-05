package delivery.mvc.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import delivery.mvc.dto.Delivery_StatusDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrderLineDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.dto.UsersDTO;
import util.DbUtil;

public class UsersDAOImpl implements UsersDAO {
	private Properties proFile = DbUtil.getProFile();

	@Override
	public UsersDTO usersLogin(String user_id, String user_pwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsersDTO usersDTO = null;
		
		String sql = "SELECT USER_NAME FROM USERS WHERE USER_ID = ? AND USER_PWD = ?"; 
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user_id);
			ps.setString(2, user_pwd);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				usersDTO = new UsersDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}

		
		return usersDTO;
	}

	@Override //??????????????@@@@@@@@@@@@@@@@@@@@@
	public void usersLogout() throws SQLException {
	    UsersDTO user = null;
	    System.out.println("로그아웃되었습니다.");

	}

	@Override//중복체크?
	public int join(UsersDTO usersDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "insert into users values(?,?,?,?,?,?,?,?,sysdate)"; 
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, usersDTO.getUsers_id());
			ps.setString(2, usersDTO.getJob_code());
			ps.setString(3, usersDTO.getUsers_pwd());
			ps.setString(4, usersDTO.getUsers_name());
			ps.setString(5, usersDTO.getUsers_nick());
			ps.setString(6, usersDTO.getUsers_addr());
			ps.setString(7, usersDTO.getUsers_phone());
			ps.setString(8, usersDTO.getUsers_jumin());
			
			
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		
		
		return result;
	}

	@Override // return String 
	public String searchId(String user_name, String user_jumin) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsersDTO usersDTO = null;
		String result = null;
		
		String sql = "SELECT USER_ID FROM USERS WHERE USER_NAME = ? AND USER_JUMIN =?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user_name);
			ps.setString(2, user_jumin);
			
			rs=ps.executeQuery();
			if (rs.next()) { //이것도 인수로 아이디 주민을 받는 생성자 따로 만들어야?
				/*usersDTO = new UsersDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));*/
				result = rs.getString(1);
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		
		return result;
	}

	@Override
	public int searchPwd(String user_id, String user_name, String user_jumin, String newpwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		UsersDTO usersDTO = null;
		int result =0;
		
		String sql = "UPDATE USERS SET USER_PWD = ? WHERE USER_ID = ? AND USER_NAME = ? AND USER_JUMIN = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, newpwd);
			ps.setString(2, user_id);
			ps.setString(3, user_name);
			ps.setString(4, user_jumin);
			
			result = ps.executeUpdate();
			
					
//			rs = ps.executeQuery();
//			if (rs.next()) { //이것도 인수로 아이디, 이름, 주민 을 받는 생성자 따로 만들어야?
//				usersDTO = new UsersDTO(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
//						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
//			}
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		
		return result;
	}

	@Override
	public int nickUpdate(String oldNick, String newNick) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "update users set user_nick=? where user_nick=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, newNick);
			ps.setString(2, oldNick);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	
	@Override
	public int addrUpdate(String oldAddr, String newAddr) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "update users set user_addr=? where user_addr=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, newAddr);
			ps.setString(2, oldAddr);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int phoneUpdate(String oldPhone, String newPhone) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "update users set user_phone=? where user_phone=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, newPhone);
			ps.setString(2, oldPhone);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int pwdUpdate(String oldPwd, String newPwd) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "update users set user_pwd=? where user_pwd=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, newPwd);
			ps.setString(2, oldPwd);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}
	

	@Override
	public List<OrdersDTO> selectOrderList(String user_id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<OrdersDTO> listO = new ArrayList<OrdersDTO>();
		
		Delivery_StatusDTO status = null;
		OrdersDTO order = null;
		
		String sql = "SELECT ORDER_CODE, ORDER_DATE, ORDER_TOTAL_PRICE, DELIVERY_STATUS,ORDER_DELIVERY_TIME "
				+ "FROM ORDERS O JOIN DELIVERY_STATUS D "
				+ "ON O.DELIVERY_CODE = D.DELIVERY_CODE "
				+ "WHERE O.USER_ID = ?";		
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, user_id);
			
			rs =ps.executeQuery();
			while(rs.next()) {
				status = new Delivery_StatusDTO(rs.getString(4));
				order = new OrdersDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), status, rs.getString(5));
				
				listO.add(order);								
			}			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}		
		
		return listO;
	}
	

	@Override
	public List<OrderLineDTO> selectDelivery_time(int order_code) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = null;
		List<OrderLineDTO> listOL = new ArrayList<OrderLineDTO>();
		
		StoresDTO store = null;
		MenuDTO menu = null;
		OrderLineDTO ol = null;
		
		String sql = "SELECT O.ORDER_LINE_CODE , S.STORE_NAME, M.MENU_NAME , O.ORDER_QUANTITY, M.MENU_PRICE "
				+ "FROM ORDER_LINE O, MENU M, STORES S "
				+ "WHERE O.MENU_CODE = M.MENU_CODE AND S.STORE_CODE = M.STORE_CODE "
				+ "AND O.ORDER_CODE = ?";		
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, order_code);
			
			rs =ps.executeQuery();
			while(rs.next()) {
				store = new StoresDTO(rs.getString(2));
				menu = new MenuDTO(rs.getString(3),rs.getInt(5));
				ol = new OrderLineDTO(rs.getInt(1), rs.getInt(4), menu, store);
				listOL.add(ol);								
			}			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}		
		
		return listOL;
	}

	@Override // 환불은 주문코드로하는 것이 맞을거 같습니다.
	public int cancelOrder(int order_code) throws SQLException {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE ORDERS SET DELIVERY_CODE = 3 WHERE ORDER_CODE = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, order_code);
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(con, ps);
		}

		
		return result;
	}

	
	
	
	
	public static void main(String[] args) {
		UsersDAO user = new UsersDAOImpl();
		try {

/*
			String id = user.searchId("테스트", "000000-0000000");
			System.out.println(id);
*/			
/*			
			List<OrderLineDTO> oll = user.selectDelivery_time(1);
			for(OrderLineDTO list : oll) {
				System.out.println(list.getOrder_line_code()+ "  " +  list.getStore().getStore_name() + "  " + list.getMenu().getMenu_name() + "  " + list.getOrder_quntity() + "  " + list.getMenu().getMenu_price() );
			}
*/			
/*			
			List<OrdersDTO> order = user.selectOrderList("testid");
			for(OrdersDTO list : order) {
				System.out.println(list.getOrder_code()+ "  " +  list.getOrder_date() + "  " + list.getOrder_total_price()+ "  " + list.getDelivery_code() + "  " + list.getOrder_delivery_time() );
			}
*/	
/*			
			int result = user.join(new UsersDTO("jj", "A", "asd123", "김이박최", "김나박이", "서울경기인천", "010-4554-8822", "111111-2222222","2022-09-05"));
			if(result == 1) System.out.println("로그인");
			else System.out.println("실패");
*/
/*			
			int result = user.searchPwd("jj", "김이박최", "111111-2222222", "asd111");
			if(result == 1) System.out.println("변경");
			else System.out.println("실패");
*/
			int result = user.addrUpdate("서울경기인천", "서울대구대전부산");
			if(result == 1) System.out.println("주소변경");
			else System.out.println("실패");
			
			System.out.println("끝");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}



}
