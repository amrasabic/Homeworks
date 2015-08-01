package ba.bitcamp.homeworkEventHandlers.task03;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window3 extends JFrame{

	private static final long serialVersionUID = -1237423088476352712L;
	
	private JPanel panel = new MyPanel();
	
	private int x = 200;
	private int y = 100;
	
	public Window3(){
		add(panel);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP){
					y -= 5;
				} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					y += 5;
				} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					x += 5;
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					x -= 5;
				}
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		
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
	
	public static void main(String[] args) {
		
		new Window3();
	}
	
}
