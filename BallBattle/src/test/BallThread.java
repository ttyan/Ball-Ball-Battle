package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BallThread extends Thread{

	private ArrayList<Ball> list = null;
	private Graphics gr = null;
	private JPanel jp = null;
	private Background background = null;
	public int state;
	public static final int over = 1;
	
	public BallThread(ArrayList<Ball> list,Graphics gr,JPanel jp,Background background){
		this.list = list;
		this.gr = gr;
		this.jp = jp;
		this.background = background;
	}
	
	public void run(){
		while(true){
			if(state==over){
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//创建缓冲区
			BufferedImage buffim = new BufferedImage(jp.getWidth(), jp.getHeight(), BufferedImage.TYPE_INT_RGB);
			//从缓冲区上获取画笔
			Graphics buffgr = buffim.getGraphics();
			
			buffgr.drawImage(background.getImg(), background.getX(), background.getY(), jp);
			
			buffgr.setFont(new Font(null, Font.BOLD, 15));
			buffgr.drawString("开始", 500, 30);
			
			buffgr.setColor(Color.RED);
			buffgr.setFont(new Font(null, Font.BOLD, 12));
			buffgr.drawString("得分:", 500, 60);
			String score =  Integer.toString(Ball.score);
			buffgr.drawString(score,540 , 60);
			
			for(int i=0;i<list.size();i++){
				Ball ball = list.get(i);
				if(ball.getFlag()==1){
					ball.drawBall1(buffgr);
				}else if(ball.getFlag()==2){
					ball.drawBall2(buffgr);
				}else if(ball.getFlag()==0){
					state=over;
					list.clear();
				}
			}
			
			//将缓冲区显示在JPanel上
			gr.drawImage(buffim, 0, 0, null);		
		}
	}
}
