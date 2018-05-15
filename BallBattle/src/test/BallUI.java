package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallUI extends JPanel{
	private Background background;
	private Image img;
	private String personName;
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new BallUI();
//	}
    public BallUI(String personName){ 
    	this.personName = personName;
		//画个背景
		img = new ImageIcon("C:\\Users\\Administrator\\Pictures\\Saved Pictures\\8.jpg").getImage();	
		background = new Background(img,0,0,this);
        show(); 
    }
	public void show(){
		JFrame jf = new JFrame("球球");
		jf.setSize(590, 500);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.add(this,BorderLayout.CENTER);
				
		jf.setVisible(true);
		
		Graphics gr = this.getGraphics();
					
		BallListener bl = new BallListener(this,gr,background,personName);	
		this.addMouseMotionListener(bl);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		g.drawImage(background.getImg(), background.getX(), background.getY(), this);
		g.setFont(new Font(null, Font.BOLD, 15));
		g.drawString("开始", 500, 30);
		g.setColor(Color.RED);
		g.setFont(new Font(null, Font.BOLD, 12));
		g.drawString("得分:", 500, 60);
		g.drawString("0",540 , 60);
	}

}
