//package Textview;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.Vector;
//
//import control.CSugansincheon;
//import model.MLecture;
//import valueObject.OHwewon;
//import valueObject.OLecture;
//
//public class VMiridamgi {
//	private String id;
//	private String lectureName;
//	private String profName;
//	private String credits;
//	private String time;
//	private MLecture mLecture;
//	private Scanner scanner;
//	private VSugangsincheon vSugangsincheon;
//	private VGrade vGrade;
//	private String Grade;
//	private CSugansincheon cSugansincheon;
//	
//	public VMiridamgi(Scanner scanner) {
//		this.scanner = scanner;
//		this.vGrade = new VGrade();
//		this.cSugansincheon = new CSugansincheon(scanner);
//	}
//
//	public void get(OLecture oLecture, OHwewon oHwewon) {
//		this.id = oLecture.getId();
//		this.lectureName = oLecture.getLectureName();
//		this.profName = oLecture.getProfName();
//		this.credits = oLecture.getCredits();
//		this.time = oLecture.getTime();
//		Grade=vGrade.Mshow(oHwewon);
////		this.Grade=grade;
//		File f = new File("user/" + oHwewon.getId() + "_bag.txt");
//		if(f.exists()) {
//			this.MGradeCheck(oHwewon);
//			this.Check(oHwewon);
//		}else {
//			this.save(oHwewon);
//		}
//	}
//
//	public void save(OHwewon oHwewon) {
//		try {
//			File file = new File("user/" + oHwewon.getId() + "_bag.txt");
//			FileWriter filewriter = new FileWriter(file, true);
//			BufferedWriter bw = new BufferedWriter(filewriter);
//
//			bw.write(id + ' ' + lectureName + ' ' + profName + ' ' + credits + ' ' + time);
//			bw.newLine();
//			bw.flush();
//			filewriter.close();
//			bw.close();
//			System.out.println("�̸���� �Ϸ�");
//
//			// oHwewond���� mHwewon���� �����͸� �̵�
//			// mHwewon�� ���ؼ� ���Ͽ� ����
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void Mdelete(OHwewon oHwewon) {
//		Vector v = new Vector();
//		int index = 0;
//		try {
//			File file = new File("user/" + oHwewon.getId() + "_bag.txt");
//			FileReader filereader = new FileReader(file);
//			BufferedReader bufReader = new BufferedReader(filereader);
//			String line = "";
//			while ((line = bufReader.readLine()) != null) {
//				System.out.println('[' + String.valueOf(index) + ']' + line);
//				v.add(line);
//				index++;
//			}
//			System.out.println("������ ������ ��ȣ�� �Է��ϼ���...");
//			int input = this.scanner.nextInt();
//			v.remove(input);
//			file.delete();
//
//			File Newfile = new File("user/" + oHwewon.getId() + "_bag.txt");
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Newfile));
//			for (int i = 0; i < v.size(); i++) {
//				String inputString = (String) v.get(i);
//				bufferedWriter.write(inputString);
//				bufferedWriter.newLine();
//			}
//			bufferedWriter.close();
//			bufReader.close();
//		} catch (FileNotFoundException e) {
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//		System.out.println("���� �Ϸ�.");
//	}
//
//	public void sincheon(OHwewon oHwewon, String grade) {
//		Vector v = new Vector();
//		int index = 0;
//		try {
//			File file = new File("user/" + oHwewon.getId() + "_bag.txt");
//			FileReader filereader = new FileReader(file);
//			BufferedReader bufReader = new BufferedReader(filereader);
//			String line;
//
//			while ((line = bufReader.readLine()) != null) {
//				System.out.println('[' + String.valueOf(index) + ']' + line);
//				v.add(line);
//				index++;
//			}
//			
//
//			System.out.println("��û�� ������ ��ȣ�� �����ϼ���..");
//			this.id = this.scanner.next();
//			
//			
//			File SFile = new File("user/" + oHwewon.getId() + "_sinchoen.txt");
//			String lectures;
//			Scanner scan;
//			scan = new Scanner(SFile);
//			mLecture = new MLecture();
//			if (this.equal( index, SFile, oHwewon)) {
//				System.out.println("�ߺ� �����Դϴ�.");
//			}else {
//				scan = new Scanner(file);
//				for (int i = 0; i < index; i++) {
//					mLecture.read(scan);
//					OLecture oLecture = new OLecture();
//					oLecture.setId(mLecture.getId());
//					lectures = oLecture.getId();
//
//					if (this.id.equals(lectures)) {
//						if(Integer.parseInt(mLecture.getCredits())<=18-Integer.parseInt(grade)) {
//							oLecture.setCredits(mLecture.getCredits());
//							oLecture.setLecturename(mLecture.getLectureName());
//							oLecture.setProfName(mLecture.getProfName());
//							oLecture.setTime(mLecture.getTime());
//							this.vSugangsincheon = new VSugangsincheon(this.scanner);
//							this.cSugansincheon.save(oLecture, oHwewon);
//							
//						}else {
//							System.out.print("��û ���������� �ʰ��մϴ�.");
//						}
//
//
//					}
//					
//				}
//				
//			}
//			bufReader.close();
//		
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//	}
//
//	public boolean Check(OHwewon oHwewon) {
//		Vector v = new Vector();
//		int index = 0;
//		try {
//			File file = new File("user/" + oHwewon.getId() + "_bag.txt");
//			FileReader filereader = new FileReader(file);
//			BufferedReader bufReader = new BufferedReader(filereader);
//			String line;
//			while ((line = bufReader.readLine()) != null) {
//				index++;
//			}
//
//			this.vSugangsincheon = new VSugangsincheon(this.scanner);
//			int i = 0;
//
//			if (this.equal( index, file, oHwewon)) {
//				System.out.println("�ߺ��Ǵ� �����Դϴ�. �ٽ� �������ּ���..");
//				vSugangsincheon.show(oHwewon);
//				System.exit(0);
//				return true;
//			} else {
//					this.save(oHwewon);
//			}
//
//		} catch (IOException e) {
//			System.out.println(e);
//		}
//		return false;
//	}
//
//	public boolean equal(int index,File file, OHwewon oHwewon) {
//		try {
//			String lectures;
//			Scanner scan;
//			scan = new Scanner(file);
//			mLecture = new MLecture();
//		for (int i = 0; i < index; i++) {
//			mLecture.read(scan);
//			OLecture oLecture = new OLecture();
//			oLecture.setId(mLecture.getId());
//			lectures = oLecture.getId();
//			
//			if (this.id.equals(lectures)) {
//				return true;
//			}
//			
//		}
//		scan.close();
//	
//	}catch (FileNotFoundException e) {
//		e.printStackTrace();
//	}		
//		return false;
//}
//
//	public void MList(OHwewon oHwewon) {
//		vGrade.Mshow(oHwewon);
//		  try{
//	            File file = new File("user/" + oHwewon.getId() + "_bag.txt");
//	            FileReader filereader = new FileReader(file);
//	            BufferedReader bufReader = new BufferedReader(filereader);
//	            String line = "";
//	            while((line = bufReader.readLine()) != null){
//	                System.out.println(line);
//	            }
//                System.out.println();
//	            bufReader.close();
//	        }catch (FileNotFoundException e) {
//	            // TODO: handle exception
//	        }catch(IOException e){
//	            System.out.println(e);
//	        }
//
//
//		}
//	
//	private boolean MGradeCheck(OHwewon oHwewon) {
//		this.vSugangsincheon = new VSugangsincheon(this.scanner);
//		if(Integer.parseInt(this.credits) > 25-Integer.parseInt(this.Grade)) {
//			System.out.println("�����ʰ��Դϴ�.");
//			System.out.println("�ٽ� �������ּ���.");
//			this.vSugangsincheon.show(oHwewon);
//			System.exit(0);
//		}else {
//			
//		}
//		return true;
//	}
//
//}