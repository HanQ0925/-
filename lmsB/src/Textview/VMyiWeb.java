package Textview;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VMyiWeb {

	private Scanner scanner;
	private CLecture cLecture;
	
	public VMyiWeb(Scanner scanner) {
	      this.scanner = scanner;
	      this.cLecture = new CLecture();
	}

	public void show(OHwewon oHwewon) {
	      System.out.println("�������� ��ȸ(1), ������� ��ȸ(2)");
	      int choice = this.scanner.nextInt();
	      if(choice==1) {
	    	  System.out.println("�������� ��ȸ�Դϴ�.");
	    	  System.out.println("���̵�: "+oHwewon.getId() 
	    	  + "\n�̸�: "+oHwewon.getName()
	    	  +"\n�ּ�: "+oHwewon.getAddress()
	    	  +"\n�а�:"+oHwewon.getHwakgwa()
	    	  +"\n�ڵ��� ��ȣ: "+ oHwewon.getPhoneNum());
	      }else if(choice==2) {
	    	  System.out.println("������� ��ȸ�Դϴ�..");

	    	  float avggrade =cLecture.getpast(oHwewon);
	    	  System.out.println("�������: "+avggrade);

	    	  
	      }else if(choice==3) {
	    	  return;
	      }else {
	    	  System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	      }		
	}



	
	
}
