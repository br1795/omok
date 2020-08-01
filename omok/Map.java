package com.omok;

import java.awt.*;
import javax.swing.JPanel;

public class Map extends JPanel{
	private MapSize size;
	private GameRule gr;
	private final int STONE_SIZE=28;
	
	public Map(MapSize m, GameRule gr) {
		setBackground(new Color(206,167,61));
		size = m;
		setLayout(null);
		this.gr = gr;
	}
	
	
}
