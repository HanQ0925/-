package view;

import java.io.IOException;

public class VInitial {

	private VHwewonDeungrok hwewonDeungrok;
	public VInitial() {
		this.hwewonDeungrok = new VHwewonDeungrok();
	}

	public void show() {
		System.out.println("���� ����� ���� �ϼ���");
		System.out.println("�α���(1), ȸ�����(2)");

		try {
			int input = System.in.read();
			if (input == '1') {
				// login dialog show
			} else if (input == '2') {
				this.hwewonDeungrok.show();
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
