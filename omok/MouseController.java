package com.omok;

import java.awt.event.MouseAdapter;

public class MouseController extends MouseAdapter {
	private GameRule gr; 
	private MapSize ms; 
	private Map m;
	private Run r;
	
	public MouseController(GameRule gr, MapSize ms, Map m, Run r) {
		this.gr = gr;
		this.ms = ms;
		this.m = m;
		this.r = r;
	}

}
