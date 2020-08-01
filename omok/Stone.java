package com.omok;

public class Stone {
	private int x; // x√‡
	private int y; // y√‡
	private int color; // µπ color, ex) if ==1 black  else white
	
	// Constructor
	public Stone(int x, int y, int color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	// getter/setter
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
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	
}
