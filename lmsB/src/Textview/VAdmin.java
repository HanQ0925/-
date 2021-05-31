package Textview;

import java.util.Scanner;

import control.CAdmin;
import valueObject.OHwewon;

public class VAdmin {
	
	private Scanner scanner;
	private CAdmin cAdmin;
	
	public VAdmin(Scanner scanner) {
		this.scanner = scanner;
		this.cAdmin = new CAdmin();
	}

	
	public void show(OHwewon oHwewon) {
		System.out.println("ȸ�����(1) ȸ������(2) ȸ������ ����(3)");
		int choice = this.scanner.nextInt();
		if(choice==1) {
			cAdmin.selectHwewon();
		}else if (choice==2) {
			cAdmin.deleteHwewon();
		}else if (choice==3) {
			cAdmin.changeHwewon();
		}
	}
}
