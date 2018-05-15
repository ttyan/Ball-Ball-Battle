package test;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class BallListener extends MouseAdapter implements KeyListener{
	
	private BallThread bt = null;
	private JPanel jp = null;
	private Graphics gr = null;
	private ArrayList<Ball> list = new ArrayList<Ball>();
	private Ball ball= null;
	private Background background = null;
	private String personName;
	
	private int x,y;
	
	public BallListener(JPanel jp,Graphics gr,Background background,String personName) {
		this.jp = jp;	
		this.gr = gr;
		this.background = background;
		this.personName = personName;
	}

	
	public void mouseMoved(MouseEvent e){
		x = e.getX();
		y = e.getY();
		
		if(x>480&&x<550&&y<80&&y>0){
			jp.addKeyListener(this);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			//获取焦点
			jp.requestFocus();
			
			
			if(bt==null){
				 bt = new BallThread(list,gr,jp,background);
				 bt.start();
				 
				 ball = new Ball(jp.getWidth()/2, jp.getWidth()/2, 30,Color.RED,1,jp,background);
				 ball.setPersonName(personName);
				 ball.setList(list);
				 list.add(ball);
				 
				 for(int i=0;i<5;i++){
						Random rand = new Random();
						int size = rand.nextInt(50)+15;
						int x = rand.nextInt(jp.getWidth()-size);
						int y = rand.nextInt(jp.getHeight()-size);
						int r = rand.nextInt(256);
						int g = rand.nextInt(256);
						int b = rand.nextInt(256);		
						ball = new Ball(x,y,size,new Color(r, g, b),2,jp,background);
						ball.setList(list);
						list.add(ball);
				 }
	 
				 WorkThread wt = new WorkThread(jp, list,background);
				 wt.start();
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== 38){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFlag()==1){
					list.get(i).setY(list.get(i).getY()-1);
				}
			}
			if(background.getY()+1<=0){
				background.setY(background.getY()+1);
			}else background.setY(0);
					
		}else if(e.getKeyCode()== 40){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFlag()==1){
					list.get(i).setY(list.get(i).getY()+1);
				}
			}
			if(background.getY()-1>=-200){
				background.setY(background.getY()-1);
			}else background.setY(-200);
			
		}else if(e.getKeyCode()== 37){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFlag()==1){
					list.get(i).setX(list.get(i).getX()-1);
				}
			}
			if(background.getX()+1<=0){
				background.setX(background.getX()+1);
			}else background.setX(0);	
			
		}else if(e.getKeyCode()== 39){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getFlag()==1){
					list.get(i).setX(list.get(i).getX()+1);
				}
			}
			if(background.getX()-1>=-200){
				background.setX(background.getX()-1);
			}else background.setX(-200);	    
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
