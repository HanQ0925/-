package view;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok {

	private CHwewonDeungrok cHwewonDeungrok;
	public VHwewonDeungrok() {
		this.cHwewonDeungrok = new CHwewonDeungrok();
	}

	public void show() {
		System.out.println("LHwewonDeungrok::show()");
		OHwewon oHwewon = new OHwewon();
		// ����� ���� �Է� �޾�
		// oHwewon�� ����
		this.cHwewonDeungrok.saveHwewon(oHwewon);
	}
}
