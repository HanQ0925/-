package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheon {

	private static final char[] Text = null;

	private Scanner scanner;

	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	private CLecture cLecture;
	private VMiridamgi vMridamgi;


	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege=new VIndex(this.scanner);
		this.vDepartment=new VIndex(this.scanner);
		this.vLecture=new VLecture(this.scanner);
		this.vMridamgi=new VMiridamgi(this.scanner);
		this.cLecture=new CLecture();
	}

	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName()+"�� �ȳ��ϼ���..");
		System.out.println("������û �� �̸����(1) �̸���⿡�� ���� ����(2) ������û���� ���� ����(3)");
		int input = this.scanner.nextInt();
		if(input == 1) {
			System.out.println("���� ��û�� �����մϴ�");
			String campusFileName = this.vCampus.show("root", "ķ�۽���");
			if(campusFileName != null) {
				String collegeFileName = this.vCollege.show(campusFileName, "���и�");
				if(campusFileName != null) {
					String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
					if(campusFileName != null) {
						OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");
						if(oLecture != null) {
							System.out.println("�̸���� (1), ������û(2)");
							input = this.scanner.nextInt();
							if(input==1) {
								vMridamgi.get(oLecture, oHwewon);
							}else if(input==2){
								this.save(oLecture, oHwewon);
								System.out.println("������û �Ϸ�");
							}else {
								System.out.println("�߸� �Է��ϼ̽��ϴ�.");
							}
						}
					}
				}
			}
		}else if(input == 2) {
			vMridamgi.Mdelete(oHwewon);
		}else if(input ==3) {
			this.Sdelete(oHwewon);
		}else if(input==4) {
		}
	}

	public void save(OLecture oLecture, OHwewon oHwewon) {
		try {
			File file = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
			FileWriter filewriter = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(filewriter);

			bw.write(oLecture.getId()+"/"+oLecture.getLectureName()+'/'+oLecture.getProfName()+'/'+oLecture.getCredits()+'/'+oLecture.getTime());
			bw.newLine();
			bw.flush();
			bw.close();
			filewriter.close();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public void Sdelete(OHwewon oHwewon) {
		Vector v = new Vector();
		int index=0;
	        try{
	            File file = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
	            FileReader filereader = new FileReader(file);
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            while((line = bufReader.readLine()) != null){
	                System.out.println('['+String.valueOf(index)+']'+line);
	                v.add(line);
	                index++;
	            }
	            System.out.println("������ ������ ��ȣ�� �Է��ϼ���...");
	    		int input = this.scanner.nextInt();
	    		v.remove(input);
	    		file.delete();
	    		
	            File Newfile = new File("user/"+oHwewon.getId()+"_sinchoen.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
	            for(int i= 0; i<v.size();i++) {
	            String inputString = (String) v.get(i);
	            bufferedWriter.write(inputString);
	            bufferedWriter.newLine();
	            }
	            
                bufferedWriter.close();
	            bufReader.close();
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	        System.out.print("���� �Ϸ�.");
	}
}