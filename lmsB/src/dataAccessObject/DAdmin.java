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

public class DAdmin {

	public void DselectiHwewon() {
			
		 try{
	            File file = new File("hwewon");
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	                System.out.println(line);
	            }
             System.out.println();
	            bufReader.close();
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
		
	}

	public void DdeleteHwewon() {
		Vector v = new Vector();
		int index = 0;
		try {
			File file = new File("hwewon");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			System.out.println("ID                                       Password                          Name  Location hwakgwa  Phone  ");
			while ((line = bufReader.readLine()) != null) {
				System.out.println('[' + String.valueOf(index) + ']' + line);
				v.add(line);
				index++;
			}
			System.out.println("������ ȸ���� ��ȣ�� �Է��ϼ���.");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			v.remove(input);

			File Newfile = new File("hwewon");
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

	
	public void DChangeHwewon() {
		Vector v = new Vector();
		int index = 0;
		try {
			File file = new File("hwewon");
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
						System.out.println("�̸�����(1) �ּҺ���(2) �а�����(3) ��ȣ����(4) ����(5)");
						int choice =sc.nextInt();
							if(choice==1) {
								System.out.println("���� ����: "+inputArr[2]);
								System.out.println("���� ���� �Է����ּ���.");
								String newname = sc.next();
								inputArr[2]=newname;
								System.out.println("���� ��: "+inputArr[2]);
								String newinput ="";
								for(int j=0; j<inputArr.length; j++) {
									newinput += inputArr[j]+' ';
								}
								System.out.println(newinput);
								v.set(i,newinput);
								break;
							}else if(choice==2) {
								System.out.println("���� �ּ�: "+inputArr[3]);
								System.out.println("���� �ּҸ� �Է����ּ���");
								String newdepart = sc.next();
								inputArr[3]=newdepart;
								System.out.println("���� ��: "+inputArr[3]);
								String newinput ="";
								for(int j=0; j<inputArr.length; j++) {
									newinput += inputArr[j]+' ';
								}
								System.out.println(newinput);
								v.set(i,newinput);
								break;
							}else if(choice==3) {
								System.out.println("���� �а�: "+inputArr[4]);
								System.out.println("���� �а��� �Է����ּ���");
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
								System.out.println("���� ��ȣ: "+inputArr[5]);
								System.out.println("���� ��ȣ�� �Է����ּ���");
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
								return;
							}
			       }
		       }
				File Newfile = new File("hwewon");
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
	

}
