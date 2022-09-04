package delivery.mvc.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
	private static Properties proFile = new Properties();

	/**
	 *  로드 : 연결하려는 DBMS를 선택( DB lib가 필요하다. )
	 * */
	static {
		try {
			proFile.load(new FileInputStream("resources/db.properties"));
			//proFile.load(new FileInputStream("resources/board.properties"));
			
			//System.out.println(proFile.get("driverName"));
			//System.out.println(proFile.get("board.selectBySubject"));
			
			Class.forName(proFile.getProperty("driverName"));
	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	
	
	/**
	 *  연결 : 
	 * */
	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(
				proFile.getProperty("url"),
				proFile.getProperty("userName"),
				proFile.getProperty("userPass"));
				
		return con;
	}

	/**
	 *  닫기 - 사용된 객체 닫기 - select인 경우
	 * */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try{
			if(rs != null) rs.close();
			dbClose(con, st);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 *  닫기 - 사용된 객체 닫기 - DML or DDL 인 경우
	 * */
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st != null) st.close();
			if(con != null) con.close();
	
	}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("***메인시작****");
			Connection con = DbUtil.getConnection();
			System.out.println("con = " + con);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
