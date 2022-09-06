package delivery.mvc.view.store_function;

import java.util.Scanner;

import delivery.mvc.view.MenuView;
import delivery.mvc.view.actor.StoreView;

public class MypageForStoreView {
	private static Scanner sc = new Scanner(System.in);
	
	
	//public static void main(String[] args) {
	//	MypageForStoreView.mypageForStore();
	//	}
	
	
	public static void mypageForStore(String userid){
		while(true) {
			MypageForStoreView.printMenu();
			int menu=Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1 :
				updateStoreInfo();//�Ǹ��� ��������
				//storeDetail();
				return;
				
			case 2 : 
				StoreView.printMenuForStores(userid);//�ڷΰ���
				return;
				
			default:
				System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
				mypageForStore(userid);
				break;	
			}

		}
	}
	
	//��� �������� �ƴҶ� ���� �޼ҵ� ¥�ߵǴ���
	
	public static void updateStoreInfo() {
		System.out.println("* * * ��й�ȣ��  �Է����ּ���. >>  ");
		String pwd = sc.nextLine();
		System.out.println("* * * ������ ���� �̸��� �Է����ּ��� >> ");
		String newName = sc.nextLine();
		System.out.println("* * * ������ ���� �ּҸ� �Է����ּ��� >> ");
		String newAddr = sc.nextLine();
		System.out.println("* * * ������ ���� ��ȭ��ȣ��  �Է����ּ��� >> ");
		String newPhone = sc.nextLine();
		System.out.println("* * * ������ ���� �Ұ��� �Է����ּ���(�ִ� 30 ��) >> ");
		String info = sc.nextLine();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("              1. �����ϱ�              2. ���                  ");
		System.out.println("---------------------------------------------------------------------");
		
		
		while(true) {
			int menu=Integer.parseInt(sc.nextLine()) ;
			switch(menu) {
				case 1:
					update();//�����ϱ�
					printMenu();
					break;
				case 2:
					printMenu(); //�ڷΰ���
					break;
					
				default:
					System.out.println("* * * ��ȣ�� �߸� �Է��ϼ̽��ϴ�.\n\n");
					updateStoreInfo();
					break;	
					
					//��Ʈ�ѷ��� pwd������ �´��� Ȯ��
			}
		}
	}
	
	/**
	 * 1-1 �����ϱ�
	 * */
	public static void update() {
		System.out.println( " ���� �����ϴ°� db�� ����");
	}
	
	
	
	
	public static void printMenu() {
		storeDetail();
		System.out.println("                1. �Ǹ��� ���� ����                  2. �ڷΰ���                  ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("* * * ��ȣ�� �Է����ּ���. >>  ");;
			
		}
	
	
	public static void storeDetail() {
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                              xxxx�����Դϴ�.                                    ");
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("                                   �� �� �� �� �� ��                             ");
		System.out.println("----------------------------------------------------------------------------------");
	}
}
	
	
