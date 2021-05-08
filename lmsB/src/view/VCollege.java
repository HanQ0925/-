package view;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import valueObject.OIndex;

public class VCollege {
	private Scanner scanner;	
	private CIndex cIndex;
	
	public VCollege(Scanner scanner) {
		this.scanner=scanner;
		this.cIndex = new CIndex();
	}

	public String show(String campusFileName) {
		System.out.println("�Ҽ� �ܰ��븦 �����ϼ���.");
		
		Vector<OIndex> indices = cIndex.getAll("src/data/"+campusFileName);   // ���⼭ ������
		for(OIndex index: indices) {
			System.out.println(index.getId() + " " + index.getName());
		}		
		
		String id = this.scanner.next();
		for(OIndex index: indices) {
			if(index.getId().equals(id)) {
				return index.getFileName();
			}
		}
		return null;
	}
}
