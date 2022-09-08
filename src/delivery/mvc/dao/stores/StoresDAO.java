package delivery.mvc.dao.stores;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;

public interface StoresDAO {
	/**
	 * ��ü ���� ��ü ���� ��ȸ
	 * select * from stores order by store_regis_status
	 * */
	List<StoresDTO> storesInfoSelectAll(String arrange) throws SQLException;
	
	/**
	 * ��ü ���� �ı�, �ֹ��� �� ��ȸ
	 * SELECT S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, "
				+ "COUNT(DISTINCT R.REVIEW_DETAIL) AS REVIEW_COUNT, NVL(AVG(R.STAR_GRADE),0) AS STAR_AVG , COUNT(DISTINCT O.ORDER_CODE) AS ORDER_COUNT\r\n"
				+ "FROM STORES S LEFT OUTER JOIN REVIEW R ON S.STORE_CODE = R.STORE_CODE \r\n"
				+ "LEFT OUTER JOIN ORDERS O ON S.STORE_CODE = O.STORE_CODE where s.store_regis_status = '����' and s.store_status = 1  \r\n"
				+ "GROUP BY S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE  + arrange;
	 * */
	List<StoresDTO> storesSelectAll(String arrange) throws SQLException;
	
	/**
	 * �����ڵ忡 �ش��ϴ� ���� ��ü ���� ��ȸ
	 * select * from stores where store_code = ?
	 * */
	StoresDTO storeSelcetByCode(int store_code) throws SQLException;
	
	/**
	 * ȸ�����̵� �ش��ϴ� ���� �˻�
	 * select * from stores where user_id = ?;
	 * */
	StoresDTO storeSelectById(String user_id) throws SQLException;
	
	/**
	 * �޴��̸��� �ش��ϴ� ���� ����, �ı�, �ֹ��� �� ��ȸ(��������)
	 * SELECT S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, COUNT(DISTINCT R.REVIEW_CODE) AS REVIEW_COUNT , NVL(AVG(R.STAR_GRADE),0) AS STAR_AVG , COUNT(DISTINCT O.ORDER_CODE) AS ORDER_COUNT \r\n"
				+ "FROM STORES S LEFT OUTER JOIN REVIEW R ON S.STORE_CODE = R.STORE_CODE \r\n"
				+ "LEFT OUTER JOIN ORDERS O ON S.STORE_CODE = O.STORE_CODE where s.store_regis_status = '����' and s.store_status = 1 \r\n"
				+ "GROUP BY S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE\r\n" 
				+ "HAVING S.STORE_CODE = ? + arrange;
	 * */
	List<StoresDTO> storesSelectByMenu(String arrange, String menu_name) throws SQLException;

	
	
	/**
	 * ī�װ��ڵ忡 �ش��ϴ� ���� ����, �ı�, �ֹ��� �� ��ȸ(��������)
	 * SELECT S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, COUNT(DISTINCT R.REVIEW_CODE) AS REVIEW_COUNT , NVL(AVG(R.STAR_GRADE),0) AS STAR_AVG , COUNT(DISTINCT O.ORDER_CODE) AS ORDER_COUNT \r\n"
				+ "FROM STORES S LEFT OUTER JOIN REVIEW R ON S.STORE_CODE = R.STORE_CODE \r\n"
				+ "LEFT OUTER JOIN ORDERS O ON S.STORE_CODE = O.STORE_CODE join menu m\r\n"
				+ "on m.store_code = s.store_code\r\n where s.store_regis_status = '����' and s.store_status = 1"
				+ "GROUP BY S.STORE_CODE, S.STORE_NAME, S.STORE_DELIVERY_FEE, m.CATEGORY_CODE\r\n"
				+ "HAVING m.CATEGORY_CODE = ? + arrange;
	 * */
	List<StoresDTO> storesSelectByCategory(String arrange, int category_code) throws SQLException;
	
	/**
	 * ���� ��� ��û
	 * insert into stores values(store_code_seq.nextval,?,?,?,?,?,?,?,?,default,sysdate,default,null)
	 * */
	int storeInsert(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * ���� ���� ����
	 * update stores set store_name = ?, store_addr = ?, store_phone = ?, store_detail = ? where users_id = ?; 
	 * */
	int storeUpdate(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * �Ǹ����� ���� ���� ���� ����
	 * update stores set store_status = ? where users_id = ?
	 * */
	int storeStatusUpdate(int store_status, String user_id) throws SQLException;
	
	/**
	 * ����� ���� ��û ����, �ݷ�
	 * */
	int storeRegis(StoresDTO storesDTO) throws SQLException;

	/**
	 * ���Ժ� ���� ��Ȳ ��ȸ 
	 * SELECT stores.STORE_CODE, STORE_NAME, SUM(ORDER_TOTAL_PRICE) AS TOTAL_SALES,\r\n"
				+ "(SUM(ORDER_TOTAL_PRICE))-(SUM(ORDER_TOTAL_PRICE)*0.03) AS TOTAL_SALES_FOR_STORES,\r\n"
				+ "(SUM(ORDER_TOTAL_PRICE)*0.03) AS TOTAL_SALES_FOR_MASTER\r\n"
				+ "FROM ORDERS join stores\r\n"
				+ "on orders.store_code = stores.store_code\r\n"
				+ "GROUP BY stores.STORE_CODE, store_name\r\n"
				+ "order by stores.STORE_CODE;
	 * */
	List<StoresDTO> storesSales() throws SQLException;
	
	/**
	 * �����ڵ忡 �ش��ϴ� ������ ���� ���θ��� ��ȸ
	 * SELECT to_char(order_date, 'MM')||'��' as ����, SUM(ORDER_TOTAL_PRICE) AS TOTAL_SALES,SUM(ORDER_TOTAL_PRICE)*0.03 AS TOTAL_SALES_FOR_MASTER, (SUM(ORDER_TOTAL_PRICE))-(SUM(ORDER_TOTAL_PRICE)*0.03) AS TOTAL_SALES_FOR_STORES\r\n"
				+ "		FROM ORDERS \r\n"
				+ "		GROUP BY store_code, to_char(order_date,'MM')\r\n"
				+ "		HAVING STORE_CODE = ?\r\n"
				+ "		order by ����;
	 * */
	List<OrdersDTO> storeSalesByMonth(int store_code) throws SQLException;
	
	/**
	 * ȸ�����̵� �ش��ϴ� ������ �޴��� ���� ��ȸ
	 * SELECT menu.menu_code, menu.menu_name, SUM(ORDER_LINE.ORDER_QUANTITY*MENU.MENU_PRICE) AS TOTAL_PROFIT\r\n"
				+ "FROM  MENU left JOIN ORDER_LINE ON ORDER_LINE.MENU_CODE = MENU.MENU_CODE \r\n"
				+ "join stores on menu.store_code = stores.store_code\r\n"
				+ "GROUP BY menu.menu_code, menu.menu_name, users_id\r\n"
				+ "HAVING users_id = ?;
	 * */
	List<MenuDTO> menuSales(String users_id) throws SQLException;
	
	/**
	 * ȸ�����̵�� �޴��ڵ忡 �ش��ϴ� �޴��� ���� ���� ���� ��ȸ
	 * SELECT TO_CHAR(ORDERS.ORDER_DATE,'MM') as ��, SUM(ORDER_LINE.ORDER_QUANTITY*MENU.MENU_PRICE) AS TOTAL_PROFIT\r\n"
				+ "		FROM ORDERS JOIN MENU ON ORDERS.STORE_CODE = MENU.STORE_CODE\r\n"
				+ "		JOIN ORDER_LINE ON ORDER_LINE.MENU_CODE = MENU.MENU_CODE join stores on stores.store_code = menu.store_code\r\n"
				+ "		GROUP BY MENU.MENU_CODE, stores.users_id, to_char(orders.order_date,'MM')\r\n"
				+ "		HAVING stores.users_id = ? and menu.menu_code = ?\r\n"
				+ "		order by ��;
	 * */
	
	List<OrdersDTO> menuSalesByMonth(String users_id, int menu_code) throws SQLException;

}
	


