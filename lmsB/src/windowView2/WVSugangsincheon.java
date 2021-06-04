package windowView2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;


import Textview.VIndex;
import control.CIndex;
import valueObject.OHwewon;
import valueObject.OIndex;
import valueObject.OLecture;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class WVSugangsincheon {

	static JFrame frame;
	private CIndex cIndex;
	private WEventListen wEventListen;
	private JTable table;
	private VGangjwaSelection vGangjwaSelection;
	private JTable Mtable;
	private JTable Stable;
	private OHwewon oHwewon1;
	private JTextField gangjwa;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton Msincheon;
	private JButton Mdelete;
	private JButton SMdelete;
	
	public WVSugangsincheon(OHwewon oHwewon) {
		
		this.cIndex = new CIndex();
		this.wEventListen = new WEventListen();
		this.oHwewon1 =oHwewon;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1353, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1339, 563);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox campus = new JComboBox();
		campus.setFont(new Font("����", Font.PLAIN, 20));
		
	      this.cIndex = new CIndex();
	      Vector<OIndex> indices = this.cIndex.getAll("root");
	      
	      String campusarr[] = new String[indices.size()];
	      int i=0;
	      for(OIndex oIndex : indices) {
	    	 campusarr[i]=oIndex.getFileName();
	         i++;
	      }
	      campus.setModel(new DefaultComboBoxModel(campusarr));
		campus.setBounds(12, 38, 206, 39);
		panel.add(campus);
		
		JComboBox college = new JComboBox();
		college.setFont(new Font("����", Font.PLAIN, 20));
		college.setBounds(12, 113, 206, 39);
		panel.add(college);
		
		
		campus.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) { //ķ�۽� ���ý�
			    String collegeget []= wEventListen.getcollege(campus.getSelectedItem().toString());
			      college.setModel(new DefaultComboBoxModel(collegeget));
			}
		});	     

				
		JComboBox department = new JComboBox();
		department.setFont(new Font("����", Font.PLAIN, 20));
		department.setBounds(12, 192, 206, 39);
		panel.add(department);
		
		table = new JTable();  //���¸�� ���̺�
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"���¹�ȣ", "���¸�", "������", "����","�ð�"}
			},
			new String[] {
				"���¹�ȣ", "���¸�", "������", "����", "�ð�"
			}
		));
		table.setBounds(230, 74, 324, 423);
		panel.add(table);
		
		JButton sincheon = new JButton("\uC2E0\uCCAD");
		
		sincheon.setBounds(443, 507, 111, 46);
		panel.add(sincheon);
		
		JButton miridamgi = new JButton("\uBBF8\uB9AC\uB2F4\uAE30");

		miridamgi.setBounds(230, 507, 111, 46);
		panel.add(miridamgi);
		
		Mtable = new JTable();
		Mtable.setBounds(603, 74, 324, 423);
		panel.add(Mtable);
		Mtable.setModel(new DefaultTableModel(
				new Object[][] {
					{"���¹�ȣ", "���¸�", "������", "����","�ð�"}
				},
				new String[] {
					"���¹�ȣ", "���¸�", "������", "����", "�ð�"
				}
			));
		vGangjwaSelection = new VGangjwaSelection();
		  DefaultTableModel dtm = (DefaultTableModel) Mtable.getModel();
	      dtm.setNumRows(1);
	     vGangjwaSelection.Miridamgi(oHwewon1.getId(),dtm);
		
		Stable = new JTable();
		Stable.setBounds(985, 74, 324, 423);
		panel.add(Stable);
		Stable.setModel(new DefaultTableModel(
				new Object[][] {
					{"���¹�ȣ", "���¸�", "������", "����","�ð�"}
				},
				new String[] {
					"���¹�ȣ", "���¸�", "������", "����", "�ð�"
				}
			));
		
		gangjwa = new JTextField();
		gangjwa.setFont(new Font("HY�߰��", Font.BOLD, 36));
		gangjwa.setHorizontalAlignment(SwingConstants.CENTER);
		gangjwa.setText("\uAC15\uC88C");
		gangjwa.setBounds(230, 10, 324, 54);
		panel.add(gangjwa);
		gangjwa.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("HY�߰��", Font.BOLD, 36));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("\uBBF8\uB9AC\uB2F4\uAE30");
		textField_1.setColumns(10);
		textField_1.setBounds(603, 10, 324, 54);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("HY�߰��", Font.BOLD, 36));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("\uC218\uAC15\uC2E0\uCCAD");
		textField_2.setColumns(10);
		textField_2.setBounds(985, 10, 324, 54);
		panel.add(textField_2);
		
		Msincheon = new JButton("\uC218\uAC15\uC2E0\uCCAD");
		
		Msincheon.setBounds(816, 507, 111, 46);
		panel.add(Msincheon);
		
		Mdelete = new JButton("\uC0AD\uC81C");
	
		Mdelete.setBounds(603, 507, 111, 46);
		panel.add(Mdelete);
		
		SMdelete = new JButton("\uC0AD\uC81C");
		
		SMdelete.setBounds(985, 507, 324, 46);
		panel.add(SMdelete);
		vGangjwaSelection = new VGangjwaSelection();
		  DefaultTableModel dtm1 = (DefaultTableModel) Stable.getModel();
	      dtm1.setNumRows(1);
	     vGangjwaSelection.Sincheon(oHwewon1.getId(),dtm1);
	     
		
		college.addActionListener(new ActionListener() { //�ܰ��� ���ý� 
			public void actionPerformed(ActionEvent e) {
				String getdepartment[] = wEventListen.getdepartment(college.getSelectedItem().toString());
				department.setModel(new DefaultComboBoxModel(getdepartment));
			}
		});
		
		department.addActionListener(new ActionListener() { //�а� ���ý�
			public void actionPerformed(ActionEvent e) {
				vGangjwaSelection = new VGangjwaSelection();
			     DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			      dtm.setNumRows(1);
			     vGangjwaSelection.addRow(department.getSelectedItem().toString(),dtm);
			}
		});
		miridamgi.addActionListener(new ActionListener() { //���¸�Ͽ��� �̸����
			public void actionPerformed(ActionEvent e) {
				wEventListen.Msave(oHwewon1, table);
				JOptionPane.showMessageDialog(null, "�̸���� �Ϸ�", "������û �ý���", JOptionPane.WARNING_MESSAGE);
				vGangjwaSelection = new VGangjwaSelection();
				DefaultTableModel dtm = (DefaultTableModel) Mtable.getModel();
			    dtm.setNumRows(1);
			    vGangjwaSelection.Miridamgi(oHwewon1.getId(),dtm);
			}
		});
		
		Mdelete.addActionListener(new ActionListener() {  //�̸���⿡�� ����
			public void actionPerformed(ActionEvent e) {
				wEventListen.Mdelete(oHwewon1, Mtable);
				JOptionPane.showMessageDialog(null, "�����Ϸ�", "������û �ý���", JOptionPane.WARNING_MESSAGE);
				vGangjwaSelection = new VGangjwaSelection();
				DefaultTableModel dtm = (DefaultTableModel) Mtable.getModel();
			    dtm.setNumRows(1);
			    vGangjwaSelection.Miridamgi(oHwewon1.getId(),dtm);
			}
		});
		
		Msincheon.addActionListener(new ActionListener() { //�̸���⿡�� ������û
			public void actionPerformed(ActionEvent e) {
				wEventListen.Msincheon(oHwewon1, Mtable);
				JOptionPane.showMessageDialog(null, "������û �Ϸ�", "������û �ý���", JOptionPane.WARNING_MESSAGE);
				vGangjwaSelection = new VGangjwaSelection();
				DefaultTableModel dtm = (DefaultTableModel) Stable.getModel();
			    dtm.setNumRows(1);
			    vGangjwaSelection.Sincheon(oHwewon1.getId(),dtm);
			}
		});
		
		sincheon.addActionListener(new ActionListener() { //���¸�Ͽ��� ������û
			public void actionPerformed(ActionEvent e) {
				wEventListen.sincheon(oHwewon1, table);
				JOptionPane.showMessageDialog(null, "������û �Ϸ�", "������û �ý���", JOptionPane.WARNING_MESSAGE);
				vGangjwaSelection = new VGangjwaSelection();
				DefaultTableModel dtm = (DefaultTableModel) Stable.getModel();
			    dtm.setNumRows(1);
			    vGangjwaSelection.Sincheon(oHwewon1.getId(),dtm);
			}
		});
		SMdelete.addActionListener(new ActionListener() { //������û���� ����
			public void actionPerformed(ActionEvent e) {
				wEventListen.Sdelete(oHwewon1, Stable);
				JOptionPane.showMessageDialog(null, "�����Ϸ�", "������û �ý���", JOptionPane.WARNING_MESSAGE);
				vGangjwaSelection = new VGangjwaSelection();
				DefaultTableModel dtm = (DefaultTableModel) Stable.getModel();
			    dtm.setNumRows(1);
			    vGangjwaSelection.Sincheon(oHwewon1.getId(),dtm);
			}
		});

	}
}
