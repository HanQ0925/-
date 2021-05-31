package Textview;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import control.CHwewonDeungrok;
import control.CLogin;
import control.CPassword;
import valueObject.OHwewon;
import valueObject.OLogin;
import valueObject.OPassword;

public class VLogin {
	
	
	private Scanner scanner;
	private CLogin cLogin;
	   
	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.cLogin = new CLogin();
   }

	   public  OHwewon show(){
	      System.out.println("���̵�� ��й�ȣ�� �Է� �ϼ���.");
	      OLogin oLogin = new OLogin();
	      
	      System.out.print("���̵� :");
	      String id = scanner.next();
	      oLogin.setId(id);
	      
	      System.out.print("��й�ȣ :");
	      String password = scanner.next();
	      oLogin.setPassword(password);

//	      CPassword.CLoginpw(password);
	      
	      OHwewon oHwewon = this.cLogin.validate(oLogin);
	      if (oHwewon != null) {
	    	  return oHwewon;
	      }
	      else {
	    	  System.out.print("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
	    	  return null;
	      }
	      
}
}
