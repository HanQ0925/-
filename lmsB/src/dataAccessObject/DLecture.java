package dataAccessObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import model.MLecture;
import model.MpastLecture;
import valueObject.OHwewon;
import valueObject.OIndex;
import valueObject.OLecture;
import valueObject.OpastLecture;

public class DLecture {
	private MLecture mLecture;
	private MpastLecture mpastLecture;
	private static final String PATHNAME="data/";
 public DLecture() {	 
	 
 }
 
 public Vector<OLecture> readAll(String fileName){
  Vector<OLecture> lectures = new Vector<OLecture>();
  
  try {
   File file = new File(PATHNAME+fileName);
   Scanner scan = new Scanner(file);
   this.mLecture = new MLecture();
   while(mLecture.read(scan)){
    OLecture oLecture = new OLecture();
    oLecture.set(mLecture);
    lectures.add(oLecture);
   }
   scan.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  return lectures;
 }


 public float readpast(OHwewon oHwewon) {
	 float Avggrade = 0;
	    int sumcredit=0;
	    String grade;
	    float Sumgrade = 0;
	 Vector<OpastLecture> lectures = new Vector<OpastLecture>();
	  try {
	   File file = new File("user/" + oHwewon.getId() + "_past.txt");
	   Scanner scan = new Scanner(file);
	   this.mpastLecture = new MpastLecture();
	   while(mpastLecture.read_past(scan)){
	    OpastLecture opastLecture = new OpastLecture();
	    opastLecture.set(mpastLecture);
	    grade=opastLecture.getGrade();
	    if("A+".equals(grade)) {
	    	 Sumgrade+=(float) 4.5*Integer.parseInt(opastLecture.getCredits());
	    }else if("A0".equals(grade)){
	    	 Sumgrade+=(float) 4.0*Integer.parseInt(opastLecture.getCredits());
	    }else if("B+".equals(grade)) {
	    	 Sumgrade+=(float) 3.5*Integer.parseInt(opastLecture.getCredits());
	    }else if("B0".equals(grade)) {
	    	 Sumgrade+=(float) 3.0*Integer.parseInt(opastLecture.getCredits());
	    }else if("C+".equals(grade)) {
	    	 Sumgrade+=(float) 2.5*Integer.parseInt(opastLecture.getCredits());
	    }else if("C0".equals(grade)) {
	    	 Sumgrade+=(float) 2.0*Integer.parseInt(opastLecture.getCredits());
	    }else if("D+".equals(grade)) {
	    	 Sumgrade+=(float) 1.5*Integer.parseInt(opastLecture.getCredits());
	    }else if("D0".equals(grade)) {
	    	 Sumgrade+=(float) 1.0*Integer.parseInt(opastLecture.getCredits());
	    }else if("F".equals(grade)) {
	    	 Sumgrade+=(float) 0*Integer.parseInt(opastLecture.getCredits());
	    }
	    sumcredit +=  Integer.parseInt(opastLecture.getCredits());
	    lectures.add(opastLecture);
	   }
	   Avggrade=(float) (Sumgrade/sumcredit);
	   scan.close();
	  } catch (FileNotFoundException e) {
	   e.printStackTrace();
	  }
	  return Avggrade;
 }

	public void DaddLecture(String fileName) {
		Scanner scan = new Scanner(System.in);
		 String id;
		 String lectureName;
		 String profName;
		 String credits;
		 String time;
		
		System.out.println("������ ��ȣ�� �Է��ϼ���.");
		id=scan.next();
		System.out.println("������ �̸��� �Է��ϼ���.");
		lectureName=scan.next();
		System.out.println("������ �����̸��� �Է��ϼ���.");
		profName=scan.next();
		System.out.println("������ ������ �Է��ϼ���.");
		credits=scan.next();
		System.out.println("������ �ð��� �Է��ϼ���.");
		time=scan.next();
		
		try {
		File file = new File("data/" + fileName);
		FileWriter filewriter = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(filewriter);
		bw.newLine();
		bw.write(id + ' ' + lectureName + ' ' + profName + ' '+ credits + ' ' + time);
		bw.newLine();
		bw.flush();
		bw.close();
		filewriter.close();
		bw.close();
		System.out.println("���� �߰� �Ϸ�");
		}catch (Exception e) {
		// TODO: handle exception
		}
	}

	public void DdelteLecture(String fileName) {
		Vector v = new Vector();
		int index = 0;
		try {
			File file = new File("data/" + fileName);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				System.out.println('[' + String.valueOf(index) + ']' + line);
				v.add(line);
				index++;
			}
			System.out.println("������ ������ ��ȣ�� �Է��ϼ���.");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			v.remove(input);
			file.delete();

			File Newfile = new File("data/" + fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
			for (int i = 0; i < v.size(); i++) {
				String inputString = (String) v.get(i);
				bufferedWriter.write(inputString);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
			bufReader.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("���� �Ϸ�.");
	}

	
	public void DchangeLecture(String fileName) {
		Vector v = new Vector();
		int index = 0;
		try {
			File file = new File("data/" + fileName);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line;

			while ((line = bufReader.readLine()) != null) {
				System.out.println(line);
				v.add(line);
				index++;
			}
			System.out.println("������ ȸ���� ID�� �Է����ּ���");
			Scanner sc = new Scanner(System.in);
			String id = sc.next();
			
			 for(int i = 0; i<v.size(); i++) {
		       String input = (String)v.get(i);
		       String [] inputArr = input.split(" ");
			       if(id.equals(inputArr[0])) {
						System.out.println("���¹�ȣ ����(1) �����̸� ����(2) ���� ��米�� ����(3) �������� ����(4) ���½ð� ����(5)");
						int choice =sc.nextInt();
							if(choice==1) {
								System.out.println("���� ���� ��ȣ: "+inputArr[0]);
								System.out.println("���� ���� ��ȣ�� �Է����ּ���.");
								String newname = sc.next();
								inputArr[0]=newname;
								System.out.println("���� ��: "+inputArr[0]);
								String newinput ="";
								for(int j=0; j<inputArr.length; j++) {
									newinput += inputArr[j]+' ';
								}
								System.out.println(newinput);
								v.set(i,newinput);
								break;
							}else if(choice==2) {
								System.out.println("���� ���� �̸�: "+inputArr[1]);
								System.out.println("���� ���� �̸��� �Է����ּ���");
								String newdepart = sc.next();
								inputArr[1]=newdepart;
								System.out.println("���� ��: "+inputArr[1]);
								String newinput ="";
								for(int j=0; j<inputArr.length; j++) {
									newinput += inputArr[j]+' ';
								}
								System.out.println(newinput);
								v.set(i,newinput);
								break;
							}else if(choice==3) {
								System.out.println("���� ���� ��米��: "+inputArr[4]);
								System.out.println("���� ���� ��米���� �Է����ּ���");
								String newdnum = sc.next();
								inputArr[4]=newdnum;
								System.out.println("���� ��: "+inputArr[4]);
								String newinput ="";
								for(int j=0; j<inputArr.length; j++) {
									newinput += inputArr[j]+' ';
								}
								System.out.println(newinput);
								v.set(i,newinput);
								break;
							}else if(choice==4) {
								System.out.println("���� ���� ����: "+inputArr[5]);
								System.out.println("���� ���� ������ �Է����ּ���");
								String newdnum = sc.next();
								inputArr[5]=newdnum;
								System.out.println("���� ��: "+inputArr[5]);
								String newinput ="";
								for(int j=0; j<inputArr.length; j++) {
									newinput += inputArr[j]+' ';
								}
								System.out.println(newinput);
								v.set(i,newinput);
								break;							
								}else if(choice==5) {
									System.out.println("���� ���� ����: "+inputArr[6]);
									System.out.println("���� ���� ������ �Է����ּ���");
									String newdnum = sc.next();
									inputArr[6]=newdnum;
									System.out.println("���� ��: "+inputArr[6]);
									String newinput ="";
									for(int j=0; j<inputArr.length; j++) {
										newinput += inputArr[j]+' ';
									}
									System.out.println(newinput);
									v.set(i,newinput);
									break;
								}
			       }
		       }
				File Newfile = new File("data/"+fileName);
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
				for (int i = 0; i < v.size(); i++) {
					String inputString = (String) v.get(i);
					bufferedWriter.write(inputString);
					bufferedWriter.newLine();
				}

				bufferedWriter.close();						
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Vector<OLecture> WMiridamgiAll(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		  
		  try {
		   File file = new File("user/"+fileName+"_bag.txt");
		   Scanner scan = new Scanner(file);
		   this.mLecture = new MLecture();
		   while(mLecture.read(scan)){
		    OLecture oLecture = new OLecture();
		    oLecture.set(mLecture);
		    lectures.add(oLecture);
		   }
		   scan.close();
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  }
		  return lectures;
	}

	public Vector<OLecture> WSincheon(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		  
		  try {
		   File file = new File("user/"+fileName+"_sinchoen.txt");
		   Scanner scan = new Scanner(file);
		   this.mLecture = new MLecture();
		   while(mLecture.read(scan)){
		    OLecture oLecture = new OLecture();
		    oLecture.set(mLecture);
		    lectures.add(oLecture);
		   }
		   scan.close();
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  }
		  return lectures;
	}
	
	


}