package Textview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import control.CGrade;
import valueObject.OHwewon;

public class VGrade {
	private CGrade cGrade;
	
	public VGrade() {
	this.cGrade=new CGrade();
	}
	
	public String Sshow(OHwewon oHwewon) {
		String maxGrade =cGrade.SgetAll(oHwewon);
		System.out.println("���� ��û����:" + maxGrade);
		return maxGrade;
	}
	
	public String Mshow(OHwewon oHwewon) {
		String maxGrade =cGrade.MgetAll(oHwewon);
		System.out.println("���� �̸� ��� ���� ����:" + maxGrade);
		return maxGrade;
	} 

}
