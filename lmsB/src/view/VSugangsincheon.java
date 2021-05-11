package view;

import java.util.Scanner;
import java.util.Vector;

import control.CBag;
import control.CIndex;
import control.CLecture;
import valueObject.OBag;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheon {

	private Scanner scanner;
	
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	private VLecture vLecture;
	private CLecture cLecture;
	private OBag oBag;
	private CBag cBag;
	
	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vCampus = new VIndex(this.scanner);
		this.vCollege=new VIndex(this.scanner);
		this.vDepartment=new VIndex(this.scanner);
		this.vLecture=new VLecture(this.scanner);
		
		this.cLecture=new CLecture();
		this.oBag=new OBag();
		this.cBag=new CBag();
	}
	
	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName()+"�� �ȳ��ϼ���");
		System.out.println("���� ��û�� �����մϴ�.");

		
		String campusFileName = this.vCampus.show("root", "ķ�۽���");
		if(campusFileName != null) {
			String collegeFileName = this.vCollege.show(campusFileName, "���и�");
		if(campusFileName != null) {
			String departmentFileName = this.vDepartment.show(collegeFileName, "�а���");
		if(campusFileName != null) {
			OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");
		if(oLecture != null) {
			Vector<OLecture> lectures = cLecture.getAll(departmentFileName);
			System.out.println("�̸���� (1), ������û(2)");

			int input = this.scanner.nextInt();
			
			if(input==1) {
				for(OLecture lecture: lectures) {
					oBag.setId(lecture.getId());
					oBag.setLecturename(lecture.getLectureName());
					oBag.setProfName(lecture.getProfName());
					oBag.setCredits(lecture.getCredits());
					oBag.setTime(lecture.getTime());
				}
				this.cBag.saveLecutres(oBag, oHwewon);
				System.out.println("�̸���� �Ϸ�");

				
				
				
			}else if(input==2){
				System.out.println("������û �Ϸ�");
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
			
			
				}
			}
		}
	}
}