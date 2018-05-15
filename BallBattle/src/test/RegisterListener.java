package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class RegisterListener implements ActionListener{
	private JTextField jtf = null;
	
	public RegisterListener(JTextField jtf){
		this.jtf = jtf;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = jtf.getText();
		new BallUI(str); //传入游戏玩家名
	}
	
}
