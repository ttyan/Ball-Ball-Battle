package test;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ball {
	private int x, y, vx = -1, vy = -1, size;
	private Color color = null;
	private int flag;
	private JPanel jp = null;
	private Background background = null;
	private int xvr, yvr;
	public static int score;
	public String personName;

	private ArrayList<Ball> list = null;
	private Person person = null;
	private Person[] per = null;

	public Ball(int x, int y, int size, Color color, int flag, JPanel jp, Background background) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		this.flag = flag;
		this.jp = jp;
		this.background = background;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public void setList(ArrayList<Ball> list) {
		this.list = list;
	}

	public void drawBall1(Graphics gr) {
		gr.setColor(color);
		gr.fillOval(x, y, size, size);

		for (int i = 0; i < list.size(); i++) {
			Ball ball = list.get(i);
			if (ball.getFlag() == 2) {
				int xx = Math.abs(this.x - ball.x);
				int yy = Math.abs(this.y - ball.y);
				int xy = (int) Math.sqrt(xx * xx + yy * yy);
				if (xy <= (this.size / 2 + ball.size / 2)) {
					if (this.getSize() >= list.get(i).getSize()) {
						this.setSize(this.getSize() + 2);// 吃了变大

						this.score += 10;
						list.remove(i);
					} else {
						this.flag = 0;
						JOptionPane.showMessageDialog(null, "你被吃了");
						person = new Person(personName, score);
						
						per = In();
						
						Person[] pero;
						
						if(per==null){
							pero = new Person[1];
							pero[0] = person;
						}else{
							pero = new Person[per.length+1];
						    for(int num=0;num<per.length;num++){
						    	pero[num] = per[num];
						    }
						    pero[per.length]=person;
						}
						
						Out(pero);
						
						for(int m=1;m<pero.length;m++){
							for(int n=0;n<pero.length-m;n++){
								if(pero[n].getScore()<pero[n+1].getScore()){
									Person temp = pero[n+1];
									pero[n+1] = pero[n];
									pero[n] = temp;
								}
							}
						}
						/*for(int num=0;num<pero.length;num++){
							System.out.println(pero[num].getpersonName()+" "+pero[num].getScore());
						}*/	
						
						Paihang ph = new Paihang(pero,person);
						ph.show();
					}

				}
			}
		}
	}

	public void Out(Person[] per){
		File file = new File("G:\\person.txt");
		ObjectOutputStream objectout=null; 
		try {
			objectout = new ObjectOutputStream(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			objectout.writeObject(per);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		try {
			objectout.flush();
			objectout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
    
	// 读出数据
	public Person[] In(){
		Person[] per = null;
		
		File file = new File("G:\\person.txt");
		ObjectInputStream objectin = null;
		try {
			
			objectin = new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			return null;
		}	
				
		try {		
			per = (Person[])objectin.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		try {
			objectin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return per;
	}
	
	
	public void drawBall2(Graphics gr) {
		x += vx;
		y += vy;
		gr.setColor(color);
		gr.fillOval(x, y, size, size);

		xvr = Math.abs(background.getX()) + x;
		yvr = Math.abs(background.getY()) + y;

		if (xvr >= 200 + jp.getWidth() - size || xvr <= 0) {
			if (xvr > 200 + jp.getWidth() - size) {
				x = 200 + jp.getWidth() - size - Math.abs(background.getX());
			}
			if (xvr < 0) {
				x = 0;
			}
			vx = -vx;
		}
		if (yvr >= 200 + jp.getHeight() - size || yvr <= 0) {
			if (yvr > 200 + jp.getHeight() - size) {
				y = 200 + jp.getHeight() - size - Math.abs(background.getY());
			}
			if (yvr < 0) {
				y = 0;
			}
			vy = -vy;
		}
	}

	public int getFlag() {
		return this.flag;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
