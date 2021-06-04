package Textview;

import java.util.Scanner;

import control.CAdmin;
import control.CLecture;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLecture;
import windowView.VCampus;
import windowView.VCollege;
import windowView.VDepartment;

public class VAdmin {
	
	private Scanner scanner;
	private CAdmin cAdmin;
	private VLecture vLecture;
	private VIndex vCampus;
	private VIndex vCollege;
	private VIndex vDepartment;
	
	public VAdmin(Scanner scanner) {
		this.scanner = scanner;
		this.cAdmin = new CAdmin();
		this.vLecture = new VLecture(scanner);
		this.vCampus = new VIndex(scanner);
		this.vCollege = new VIndex(scanner);
		this.vDepartment = new VIndex(scanner);	
	}

	
	public void show(OHwewon oHwewon) {
		System.out.println("ȸ�����(1) ȸ������(2) ȸ������ ����(3) ���� �߰�,����,����(4) �����޴�(5) ");
		int choice = this.scanner.nextInt();
		if(choice==1) {
			cAdmin.selectHwewon();
			return;
		}else if (choice==2) {
			cAdmin.deleteHwewon();
			return;
		}else if (choice==3) {
			cAdmin.changeHwewon();
			return;
		}else if(choice==4) {
			System.out.println("���� �߰�(1), ���� ����(2), ���� ����(3)");
			int j = this.scanner.nextInt();
			String campusFileName = this.vCampus.show("root", "ķ�۽���");
			if (campusFileName != null) {
				String collegeFileName = this.vCollege.show(campusFileName, "���и�");
				if (campusFileName != null) {
					String departmentFileName = this.vDepartment.show(collegeFileName, "�а���.");
					if (campusFileName != null) {
						if(j==1) {
						this.vLecture.VaddLecture(departmentFileName);
						}else if (j==2) {
							this.vLecture.VdelteLecture(departmentFileName);
						}else if (j==3) {
							this.vLecture.VchangeLecture(departmentFileName);
						}
					}
				}
			}
		}
	}
}