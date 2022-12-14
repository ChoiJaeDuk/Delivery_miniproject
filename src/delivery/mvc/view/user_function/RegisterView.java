package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.UsersController;
import delivery.mvc.dto.UsersDTO;

public class RegisterView {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * 회원가입 기능
	 */

	public static void register() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                              [ 회원가입 ]                          ");
		System.out.println("--------------------------------------------------------------------");
		System.out.print("* * * 아이디를 입력해주세요. >> "); //중복확인!
		String usersId = sc.nextLine();	

		System.out.print("* * * 비밀번호를 입력해주세요. >> ");
		String usersPwd = sc.nextLine();

		System.out.print("* * * 이름을 입력해주세요. >> ");
		String usersName = sc.nextLine();

		System.out.print("* * * 닉네임을 입력해주세요. >> "); //중복확인!!
		String usersNic = sc.nextLine();
		

		System.out.print("* * * 주소를 입력해주세요. >> ");
		String usersAddr = sc.nextLine();

		System.out.print("* * * 전화번호를 입력해주세요. >> ");
		String usersPhone = sc.nextLine();

		System.out.print("* * * 주민등록번호를 입력해주세요. >> "); //중복확인
		String usersJumin = sc.nextLine();
		
		UsersDTO user = new UsersDTO(usersId, "A", usersPwd, usersName, usersNic, usersAddr, usersPhone, usersJumin);
		UsersController.join(user);
	}
}
