package Textview;

import java.util.Scanner;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok {
   
   private Scanner scanner;
   private CHwewonDeungrok cHwewonDeungrok;
   
   public VHwewonDeungrok(Scanner scanner) {
      this.scanner = scanner;
      this.cHwewonDeungrok = new CHwewonDeungrok();
   }

   public void show() {
      System.out.println("ȸ�������� �Է��ϼ���:");
      OHwewon oHwewon = new OHwewon();
      
      System.out.print("���̵�");
      String id = scanner.next();
      oHwewon.setId(id);
      
      System.out.print("��й�ȣ");
      String password = scanner.next();
      oHwewon.setPassword(password);
      
      System.out.print("�̸�");
      String name = scanner.next();
      oHwewon.setName(name);
      
      System.out.print("�ּ�");
      String address = scanner.next();
      oHwewon.setAddress(address);
      
      System.out.print("�а�");
      String hwakgwa = scanner.next();
      oHwewon.setHwakgwa(hwakgwa);
      
      System.out.print("��ȭ��ȣ");
      String PhoneNum = scanner.next();
      oHwewon.setPhoneNum(PhoneNum);
      // ����� ���� �Է� �޾�
      // oHwewon�� ����
      this.cHwewonDeungrok.saveHwewon(oHwewon);
   }
}