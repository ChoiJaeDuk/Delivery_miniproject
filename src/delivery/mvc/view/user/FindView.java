package delivery.mvc.view.user;

import java.util.Scanner;

import delivery.mvc.view.MenuView;


public class FindView {
	private static Scanner sc = new Scanner(System.in);

	
	public static void find() {
				
		while (true) {
			
			FindView.idPw();
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				FindView.findId(); //아이디 찾기
				FindView.idPw();
				return;
				
			case 2:
				FindView.findPw();// 비밀번호찾기
				FindView.idPw();
				return;
				
			case 3:
				MenuView.printMenu();// 뒤로가기
				
			}
			break;
			
		}//while끝
		
	}
	
	/**
	 *  아이디*비밀번호 찾기 메인
	 */
	
	public static void idPw() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                              [ 아이디 * 비밀번호 찾기 ]            ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1.아이디 찾기    2.비밀번호 찾기     3.뒤로가기");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("* * * 번호를 입력해주세요. >> ");
		
	}
	
	
	/**
	 * 아이디
	 */
	
	public static void findId() {
		System.out.print("* * * 이름을 입력해주세요. >> ");
		String usersName = sc.nextLine();
		
		System.out.print("* * * 주민등록번호를 입력해주세요. >> ");
		String usersJumin = sc.nextLine();
	}
	
	
	
	/**
	 * 비밀번호
	 */
	
	public static void findPw() {
		System.out.print("* * * 아이디를 입력해주세요. >> ");
		String usersId = sc.nextLine();
		
		System.out.print("* * * 이름을 입력해주세요. >> ");
		String usersName = sc.nextLine();
		
		System.out.print("* * * 주민등록번호를 입력해주세요. >> ");
		String usersJumin = sc.nextLine();
	}
}
