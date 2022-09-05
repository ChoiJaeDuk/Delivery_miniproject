package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.view.MenuView;
import delivery.mvc.view.actor.StoreView;

public class MypageForStoreView {
	private static Scanner sc = new Scanner(System.in);
	
	
	//public static void main(String[] args) {
	//	MypageForStoreView.mypageForStore();
	//	}
	
	
	public static void mypageForStore(){
		while(true) {
			MypageForStoreView.printMenu();
			int menu=Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1 :
				updateStoreInfo();//판매자 정보수정
				//storeDetail();
				return;
				
			case 2 : 
				StoreView.printMenuForStores();//뒤로가기
				return;
			}

		}
	}
	
	//비번 맞을때랑 아닐때 따로 메소드 짜야되는지
	
	public static void updateStoreInfo() {
		System.out.println("* * * 비밀번호를  입력해주세요. >>  ");
		String pwd = sc.nextLine();
		System.out.println("* * * 수정할 가게 이름을 입력해주세요 >> ");
		String newName = sc.nextLine();
		System.out.println("* * * 수정할 가게 주소를 입력해주세요 >> ");
		String newAddr = sc.nextLine();
		System.out.println("* * * 수정할 가게 전화번호를  입력해주세요 >> ");
		String newPhone = sc.nextLine();
		System.out.println("* * * 간단한 가게 소개를 입력해주세요(최대 30 자) >> ");
		String info = sc.nextLine();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("              1. 수정하기              2. 뒤로가기                  ");
		System.out.println("---------------------------------------------------------------------");
		
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					update();//t수정하기
					printMenu();
					return;
				case 2:
					printMenu(); //뒤로가기
					return;
					
					//컨트롤러로 pwd보내서 맞는지 확인
			}
		}
	}
	
	/**
	 * 1-1 승인하기
	 * */
	public static void update() {
		System.out.println( " 정보 수정하는거 db랑 이음");
	}
	
	
	
	
	public static void printMenu() {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                              xxxx가게입니다.                                    ");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                                   정 보 불 러 오 기                             ");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("                1. 판매자 정보 수정                  2. 뒤로가기                   ");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("* * * 번호를 입력해주세요. >>  ");
		}
	
	
	public static void storeDetail() {
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              xxxx가게입니다.                                    ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                                   정 보 불 러 오 기                             ");
		System.out.println("----------------------------------------------------------------------------------");
	}
}
	
	
