package ba.bitcamp.homeworkEventHandlers.task01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 5183830844740795759L;

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.fillOval(Window1.x, Window1.y, 50, 50);
	}
	
}
