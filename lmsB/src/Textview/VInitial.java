package Textview;

import java.io.IOException;
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

import control.CId;
import control.CPassword;
import valueObject.OHwewon;

public class VInitial {
   
   private Scanner scanner;
   private VHwewonDeungrok hwewonDeungrok;
   private VLogin login;
   private VAdmin vadmin;
   private VSugangsincheon vSugangsincheon;
   private VMyiWeb vMyiWeb;
   
   public VInitial(Scanner scanner) {
      this.scanner = scanner;
      this.hwewonDeungrok = new VHwewonDeungrok(scanner);
      this.login = new VLogin(scanner);
      this.vadmin = new VAdmin(scanner);
      this.vMyiWeb = new VMyiWeb(scanner);
   }

   public void show() {
	   while(true) {
      System.out.println("���� ����� ���� �ϼ���");
      System.out.println("�α���(1), ȸ�����(2), IDã��(3) ,��й�ȣ ã��(4)");
         int input = this.scanner.nextInt();
         if (input == 1) {
            OHwewon oHwewon = this.login.show();
            if(oHwewon != null) {
            	if(oHwewon.getId().equals("admin")){
            		//�����ڷ� ����
            		System.out.println(oHwewon.getName()+"");
            		vadmin.show(oHwewon);
            		continue;
            	}else {
            	      System.out.println("������û ȭ��(1), MyiWwb(2), ��й�ȣ ����(3) ,�α׾ƿ�(4)");
            	      int choice = this.scanner.nextInt();
            	      if(choice == 1) {
                  		//�л� ������û ����
            	        this.vSugangsincheon = new VSugangsincheon(this.scanner);
                		this.vSugangsincheon.show(oHwewon);
                		continue;
            	      }else if(choice==2) {
            	    	  //MyiWeb
            	    	  this.vMyiWeb.show(oHwewon);
            	    	  continue;
            	      }else if(choice==3) {
            	    	  CPassword.Pwchange(oHwewon);
            	    	  continue;
            	      }else if(choice==4) {
            	    	  continue;
            	      }


            	}
            }
         } 
         else if (input == 2) {
            this.hwewonDeungrok.show();
         } else if (input==3) {
             System.out.println("�̸��� �Է����ּ���.");
        	 String name = this.scanner.next();
        	 System.out.println("��ȭ��ȣ�� �Է����ּ���.");
        	 String Phone = this.scanner.next();
        	 System.out.println("IDã��");
        	 CId.Idsearch(name, Phone);
        	 continue;
         }else if (input==4) {
             System.out.println("���̵� �Է����ּ���.");
        	 String id = this.scanner.next();
        	 System.out.println("�̸��� �Է����ּ���.");
        	 String name = this.scanner.next();
        	 System.out.println("��ȭ��ȣ�� �Է����ּ���.");
        	 String phone = this.scanner.next();
        	 System.out.println("��й�ȣ ã��");
        	 CPassword.PwSearch(id, name, phone);
        	 continue;
         }
   }
   }

}