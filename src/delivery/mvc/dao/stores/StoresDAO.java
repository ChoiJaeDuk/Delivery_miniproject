package delivery.mvc.dao.stores;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;

public interface StoresDAO {
	/**
	 * ���Ը�� ��ü�˻�
	 * select * from stores;(join?)
	 * */
	List<StoresDTO> storesSelectAll() throws SQLException;
	
	/**
	 * �����ڵ�� ���� �˻�
	 * */
	StoresDTO storeSelcetByCode(int store_code) throws SQLException;
	
	/**
	 * ȸ�����̵� �ش��ϴ� ���� �˻�
	 * select * from stores where user_id = ?;
	 * */
	List<StoresDTO> storeSelectById(String user_id) throws SQLException;
	
	/**
	 * ���Ϲ��� store_code�� �޴� ��ȸ
	 * select * from stores where menu_name = %?%;
	 * */
	List<StoresDTO> storesSelectByMenu(String menu_name) throws SQLException;

	
	/**
	 * �޴��̸��� �˻��� �ش� store_code ���� 
	 * */
	List<MenuDTO> storeCodeSelectByMenu(Connection con, String menu_name) throws SQLException;
	
	
	/**
	 * ī�װ��� �ش��ϴ� ���� �˻�
	 * select * from 
	 * */
	List<StoresDTO> storesSelectByCategory(int category_code) throws SQLException;
	
	/**
	 * ���� ����ϱ�
	 * INSERT INTO STORES VALUES(STORE_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,DEFAULT,SYSDATE,DEFAULT,NULL);
	 * */
	//int storeStatus(StoresDTO storesDTO) throws SQLException;
	int storeInsert(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * ���� ���� �����ϱ�
	 * update stores set (stores_name = ?, store_addr = ?, store_phone = ?, store_detail = ?) 
	 * where user_id = ?;
	 * */
	int storeUpdate(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * ���� ���� ����
	 * update stores set store_status = ? where user_id = ?
	 * */
	int storeStatusUpdate(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * ���Խ�û ����,�ź�
	 * update stores set () where store_name = ?
	 * 
	 * UPDATE STORES SET STORE_REGIS_STATUS = '����', STORE_APPROVAL_DATE = SYSDATE
	   WHERE STORE_CODE = ?  AND STORE_REGIS_STATUS = '���' AND STORE_APPROVAL_DATE IS NULL;
	 * */
	int storeRegis(StoresDTO storesDTO) throws SQLException;

	/**
	 * ���Ը�����Ȳ��ȸ
	 * SELECT MENU.MENU_CODE, MENU.MENU_NAME, SUM(ORDER_LINE.ORDER_QUANTITY*MENU.MENU_PRICE)
		FROM ORDERS JOIN MENU ON ORDERS.STORE_CODE = MENU.STORE_CODE
		JOIN ORDER_LINE ON ORDER_LINE.MENU_CODE = MENU.MENU_CODE
		GROUP BY MENU.MENU_CODE, MENU.MENU_NAME, ORDERS.STORE_CODE
		HAVING ORDERS.STORE_CODE = ?;
	 * 
	 * */
	
	//List<StoresDTO> storesSales(int store_code) throws SQLException;

}
	


