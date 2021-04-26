package view;

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
      int id = scanner.nextInt();
      oHwewon.setId(id);
      
      System.out.print("��й�ȣ");
      int password = scanner.nextInt();
      oHwewon.setPassword(password);
      
      System.out.print("�̸�");
      String name = scanner.next();
      oHwewon.setName(name);
      
      System.out.print("�ּ�");
      String address = scanner.next();
      oHwewon.setAddress(address);
      
      System.out.print("�а�");
      int hwakgwa = scanner.nextInt();
      oHwewon.setHwakgwa(hwakgwa);
      // ����� ���� �Է� �޾�
      // oHwewon�� ����
      this.cHwewonDeungrok.saveHwewon(oHwewon);
   }
}