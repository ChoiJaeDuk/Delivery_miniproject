package delivery.mvc.view.user;

import java.util.Scanner;
import delivery.mvc.view.actor.UsersView;

public class mypageView {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 *  ����������
	 */
	public static void mypage() {
		while(true) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
			System.out.println("                            [ ���������� ]                            ");
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1.�������� ����   2.�ֹ�����   3.�ı�   4.�Ǹ��� ��û�ϱ�   5.�ڷΰ���");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("* * * ��ȣ�� �Է����ּ���. >> ");
			
			int mypage = Integer.parseInt(sc.nextLine());
		
			switch (mypage) {
				case 1:
					//�������� ����
				case 2:
					//�ֹ�����
				case 3:
					//�ı�
				case 4:
					//�Ǹ��� ��û�ϱ�
				case 5:					
					UsersView.users(); //�ڷΰ���
					return;
				
				//�� �� ��ȣ �Է� �� �����޼���		
					
			}//switch��	
		}//while��
	}
}
