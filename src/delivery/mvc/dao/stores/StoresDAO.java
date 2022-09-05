package delivery.mvc.dao.stores;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;

public interface StoresDAO {
	/**
	 * 가게정보 전체검색
	 * select * from stores;(join?)
	 * */
	List<StoresDTO> storesInfoSelectAll() throws SQLException;
	
	/**
	 * 가게목록(별점,후기,주문건) 전체검색
	 * */
	List<StoresDTO> storesSelectAll() throws SQLException;
	
	/**
	 * 가게코드로 가게 검색
	 * */
	StoresDTO storeSelcetByCode(int store_code) throws SQLException;
	
	/**
	 * 회원아이디에 해당하는 가게 검색
	 * select * from stores where user_id = ?;
	 * */
	StoresDTO storeSelectById(String user_id) throws SQLException;
	
	/**
	 * 리턴받은 store_code로 메뉴 조회
	 * select * from stores where menu_name = %?%;
	 * */
	List<StoresDTO> storesSelectByMenu(String menu_name) throws SQLException;

	
	/**
	 * 메뉴이름을 검색해 해당 store_code 리턴 
	 * */
	List<MenuDTO> storeCodeSelectByMenu(Connection con, String menu_name) throws SQLException;
	
	
	/**
	 * 카테고리에 해당하는 가게 검색
	 * select * from 
	 * */
	List<StoresDTO> storesSelectByCategory(int category_code) throws SQLException;
	
	/**
	 * 가게 등록하기
	 * INSERT INTO STORES VALUES(STORE_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,DEFAULT,SYSDATE,DEFAULT,NULL);
	 * */
	//int storeStatus(StoresDTO storesDTO) throws SQLException;
	int storeInsert(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * 가게 정보 수정하기
	 * update stores set (stores_name = ?, store_addr = ?, store_phone = ?, store_detail = ?) 
	 * where user_id = ?;
	 * */
	int storeUpdate(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * 가게 오픈 설정
	 * update stores set store_status = ? where user_id = ?
	 * */
	int storeStatusUpdate(StoresDTO storesDTO) throws SQLException;
	
	/**
	 * 가게신청 승인,거부
	 * update stores set () where store_name = ?
	 * 
	 * UPDATE STORES SET STORE_REGIS_STATUS = '승인', STORE_APPROVAL_DATE = SYSDATE
	   WHERE STORE_CODE = ?  AND STORE_REGIS_STATUS = '대기' AND STORE_APPROVAL_DATE IS NULL;
	 * */
	int storeRegis(StoresDTO storesDTO) throws SQLException;

	/**
	 * 가게매출현황조회 -10p
	 * SELECT stores.STORE_CODE, STORE_NAME, SUM(ORDER_TOTAL_PRICE) AS TOTAL_SALES,
		(SUM(ORDER_TOTAL_PRICE))-(SUM(ORDER_TOTAL_PRICE)*0.03) AS TOTAL_SALES_FOR_STORES,
		(SUM(ORDER_TOTAL_PRICE)*0.03) AS TOTAL_SALES_FOR_MASTER
		FROM ORDERS join stores 
		on orders.store_code = stores.store_code
		GROUP BY stores.STORE_CODE, store_name ;
	 * 
	 * */
	
	List<StoresDTO> storesSales() throws SQLException;
	
	/**
	 * 가게별 메뉴당 매출조회
	 * SELECT MENU.MENU_CODE, MENU.MENU_NAME, SUM(ORDER_LINE.ORDER_QUANTITY*MENU.MENU_PRICE) AS MENU_TOTAL_SALES
		FROM ORDERS RIGHT OUTER JOIN MENU ON ORDERS.STORE_CODE = MENU.STORE_CODE
		LEFT OUTER JOIN ORDER_LINE ON ORDER_LINE.MENU_CODE = MENU.MENU_CODE
		GROUP BY MENU.MENU_CODE, MENU.MENU_NAME, ORDERS.STORE_CODE
		HAVING ORDERS.STORE_CODE = ?;
	 * */
	
	/***/

}
	


