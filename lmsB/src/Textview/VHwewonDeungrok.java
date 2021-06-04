package Textview;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import control.CHwewonDeungrok;
import control.CId;
import valueObject.OHwewon;

public class VHwewonDeungrok {
   
   private Scanner scanner;
   private CHwewonDeungrok cHwewonDeungrok;
   
   public VHwewonDeungrok(Scanner scanner) {
      this.scanner = scanner;
      this.cHwewonDeungrok = new CHwewonDeungrok();
   }

   public void show(){
      System.out.println("ȸ�������� �Է��ϼ���:");
      OHwewon oHwewon = new OHwewon();
      
      System.out.print("���̵�: ");
      String id = scanner.next();
      while(true) {
    	  if(CId.Idcheck(id)==true) {
    		  break;
          }else {
        	  System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
        	  id = scanner.next();
        	  continue;
          }

      }
      oHwewon.setId(id);
      
      System.out.print("��й�ȣ: ");
      String password = scanner.next();
      while(true) {
	      if(password.length()<4) {
	    	  System.out.println("��й�ȣ�� 4�ڸ� �̻� �Է��ؾ��մϴ�.");
	    	  password = scanner.next();;
	      }else {
	    	  break;
	      	}
	      }
      oHwewon.setPassword(password);
      
      System.out.print("�̸�: ");
      String name = scanner.next();
      oHwewon.setName(name);
      
      System.out.print("�ּ�: ");
      String address = scanner.next();
      oHwewon.setAddress(address);
      
      System.out.print("�а�: ");
      String hwakgwa = scanner.next();
      oHwewon.setHwakgwa(hwakgwa);
      
      System.out.print("��ȭ��ȣ: ");
      String PhoneNum = scanner.next();
      oHwewon.setPhoneNum(PhoneNum);
      // ����� ���� �Է� �޾�
      // oHwewon�� ����
      System.out.print("ȸ������� �Ϸ�Ǿ����ϴ�.");

      try {
          File file_s = new File("user/" + oHwewon.getId() + "_sincheon.txt");
		file_s.createNewFile();
	      File file_b = new File("user/" + oHwewon.getId() + "_bag.txt");
		file_b.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      this.cHwewonDeungrok.saveHwewon(oHwewon);
   }
}