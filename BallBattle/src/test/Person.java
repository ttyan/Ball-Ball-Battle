package test;

import java.io.Serializable;

public class Person  extends Object implements Serializable{
	private String personName;
	private int score;
	
	public Person(String personName, int score) {
		this.personName = personName;
		this.score = score;
	}
	public String getpersonName() {
		return personName;
	}
	public void setpersonName(String personName) {
		this.personName = personName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}	
}
