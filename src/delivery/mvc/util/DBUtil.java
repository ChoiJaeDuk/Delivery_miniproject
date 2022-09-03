package delivery.mvc.util;
/**
 * DB������ ���� �ε�, ���� ,�ݱ�
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
	 * �ε� : �����Ϸ��� DBMS�� ���� (DB lib�� �ʿ��ϴ�)
	 * 			�̶� "" �ȿ����� ��ҹ��� �����Ѵ�
	 */
	// �����ڿ� �ۼ��ص� ������
	static {
		try {
			//2���� �ܺ� ~.properties���� �ε�
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
	 * ����
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
	 * �ݱ� : ���� ��ü�� �ݱ� : select �� ��� / DML or DDL �� ���
	 * ~ != null �� ������ �Ŵ� ���� null�� ��� nullpointException�� �߻��� �����Ϸ��� �ϴ� ���̴�
	 */
	//select �� ���
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//DML or DDL	�� ���
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}