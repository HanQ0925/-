package dataAccessObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {
   public DHwewonDeungrok() {      
   }

   public void save(OHwewon oHwewon) {
      try {
      File file = new File("hwewon");
      FileWriter filewriter = new FileWriter(file, true);
      BufferedWriter bw = new BufferedWriter(filewriter);
      MHwewon mHwewon = new MHwewon();
      mHwewon.save(bw, oHwewon);
      filewriter.close();
      bw.close();
      // oHwewond���� mHwewon���� �����͸� �̵�
      // mHwewon�� ���ؼ� ���Ͽ� ����
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public OHwewon read() {
      // mHwewon�� ���� Data read
      // oHwewon ����
      // mHwewon���� oHwewon���� ������ �̵�
      return null;
   }

}