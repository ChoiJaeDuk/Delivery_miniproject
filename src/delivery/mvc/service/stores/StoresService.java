package delivery.mvc.service.stores;

import java.sql.SQLException;
import java.util.List;

import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.OrdersDTO;
import delivery.mvc.dto.StoresDTO;

public interface StoresService {
	/**
	 * ���Ŀ� ���� ���� ���� ���� ��ȸ
	 * */
	 List<StoresDTO> storesInfoSelectAll(String arrange) throws SQLException;
	 
	 /**
	  * ���Ŀ� ���� ���� ������ �ı�, �ֹ� �� �� ��ȸ
	  * */
	 List<StoresDTO> storesSelectAll(String arrange) throws SQLException;
	 
	 /**
	  * �����ڵ忡 �ش��ϴ� ���� ��ȸ
	  * */
	 StoresDTO storeSelcetByCode(int store_code) throws SQLException;
	 
	 /**
	  * ȸ�����̵�(�ڽ��� ����)�� �ش��ϴ� ���� ���� ��ȸ
	  * */
	 StoresDTO storeSelectById(String user_id) throws SQLException;
	 
	 /**
	  * �޴� �̸��� �ش��ϴ� ���� ��ȸ(���� ����)
	  * */
	 List<StoresDTO> storesSelectByMenu(String arrange, String menu_name) throws SQLException;
	
	 /**
	  * ī�װ� �ڵ忡 �ش��ϴ� ���� ��ȸ(���� ����)
	  * */
	 List<StoresDTO> storesSelectByCategory(String arrange, int category_code) throws SQLException;
	 
	 /**
	  * ���� ��û ���� �Է�
	  * */
	 void storeInsert(StoresDTO storesDTO) throws SQLException;
	
	 /**
	  * ���� ���� ����
	  * */
	 void storeUpdate(StoresDTO storesDTO) throws SQLException;
	 
	 /**
	  * ���� ���� ��Ȳ ����
	  * */
	 void storeStatusUpdate(int store_status, String user_id) throws SQLException;
	 
	 /**
	  * ����� ���� ��û ����, �ݷ�
	  * */
	 void storeRegis(StoresDTO storesDTO) throws SQLException;
	 
	 /**
	  * ��ü ������ ���� ���� ��ȸ
	  * */
	 List<StoresDTO> storesSales() throws SQLException;
	 
	 /**
	  * ���Դ� ���� ���� ��ȸ
	  * */
	 List<OrdersDTO> storesSalesByMonth(int store_code) throws SQLException;
	 
	 /**
	  * �� ������ �޴��� ���� ��ȸ
	  * */
	 List<MenuDTO> menuSales(String users_id) throws SQLException;
	 
	 /**
	  * �� ������ �޴��� ���� ���� ��ȸ
	  * */
	 List<OrdersDTO> menuSalesByMonth(String users_id, int menu_code) throws SQLException;
	 
}
