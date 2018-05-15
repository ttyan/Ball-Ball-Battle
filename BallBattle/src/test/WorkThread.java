package test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class WorkThread extends Thread{
	private int x,y,r,g,b,size;
	private JPanel jp = null;
	private ArrayList<Ball> list = null;
	private Background background = null;
	public int state;
	public static final int over = 1;
	
	public WorkThread(JPanel jp,ArrayList<Ball> list,Background background) {
		this.jp = jp;
		this.list = list;
		this.background = background;
	}

	public void run(){
		while(true){
			
			if(state==over){
				break;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random rand = new Random();
			size = rand.nextInt(50)+15;
			x = rand.nextInt(jp.getWidth()-size);
			y = rand.nextInt(jp.getHeight()-size);
			r = rand.nextInt(256);
			g = rand.nextInt(256);
			b = rand.nextInt(256);
			Ball ball = new Ball(x,y,size,new Color(r, g, b),2,jp,background);
			ball.setList(list);
			list.add(ball);
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFlag()==0){
					state = over;
					list.clear();
				}
			}
		}
	}
	
}
