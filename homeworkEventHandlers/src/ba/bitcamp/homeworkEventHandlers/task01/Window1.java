package ba.bitcamp.homeworkEventHandlers.task01;

import javax.swing.JFrame;

public class Window1 extends JFrame{
	private static final long serialVersionUID = -2861259498965185310L;
	// declaration of parameters
	static MyPanel p = new MyPanel();
	static int x = 200;
	static int y = 100;
	
	/**
	 * Constructor
	 */
	public Window1(){
		add(p);
		addKeyListener(new MoveListener());
		
		setTitle("Moving circle");
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Window1();
	}
	
}
