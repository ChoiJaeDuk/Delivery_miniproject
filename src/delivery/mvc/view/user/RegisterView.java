package delivery.mvc.view.user;

import java.util.Scanner;

public class RegisterView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * ȸ������ ���
	 */
	
	public static void register() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("                              [ ȸ������ ]                          ");
		System.out.println("--------------------------------------------------------------------");
		System.out.print("* * * ���̵� �Է����ּ���. >> ");
		String usersId = sc.nextLine();

		System.out.print("* * * ��й�ȣ�� �Է����ּ���. >> ");
		String usersPwd = sc.nextLine();
		
		System.out.print("* * * �̸��� �Է����ּ���. >> ");
		String usersName = sc.nextLine();
		
		System.out.print("* * * �г����� �Է����ּ���. >> ");
		String usersNic = sc.nextLine();
		
		System.out.print("* * * �ּҸ� �Է����ּ���. >> ");
		String usersAddr = sc.nextLine();
		
		System.out.print("* * * ��ȭ��ȣ�� �Է����ּ���. >> ");
		String usersPhone = sc.nextLine();
		
		System.out.print("* * * �ֹε�Ϲ�ȣ�� �Է����ּ���. >> ");
		String usersJumin = sc.nextLine();




		// ��Ʈ�ѷ� ȣ���ϱ�
	}
}
