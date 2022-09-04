package delivery.mvc.dao.stores;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.StoresDTO;

public interface StoresDAO {
	/**
	 * 가게목록 전체검색
	 * select * from stores;(join?)
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
	List<StoresDTO> storeSelectById(String user_id) throws SQLException;
	
	/**
	 * 메뉴이름에 해당하는 가게 검색
	 * select * from stores where menu_name = %?%;
	 * */
	List<StoresDTO> storesSelectByMenu(String menu_name) throws SQLException;

	
	/**
	 * 카테고리에 해당하는 가게 검색
	 * select * from 
	 * */
	List<StoresDTO> storesSelectByCategory(int category_code) throws SQLException;
	
	/**
	 * 가게 등록하기
	 * INSERT INTO STORES VALUES(STORE_CODE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,DEFAULT,SYSDATE,DEFAULT,NULL);
	 * */
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
	//int storeStatus(StoresDTO storesDTO) throws SQLException;
	int storeStatus(int no, String user_id) throws SQLException;
	
	/**
	 * 가게신청 승인,거부
	 * update stores set () where store_name = ?
	 * 
	 * UPDATE STORES SET STORE_REGIS_STATUS = '승인', STORE_APPROVAL_DATE = SYSDATE
	   WHERE STORE_CODE = ?  AND STORE_REGIS_STATUS = '대기' AND STORE_APPROVAL_DATE IS NULL;
	 * */
	int storeRegis(int no, int store_code) throws SQLException;
	

	
}
