package delivery.mvc.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import delivery.mvc.controller.BasketController;
import delivery.mvc.controller.MenuController;
import delivery.mvc.dao.stores.StoresDAO;
import delivery.mvc.dao.stores.StoresDAOImpl;
import delivery.mvc.dto.BasketDTO;
import delivery.mvc.dto.MenuDTO;
import delivery.mvc.dto.StoresDTO;

public class StartView {

	public static void main(String[] args) {
		MenuView.menu();
	}
}
