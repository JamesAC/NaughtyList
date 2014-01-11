package com.jamesac.thing;

import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Student {
	
	private final String name;
	private int score = 0;
	private int good = 0;
	private int bad = 0;
	private Rectangle2D screenLocation;
	Random random = new Random();
	
	public Student(String name) {
		this.name = name;
		this.score = random.nextInt(3) - 1;
		this.good = random.nextInt(7) - 3;
		this.bad = random.nextInt(7) - 3;
	}

	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

	public Rectangle2D getScreenLocation() {
		return screenLocation;
	}

	public void setScreenLocation(Rectangle2D screenLocation) {
		this.screenLocation = screenLocation;
	}
}
