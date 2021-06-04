package Textview;

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
import control.CMiridamgi;
import control.CSugansincheon;
import model.MLecture;
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
//	private VMiridamgi vMridamgi;
	private MLecture mLecture;
	private VGrade vGrade;
	private CSugansincheon cSugansincheon;
	private CMiridamgi cMiridamgi;

	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vDepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
//		this.vMridamgi = new VMiridamgi(this.scanner);
		this.cLecture = new CLecture();
		this.mLecture = new MLecture();
		this.vGrade = new VGrade();
		this.cSugansincheon = new CSugansincheon(this.scanner);
		this.cMiridamgi = new CMiridamgi(scanner);
	}

	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName() + "�� �ȳ��ϼ���..");

		int choice;
		while (true) {
			String grade = vGrade.Sshow(oHwewon);
			System.out.println("������û �� �̸����(1) �̸���⿡�� ������û(2) �̸���⿡�� ���� ����(3) ������û���� ���� ����(4) �̸���� ��� ��ȸ(5) ������û ��� ��ȸ(6) ���α׷� ����(7)");
			int input = this.scanner.nextInt();
			if (input == 1) {
				System.out.println("���� ��û�� �����մϴ�");
				String campusFileName = this.vCampus.show("root", "ķ�۽���");
				if (campusFileName != null) {
					String collegeFileName = this.vCollege.show(campusFileName, "���и�");
					if (campusFileName != null) {
						String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
						if (campusFileName != null) {
							OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");

							if (oLecture != null) {
								System.out.println("�̸���� (1), ������û(2)");
								input = this.scanner.nextInt();
								if (input == 1) {
									this.cMiridamgi.CMget(oLecture, oHwewon);
									System.out.println("�߰� ��û�� ��� �Ͻðڽ��ϱ�? ��(1) �ƴϿ�(2)");
									choice = this.scanner.nextInt();
									if (choice == 1) {
										System.out.println("-------�߰���û-------");
									} else if (choice == 2) {
										System.out.println("���α׷� �����մϴ�.");
										continue;
									}
								}else if (input == 2) {
									File f = new File("user/" + oHwewon.getId() + "_sinchoen.txt");
									if (f.exists()) {
										this.SGradeCheck(oLecture, oHwewon, grade);
										if(this.cSugansincheon.SCheck(oLecture, oHwewon)==true){
											this.cSugansincheon.save(oLecture, oHwewon);
										}else {
											continue;
										}
									} else {
										this.cSugansincheon.save(oLecture, oHwewon);
									}
									System.out.println("�߰� ��û�� ��� �Ͻðڽ��ϱ�? ��(1) �ƴϿ�(2)");
									choice = this.scanner.nextInt();
									if (choice == 1) {
										System.out.println("-------�߰���û-------");
									} else if (choice == 2) {
										System.out.println("���α׷� �����մϴ�.");
										continue;
									}
								}
							}

						}
					}

				}

			} else if (input == 2) {
				this.cMiridamgi.CMsincheon(oHwewon, grade);
			} else if (input == 3) {
				while (true) {
					this.cMiridamgi.CMdelte(oHwewon);
					System.out.println("�߰� ������ �Ͻðڽ��ϱ�? ��(1) �ƴϿ�(2)");
					choice = this.scanner.nextInt();
					if (choice == 1) {
						System.out.println("-------�߰�����-------");
					}

					if (choice == 2) {
						System.out.println("���α׷� �����մϴ�.");
						continue;
					}

				}
			} else if (input == 4) {
				while (true) {
					this.cSugansincheon.delete(oHwewon);
					System.out.println("�߰� ������ �Ͻðڽ��ϱ�? ��(1) �ƴϿ�(2)");
					choice = this.scanner.nextInt();
					if (choice == 1) {
						System.out.println("-------�߰�����-------");
					}

					if (choice == 2) {
						System.out.println("���α׷� �����մϴ�.");
						continue;
					}
				}
			} else if (input == 5) {
				System.out.println("�̸� ��� ��� ��ȸ");
				this.cMiridamgi.MList(oHwewon);
				continue;
			} else if (input == 6) {
				System.out.println("���� ������û ��� ��ȸ");
				this.cSugansincheon.SList(oHwewon, grade);
				continue;
			} else if (input==7) {
				System.out.println("���α׷� �����մϴ�.");
				break;
			}

		} // while
	}


	private boolean SGradeCheck(OLecture oLecture, OHwewon oHwewon, String grade) {
		if(Integer.parseInt(oLecture.getCredits()) > 20-Integer.parseInt(grade)) {
			System.out.println("�����ʰ��Դϴ�.");
			System.out.println("�ٽ� �������ּ���.");
			this.show(oHwewon);
			System.exit(0);
		}else {
			
		}
		return true;
	}

}