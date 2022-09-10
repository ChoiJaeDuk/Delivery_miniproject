package delivery.mvc.view.user_function;

import java.util.Scanner;

import delivery.mvc.controller.UsersController;
import delivery.mvc.dto.UsersDTO;

public class RegisterView {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * ȸ������ ���
	 */

	public static void register() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                              [ ȸ������ ]                          ");
		System.out.println("--------------------------------------------------------------------");
		System.out.print("* * * ���̵� �Է����ּ���. >> "); //�ߺ�Ȯ��!
		String usersId = sc.nextLine();	

		System.out.print("* * * ��й�ȣ�� �Է����ּ���. >> ");
		String usersPwd = sc.nextLine();

		System.out.print("* * * �̸��� �Է����ּ���. >> ");
		String usersName = sc.nextLine();

		System.out.print("* * * �г����� �Է����ּ���. >> "); //�ߺ�Ȯ��!!
		String usersNic = sc.nextLine();
		

		System.out.print("* * * �ּҸ� �Է����ּ���. >> ");
		String usersAddr = sc.nextLine();

		System.out.print("* * * ��ȭ��ȣ�� �Է����ּ���. >> ");
		String usersPhone = sc.nextLine();

		System.out.print("* * * �ֹε�Ϲ�ȣ�� �Է����ּ���. >> "); //�ߺ�Ȯ��
		String usersJumin = sc.nextLine();
		
		UsersDTO user = new UsersDTO(usersId, "A", usersPwd, usersName, usersNic, usersAddr, usersPhone, usersJumin);
		UsersController.join(user);
	}
}
