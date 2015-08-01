package ba.bitcamp.homeworkEventHandlers.task01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			Window1.y--;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			Window1.y++;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Window1.x++;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Window1.x--;
		}
		Window1.p.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}

