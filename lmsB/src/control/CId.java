package control;

import dataAccessObject.DId;

public class CId {
	
	public static boolean Idcheck(String id){
		if(DId.DIdChek(id)==true) {
			return true;
		}else{
			return false;
		}
	}
	
	public static void Idsearch(String name, String phone) {
		if(DId.DIdsearch(name, phone)==false) {
			System.out.println("�������� �ʴ� ȸ�������Դϴ�.");
		}
	}
}
