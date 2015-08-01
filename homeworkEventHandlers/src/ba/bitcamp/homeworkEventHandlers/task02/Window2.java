package ba.bitcamp.homeworkEventHandlers.task02;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window2 extends JFrame{

	private static final long serialVersionUID = -1237423088476352712L;
	
	private JPanel panel = new MyPanel();
	
	private int x = 200;
	private int y = 100;
	
	public Window2(){
		add(panel);
		addKeyListener(new Move());
		
		setTitle("Moving circle");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class MyPanel extends JPanel{

		private static final long serialVersionUID = 5183830844740795759L;
	
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.fillOval(x, y, 50, 50);
		}
		
	}
	
	private class Move implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP){
				y--;
			} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				y++;
			} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				x++;
			} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
				x--;
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new Window2();
	}
	
}
