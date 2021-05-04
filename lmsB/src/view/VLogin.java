package view;

import java.util.Scanner;

import control.CHwewonDeungrok;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {
	
	
	private Scanner scanner;
	private CLogin cLogin;
	   
	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.cLogin = new CLogin();
   }

	   public void show() {
	      System.out.println("���̵�� ��й�ȣ�� �Է� �ϼ���.:");
	      OLogin oLogin = new OLogin();
	      
	      System.out.print("���̵� :");
	      String id = scanner.next();
	      oLogin.setId(id);
	      
	      System.out.print("��й�ȣ :");
	      String password = scanner.next();
	      oLogin.setPassword(password);
	      
	      OHwewon oHwewon = this.cLogin.validate(oLogin);
	      if (oHwewon != null) {
	    	  System.out.print(oHwewon.getName()+"�� �ȳ��ϼ���");
	      }
	      else {
	    	  System.out.print("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
	      }
	      
}
}
