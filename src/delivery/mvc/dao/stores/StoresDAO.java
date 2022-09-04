package delivery.mvc.dao.stores;

import java.sql.SQLException;
import java.util.List;

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
	 * �޴��̸��� �ش��ϴ� ���� �˻�
	 * select * from stores where menu_name = %?%;
	 * */
	List<StoresDTO> storesSelectByMenu(String menu_name) throws SQLException;

	
	/**
	 * ī�װ��� �ش��ϴ� ���� �˻�
	 * select * from 
	 * */
	List<StoresDTO> storesSelectByCategory(int category_code) throws SQLException;
	
	/**
	 * ���� ����ϱ�
	 * INSERT INTO STORES VALUES(STORE_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,DEFAULT,SYSDATE,DEFAULT,NULL);
	 * */
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
	//int storeStatus(StoresDTO storesDTO) throws SQLException;
	int storeStatus(int no, String user_id) throws SQLException;
	
	/**
	 * ���Խ�û ����,�ź�
	 * update stores set () where store_name = ?
	 * 
	 * UPDATE STORES SET STORE_REGIS_STATUS = '����', STORE_APPROVAL_DATE = SYSDATE
	   WHERE STORE_CODE = ?  AND STORE_REGIS_STATUS = '���' AND STORE_APPROVAL_DATE IS NULL;
	 * */
	int storeRegis(int no, int store_code) throws SQLException;
	

	
}
