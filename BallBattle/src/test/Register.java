package test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Register {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Register().show();
	}
	public void show(){
    	JFrame jf = new JFrame("请输入玩家名：");
    	jf.setSize(400, 100);
    	jf.setLocationRelativeTo(null);
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	FlowLayout fl = new FlowLayout();
    	jf.setLayout(fl);
    	
    	JTextField jtf = new JTextField();
    	jtf.setPreferredSize(new Dimension(300, 30));
    	jf.add(jtf);
    
    	JButton jb = new JButton("登陆");
    	jf.add(jb);
    	
    	jf.setVisible(true);
    	
    	RegisterListener rl = new RegisterListener(jtf);
    	jb.addActionListener(rl);
	}

}
