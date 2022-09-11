package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.controller.StoresController;
import delivery.mvc.controller.UsersController;
import delivery.mvc.dto.StoresDTO;
import delivery.mvc.view.MenuView;
import delivery.mvc.view.actor.StoreView;
import delivery.mvc.view.user_function.MypageView;

public class MypageForStoreView {
	private static Scanner sc = new Scanner(System.in);

	public static void mypageForStore(String users_id){

		while(true) {
			MypageForStoreView.printMenu(users_id);
			int menu=Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1 :
				updateStoreInfo(users_id);//판매자 정보수정
				storeDetail(users_id);
				return;
				
			case 2 : 

				StoreView.printMenuForStores(users_id);//뒤로가기

				return;
				
			default:
				System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");

				mypageForStore(users_id);

				break;	
			}

		}
	}
	
	//비번 맞을때랑 아닐때 따로 메소드 짜야되는지
	
	public static void updateStoreInfo(String users_id) {
		System.out.println("* * * 비밀번호를  입력해주세요. >>  ");
		String pwd = sc.nextLine();
		int result = UsersController.pwdCheck(users_id, pwd);
		if(result==9999) updateStoreInfo(users_id);
		
		System.out.println("* * * 수정할 가게 이름을 입력해주세요 >> ");
		String newName = sc.nextLine();
		System.out.println("* * * 수정할 가게 주소를 입력해주세요 >> ");
		String newAddr = sc.nextLine();
		System.out.println("* * * 수정할 가게 전화번호를  입력해주세요 >> ");
		String newPhone = sc.nextLine();
		System.out.println("* * * 간단한 가게 소개를 입력해주세요(최대 30 자) >> ");
		String info = sc.nextLine();
		StoresDTO stores = new StoresDTO(users_id, newName, newAddr, newPhone ,info);
		System.out.println("---------------------------------------------------------------------");
		System.out.println("              1. 수정하기              2. 취소                  ");
		System.out.println("---------------------------------------------------------------------");
		
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					 update(stores);
			
					printMenu(users_id);
					break;
				case 2:
					StoreView.printMenuForStores(users_id); //뒤로가기
					break;
					
				default:
					System.out.println("* * * 번호를 잘못 입력하셨습니다.\n\n");
					updateStoreInfo(users_id);
					break;	
					
					//컨트롤러로 pwd보내서 맞는지 확인
			}
		}
	}
	
	/**
	 * 1-1 승인하기
	 * */
	public static void update(StoresDTO stores) {
		StoresController.storeUpdate(stores);
	}
	
	
	
	
	public static void printMenu(String users_id) {
		storeDetail(users_id);
		System.out.println("                1. 판매자 정보 수정                  2. 뒤로가기                  ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >>  ");;
			
		}
	
	
	public static void storeDetail(String users_id) {
		
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              "+users_id+"가게입니다.                                    ");	
		System.out.println("----------------------------------------------------------------------------------");
		StoresController.storeSelectById(users_id);                  
		System.out.println("----------------------------------------------------------------------------------");
	}
}
	
	
