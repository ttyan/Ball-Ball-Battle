package test;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Paihang {

	private Person[] pero;
	private Person person;
	
	public Paihang(Person[] pero,Person person){
		this.pero = pero;
		this.person = person;
	}
	
	public void show(){
		JFrame jf = new JFrame("排行榜");
		jf.setSize(300, 500);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置字体大小
        SimpleAttributeSet attrset = new SimpleAttributeSet();     
        
        //插入内容
        JTextPane textPane = new JTextPane();
        Document docs = textPane.getDocument();//获得文本对象

		jf.add(textPane);

		for(int i=0;i<pero.length;i++){
			if(pero[i]==person){	 
		        try {
		        	StyleConstants.setFontSize(attrset,30);
		        	StyleConstants.setForeground(attrset,Color.RED);  
		            docs.insertString(docs.getLength(), i+"    "+pero[i].getpersonName()+"     "+pero[i].getScore(), attrset);//对文本进行追加
		            //换行
		            docs.insertString(docs.getLength(), "\n", attrset);
		        } catch (BadLocationException e) {
		            e.printStackTrace();
		        }
		
			}else{
		        try {
		        	StyleConstants.setFontSize(attrset,20);
		        	StyleConstants.setForeground(attrset,Color.BLACK);
		            docs.insertString(docs.getLength(),i+"    "+pero[i].getpersonName()+"     "+pero[i].getScore(), attrset);//对文本进行追加
		            docs.insertString(docs.getLength(), "\n", attrset);
		        } catch (BadLocationException e) {
		            e.printStackTrace();
		        }
			}

		}
		
		jf.setVisible(true);
		
	}

}
