package view;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import valueObject.OLecture;

public class VLecture {
 private Scanner scan;
 private CLecture cLecture;

 public VLecture(Scanner scan) {
  this.scan = scan;
  this.cLecture = new CLecture();
 }

 public OLecture show(String departmentFileName) {
  departmentFileName = "src/data/"+departmentFileName;
  System.out.println("���¸� �����ϼ���.");
  
  Vector<OLecture> lectures = cLecture.getAll(departmentFileName);
  for(OLecture lecture: lectures) {
   System.out.println(lecture.getId()+ " "+lecture.getLectureName()+" "+lecture.getProfName()+" "+lecture.getCredits()+" "+lecture.getTime());
  }
  String id = this.scan.next();
  for(OLecture lecture: lectures) {
   if(lecture.getId().equals(id)) {
    return null;
   }
  }
  return null;
 
 }
}