package delivery.mvc.util;
/**
 * DB연동을 위한 로드, 연결 ,닫기
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties proFile = new Properties();
	
	/**
	 * 로드 : 연결하려는 DBMS를 선택 (DB lib가 필요하다)
	 * 			이때 "" 안에서는 대소문자 구분한다
	 */
	// 생성자에 작성해도 괜찮다
	static {
		try {
			//2개의 외부 ~.properties파일 로딩
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			Class.forName(proFile.getProperty("driverName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProFile() {
		return proFile;
	}

	/**
	 * 연결
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
				proFile.getProperty("url"),
				proFile.getProperty("userName"),
				proFile.getProperty("userPass"));
		return con;
	}

	/**
	 * 닫기 : 사용된 객체를 닫기 : select 인 경우 / DML or DDL 인 경우
	 * ~ != null 의 조건을 거는 경우는 null일 경우 nullpointException이 발생을 방지하려고 하는 것이다
	 */
	//select 인 경우
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//DML or DDL	인 경우
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}