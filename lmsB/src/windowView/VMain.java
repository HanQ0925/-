package windowView;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VMain extends JFrame implements ActionListener {
 private String id = "1";
 private String password = "1";
 private JTextField TF;
 private JPasswordField PF;
 private JButton login;
 JLabel loginText = new JLabel();
 private boolean isLogin = false;

 public VMain() {
  JPanel id = new JPanel();
  JPanel password = new JPanel();
  TF = new JTextField(10);
  PF = new JPasswordField(10);
  loginText.setForeground(Color.BLUE);
  
  JLabel IdBox = new JLabel("���̵� : ");
  JLabel PassBox = new JLabel("��й�ȣ : ");
  login = new JButton("LOGIN");
  login.addActionListener(this);
  
  id.add(IdBox);
  id.add(TF);

  password.add(PassBox);
  password.add(PF);

  this.add(id);
  this.add(password);
  this.add(login);
  this.add(loginText);
  
  setLayout(new FlowLayout());

  setTitle("�α���");
  setSize(500, 300);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setVisible(true);
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == login) {
   try {
    if (id.equals(TF.getText()) && password.equals(PF.getText()))
     isLogin = true;
    else
     isLogin = false;
    if (isLogin) {
     loginText.setText("�α��οϷ�.");
    } else {
     loginText.setText("ID �Ǵ� password�� �߸��Ǿ����ϴ�.");
    }
   } catch (Exception e1) {
    System.out.println("false");
   }
  }
 }

 public static void main(String[] args) {
	 VMain my = new VMain();
 }
} 


