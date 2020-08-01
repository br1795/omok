package com.omok;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Run extends JFrame implements ActionListener{
	private Container c;
	MapSize size = new MapSize();
	GameRule gr = new GameRule();
	
	public Run(String title) {
		setTitle(title);
		setBounds(200, 20, 650, 750);
		c = getContentPane();
		c.setLayout(null);
		Map m = new Map(size, gr);
		setContentPane(m);
		MouseController mc = new MouseController(gr, size , m, this);
		addMouseListener(mc);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gr.init();
	}

}
