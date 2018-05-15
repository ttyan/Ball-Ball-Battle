package test;

import java.awt.Image;

import javax.swing.JPanel;

public class Background {
	private int x,y;
	private Image img;
	private JPanel jp;
	public Background(Image img,int x,int y,JPanel jp){
		this.x = x;
		this.y = y;
		this.img = img;
		this.jp = jp;
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
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
}
